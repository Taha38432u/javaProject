/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.school;

/**
 *
 * @author Taha Rasheed
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class FeeReceiptGenerator extends JFrame {

    private JTextField rollNoField;
    private JTextField classField;
    private Connection con;

    public FeeReceiptGenerator(Connection con) {
        super("Fee Receipt Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.con = con;

        // Create labels and text fields
        JLabel rollNoLabel = new JLabel("Enter Roll No:");
        rollNoField = new JTextField(10);

        JLabel classLabel = new JLabel("Enter Class:");
        classField = new JTextField(10);

        // Create button to generate fee receipt
        JButton generateButton = new JButton("Generate Fee Receipt");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateFeeReceipt();
            }
        });

        // Create panel to hold components
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(rollNoLabel);
        panel.add(rollNoField);
        panel.add(classLabel);
        panel.add(classField);
        panel.add(generateButton);

        // Add panel to frame
        getContentPane().add(panel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void generateFeeReceipt() {
        int rollNo = Integer.parseInt(rollNoField.getText());
        String studentClass = classField.getText();

        try {
            // Check if record exists in the table
            String query = "SELECT * FROM recordsOfFee WHERE studentRollNo = ? AND studentClass = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rollNo);
            ps.setString(2, studentClass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // If record exists, generate fee receipt PDF
                generateReceiptPDF(rs);
            } else {
                JOptionPane.showMessageDialog(this, "Record not found for Roll No: " + rollNo + " and Class: " + studentClass);
            }

            ps.close();
            rs.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while generating fee receipt.");
        }
    }

    private void generateReceiptPDF(ResultSet rs) throws IOException, SQLException {
        try (PDDocument document = new PDDocument()) {
            // Create a new page
            PDPage page = new PDPage();
            document.addPage(page);

            // Get the page dimensions
            PDRectangle pageSize = page.getMediaBox();
            float pageWidth = pageSize.getWidth();
            float pageHeight = pageSize.getHeight();
            int rollNo = rs.getInt("studentRollNo");
            String studentClass = rs.getString("studentClass");
            int totalFee = fetchFeeFromDatabase(rollNo, studentClass);

            // Create a content stream
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                // Set up font and style for school name
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
                contentStream.setNonStrokingColor(Color.BLUE); // Blue color for school name
                float schoolNameWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Innovative School") / 1000f * 20; // Width of the school name text
                float schoolNameX = (pageWidth - schoolNameWidth) / 2; // Centering the school name horizontally
                float schoolNameY = pageHeight - 50; // Top margin for the school name

                // Draw school name
                contentStream.beginText();
                contentStream.newLineAtOffset(schoolNameX, schoolNameY);
                contentStream.showText("Innovative School");
                contentStream.endText();

                // Set up font and style for title
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
                float titleWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Fee Receipt") / 1000f * 24; // Width of the title text
                float titleX = (pageWidth - titleWidth) / 2; // Centering the title horizontally
                float titleY = schoolNameY - 40; // Margin below the school name for the title

                // Draw title
                contentStream.setNonStrokingColor(Color.BLACK); // Black color for title
                contentStream.beginText();
                contentStream.newLineAtOffset(titleX, titleY);
                contentStream.showText("Fee Receipt");
                contentStream.endText();

                // Set up font and style for table headers
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                float startX = 50; // Left margin for details
                float startY = titleY - 40; // Margin below the title for details
                float cellWidth = (pageWidth - 100) / 2; // Width of each cell
                float cellHeight = 20; // Height of each cell
                float rowHeight = 25; // Height of each row

                // Draw table headers
                contentStream.setNonStrokingColor(Color.BLACK); // Black color for table headers
                contentStream.beginText();
                contentStream.newLineAtOffset(startX, startY);
                contentStream.showText("Attribute");
                contentStream.newLineAtOffset(cellWidth, 0);
                contentStream.showText("Value");
                contentStream.endText();

                // Draw horizontal line below table headers
                contentStream.moveTo(startX, startY - rowHeight);
                contentStream.lineTo(startX + cellWidth * 2, startY - rowHeight);
                contentStream.stroke();

                // Set up font and style for table content
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                float contentX = startX;
                float contentY = startY - rowHeight - cellHeight;

                // Write student details
                writeTableCell(contentStream, contentX, contentY, "Student Name", rs.getString("studentName"), cellWidth, cellHeight);
                contentY -= cellHeight;
                writeTableCell(contentStream, contentX, contentY, "Roll No", String.valueOf(rs.getInt("studentRollNo")), cellWidth, cellHeight);
                contentY -= cellHeight;
                writeTableCell(contentStream, contentX, contentY, "Class", rs.getString("studentClass"), cellWidth, cellHeight);
                contentY -= cellHeight;
                writeTableCell(contentStream, contentX, contentY, "Total Fee", String.valueOf(totalFee), cellWidth, cellHeight); // Example total fee
                contentY -= cellHeight;
                writeTableCell(contentStream, contentX, contentY, "Paid Date", String.valueOf(rs.getDate("payDate")), cellWidth, cellHeight);
                contentY -= cellHeight;

                // Add important notes
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
                contentStream.setNonStrokingColor(Color.RED); // Red color for important notes
                float noteY = 50; // Margin from the bottom for notes
                contentStream.beginText();
                contentStream.newLineAtOffset(50, noteY);
                contentStream.showText("Important Notes:");
                contentStream.newLineAtOffset(0, -20);
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.setNonStrokingColor(Color.BLACK); // Black color for notes content
                contentStream.showText("1) Keep this Receipt Safe");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("2) Additional notes here...");
                contentStream.endText();

            } // Close the PDPageContentStream here

            // Save the document
            document.save("fee_receipt.pdf");

            // Inform the user
            JOptionPane.showMessageDialog(this, "Fee receipt saved as fee_receipt.pdf");
        }
    }

    private int fetchFeeFromDatabase(int rollNo, String studentClass) throws SQLException {
        int totalFee = 0;
        try (Connection con = ConnectionClass.db()) {
            String query = "SELECT fee FROM studentsFee WHERE studentRollNo = ? AND studentClass = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rollNo);
            ps.setString(2, studentClass);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                totalFee = result.getInt("fee");
            }
        }
        return totalFee;
    }

    private void writeTableCell(PDPageContentStream contentStream, float startX, float startY, String attribute, String value, float cellWidth, float cellHeight) throws IOException {
        contentStream.beginText();
        contentStream.newLineAtOffset(startX, startY);
        contentStream.showText(attribute);
        contentStream.newLineAtOffset(cellWidth, 0);
        contentStream.showText(value);
        contentStream.endText();
    }

    public static void main(String[] args) {
        // Replace the null parameter with your database connection
        Connection con = ConnectionClass.db(); // Initialize your database connection
        new FeeReceiptGenerator(con);
    }
}
