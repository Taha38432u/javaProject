/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.school;

import javax.swing.JFrame;

/**
 *
 * @author Taha Rasheed
 */
public class teacherFrame extends javax.swing.JFrame {

    /**
     * Creates new form teacherFrame
     */
    public teacherFrame() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        viewInfoBtn2 = new javax.swing.JButton();
        addTeacherBtn2 = new javax.swing.JButton();
        updateTeacherBtn2 = new javax.swing.JButton();
        deleteTeacherBtn2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(28, 126, 214));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setText("Teachers");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(206, 212, 218));
        jPanel7.setPreferredSize(new java.awt.Dimension(648, 513));

        jPanel8.setBackground(new java.awt.Color(0, 0, 153));

        viewInfoBtn2.setBackground(new java.awt.Color(28, 126, 214));
        viewInfoBtn2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        viewInfoBtn2.setForeground(new java.awt.Color(33, 37, 41));
        viewInfoBtn2.setText("View Info");
        viewInfoBtn2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 126, 214), 3, true));
        viewInfoBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewInfoBtn2ActionPerformed(evt);
            }
        });

        addTeacherBtn2.setBackground(new java.awt.Color(28, 126, 214));
        addTeacherBtn2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        addTeacherBtn2.setForeground(new java.awt.Color(33, 37, 41));
        addTeacherBtn2.setText("Add Teacher");
        addTeacherBtn2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 126, 214), 3, true));
        addTeacherBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTeacherBtn2MouseClicked(evt);
            }
        });
        addTeacherBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherBtn2ActionPerformed(evt);
            }
        });

        updateTeacherBtn2.setBackground(new java.awt.Color(28, 126, 214));
        updateTeacherBtn2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        updateTeacherBtn2.setForeground(new java.awt.Color(33, 37, 41));
        updateTeacherBtn2.setText("Update Teacher");
        updateTeacherBtn2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 126, 214), 3, true));
        updateTeacherBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateTeacherBtn2MouseClicked(evt);
            }
        });
        updateTeacherBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTeacherBtn2ActionPerformed(evt);
            }
        });

        deleteTeacherBtn2.setBackground(new java.awt.Color(28, 126, 214));
        deleteTeacherBtn2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        deleteTeacherBtn2.setForeground(new java.awt.Color(33, 37, 41));
        deleteTeacherBtn2.setText("Delete Teacher");
        deleteTeacherBtn2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 126, 214), 3, true));
        deleteTeacherBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTeacherBtn2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(28, 126, 214));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Dashboard");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(28, 126, 214), 3, true));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateTeacherBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteTeacherBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTeacherBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewInfoBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewInfoBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addTeacherBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(updateTeacherBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteTeacherBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewInfoBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewInfoBtn2ActionPerformed
        viewInfoTeacher viewInfo = new viewInfoTeacher();
        viewInfo.show();
    }//GEN-LAST:event_viewInfoBtn2ActionPerformed

    private void addTeacherBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTeacherBtn2MouseClicked
        addTeacher aTeach = new addTeacher();
        aTeach.show();
    }//GEN-LAST:event_addTeacherBtn2MouseClicked

    private void addTeacherBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherBtn2ActionPerformed

    }//GEN-LAST:event_addTeacherBtn2ActionPerformed

    private void updateTeacherBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateTeacherBtn2MouseClicked
        updateTeacher uTeach = new updateTeacher();
        uTeach.show();
    }//GEN-LAST:event_updateTeacherBtn2MouseClicked

    private void updateTeacherBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTeacherBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateTeacherBtn2ActionPerformed

    private void deleteTeacherBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTeacherBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteTeacherBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(teacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teacherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teacherFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTeacherBtn;
    private javax.swing.JButton addTeacherBtn1;
    private javax.swing.JButton addTeacherBtn2;
    private javax.swing.JButton deleteTeacherBtn;
    private javax.swing.JButton deleteTeacherBtn1;
    private javax.swing.JButton deleteTeacherBtn2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton updateTeacherBtn;
    private javax.swing.JButton updateTeacherBtn1;
    private javax.swing.JButton updateTeacherBtn2;
    private javax.swing.JButton viewInfoBtn;
    private javax.swing.JButton viewInfoBtn1;
    private javax.swing.JButton viewInfoBtn2;
    // End of variables declaration//GEN-END:variables
}