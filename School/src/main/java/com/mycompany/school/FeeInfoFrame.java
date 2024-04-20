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

public class FeeInfoFrame extends JFrame {

    private JComboBox<String> classComboBox;
    private JTable table;

    public FeeInfoFrame() {
        setTitle("Fee Records");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create class options
        String[] classOptions = {"Kg", "Nursery", "Prep", "Class 1", "Class 2", "Class 3", "Class 4", "Class 5", "Class 6", "Class 7", "Class 8", "Class 9", "Class 10"};
        classComboBox = new JComboBox<>(classOptions);

        JPanel classPanel = new JPanel();
        classPanel.add(new JLabel("Select Class: "));
        classPanel.add(classComboBox);
        add(classPanel, BorderLayout.NORTH);

        String[] columns = {"Roll No", "Student Name", "Pay Date", "Payment Status"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        classComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                viewFeeInfo(selectedClass);
            }
        });
    }

    public void viewFeeInfo(String studentClass) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear previous data

        String query = "SELECT * FROM recordsOfFee WHERE studentClass = ?";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, studentClass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int rollNo = rs.getInt("studentRollNo");
                String studentName = rs.getString("studentName");
                String payDate = rs.getDate("payDate").toString();
                String paidOrNot = rs.getString("paidOrNot");

                Object[] row = {rollNo, studentName, payDate, paidOrNot};
                model.addRow(row);
            }

            rs.close();
            ps.close();
            con.close();
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
