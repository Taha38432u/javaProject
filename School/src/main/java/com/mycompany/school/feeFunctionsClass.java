/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.school;

/**
 *
 * @author Taha Rasheed
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class feeFunctionsClass {

    private int studentRollNo;
    private String studentName;
    private String studentClass;
    private int fee;

    public void setRecordStudentRollNo(int recordStudentRollNo) {
        this.recordStudentRollNo = recordStudentRollNo;
    }

    public void setRecordStudentName(String recordStudentName) {
        this.recordStudentName = recordStudentName;
    }

    public void setRecordStudentClass(String recordStudentClass) {
        this.recordStudentClass = recordStudentClass;
    }

    public void setRecordPayDate(LocalDate recordPayDate) {
        this.recordPayDate = recordPayDate;
    }

    public void setRecordPaid(String recordPaid) {
        this.recordPaid = recordPaid;
    }

    public int getRecordStudentRollNo() {
        return recordStudentRollNo;
    }

    public String getRecordStudentName() {
        return recordStudentName;
    }

    public String getRecordStudentClass() {
        return recordStudentClass;
    }

    public LocalDate getRecordPayDate() {
        return recordPayDate;
    }

    public String getRecordPaid() {
        return recordPaid;
    }

    private int recordStudentRollNo;
    private String recordStudentName;
    private String recordStudentClass;
    private LocalDate recordPayDate;
    private String recordPaid;

    public feeFunctionsClass() {

    }

    // Getters
    public int getStudentRollNo() {
        return studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public int getFee() {
        return fee;
    }

    // Setters
    public void setStudentRollNo(int studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void addFee(feeFunctionsClass fee) {
        String query = "INSERT INTO studentsFee (studentRollNo, studentName, studentClass, fee) VALUES (?, ?, ?, ?)";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, fee.getStudentRollNo());
            ps.setString(2, fee.getStudentName());
            ps.setString(3, fee.getStudentClass());
//            ps.setDate(4, java.sql.Date.valueOf(fee.getPayDate()));
            ps.setInt(4, fee.getFee());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fee record inserted successfully");
            updateTotalFee();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public String checkAndReturnStudentName(int roll, String studentClass) {
        String query = "SELECT studentFirstName FROM studentInfo WHERE rollNo = ? AND class = ?";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, roll);
            ps.setString(2, studentClass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("studentFirstName");
            } else {
                JOptionPane.showMessageDialog(null, "Student with roll number " + roll + " in class " + studentClass + " does not exist.");
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void updateFee(feeFunctionsClass fee, int oldRollNo, String className) {
        try {
            Connection con = ConnectionClass.db();
            String query = "UPDATE studentsFee SET  "
                    + "fee = ? WHERE studentRollNo = ? AND studentClass = ?";
            PreparedStatement ps = con.prepareStatement(query);

            // Set parameters for the update query
            ps.setInt(1, fee.getFee());
            ps.setInt(2, oldRollNo); // Assuming rollNo uniquely identifies a fee record
            ps.setString(3, className); // Assuming className uniquely identifies a fee record

            // Execute the update query
            int updatedRows = ps.executeUpdate();

            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Fee information updated successfully");
                updateTotalFee();
            } else {
                JOptionPane.showMessageDialog(null, "No fee record found with the specified roll number and class");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void payFee(feeFunctionsClass fee) {
        String query = "INSERT INTO recordsOfFee "
                + "(studentRollNo, studentName, studentClass,payDate,paidOrNot) "
                + "VALUES (?, ?, ?, ?,?)";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, fee.getRecordStudentRollNo());
            ps.setString(2, fee.getRecordStudentName());
            ps.setString(3, fee.getRecordStudentClass());
            ps.setDate(4, java.sql.Date.valueOf(fee.getRecordPayDate()));
            ps.setString(5, fee.getRecordPaid());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fee record inserted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static feeFunctionsClass getFeeByRollNoAndClass(int rollNo, String studentClass) {
        feeFunctionsClass fee = null;
        try {
            Connection con = ConnectionClass.db();
            String query = "SELECT * FROM studentsFee WHERE studentRollNo = ? AND studentClass = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rollNo);
            ps.setString(2, studentClass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fee = new feeFunctionsClass();
                fee.setStudentRollNo(rs.getInt("studentRollNo"));
                fee.setStudentName(rs.getString("studentName"));
                fee.setStudentClass(rs.getString("studentClass"));
                fee.setFee(rs.getInt("fee"));
                System.out.println(fee.getFee());
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fee;
    }

    public void updateTotalFee() {
        String selectQuery = "SELECT SUM(fee) AS totalFee FROM studentsFee";
        String updateQuery = "UPDATE total SET totalFee = ? WHERE id = 1";

        try {
            Connection con = ConnectionClass.db();
            PreparedStatement selectStatement = con.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            // Get the total fee from the result set
            int totalFee = 0;
            if (resultSet.next()) {
                totalFee = resultSet.getInt("totalFee");
            }

            // Update the total fee in the total table
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setInt(1, totalFee);
            updateStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Total fee updated successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
