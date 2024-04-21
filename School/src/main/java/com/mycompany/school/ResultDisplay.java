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
import javax.swing.table.DefaultTableCellRenderer;

public class ResultDisplay extends JFrame {

    private resultFunctions result;

    public ResultDisplay(resultFunctions result) {
        super("Result Details");
        this.result = result;

        // Create a table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Subject");
        model.addColumn("Total Marks");
        model.addColumn("Obtained Marks");

        // Add data to the table model
        addRowToModel(model, result.getSubject1Name(), result.getSubject1TotalMarks(), result.getSubject1ObtainedMarks());
        addRowToModel(model, result.getSubject2Name(), result.getSubject2TotalMarks(), result.getSubject2ObtainedMarks());
        // Add rows for other subjects similarly...

        // Create the table
        JTable table = new JTable(model);
        table.setRowHeight(30); // Set row height for better visibility

        // Center align column headers
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

        // Set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(200); // Subject column
        table.getColumnModel().getColumn(1).setPreferredWidth(100); // Total Marks column
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Obtained Marks column

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Create labels and text fields for total marks, total obtained marks, and obtained percentage
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

        // Create a panel to hold the labels and text fields
        JPanel totalPanel = new JPanel(new GridLayout(3, 2));
        totalPanel.add(totalMarksLabel);
        totalPanel.add(totalMarksField);
        totalPanel.add(totalObtainedMarksLabel);
        totalPanel.add(totalObtainedMarksField);
        totalPanel.add(obtainedPercentageLabel);
        totalPanel.add(obtainedPercentageField);

        // Add the scroll pane and total panel to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(totalPanel, BorderLayout.SOUTH);

        // Set frame properties
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void addRowToModel(DefaultTableModel model, String subjectName, Integer totalMarks, Integer obtainedMarks) {
        if (subjectName != null && (totalMarks != null && totalMarks != 0) && (obtainedMarks != null && obtainedMarks != 0)) {
            model.addRow(new Object[]{subjectName, totalMarks, obtainedMarks});
        }
    }
}

