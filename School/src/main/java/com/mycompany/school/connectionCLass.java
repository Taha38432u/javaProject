/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.school;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Taha Rasheed
 */
public class connectionCLass {

    static Connection con = null;

    public static Connection db() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conn = "jdbc:sqlserver://localhost:1433; databaseName=school;user=taha;password=taha;encrypt=true;trustServerCertificate=true";
            con = DriverManager.getConnection(conn);

            JOptionPane.showMessageDialog(null, "Connection Established");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
}
