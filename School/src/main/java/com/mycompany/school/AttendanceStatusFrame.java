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
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AttendanceStatusFrame extends JFrame {

    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField employeeIdField;
    private JTextArea resultTextArea;
    private JButton checkButton;

    public AttendanceStatusFrame() {
        setTitle("Check Attendance Status");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel startDateLabel = new JLabel("Start Date (YYYY-MM-DD):");
        startDateField = new JTextField();
        JLabel endDateLabel = new JLabel("End Date (YYYY-MM-DD):");
        endDateField = new JTextField();
        JLabel employeeIdLabel = new JLabel("Employee ID:");
        employeeIdField = new JTextField();
        checkButton = new JButton("Check");
        inputPanel.add(startDateLabel);
        inputPanel.add(startDateField);
        inputPanel.add(endDateLabel);
        inputPanel.add(endDateField);
        inputPanel.add(employeeIdLabel);
        inputPanel.add(employeeIdField);
        inputPanel.add(new JLabel()); // Placeholder
        inputPanel.add(checkButton);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add action listener to the check button
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAttendanceStatus();
            }
        });

        setVisible(true);
    }

    private void checkAttendanceStatus() {
        try {
            // Get input values
            LocalDate startDate = LocalDate.parse(startDateField.getText());
            LocalDate endDate = LocalDate.parse(endDateField.getText());
            int employeeId = Integer.parseInt(employeeIdField.getText());

            // Retrieve attendance status from the database
            List<LocalDate> presentDates = getAttendanceDates(startDate, endDate, employeeId, "P");
            List<LocalDate> absentDates = getAttendanceDates(startDate, endDate, employeeId, "A");

            // Display the status
            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append("Start Date: ").append(startDate).append("\n");
            resultBuilder.append("End Date: ").append(endDate).append("\n\n");

            resultBuilder.append("Present Dates:\n");
            for (LocalDate date : presentDates) {
                resultBuilder.append(date).append("\n");
            }

            resultBuilder.append("\nAbsent Dates:\n");
            for (LocalDate date : absentDates) {
                resultBuilder.append(date).append("\n");
            }

            JOptionPane.showMessageDialog(null, resultBuilder.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private List<LocalDate> getAttendanceDates(LocalDate startDate, LocalDate endDate, int employeeId, String status) {
        List<LocalDate> dates = new ArrayList<>();
        String query = "SELECT attendanceDate FROM TeacherAttendance WHERE teacherId = ? AND attendanceDate BETWEEN ? AND ? AND status = ?";

        try (Connection con = ConnectionClass.db(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, employeeId);
            pstmt.setDate(2, java.sql.Date.valueOf(startDate));
            pstmt.setDate(3, java.sql.Date.valueOf(endDate));
            pstmt.setString(4, status);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LocalDate date = rs.getDate("attendanceDate").toLocalDate();
                dates.add(date);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
        }

        return dates;
    }

    public static void main(String[] args) {
        new AttendanceStatusFrame();
    }
}
