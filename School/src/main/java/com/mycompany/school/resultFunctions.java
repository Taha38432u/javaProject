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
public class resultFunctions {

    private Integer resultId;
    private Integer studentRollNo;
    private String studentClassId;
    private String subject1Name;
    private Integer subject1TotalMarks;
    private Integer subject1ObtainedMarks;
    private String subject2Name;
    private Integer subject2TotalMarks;
    private Integer subject2ObtainedMarks;
    private String subject3Name;
    private Integer subject3TotalMarks;
    private Integer subject3ObtainedMarks;
    private String subject4Name;
    private Integer subject4TotalMarks;
    private Integer subject4ObtainedMarks;
    private String subject5Name;
    private Integer subject5TotalMarks;
    private Integer subject5ObtainedMarks;
    private String subject6Name;
    private Integer subject6TotalMarks;
    private Integer subject6ObtainedMarks;
    private String subject7Name;
    private Integer subject7TotalMarks;
    private Integer subject7ObtainedMarks;
    private String subject8Name;
    private Integer subject8TotalMarks;
    private Integer subject8ObtainedMarks;
    private String subject9Name;
    private Integer subject9TotalMarks;
    private Integer subject9ObtainedMarks;
    private String subject10Name;
    private Integer subject10TotalMarks;
    private Integer subject10ObtainedMarks;
    private String testType;

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public int getObtainedMarks() {
        return obtainedMarks;
    }

    public void setObtainedMarks(int obtainedMarks) {
        this.obtainedMarks = obtainedMarks;
    }

    public int getObtainedPercentage() {
        return obtainedPercentage;
    }

    public void setObtainedPercentage(int obtainedPercentage) {
        this.obtainedPercentage = obtainedPercentage;
    }
    private int totalMarks;
    private int obtainedMarks;
    private int obtainedPercentage;

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(Integer studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(String studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getSubject1Name() {
        return subject1Name;
    }

    public void setSubject1Name(String subject1Name) {
        this.subject1Name = subject1Name;
    }

    public Integer getSubject1TotalMarks() {
        return subject1TotalMarks;
    }

    public void setSubject1TotalMarks(Integer subject1TotalMarks) {
        this.subject1TotalMarks = subject1TotalMarks;
    }

    public Integer getSubject1ObtainedMarks() {
        return subject1ObtainedMarks;
    }

    public void setSubject1ObtainedMarks(Integer subject1ObtainedMarks) {
        this.subject1ObtainedMarks = subject1ObtainedMarks;
    }

    public String getSubject2Name() {
        return subject2Name;
    }

    public void setSubject2Name(String subject2Name) {
        this.subject2Name = subject2Name;
    }

    public Integer getSubject2TotalMarks() {
        return subject2TotalMarks;
    }

    public void setSubject2TotalMarks(Integer subject2TotalMarks) {
        this.subject2TotalMarks = subject2TotalMarks;
    }

    public Integer getSubject2ObtainedMarks() {
        return subject2ObtainedMarks;
    }

    public void setSubject2ObtainedMarks(Integer subject2ObtainedMarks) {
        this.subject2ObtainedMarks = subject2ObtainedMarks;
    }

    public String getSubject3Name() {
        return subject3Name;
    }

    public void setSubject3Name(String subject3Name) {
        this.subject3Name = subject3Name;
    }

    public Integer getSubject3TotalMarks() {
        return subject3TotalMarks;
    }

    public void setSubject3TotalMarks(Integer subject3TotalMarks) {
        this.subject3TotalMarks = subject3TotalMarks;
    }

    public Integer getSubject3ObtainedMarks() {
        return subject3ObtainedMarks;
    }

    public void setSubject3ObtainedMarks(Integer subject3ObtainedMarks) {
        this.subject3ObtainedMarks = subject3ObtainedMarks;
    }

    public String getSubject4Name() {
        return subject4Name;
    }

    public void setSubject4Name(String subject4Name) {
        this.subject4Name = subject4Name;
    }

    public Integer getSubject4TotalMarks() {
        return subject4TotalMarks;
    }

    public void setSubject4TotalMarks(Integer subject4TotalMarks) {
        this.subject4TotalMarks = subject4TotalMarks;
    }

    public Integer getSubject4ObtainedMarks() {
        return subject4ObtainedMarks;
    }

    public void setSubject4ObtainedMarks(Integer subject4ObtainedMarks) {
        this.subject4ObtainedMarks = subject4ObtainedMarks;
    }

    public String getSubject5Name() {
        return subject5Name;
    }

    public void setSubject5Name(String subject5Name) {
        this.subject5Name = subject5Name;
    }

    public Integer getSubject5TotalMarks() {
        return subject5TotalMarks;
    }

    public void setSubject5TotalMarks(Integer subject5TotalMarks) {
        this.subject5TotalMarks = subject5TotalMarks;
    }

    public Integer getSubject5ObtainedMarks() {
        return subject5ObtainedMarks;
    }

    public void setSubject5ObtainedMarks(Integer subject5ObtainedMarks) {
        this.subject5ObtainedMarks = subject5ObtainedMarks;
    }

    public String getSubject6Name() {
        return subject6Name;
    }

    public void setSubject6Name(String subject6Name) {
        this.subject6Name = subject6Name;
    }

    public Integer getSubject6TotalMarks() {
        return subject6TotalMarks;
    }

    public void setSubject6TotalMarks(Integer subject6TotalMarks) {
        this.subject6TotalMarks = subject6TotalMarks;
    }

    public Integer getSubject6ObtainedMarks() {
        return subject6ObtainedMarks;
    }

    public void setSubject6ObtainedMarks(Integer subject6ObtainedMarks) {
        this.subject6ObtainedMarks = subject6ObtainedMarks;
    }

    public String getSubject7Name() {
        return subject7Name;
    }

    public void setSubject7Name(String subject7Name) {
        this.subject7Name = subject7Name;
    }

    public Integer getSubject7TotalMarks() {
        return subject7TotalMarks;
    }

    public void setSubject7TotalMarks(Integer subject7TotalMarks) {
        this.subject7TotalMarks = subject7TotalMarks;
    }

    public Integer getSubject7ObtainedMarks() {
        return subject7ObtainedMarks;
    }

    public void setSubject7ObtainedMarks(Integer subject7ObtainedMarks) {
        this.subject7ObtainedMarks = subject7ObtainedMarks;
    }

    public String getSubject8Name() {
        return subject8Name;
    }

    public void setSubject8Name(String subject8Name) {
        this.subject8Name = subject8Name;
    }

    public Integer getSubject8TotalMarks() {
        return subject8TotalMarks;
    }

    public void setSubject8TotalMarks(Integer subject8TotalMarks) {
        this.subject8TotalMarks = subject8TotalMarks;
    }

    public Integer getSubject8ObtainedMarks() {
        return subject8ObtainedMarks;
    }

    public void setSubject8ObtainedMarks(Integer subject8ObtainedMarks) {
        this.subject8ObtainedMarks = subject8ObtainedMarks;
    }

    public String getSubject9Name() {
        return subject9Name;
    }

    public void setSubject9Name(String subject9Name) {
        this.subject9Name = subject9Name;
    }

    public Integer getSubject9TotalMarks() {
        return subject9TotalMarks;
    }

    public void setSubject9TotalMarks(Integer subject9TotalMarks) {
        this.subject9TotalMarks = subject9TotalMarks;
    }

    public Integer getSubject9ObtainedMarks() {
        return subject9ObtainedMarks;
    }

    public void setSubject9ObtainedMarks(Integer subject9ObtainedMarks) {
        this.subject9ObtainedMarks = subject9ObtainedMarks;
    }

    public String getSubject10Name() {
        return subject10Name;
    }

    public void setSubject10Name(String subject10Name) {
        this.subject10Name = subject10Name;
    }

    public Integer getSubject10TotalMarks() {
        return subject10TotalMarks;
    }

    public void setSubject10TotalMarks(Integer subject10TotalMarks) {
        this.subject10TotalMarks = subject10TotalMarks;
    }

    public Integer getSubject10ObtainedMarks() {
        return subject10ObtainedMarks;
    }

    public void setSubject10ObtainedMarks(Integer subject10ObtainedMarks) {
        this.subject10ObtainedMarks = subject10ObtainedMarks;
    }

    // Default constructor
    public resultFunctions() {
        // Initialize all fields to null
        this.resultId = null;
        this.studentRollNo = null;
        this.studentClassId = null;
        this.subject1Name = null;
        this.subject1TotalMarks = null;
        this.subject1ObtainedMarks = null;
        this.subject2Name = null;
        this.subject2TotalMarks = null;
        this.subject2ObtainedMarks = null;
        this.subject3Name = null;
        this.subject3TotalMarks = null;
        this.subject3ObtainedMarks = null;
        this.subject4Name = null;
        this.subject4TotalMarks = null;
        this.subject4ObtainedMarks = null;
        this.subject5Name = null;
        this.subject5TotalMarks = null;
        this.subject5ObtainedMarks = null;
        this.subject6Name = null;
        this.subject6TotalMarks = null;
        this.subject6ObtainedMarks = null;
        this.subject7Name = null;
        this.subject7TotalMarks = null;
        this.subject7ObtainedMarks = null;
        this.subject8Name = null;
        this.subject8TotalMarks = null;
        this.subject8ObtainedMarks = null;
        this.subject9Name = null;
        this.subject9TotalMarks = null;
        this.subject9ObtainedMarks = null;
        this.subject10Name = null;
        this.subject10TotalMarks = null;
        this.subject10ObtainedMarks = null;
    }

    public void insertResult(resultFunctions result) {
        String query = "INSERT INTO Result (resultId,studentRollNo, studentClassId, "
                + "subject1Name, subject1TotalMarks, subject1ObtainedMarks, "
                + "subject2Name, subject2TotalMarks, subject2ObtainedMarks, "
                + "subject3Name, subject3TotalMarks, subject3ObtainedMarks, "
                + "subject4Name, subject4TotalMarks, subject4ObtainedMarks, "
                + "subject5Name, subject5TotalMarks, subject5ObtainedMarks, "
                + "subject6Name, subject6TotalMarks, subject6ObtainedMarks, "
                + "subject7Name, subject7TotalMarks, subject7ObtainedMarks, "
                + "subject8Name, subject8TotalMarks, subject8ObtainedMarks, "
                + "subject9Name, subject9TotalMarks, subject9ObtainedMarks, "
                + "subject10Name, subject10TotalMarks, subject10ObtainedMarks,testType,totalMarks,obtainedMarks,obtainedpercentage) "
                + "VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

        try (Connection con = ConnectionClass.db(); PreparedStatement pstmt = con.prepareStatement(query)) {

            // Set parameters
            pstmt.setInt(1, result.getResultId());
            pstmt.setInt(2, result.getStudentRollNo());

            pstmt.setString(3, result.getStudentClassId());
            pstmt.setString(4, result.getSubject1Name());
            pstmt.setInt(5, result.getSubject1TotalMarks());
            pstmt.setInt(6, result.getSubject1ObtainedMarks());
            pstmt.setString(7, result.getSubject2Name());
            pstmt.setInt(8, result.getSubject2TotalMarks());
            pstmt.setInt(9, result.getSubject2ObtainedMarks());
            pstmt.setString(10, result.getSubject3Name());
            pstmt.setInt(11, result.getSubject3TotalMarks());
            pstmt.setInt(12, result.getSubject3ObtainedMarks());
            pstmt.setString(13, result.getSubject4Name());
            pstmt.setInt(14, result.getSubject4TotalMarks());
            pstmt.setInt(15, result.getSubject4ObtainedMarks());
            pstmt.setString(16, result.getSubject5Name());
            pstmt.setInt(17, result.getSubject5TotalMarks());
            pstmt.setInt(18, result.getSubject5ObtainedMarks());
            pstmt.setString(19, result.getSubject6Name());
            pstmt.setInt(20, result.getSubject6TotalMarks());
            pstmt.setInt(21, result.getSubject6ObtainedMarks());
            pstmt.setString(22, result.getSubject7Name());
            pstmt.setInt(23, result.getSubject7TotalMarks());
            pstmt.setInt(24, result.getSubject7ObtainedMarks());
            pstmt.setString(25, result.getSubject8Name());
            pstmt.setInt(26, result.getSubject8TotalMarks());
            pstmt.setInt(27, result.getSubject8ObtainedMarks());
            pstmt.setString(28, result.getSubject9Name());
            pstmt.setInt(29, result.getSubject9TotalMarks());
            pstmt.setInt(30, result.getSubject9ObtainedMarks());
            pstmt.setString(31, result.getSubject10Name());
            pstmt.setInt(32, result.getSubject10TotalMarks());
            pstmt.setInt(33, result.getSubject10ObtainedMarks());
            pstmt.setString(34, result.getTestType());
            pstmt.setInt(35, result.getTotalMarks());
            pstmt.setInt(36, result.getObtainedMarks());
            pstmt.setInt(37, result.getObtainedPercentage());

            // Execute query
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Result inserted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Other methods and properties...
    public static resultFunctions retrieveResult(int testResultId, String studentClassId, int studentRollNo) {
        String query = "SELECT * FROM Result WHERE resultId = ? AND studentClassId = ? AND studentRollNo = ?";
        try (Connection con = ConnectionClass.db(); PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, testResultId);
            pstmt.setString(2, studentClassId);
            pstmt.setInt(3, studentRollNo);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                resultFunctions result = new resultFunctions();
                result.setResultId(rs.getInt("resultId"));
                result.setStudentRollNo(rs.getInt("studentRollNo"));
                result.setStudentClassId(rs.getString("studentClassId"));
                result.setSubject1Name(rs.getString("subject1Name"));
                result.setSubject1TotalMarks(rs.getInt("subject1TotalMarks"));
                result.setSubject1ObtainedMarks(rs.getInt("subject1ObtainedMarks"));
                result.setSubject2Name(rs.getString("subject2Name"));
                result.setSubject2TotalMarks(rs.getInt("subject2TotalMarks"));
                result.setSubject2ObtainedMarks(rs.getInt("subject2ObtainedMarks"));

                result.setSubject3Name(rs.getString("subject3Name"));
                result.setSubject3TotalMarks(rs.getInt("subject3TotalMarks"));
                result.setSubject3ObtainedMarks(rs.getInt("subject3ObtainedMarks"));

                result.setSubject4Name(rs.getString("subject4Name"));
                result.setSubject4TotalMarks(rs.getInt("subject4TotalMarks"));
                result.setSubject4ObtainedMarks(rs.getInt("subject4ObtainedMarks"));

                result.setSubject5Name(rs.getString("subject5Name"));
                result.setSubject5TotalMarks(rs.getInt("subject5TotalMarks"));
                result.setSubject5ObtainedMarks(rs.getInt("subject5ObtainedMarks"));

                result.setSubject6Name(rs.getString("subject6Name"));
                result.setSubject6TotalMarks(rs.getInt("subject6TotalMarks"));
                result.setSubject6ObtainedMarks(rs.getInt("subject6ObtainedMarks"));

                result.setSubject7Name(rs.getString("subject7Name"));
                result.setSubject7TotalMarks(rs.getInt("subject7TotalMarks"));
                result.setSubject7ObtainedMarks(rs.getInt("subject7ObtainedMarks"));

                result.setSubject8Name(rs.getString("subject8Name"));
                result.setSubject8TotalMarks(rs.getInt("subject8TotalMarks"));
                result.setSubject8ObtainedMarks(rs.getInt("subject8ObtainedMarks"));

                result.setSubject9Name(rs.getString("subject9Name"));
                result.setSubject9TotalMarks(rs.getInt("subject9TotalMarks"));
                result.setSubject9ObtainedMarks(rs.getInt("subject9ObtainedMarks"));

                result.setSubject10Name(rs.getString("subject10Name"));
                result.setSubject10TotalMarks(rs.getInt("subject10TotalMarks"));
                result.setSubject10ObtainedMarks(rs.getInt("subject10ObtainedMarks"));

                result.setTestType(rs.getString("testType"));
                result.setTotalMarks(rs.getInt("totalMarks"));
                result.setObtainedMarks(rs.getInt("obtainedMarks"));
                result.setObtainedPercentage(rs.getInt("obtainedpercentage"));
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "No result found for the given criteria.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
