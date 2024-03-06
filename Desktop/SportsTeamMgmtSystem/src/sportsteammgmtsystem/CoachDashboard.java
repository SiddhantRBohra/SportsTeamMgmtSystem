/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsteammgmtsystem;

/**
 *
 * @author sidbohra
 */
public class CoachDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public CoachDashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        CD_msg_lbl.setText("Welcome Coach "+LoginPage.coachName);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CD_ViewAllPastFixtures_btn1 = new javax.swing.JButton();
        CoachDashboardPanel = new javax.swing.JPanel();
        CD_AllUpcomingFixtures_btn = new javax.swing.JButton();
        CD_MyUpcomingFixtures_btn = new javax.swing.JButton();
        CD_AllPastFixtures_btn = new javax.swing.JButton();
        CD_MyPastFixtures_btn = new javax.swing.JButton();
        STMS_lbl2 = new javax.swing.JLabel();
        CD_msg_lbl = new javax.swing.JLabel();

        CD_ViewAllPastFixtures_btn1.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        CD_ViewAllPastFixtures_btn1.setForeground(new java.awt.Color(0, 102, 102));
        CD_ViewAllPastFixtures_btn1.setText("ALL PAST FIXTURES");
        CD_ViewAllPastFixtures_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_ViewAllPastFixtures_btn1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CoachDashboardPanel.setBackground(new java.awt.Color(0, 102, 102));

        CD_AllUpcomingFixtures_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        CD_AllUpcomingFixtures_btn.setForeground(new java.awt.Color(0, 102, 102));
        CD_AllUpcomingFixtures_btn.setText("ALL UPCOMING FIXTURES");
        CD_AllUpcomingFixtures_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_AllUpcomingFixtures_btnActionPerformed(evt);
            }
        });

        CD_MyUpcomingFixtures_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        CD_MyUpcomingFixtures_btn.setForeground(new java.awt.Color(0, 102, 102));
        CD_MyUpcomingFixtures_btn.setText("MY UPCOMING FIXTURES");
        CD_MyUpcomingFixtures_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_MyUpcomingFixtures_btnActionPerformed(evt);
            }
        });

        CD_AllPastFixtures_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        CD_AllPastFixtures_btn.setForeground(new java.awt.Color(0, 102, 102));
        CD_AllPastFixtures_btn.setText("ALL PAST FIXTURES");
        CD_AllPastFixtures_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_AllPastFixtures_btnActionPerformed(evt);
            }
        });

        CD_MyPastFixtures_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        CD_MyPastFixtures_btn.setForeground(new java.awt.Color(0, 102, 102));
        CD_MyPastFixtures_btn.setText("MY PAST FIXTURES");
        CD_MyPastFixtures_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CD_MyPastFixtures_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CoachDashboardPanelLayout = new javax.swing.GroupLayout(CoachDashboardPanel);
        CoachDashboardPanel.setLayout(CoachDashboardPanelLayout);
        CoachDashboardPanelLayout.setHorizontalGroup(
            CoachDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoachDashboardPanelLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(CoachDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CoachDashboardPanelLayout.createSequentialGroup()
                        .addComponent(CD_AllPastFixtures_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CD_MyPastFixtures_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CoachDashboardPanelLayout.createSequentialGroup()
                        .addComponent(CD_AllUpcomingFixtures_btn)
                        .addGap(18, 18, 18)
                        .addComponent(CD_MyUpcomingFixtures_btn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CoachDashboardPanelLayout.setVerticalGroup(
            CoachDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoachDashboardPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(CoachDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CD_AllUpcomingFixtures_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CD_MyUpcomingFixtures_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CoachDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CD_AllPastFixtures_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CD_MyPastFixtures_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        STMS_lbl2.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl2.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl2.setText("Sports Team Management System");

        CD_msg_lbl.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(STMS_lbl2)
                        .addGap(0, 201, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CoachDashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CD_msg_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(STMS_lbl2)
                .addGap(35, 35, 35)
                .addComponent(CD_msg_lbl)
                .addGap(35, 35, 35)
                .addComponent(CoachDashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CD_AllUpcomingFixtures_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_AllUpcomingFixtures_btnActionPerformed
        
        AllUpcomingFixtures ad=new AllUpcomingFixtures(LoginPage.name);
        ad.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_CD_AllUpcomingFixtures_btnActionPerformed

    private void CD_AllPastFixtures_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_AllPastFixtures_btnActionPerformed
        AllPastFixtures pf = new AllPastFixtures();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CD_AllPastFixtures_btnActionPerformed

    private void CD_MyUpcomingFixtures_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_MyUpcomingFixtures_btnActionPerformed
        CoachMyFixture ad=new CoachMyFixture();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CD_MyUpcomingFixtures_btnActionPerformed

    private void CD_ViewAllPastFixtures_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_ViewAllPastFixtures_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CD_ViewAllPastFixtures_btn1ActionPerformed

    private void CD_MyPastFixtures_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CD_MyPastFixtures_btnActionPerformed
        CoachPastFixtures cpf = new CoachPastFixtures();
        cpf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CD_MyPastFixtures_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see htCD_AllUpcomingFixtures_btne/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CoachDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoachDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoachDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoachDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoachDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CD_AllPastFixtures_btn;
    private javax.swing.JButton CD_AllUpcomingFixtures_btn;
    private javax.swing.JButton CD_MyPastFixtures_btn;
    private javax.swing.JButton CD_MyUpcomingFixtures_btn;
    private javax.swing.JButton CD_ViewAllPastFixtures_btn1;
    private javax.swing.JLabel CD_msg_lbl;
    private javax.swing.JPanel CoachDashboardPanel;
    private javax.swing.JLabel STMS_lbl2;
    // End of variables declaration//GEN-END:variables
}
