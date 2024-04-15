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
public class allStudentFunctionClass {

    private String studentFirstName;
    private String studentLastName;
    private LocalDate dateOfBirth;
    private String city;
    private String currentAddress;
    private String permanentAddress;
    private String gender;
    private LocalDate dateOfAdmission;
    private String studentClass;
    private int rollNo;
    private String parentFirstName;
    private String parentLastName;
    private String profession;
    private String contactNo1;
    private String contactNo2;

    // Constructor
    public allStudentFunctionClass() {
    }

    // Getter and setter methods for each field
    public void setParentFirstName(String parentFirstName) {
        this.parentFirstName = parentFirstName;
    }

    public void setParentLastName(String parentLastName) {
        this.parentLastName = parentLastName;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setContactNo1(String contactNo1) {
        this.contactNo1 = contactNo1;
    }

    public String getParentFirstName() {
        return parentFirstName;
    }

    public String getParentLastName() {
        return parentLastName;
    }

    public String getProfession() {
        return profession;
    }

    public String getContactNo1() {
        return contactNo1;
    }

    public String getContactNo2() {
        return contactNo2;
    }

    public void setContactNo2(String contactNo2) {
        this.contactNo2 = contactNo2;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int roll) {
        this.rollNo = roll;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(LocalDate dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public void insertStudent(allStudentFunctionClass student) {
        String query = "INSERT INTO studentInfo (studentFirstName, studentLastName, dateOfBirth, "
                + "City, "
                + "currentAddress, permanentAddress, gender, dateOfAdmission, class,rollNo,"
                + "parentFirstName,parentLastName,profession,contactNo1,contactNo2) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";

        try {
            Connection con = ConnectionClass.db();
            PreparedStatement pstmt = con.prepareStatement(query); // Set values using getter methods of Student object
            pstmt.setString(1, student.getStudentFirstName());
            pstmt.setString(2, student.getStudentLastName());
            pstmt.setDate(3, java.sql.Date.valueOf(student.getDateOfBirth()));
            pstmt.setString(4, student.getCity());
            pstmt.setString(5, student.getCurrentAddress());
            pstmt.setString(6, student.getPermanentAddress());
            pstmt.setString(7, student.getGender());
            pstmt.setDate(8, java.sql.Date.valueOf(student.getDateOfAdmission()));
            pstmt.setString(9, student.getStudentClass());
            pstmt.setInt(10, student.getRollNo());
            pstmt.setString(11, student.getParentFirstName());
            pstmt.setString(12, student.getParentLastName());
            pstmt.setString(13, student.getProfession());
            pstmt.setString(14, student.getContactNo1());
            pstmt.setString(15, student.getContactNo2());

            // Execute the INSERT statement
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record inserted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateStudent(allStudentFunctionClass student, int oldRollNo) {
        try {
            Connection con = ConnectionClass.db();
            String query = "UPDATE studentInfo SET studentFirstName = ?, studentLastName = ?, dateOfBirth = ?, "
                    + "City = ?, currentAddress = ?, permanentAddress = ?, gender = ?, dateOfAdmission = ?, "
                    + "class = ?, parentFirstName = ?, parentLastName = ?, profession = ?, contactNo1 = ?, "
                    + "contactNo2 = ?,rollNo = ? WHERE rollNo = ? and class = ?";
            PreparedStatement ps = con.prepareStatement(query);

            // Set parameters for the update query
            ps.setString(1, student.getStudentFirstName());
            ps.setString(2, student.getStudentLastName());
            ps.setDate(3, java.sql.Date.valueOf(student.getDateOfBirth()));
            ps.setString(4, student.getCity());
            ps.setString(5, student.getCurrentAddress());
            ps.setString(6, student.getPermanentAddress());
            ps.setString(7, student.getGender());
            ps.setDate(8, java.sql.Date.valueOf(student.getDateOfAdmission()));
            ps.setString(9, student.getStudentClass());
            ps.setString(10, student.getParentFirstName());
            ps.setString(11, student.getParentLastName());
            ps.setString(12, student.getProfession());
            ps.setString(13, student.getContactNo1());
            ps.setString(14, student.getContactNo2());
            ps.setInt(15, student.getRollNo()); // Assuming rollNo uniquely identifies a student
            ps.setInt(16, oldRollNo); // Assuming rollNo uniquely identifies a student
            ps.setString(17, student.getStudentClass()); // Assuming rollNo uniquely identifies a student


            // Execute the update query
            int updatedRows = ps.executeUpdate();

            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Student information updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No student found with the specified roll number");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static allStudentFunctionClass getStudentByRollNo(int rollNo, String className ) {
        allStudentFunctionClass student = null;
        try {
            Connection con = ConnectionClass.db();
            String query = "SELECT * FROM studentInfo WHERE rollNo = ? and class = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rollNo);
            ps.setString(2, className);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student = new allStudentFunctionClass();
                student.setStudentFirstName(rs.getString("studentFirstName"));
                student.setStudentLastName(rs.getString("studentLastName"));
                student.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                student.setCity(rs.getString("City"));
                student.setCurrentAddress(rs.getString("currentAddress"));
                student.setPermanentAddress(rs.getString("permanentAddress"));
                student.setGender(rs.getString("gender"));
                student.setDateOfAdmission(rs.getDate("dateOfAdmission").toLocalDate());
                student.setStudentClass(rs.getString("class"));
                student.setRollNo(rs.getInt("rollNo"));
                student.setParentFirstName(rs.getString("parentFirstName"));
                student.setParentLastName(rs.getString("parentLastName"));
                student.setProfession(rs.getString("profession"));
                student.setContactNo1(rs.getString("contactNo1"));
                student.setContactNo2(rs.getString("contactNo2"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
}
