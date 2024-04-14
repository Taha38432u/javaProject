/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.school;

/**
 *
 * @author System User
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        TitlePanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ToolBarPanel = new javax.swing.JPanel();
        feeMainBtn = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        teacherMainBtn = new javax.swing.JButton();
        studentMainBtn = new javax.swing.JButton();
        attendacneMainButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 0), new java.awt.Dimension(500, 32767));
        jPanel1 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("@FutureStars");
        setBackground(new java.awt.Color(51, 51, 51));
        setLocationByPlatform(true);

        BackgroundPanel.setBackground(new java.awt.Color(153, 153, 153));
        BackgroundPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 5, true));
        BackgroundPanel.setForeground(new java.awt.Color(51, 255, 255));
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitlePanel.setBackground(new java.awt.Color(25, 118, 211));
        TitlePanel.setLayout(null);

        TitleLabel.setBackground(new java.awt.Color(102, 153, 255));
        TitleLabel.setFont(new java.awt.Font("Impact", 0, 44)); // NOI18N
        TitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("INNOVATION SCHOOL MANAGEMENT SYSTEM");
        TitlePanel.add(TitleLabel);
        TitleLabel.setBounds(180, 10, 770, 70);

        BackgroundPanel.add(TitlePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 80));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\Students.png"));
        BackgroundPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 110, 130));

        ToolBarPanel.setBackground(new java.awt.Color(0, 0, 51));
        ToolBarPanel.setLayout(null);

        feeMainBtn.setBackground(new java.awt.Color(25, 118, 211));
        feeMainBtn.setText("Fee");
        feeMainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                feeMainBtnMouseClicked(evt);
            }
        });
        feeMainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                feeMainBtnActionPerformed(evt);
            }
        });
        ToolBarPanel.add(feeMainBtn);
        feeMainBtn.setBounds(30, 500, 100, 40);

        jButton9.setBackground(new java.awt.Color(0, 102, 204));
        jButton9.setText("Subjects");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        ToolBarPanel.add(jButton9);
        jButton9.setBounds(30, 220, 100, 40);

        teacherMainBtn.setBackground(new java.awt.Color(25, 118, 211));
        teacherMainBtn.setText("Teachers");
        teacherMainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherMainBtnMouseClicked(evt);
            }
        });
        teacherMainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherMainBtnActionPerformed(evt);
            }
        });
        ToolBarPanel.add(teacherMainBtn);
        teacherMainBtn.setBounds(30, 290, 100, 40);

        studentMainBtn.setBackground(new java.awt.Color(25, 118, 211));
        studentMainBtn.setText("Students");
        studentMainBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentMainBtnMouseClicked(evt);
            }
        });
        ToolBarPanel.add(studentMainBtn);
        studentMainBtn.setBounds(30, 360, 100, 40);

        attendacneMainButton.setBackground(new java.awt.Color(25, 118, 211));
        attendacneMainButton.setText("Attendance");
        attendacneMainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attendacneMainButtonMouseClicked(evt);
            }
        });
        ToolBarPanel.add(attendacneMainButton);
        attendacneMainButton.setBounds(30, 430, 100, 40);

        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        ToolBarPanel.add(jLabel10);
        jLabel10.setBounds(20, 20, 120, 130);

        jButton14.setBackground(new java.awt.Color(204, 204, 204));
        jButton14.setText("Upload");
        jButton14.setToolTipText("");
        jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true));
        ToolBarPanel.add(jButton14);
        jButton14.setBounds(30, 160, 100, 20);

        BackgroundPanel.add(ToolBarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, 570));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\Classes.png"));
        BackgroundPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 130, 120));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\report-card.png"));
        BackgroundPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 130, 130));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton1.setText("Classes");
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true)));
        BackgroundPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 120, 40));

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton2.setText("Admin");
        jButton2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true)));
        jButton2.setPreferredSize(new java.awt.Dimension(63, 26));
        BackgroundPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 380, 110, 40));

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton3.setText("Subjects");
        jButton3.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true)));
        jButton3.setName(""); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(63, 26));
        BackgroundPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 380, 140, 40));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\Subjects.png"));
        BackgroundPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 250, 170, 140));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\Admin.png"));
        BackgroundPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 160, 130));

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton5.setText("Students");
        jButton5.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true)));
        jButton5.setPreferredSize(new java.awt.Dimension(63, 26));
        BackgroundPanel.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 110, 40));

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jButton6.setText("Report Card");
        jButton6.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 4, true)));
        jButton6.setName(""); // NOI18N
        jButton6.setPreferredSize(new java.awt.Dimension(63, 26));
        BackgroundPanel.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 140, 40));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Notice Board");
        BackgroundPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 100, 40));

        filler1.setBackground(new java.awt.Color(0, 102, 204));
        filler1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 3, true));
        filler1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filler1.setForeground(new java.awt.Color(0, 102, 204));
        BackgroundPanel.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 910, 60));
        filler1.getAccessibleContext().setAccessibleName("");
        filler1.getAccessibleContext().setAccessibleDescription("");

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 204, 204), 5, true));
        jPanel1.setLayout(null);

        jButton7.setBackground(new java.awt.Color(255, 204, 204));
        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 0, 153));
        jButton7.setText("Total Salary");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        jPanel1.add(jButton7);
        jButton7.setBounds(10, 20, 130, 40);

        jTextField2.setBackground(new java.awt.Color(255, 204, 204));
        jTextField2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 153));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("15,000");
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        jPanel1.add(jTextField2);
        jTextField2.setBounds(120, 80, 100, 40);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\Salary.png"));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(160, 20, 50, 40);

        BackgroundPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 230, 140));

        jPanel2.setBackground(new java.awt.Color(51, 255, 204));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 204), 5, true));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jButton4.setBackground(new java.awt.Color(0, 255, 204));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 204));
        jButton4.setText("Total Students");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(20, 20, 130, 40);

        jTextField1.setBackground(new java.awt.Color(0, 255, 204));
        jTextField1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("872");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(156, 80, 64, 40);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\Student.png"));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(170, 20, 30, 40);

        BackgroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 230, 140));

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setLayout(null);

        jButton13.setBackground(new java.awt.Color(153, 255, 153));
        jButton13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(0, 0, 153));
        jButton13.setText("Total Fee Collected");
        jButton13.setToolTipText("");
        jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        jPanel3.add(jButton13);
        jButton13.setBounds(10, 20, 160, 40);

        jTextField3.setBackground(new java.awt.Color(153, 255, 153));
        jTextField3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 153));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("50,000");
        jTextField3.setToolTipText("");
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 153), 1, true));
        jPanel3.add(jTextField3);
        jTextField3.setBounds(120, 80, 100, 40);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\Images\\Fee.png"));
        jPanel3.add(jLabel8);
        jLabel8.setBounds(170, 20, 50, 40);

        BackgroundPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 230, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1085, 658));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void teacherMainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherMainBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherMainBtnActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void feeMainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_feeMainBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_feeMainBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void studentMainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentMainBtnMouseClicked
        studentsFrame stdFrame =  new studentsFrame();
        stdFrame.show();
    }//GEN-LAST:event_studentMainBtnMouseClicked

    private void teacherMainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherMainBtnMouseClicked
       teacherFrame tFrame = new teacherFrame();
       tFrame.show();
    }//GEN-LAST:event_teacherMainBtnMouseClicked

    private void attendacneMainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attendacneMainButtonMouseClicked
        attendanceFrame attFrame = new attendanceFrame();
        attFrame.show();
    }//GEN-LAST:event_attendacneMainButtonMouseClicked

    private void feeMainBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_feeMainBtnMouseClicked
        feeFrame feeFram = new feeFrame();
        feeFram.show();
    }//GEN-LAST:event_feeMainBtnMouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        subjectFrame subFrame = new subjectFrame();
        subFrame.show();
    }//GEN-LAST:event_jButton9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TitlePanel;
    private javax.swing.JPanel ToolBarPanel;
    private javax.swing.JButton attendacneMainButton;
    private javax.swing.JButton feeMainBtn;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton studentMainBtn;
    private javax.swing.JButton teacherMainBtn;
    // End of variables declaration//GEN-END:variables
}
