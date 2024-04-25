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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.awt.print.*;
import java.io.IOException;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ResultDisplay extends JFrame {

    JTable table;

    private resultFunctions result;

    public ResultDisplay(resultFunctions result) {
        super("Result Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.result = result;

        // Create a table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Subject");
        model.addColumn("Total Marks");
        model.addColumn("Obtained Marks");

        // Add data to the table model
        addRowToModel(model, result.getSubject1Name(), result.getSubject1TotalMarks(), result.getSubject1ObtainedMarks());
        addRowToModel(model, result.getSubject2Name(), result.getSubject2TotalMarks(), result.getSubject2ObtainedMarks());
        addRowToModel(model, result.getSubject3Name(), result.getSubject3TotalMarks(), result.getSubject3ObtainedMarks());
        addRowToModel(model, result.getSubject4Name(), result.getSubject4TotalMarks(), result.getSubject4ObtainedMarks());
        addRowToModel(model, result.getSubject5Name(), result.getSubject5TotalMarks(), result.getSubject5ObtainedMarks());
        addRowToModel(model, result.getSubject6Name(), result.getSubject6TotalMarks(), result.getSubject6ObtainedMarks());
        addRowToModel(model, result.getSubject7Name(), result.getSubject7TotalMarks(), result.getSubject7ObtainedMarks());
        addRowToModel(model, result.getSubject8Name(), result.getSubject8TotalMarks(), result.getSubject8ObtainedMarks());
        addRowToModel(model, result.getSubject9Name(), result.getSubject9TotalMarks(), result.getSubject9ObtainedMarks());
        addRowToModel(model, result.getSubject10Name(), result.getSubject10TotalMarks(), result.getSubject10ObtainedMarks());

        // Add rows for other subjects similarly...
        // Create the table
        table = new JTable(model);
        table.setRowHeight(30); // Set row height for better visibility

        // Center align column headers
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        // Set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(200); // Subject column
        table.getColumnModel().getColumn(1).setPreferredWidth(100); // Total Marks column
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Obtained Marks column

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        JLabel totalMarksLabel = new JLabel("Total Marks:");
        JTextField totalMarksField = new JTextField(10);
        totalMarksField.setEditable(false);
        totalMarksField.setText(String.valueOf(result.getTotalMarks()));

        JLabel totalObtainedMarksLabel = new JLabel("Total Obtained Marks:");
        JTextField totalObtainedMarksField = new JTextField(10);
        totalObtainedMarksField.setEditable(false);
        totalObtainedMarksField.setText(String.valueOf(result.getObtainedMarks()));

        JLabel obtainedPercentageLabel = new JLabel("Obtained Percentage:");
        JTextField obtainedPercentageField = new JTextField(10);
        obtainedPercentageField.setEditable(false);
        obtainedPercentageField.setText(String.valueOf(result.getObtainedPercentage()));

        // Create labels for roll number and class
        JLabel rollNoLabel = new JLabel("Roll No:");
        JTextField rollNoField = new JTextField(10);
        rollNoField.setEditable(false);
        rollNoField.setText(String.valueOf(result.getStudentRollNo()));

        JLabel classLabel = new JLabel("Class:");
        JTextField classField = new JTextField(10);
        classField.setEditable(false);
        classField.setText(result.getStudentClassId());

        // Create a panel to hold the labels and text fields
        JPanel totalPanel = new JPanel(new GridLayout(5, 2));
        totalPanel.add(rollNoLabel);
        totalPanel.add(rollNoField);
        totalPanel.add(classLabel);
        totalPanel.add(classField);
        totalPanel.add(totalMarksLabel);
        totalPanel.add(totalMarksField);
        totalPanel.add(totalObtainedMarksLabel);
        totalPanel.add(totalObtainedMarksField);
        totalPanel.add(obtainedPercentageLabel);
        totalPanel.add(obtainedPercentageField);

        JButton printButton = new JButton("Print Result");
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printResult();
            }
        });

        // Add the scroll pane, total panel, and print button to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(totalPanel, BorderLayout.SOUTH);
        getContentPane().add(printButton, BorderLayout.NORTH);

        // Set frame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void printResult() {
        try (PDDocument document = new PDDocument()) {
            // Create a new page
            PDPage page = new PDPage();
            document.addPage(page);

            // Get the page dimensions
            PDRectangle pageSize = page.getMediaBox();
            float pageWidth = pageSize.getWidth();
            float pageHeight = pageSize.getHeight();

            // Create a content stream
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

                // Set up font for title
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 20);
                float titleWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Result") / 1000 * 20; // Width of the title text
                float titleX = (pageWidth - titleWidth) / 2; // Centering the title horizontally
                float titleY = pageHeight - 50; // Top margin for the title

                // Draw title
                contentStream.setNonStrokingColor(Color.BLUE); // Set title color
                contentStream.beginText();
                contentStream.newLineAtOffset(titleX, titleY);
                contentStream.showText("Result");
                contentStream.endText();

                // Set up font for details
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                float detailY = titleY - 30; // Margin below the title for details

                // Write student details
                contentStream.setNonStrokingColor(Color.BLACK); // Set text color for details
                String studentDetails = "Roll No: " + result.getStudentRollNo() + " | Class: " + result.getStudentClassId();
                contentStream.beginText();
                contentStream.newLineAtOffset(50, detailY);
                contentStream.showText(studentDetails);
                contentStream.endText();

                // Write marks details
                String marksDetails = "Total Marks: " + result.getTotalMarks()
                        + " | Obtained Marks: " + result.getObtainedMarks()
                        + " | Obtained Percentage: " + result.getObtainedPercentage() + "%";
                contentStream.beginText();
                contentStream.newLineAtOffset(50, detailY - 20); // Below student details
                contentStream.showText(marksDetails);
                contentStream.endText();

                // Draw table
                float tableHeaderY = detailY - 50; // Margin below the marks details for the table headers
                float tableContentY = tableHeaderY - 20; // Margin below the table headers for the table content
                drawTableHeader(contentStream, 50, tableHeaderY, pageWidth - 100, 20);
                drawTableContent(contentStream, 50, tableContentY, pageWidth - 100, 20, 5);

            } // Close the PDPageContentStream here

            // Save the document
            document.save("result_details.pdf");

            // Inform the user
            JOptionPane.showMessageDialog(this, "Result details saved as result_details.pdf");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while saving result details.");
        }
    }

    private void drawTableHeader(PDPageContentStream contentStream, float startX, float startY, float width, float cellHeight) throws java.io.IOException {
        // Define table headers
        String[] headers = {"Subject", "Total Marks", "Obtained Marks"};
        // Set cell properties
        contentStream.setNonStrokingColor(Color.LIGHT_GRAY);
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        // Draw table headers
        float currentX = startX;
        for (String header : headers) {
            contentStream.beginText();
            contentStream.newLineAtOffset(currentX, startY);
            contentStream.showText(header);
            contentStream.endText();
            currentX += width / 3;
        }
        // Draw horizontal line below headers
        contentStream.moveTo(startX, startY - cellHeight);
        contentStream.lineTo(startX + width, startY - cellHeight);
        contentStream.stroke();
    }

    private void drawTableContent(PDPageContentStream contentStream, float startX, float startY, float width, float cellHeight, float cellMargin) throws IOException {
        // Set cell properties
        contentStream.setNonStrokingColor(Color.BLACK); // Change color to black for content
        contentStream.setFont(PDType1Font.HELVETICA, 12);

        // Get result details from the table model
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        // Draw table content
        float currentY = startY;
        for (int row = 0; row < model.getRowCount(); row++) {
            float currentX = startX;
            for (int col = 0; col < model.getColumnCount(); col++) {
                String cellValue = model.getValueAt(row, col).toString();
                contentStream.beginText();
                contentStream.newLineAtOffset(currentX + cellMargin, currentY - cellHeight);
                contentStream.showText(cellValue);
                contentStream.endText();
                currentX += width / 3;
            }
            currentY -= cellHeight;
        }
    }

    private void addRowToModel(DefaultTableModel model, String subjectName, Integer totalMarks, Integer obtainedMarks) {
        if (subjectName != null && (totalMarks != null && totalMarks != 0) && (obtainedMarks != null && obtainedMarks != 0)) {
            model.addRow(new Object[]{subjectName, totalMarks, obtainedMarks});
        }
    }
}
