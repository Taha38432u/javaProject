/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.school;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Taha Rasheed
 */
public class subjectFunctions {

    private String subjectName;
    private String className;

    public String getSubjectName() {
        return subjectName;
    }

    public String getClassName() {
        return className;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void insertSubject(subjectFunctions subject) {
        String query = "insert into subjectInfo (subjectName,class) values (?,?)";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, subject.getSubjectName());
            ps.setString(2, subject.getClassName());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record inserted successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public List<String> getSubjectsForClass(String className) {
        List<String> subjects = new ArrayList<>();
        String query = "SELECT subjectName FROM subjectInfo WHERE class = ?";
        try {
            Connection con = ConnectionClass.db();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, className);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                subjects.add(rs.getString("subjectName"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return subjects;
    }

    public void updateSubjectsForClass(String className, List<String> updatedSubjects) {
        try {
            Connection con = ConnectionClass.db();

            // Delete existing subjects for the class
            String deleteQuery = "DELETE FROM subjectInfo WHERE class = ?";
            PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
            deleteStatement.setString(1, className);
            deleteStatement.executeUpdate();

            // Insert updated subjects
            String insertQuery = "INSERT INTO subjectInfo (subjectName, class) VALUES (?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertQuery);
            for (String subject : updatedSubjects) {
                insertStatement.setString(1, subject);
                insertStatement.setString(2, className);
                insertStatement.addBatch(); // Add each insert query to batch
            }
            insertStatement.executeBatch(); // Execute batch of insert queries

            JOptionPane.showMessageDialog(null, "Subjects updated successfully");

            deleteStatement.close();
            insertStatement.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
