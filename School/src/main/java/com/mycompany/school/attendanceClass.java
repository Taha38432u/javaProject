/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.school;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Taha Rasheed
 */
public class attendanceClass {

    private int teacherId;
    private LocalDate attendanceDate;
    private String status;

    public attendanceClass() {
        // Default constructor
    }


    // Getters
   

    public int getTeacherId() {
        return teacherId;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
   

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void insertTeacherAttendance(attendanceClass teacherAttendance) {
        // Check if the teacherId exists before inserting the attendance record
        if (!teacherIdExists(teacherAttendance.getTeacherId())) {
            JOptionPane.showMessageDialog(null, "Teacher with ID " + teacherAttendance.getTeacherId() + " does not exist.");
            return; // Exit the method if the teacherId does not exist
        }

        String query = "INSERT INTO TeacherAttendance (teacherId, attendanceDate, status) "
                + "VALUES (?, ?, ?)";

        try {
            Connection con = ConnectionClass.db();
            PreparedStatement pstmt = con.prepareStatement(query); // Set values using getter methods of TeacherAttendance object
            pstmt.setInt(1, teacherAttendance.getTeacherId());
            pstmt.setDate(2, java.sql.Date.valueOf(teacherAttendance.getAttendanceDate()));
            pstmt.setString(3, teacherAttendance.getStatus());

            // Execute the INSERT statement
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Teacher attendance record inserted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

// Method to check if the teacherId exists in the teacherInfo table
    private boolean teacherIdExists(int teacherId) {
        String query = "SELECT COUNT(*) FROM teacherInfo WHERE employeeId = ?";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, teacherId);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0; // Return true if the teacherId exists, false otherwise
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false; // Return false in case of any exception
        }
    }

}
