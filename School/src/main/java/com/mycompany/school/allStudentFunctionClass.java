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
import javax.swing.table.*;

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
            updateTotalStudents();
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

    public static allStudentFunctionClass getStudentByRollNo(int rollNo, String className) {
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

    public static void viewStudentsByClass() {
        JFrame frame = new JFrame("View Students by Class");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        // ComboBox to select class
        JComboBox<String> classComboBox = new JComboBox<>(new String[]{
            "KG", "Nursery", "Prep",
            "Class 1", "Class 2", "Class 3", "Class 4", "Class 5",
            "Class 6", "Class 7", "Class 8", "Class 9", "Class 10"});
        classComboBox.setSelectedIndex(0); // Set default selection
        panel.add(classComboBox, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(0, 1));
        panel.add(optionsPanel, BorderLayout.WEST);

        // Create checkboxes for each column
        JCheckBox[] checkboxes = new JCheckBox[11];
        checkboxes[0] = new JCheckBox("Id", true);
        checkboxes[1] = new JCheckBox("Roll No", true);
        checkboxes[2] = new JCheckBox("First Name", true);
        checkboxes[3] = new JCheckBox("Last Name", true);
        checkboxes[4] = new JCheckBox("Date of Birth", true);
        checkboxes[5] = new JCheckBox("City", true);
        checkboxes[6] = new JCheckBox("Gender", true);
        checkboxes[7] = new JCheckBox("Date of Admission", true);
        checkboxes[8] = new JCheckBox("Contact No 1", true);
        checkboxes[9] = new JCheckBox("Contact No 2", true);
        checkboxes[10] = new JCheckBox("Current Address", true);

        for (JCheckBox checkbox : checkboxes) {
            optionsPanel.add(checkbox);
        }

        DefaultTableModel model = new DefaultTableModel() {
            // Override getColumnClass to make sure that date columns are rendered as LocalDate
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 4 || columnIndex == 7) { // Assuming dateOfBirth and dateOfAdmission are at index 4 and 7 respectively
                    return LocalDate.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        JTable table = new JTable(model);
        table.setRowHeight(30); // Set row height
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD)); // Make column headings bold
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); // Make table fill the viewport height
        panel.add(scrollPane, BorderLayout.CENTER);

        classComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                model.setRowCount(0); // Clear existing rows

                try {
                    Connection con = ConnectionClass.db();
                    String query = "SELECT * FROM studentInfo WHERE class = ?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, selectedClass);
                    ResultSet rs = ps.executeQuery();

                    // Clear all columns
                    model.setColumnCount(0);

                    // Add selected column headings to the model
                    for (int i = 0; i < checkboxes.length; i++) {
                        if (checkboxes[i].isSelected()) {
                            switch (i) {
                                case 0 ->
                                    model.addColumn("Id");
                                case 1 ->
                                    model.addColumn("Roll No");
                                case 2 ->
                                    model.addColumn("First Name");
                                case 3 ->
                                    model.addColumn("Last Name");
                                case 4 ->
                                    model.addColumn("Date of Birth");
                                case 5 ->
                                    model.addColumn("City");
                                case 6 ->
                                    model.addColumn("Gender");
                                case 7 ->
                                    model.addColumn("Date of Admission");
                                case 8 ->
                                    model.addColumn("Contact No 1");
                                case 9 ->
                                    model.addColumn("Contact No 2");
                                case 10 ->
                                    model.addColumn("Current Address");
                            }
                        }
                    }

                    // Populate the table with data
                    while (rs.next()) {
                        Object[] row = new Object[model.getColumnCount()];
                        for (int i = 0; i < model.getColumnCount(); i++) {
                            String columnName = model.getColumnName(i);
                            switch (columnName) {
                                case "Id" ->
                                    row[i] = rs.getInt("Id");
                                case "Roll No" ->
                                    row[i] = rs.getInt("rollNo");
                                case "First Name" ->
                                    row[i] = rs.getString("studentFirstName");
                                case "Last Name" ->
                                    row[i] = rs.getString("studentLastName");
                                case "Date of Birth" ->
                                    row[i] = rs.getDate("dateOfBirth").toLocalDate();
                                case "City" ->
                                    row[i] = rs.getString("City");
                                case "Gender" ->
                                    row[i] = rs.getString("gender");
                                case "Date of Admission" ->
                                    row[i] = rs.getDate("dateOfAdmission").toLocalDate();
                                case "Contact No 1" ->
                                    row[i] = rs.getString("contactNo1");
                                case "Contact No 2" ->
                                    row[i] = rs.getString("contactNo2");
                                case "Current Address" ->
                                    row[i] = rs.getString("currentAddress");
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

        frame.setVisible(true);
    }

    public void updateTotalStudents() {
        String selectQuery = "SELECT COUNT(*) AS totalStudents FROM studentInfo";
        String updateQuery = "UPDATE total SET totalStudents = ? WHERE id = 1";

        try {
            Connection con = ConnectionClass.db();
            PreparedStatement selectStatement = con.prepareStatement(selectQuery);
            ResultSet resultSet = selectStatement.executeQuery();

            // Get the total number of students from the result set
            int totalStudents = 0;
            if (resultSet.next()) {
                totalStudents = resultSet.getInt("totalStudents");
            }

            // Update the total students in the total table
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setInt(1, totalStudents);
            updateStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Total students updated successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void parentInfo() {
        JFrame frame = new JFrame("Parent Information by Class");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        // ComboBox to select class
        JComboBox<String> classComboBox = new JComboBox<>(new String[]{
            "KG", "Nursery", "Prep",
            "Class 1", "Class 2", "Class 3", "Class 4", "Class 5",
            "Class 6", "Class 7", "Class 8", "Class 9", "Class 10"});
        classComboBox.setSelectedIndex(0); // Set default selection
        panel.add(classComboBox, BorderLayout.NORTH);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setRowHeight(30); // Set row height
        table.getTableHeader().setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD)); // Make column headings bold
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true); // Make table fill the viewport height
        panel.add(scrollPane, BorderLayout.CENTER);

        classComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                model.setRowCount(0); // Clear existing rows

                try {
                    Connection con = ConnectionClass.db();
                    String query = "SELECT studentFirstName, studentLastName, rollNo, parentFirstName, parentLastName, "
                            + "profession, contactNo1, contactNo2 FROM studentInfo WHERE class = ?";
                    PreparedStatement ps = con.prepareStatement(query);
                    ps.setString(1, selectedClass);
                    ResultSet rs = ps.executeQuery();

                    // Set column names
                    model.setColumnIdentifiers(new String[]{"Student Name", "Roll No", "Parent First Name", "Parent Last Name", "Profession", "Contact No 1", "Contact No 2"});

                    // Populate the table with parent information
                    while (rs.next()) {
                        Object[] row = new Object[7];
                        row[0] = rs.getString("studentFirstName") + " " + rs.getString("studentLastName");
                        row[1] = rs.getInt("rollNo");
                        row[2] = rs.getString("parentFirstName");
                        row[3] = rs.getString("parentLastName");
                        row[4] = rs.getString("profession");
                        row[5] = rs.getString("contactNo1");
                        row[6] = rs.getString("contactNo2");
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

        frame.setVisible(true);
    }

}
