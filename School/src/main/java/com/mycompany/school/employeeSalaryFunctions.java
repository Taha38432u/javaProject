/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.school;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Taha Rasheed
 */
public class employeeSalaryFunctions {

    private int employeeId;
    private int salary;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void insertEmployeeSalary(employeeSalaryFunctions employeeSalary) {
        String query = "INSERT INTO employeeSalary (employeeId, salary) VALUES (?, ?)";

        try {
            Connection con = ConnectionClass.db();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, employeeSalary.getEmployeeId());
            pstmt.setInt(2, employeeSalary.getSalary());

            // Execute the INSERT statement
            pstmt.executeUpdate();
            updateTotalSalary();

            JOptionPane.showMessageDialog(null, "Employee salary record inserted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateTotalSalary() {
        String selectQuery = "SELECT SUM(salary) AS totalSalary FROM employeeSalary";
        String updateQuery = "UPDATE total SET totalSalary = ? WHERE id = 1";

        try {
            Connection con = ConnectionClass.db();
            PreparedStatement selectStatement = con.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            // Get the total salary from the result set
            int totalSalary = 0;
            if (resultSet.next()) {
                totalSalary = resultSet.getInt("totalSalary");
            }

            // Update the total salary in the total table
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setInt(1, totalSalary);
            updateStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Total salary updated successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static employeeSalaryFunctions getEmployeeSalaryByEmployeeId(int employeeId) {
        employeeSalaryFunctions salary = null;
        try {
            Connection con = ConnectionClass.db();
            String query = "SELECT * FROM employeeSalary WHERE employeeId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                salary = new employeeSalaryFunctions();
                salary.setEmployeeId(rs.getInt("employeeId"));
                salary.setSalary(rs.getInt("salary"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salary;
    }

    public void updateEmployeeSalary(employeeSalaryFunctions salary) {
        try {
            Connection con = ConnectionClass.db();
            String query = "UPDATE employeeSalary SET salary = ? WHERE employeeId = ?";
            PreparedStatement ps = con.prepareStatement(query);

            // Set parameters for the update query
            ps.setInt(1, salary.getSalary());
            ps.setInt(2, salary.getEmployeeId());

            // Execute the update query
            int updatedRows = ps.executeUpdate();

            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Employee salary updated successfully");
                updateTotalSalary();
            } else {
                JOptionPane.showMessageDialog(null, "No employee found with the specified employee ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void displayAllEmployeeSalaries() {
        try {
            Connection con = ConnectionClass.db();
            String query = "SELECT employeeId, salary FROM employeeSalary";
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            // Create a JTable to display the data
            JTable table = new JTable(buildTableModel(rs));
            JScrollPane scrollPane = new JScrollPane(table);

            // Show the table in a dialog
            JOptionPane.showMessageDialog(null, scrollPane, "All Employees' Salaries", JOptionPane.PLAIN_MESSAGE);

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Helper method to convert ResultSet to DefaultTableModel
    public DefaultTableModel buildTableModel(ResultSet rs) throws Exception {
        // Get ResultSet metadata
        java.sql.ResultSetMetaData metaData = rs.getMetaData();

        // Get number of columns in ResultSet
        int columnCount = metaData.getColumnCount();

        // Create DefaultTableModel to hold data
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add columns to the table model
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        // Add rows to the table model
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
                row[i] = rs.getObject(i + 1);
            }
            tableModel.addRow(row);
        }

        return tableModel;
    }
}
