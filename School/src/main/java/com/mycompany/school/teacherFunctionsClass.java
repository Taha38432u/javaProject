/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.school;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.*;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Taha Rasheed
 */
public class teacherFunctionsClass {

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String city;
    private String currentAddress;
    private String gender;
    private String contactNo;
    private LocalDate dateOfJoining;
    private String currentPosition;
    private int employeeId;

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public String getGender() {
        return gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void insertTeacher(teacherFunctionsClass teacher) {
        String query = "INSERT INTO teacherInfo (firstName, lastName, dateOfBirth, "
                + "City, currentAddress, Gender, contactNo, dateOfJoining, currentPosition, employeeId) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = ConnectionClass.db();
            PreparedStatement pstmt = con.prepareStatement(query); // Set values using getter methods of Teacher object
            pstmt.setString(1, teacher.getFirstName());
            pstmt.setString(2, teacher.getLastName());
            pstmt.setDate(3, java.sql.Date.valueOf(teacher.getDateOfBirth()));
            pstmt.setString(4, teacher.getCity());
            pstmt.setString(5, teacher.getCurrentAddress());
            pstmt.setString(6, teacher.getGender());
            pstmt.setString(7, teacher.getContactNo());
            pstmt.setDate(8, java.sql.Date.valueOf(teacher.getDateOfJoining()));
            pstmt.setString(9, teacher.getCurrentPosition());
            pstmt.setInt(10, teacher.getEmployeeId());

            // Execute the INSERT statement
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record inserted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void updateTeacher(teacherFunctionsClass teacher, int oldEmployeeId) {
        try {
            Connection con = ConnectionClass.db();
            String query = "UPDATE teacherInfo SET firstName = ?, lastName = ?, dateOfBirth = ?, "
                    + "City = ?, currentAddress = ?, Gender = ?, contactNo = ?, dateOfJoining = ?, "
                    + "currentPosition = ?, employeeId = ? WHERE employeeId = ?";
            PreparedStatement ps = con.prepareStatement(query);

            // Set parameters for the update query
            ps.setString(1, teacher.getFirstName());
            ps.setString(2, teacher.getLastName());
            ps.setDate(3, java.sql.Date.valueOf(teacher.getDateOfBirth()));
            ps.setString(4, teacher.getCity());
            ps.setString(5, teacher.getCurrentAddress());
            ps.setString(6, teacher.getGender());
            ps.setString(7, teacher.getContactNo());
            ps.setDate(8, java.sql.Date.valueOf(teacher.getDateOfJoining()));
            ps.setString(9, teacher.getCurrentPosition());
            ps.setInt(10, teacher.getEmployeeId());
            ps.setInt(11, oldEmployeeId); // Assuming employeeId uniquely identifies a teacher

            // Execute the update query
            int updatedRows = ps.executeUpdate();

            if (updatedRows > 0) {
                JOptionPane.showMessageDialog(null, "Teacher information updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No teacher found with the specified employee ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static teacherFunctionsClass getTeacherByEmployeeId(int employeeId) {
        teacherFunctionsClass teacher = null;
        try {
            Connection con = ConnectionClass.db();
            String query = "SELECT * FROM teacherInfo WHERE employeeId = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, employeeId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacher = new teacherFunctionsClass();
                teacher.setFirstName(rs.getString("firstName"));
                teacher.setLastName(rs.getString("lastName"));
                teacher.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                teacher.setCity(rs.getString("City"));
                teacher.setCurrentAddress(rs.getString("currentAddress"));
                teacher.setGender(rs.getString("Gender"));
                teacher.setContactNo(rs.getString("contactNo"));
                teacher.setDateOfJoining(rs.getDate("dateOfJoining").toLocalDate());
                teacher.setCurrentPosition(rs.getString("currentPosition"));
                teacher.setEmployeeId(rs.getInt("employeeId"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacher;
    }

    public static void viewTeachersByAttributes() {
        JFrame frame = new JFrame("View Teachers by Attributes");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        JPanel optionsPanel = new JPanel(new GridLayout(0, 1));
        panel.add(optionsPanel, BorderLayout.WEST);

        // Create checkboxes for each attribute
        JCheckBox[] checkboxes = new JCheckBox[10];
        checkboxes[0] = new JCheckBox("Id", false);
        checkboxes[1] = new JCheckBox("First Name", true);
        checkboxes[2] = new JCheckBox("Last Name", true);
        checkboxes[3] = new JCheckBox("Date of Birth", true);
        checkboxes[4] = new JCheckBox("City", false);
        checkboxes[5] = new JCheckBox("Current Address", false);
        checkboxes[6] = new JCheckBox("Gender", true);
        checkboxes[7] = new JCheckBox("Contact No", false);
        checkboxes[8] = new JCheckBox("Date of Joining", false);
        checkboxes[9] = new JCheckBox("Current Position", false);

        for (JCheckBox checkbox : checkboxes) {
            optionsPanel.add(checkbox);
        }

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setRowHeight(30); // Set row height
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD)); // Make column headings bold
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); // Make table fill the viewport height
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton showButton = new JButton("Show");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                model.setRowCount(0); // Clear existing rows
                model.setColumnCount(0); // Clear existing columns

                // Add selected column headings to the model
                for (int i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].isSelected()) {
                        switch (i) {
                            case 0 ->
                                model.addColumn("Id");
                            case 1 ->
                                model.addColumn("First Name");
                            case 2 ->
                                model.addColumn("Last Name");
                            case 3 ->
                                model.addColumn("Date of Birth");
                            case 4 ->
                                model.addColumn("City");
                            case 5 ->
                                model.addColumn("Current Address");
                            case 6 ->
                                model.addColumn("Gender");
                            case 7 ->
                                model.addColumn("Contact No");
                            case 8 ->
                                model.addColumn("Date of Joining");
                            case 9 ->
                                model.addColumn("Current Position");
                        }
                    }
                }

                // Populate the table with data
                try {
                    Connection con = ConnectionClass.db();
                    String query = "SELECT * FROM teacherInfo";
                    PreparedStatement ps = con.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        Object[] row = new Object[model.getColumnCount()];
                        for (int i = 0; i < model.getColumnCount(); i++) {
                            String columnName = model.getColumnName(i);
                            switch (columnName) {
                                case "Id" ->
                                    row[i] = rs.getInt("employeeId");
                                case "First Name" ->
                                    row[i] = rs.getString("firstName");
                                case "Last Name" ->
                                    row[i] = rs.getString("lastName");
                                case "Date of Birth" ->
                                    row[i] = rs.getDate("dateOfBirth").toLocalDate();
                                case "City" ->
                                    row[i] = rs.getString("City");
                                case "Current Address" ->
                                    row[i] = rs.getString("currentAddress");
                                case "Gender" ->
                                    row[i] = rs.getString("Gender");
                                case "Contact No" ->
                                    row[i] = rs.getString("contactNo");
                                case "Date of Joining" ->
                                    row[i] = rs.getDate("dateOfJoining").toLocalDate();
                                case "Current Position" ->
                                    row[i] = rs.getString("currentPosition");
                            }
                        }
                        model.addRow(row);
                    }

                    rs.close();
                    ps.close();
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });

        panel.add(showButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

}
