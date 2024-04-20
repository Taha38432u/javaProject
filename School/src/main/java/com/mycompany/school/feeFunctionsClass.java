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
    private LocalDate payDate;
    private String paidOrNot;
    private int fee;

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

    public LocalDate getPayDate() {
        return payDate;
    }

    public String getPaidOrNot() {
        return paidOrNot;
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

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public void setPaidOrNot(String paidOrNot) {
        this.paidOrNot = paidOrNot;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void addFee(feeFunctionsClass fee) {
        String query = "INSERT INTO studentFee (studentRollNo, studentName, studentClass,  paidOrNot, fee) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, fee.getStudentRollNo());
            ps.setString(2, fee.getStudentName());
            ps.setString(3, fee.getStudentClass());
//            ps.setDate(4, java.sql.Date.valueOf(fee.getPayDate()));
            ps.setString(4, fee.getPaidOrNot());
            ps.setInt(5, fee.getFee());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Fee record inserted successfully");
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


}
