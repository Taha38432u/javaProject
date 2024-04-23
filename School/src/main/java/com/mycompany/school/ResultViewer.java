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

public class ResultViewer extends JFrame {

    private JLabel classLabel;
    private JTextField classField;
    private JLabel rollNoLabel;
    private JTextField rollNoField;
    private JLabel resultIdLabel;
    private JTextField resultIdField;
    private JButton showResultButton;

    public ResultViewer() {
        super("Result Viewer");

        // Initialize components
        classLabel = new JLabel("Class:");
        classField = new JTextField(10);
        rollNoLabel = new JLabel("Roll No:");
        rollNoField = new JTextField(10);
        resultIdLabel = new JLabel("Result ID:");
        resultIdField = new JTextField(10);
        showResultButton = new JButton("Show Result");

        // Add action listener to show result button
        showResultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showResult();
            }
        });

        // Set layout
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(classLabel);
        add(classField);
        add(rollNoLabel);
        add(rollNoField);
        add(resultIdLabel);
        add(resultIdField);
        add(showResultButton);

        // Set frame properties
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void showResult() {
        // Get input values
        String className = classField.getText();
        int rollNo = Integer.parseInt(rollNoField.getText());
        int resultId = Integer.parseInt(resultIdField.getText());

        // Query the database for the result
        resultFunctions resultFunc = new resultFunctions();
        resultFunc.setStudentClassId(className);
        resultFunc.setStudentRollNo(rollNo);
        resultFunc.setResultId(resultId);

        resultFunctions result = resultFunctions.retrieveResult(resultId, className, rollNo);

        // Display the result in a new JFrame
        if (result != null) {
            // Check for null subject names and skip corresponding total marks and obtained marks
//        if (result.getSubject1Name() == null) {
//            result.setSubject1TotalMarks(0);
//            result.setSubject1ObtainedMarks(0);
//        }
//        // Repeat this pattern for each subject
//        // ...
//
//        // Display the result
            new ResultDisplay(result);
        } else {
            JOptionPane.showMessageDialog(null, "Result not found!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ResultViewer();
            }
        });
    }
}
