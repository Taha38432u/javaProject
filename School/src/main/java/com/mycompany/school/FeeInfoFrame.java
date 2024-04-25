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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeeInfoFrame extends JFrame {

    private JComboBox<String> classComboBox;
    private JComboBox<String> monthComboBox;
    private JTable table;

    public FeeInfoFrame() {
        setTitle("Fee Records");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create class options
        String[] classOptions = {"Kg", "Nursery", "Prep", "Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "Class 6", "Class 7", "Class 8", "Class 9", "Class 10"};
        classComboBox = new JComboBox<>(classOptions);
        String[] month = {"Jan", "Feb", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(month);
        JPanel classPanel = new JPanel();
        classPanel.add(new JLabel("Select Class: "));
        classPanel.add(classComboBox);
        classPanel.add(new JLabel("Select Month"));
        classPanel.add(monthComboBox);
        add(classPanel, BorderLayout.NORTH);

        String[] columns = {"Roll No", "Student Name", "Pay Date", "Payment Status","Fee"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        classComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                String selectedMonth = getMonthNumber((String) monthComboBox.getSelectedItem());
                viewFeeInfo(selectedClass, selectedMonth);
            }
        });
    }
// Utility method to convert month name to its corresponding numerical value

    private String getMonthNumber(String monthName) {
        switch (monthName) {
            case "Jan":
                return "01";
            case "Feb":
                return "02";
            case "March":
                return "03";
            case "April":
                return "04";
            case "May":
                return "05";
            case "June":
                return "06";
            case "July":
                return "07";
            case "August":
                return "08";
            case "September":
                return "09";
            case "October":
                return "10";
            case "November":
                return "11";
            case "December":
                return "12";
            default:
                return null;
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

    public void viewFeeInfo(String studentClass, String selectedMonth) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous data
        int month = Integer.parseInt(selectedMonth);
        String query = "";
        switch (month) {
            case 1:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 01 AND YEAR(payDate) = 2024";
                break;
            case 2:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 02 AND YEAR(payDate) = 2024";
                break;
            case 3:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 03 AND YEAR(payDate) = 2024";
                break;
            case 4:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 04 AND YEAR(payDate) = 2024";
                break;
            case 5:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 05 AND YEAR(payDate) = 2024";
                break;
            case 6:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 06 AND YEAR(payDate) = 2024";
                break;
            case 7:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 07 AND YEAR(payDate) = 2024";
                break;
            case 8:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 08 AND YEAR(payDate) = 2024";
                break;
            case 9:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 9 AND YEAR(payDate) = 2024";
                break;
            case 10:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 10 AND YEAR(payDate) = 2024";
                break;
            case 11:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 11 AND YEAR(payDate) = 2024";
                break;
            case 12:
                query = "SELECT * FROM recordsOfFee WHERE studentClass = ? AND MONTH(payDate) = 12 AND YEAR(payDate) = 2024";
                break;
            default:
                // Handle the case where month is not within the range 1-12
                break;
        }

        // Add cases for other months as needed
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentClass);

            ResultSet rs = ps.executeQuery();
            double totalFeeCollected = 0.0; // Initialize total fee collected for this month
            while (rs.next()) {
                int rollNo = rs.getInt("studentRollNo");
                String studentName = rs.getString("studentName");
                String payDate = rs.getDate("payDate").toString();
                String paidOrNot = rs.getString("paidOrNot");

                // Fetch fee from the studentsFee table
                int fee = fetchFeeFromDatabase(rollNo, studentClass);

                Object[] row = {rollNo, studentName, payDate, paidOrNot, fee}; // Add fee to the row
                model.addRow(row);

                // Calculate total fee collected
                totalFeeCollected += fee;
            }

            rs.close();
            ps.close();
            con.close();

            // Display total fee collected
            JOptionPane.showMessageDialog(this, "Total Fee Collected in this month: " + totalFeeCollected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FeeInfoFrame frame = new FeeInfoFrame();
            frame.setVisible(true);
        });
    }
}
