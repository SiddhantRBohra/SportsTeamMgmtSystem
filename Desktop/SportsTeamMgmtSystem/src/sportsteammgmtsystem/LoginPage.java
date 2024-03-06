/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsteammgmtsystem;

import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author sidbohra
 */
public class LoginPage extends javax.swing.JFrame {

   private String username;
   private String password;
   public static String coachName;
   public static String studentName;
   public static  String name;
   public static String category ,email;
    public LoginPage() {
        initComponents();
        this.setLocationRelativeTo(null);// setlocation at the center of screen
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        STMS_lbl4 = new javax.swing.JLabel();
        LoginPagePanel = new javax.swing.JPanel();
        LP_Username_lbl = new javax.swing.JLabel();
        LP_Password_lbl = new javax.swing.JLabel();
        LP_Username_txt = new javax.swing.JTextField();
        LP_Password_txt = new javax.swing.JPasswordField();
        LP_SignIn_btn = new javax.swing.JButton();
        LP_Reset_btn = new javax.swing.JButton();
        LP_ForgotPassword_btn = new javax.swing.JButton();
        LP_SignUp_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        STMS_lbl4.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl4.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl4.setText(" Sports Team Management System");

        LoginPagePanel.setBackground(new java.awt.Color(0, 102, 102));

        LP_Username_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        LP_Username_lbl.setForeground(new java.awt.Color(255, 255, 255));
        LP_Username_lbl.setText("Username");

        LP_Password_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        LP_Password_lbl.setForeground(new java.awt.Color(255, 255, 255));
        LP_Password_lbl.setText("Password");

        LP_Username_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LP_Username_txtActionPerformed(evt);
            }
        });

        LP_Password_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LP_Password_txtActionPerformed(evt);
            }
        });

        LP_SignIn_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        LP_SignIn_btn.setForeground(new java.awt.Color(0, 102, 102));
        LP_SignIn_btn.setText("Sign In");
        LP_SignIn_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LP_SignIn_btnActionPerformed(evt);
            }
        });

        LP_Reset_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        LP_Reset_btn.setForeground(new java.awt.Color(0, 102, 102));
        LP_Reset_btn.setText("Reset");
        LP_Reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LP_Reset_btnActionPerformed(evt);
            }
        });

        LP_ForgotPassword_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        LP_ForgotPassword_btn.setForeground(new java.awt.Color(0, 102, 102));
        LP_ForgotPassword_btn.setText("Forgot Password");
        LP_ForgotPassword_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LP_ForgotPassword_btnActionPerformed(evt);
            }
        });

        LP_SignUp_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        LP_SignUp_btn.setForeground(new java.awt.Color(0, 102, 102));
        LP_SignUp_btn.setText("Sign Up");
        LP_SignUp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LP_SignUp_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPagePanelLayout = new javax.swing.GroupLayout(LoginPagePanel);
        LoginPagePanel.setLayout(LoginPagePanelLayout);
        LoginPagePanelLayout.setHorizontalGroup(
            LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                .addGroup(LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginPagePanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(LP_ForgotPassword_btn))
                            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                .addComponent(LP_Username_lbl)
                                .addGap(18, 18, 18)
                                .addComponent(LP_Username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                .addComponent(LP_Password_lbl)
                                .addGap(18, 18, 18)
                                .addGroup(LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(LoginPagePanelLayout.createSequentialGroup()
                                        .addComponent(LP_SignIn_btn)
                                        .addGap(29, 29, 29)
                                        .addComponent(LP_Reset_btn))
                                    .addComponent(LP_Password_txt)))))
                    .addGroup(LoginPagePanelLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(LP_SignUp_btn)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        LoginPagePanelLayout.setVerticalGroup(
            LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPagePanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LP_Username_lbl)
                    .addComponent(LP_Username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LP_Password_lbl)
                    .addComponent(LP_Password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LP_SignIn_btn)
                    .addComponent(LP_Reset_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LP_ForgotPassword_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LP_SignUp_btn)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(STMS_lbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginPagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(STMS_lbl4)
                .addGap(27, 27, 27)
                .addComponent(LoginPagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LP_Username_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LP_Username_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LP_Username_txtActionPerformed

    private void LP_ForgotPassword_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LP_ForgotPassword_btnActionPerformed
        
        ForgotPasswordPage fp=new ForgotPasswordPage();
        fp.setVisible(true);
        this.setVisible(false);
        
        
        
    }//GEN-LAST:event_LP_ForgotPassword_btnActionPerformed

    private void LP_SignIn_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LP_SignIn_btnActionPerformed
        if(this.LP_Username_txt.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"username cannot be empty");
        }
        else if(this.LP_Password_txt.getText().isEmpty()){
             JOptionPane.showMessageDialog(this,"password cannot be empty");
        }
        else{
            
            
            
          try{
            
               Class.forName("java.sql.DriverManager"); //loading and registering drivers required for MYSQL
               
               Connection con=ConnectDB.getConnect();
               Statement s=con.createStatement();
                ResultSet r=s.executeQuery("select * from login_details where email='"+this.LP_Username_txt.getText()+"' and password='"+this.LP_Password_txt.getText()+"'" ); 
                if(r.next()){ 
                    
                    name=r.getString(2)+" "+r.getString(3);
                        JOptionPane.showMessageDialog(this, "welcome "+name);
                                category=r.getString("category");
                                email=r.getString("email");
                        if(category.equals("Coach")){
                            coachName=r.getString("firstname")+" "+r.getString("lastname");
                            CoachDashboard d=new CoachDashboard();
                            d.setVisible(true);
                            this.dispose();}
                        else {
                            studentName = r.getString("firstname")+" "+r.getString("lastname");
                            StudentDashboard d=new StudentDashboard();
                            d.setVisible(true);
                            this.dispose();
                        }
                }else
                    JOptionPane.showMessageDialog(this, "Wrong Login Credentials");
           
                 
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }  
        }
    }//GEN-LAST:event_LP_SignIn_btnActionPerformed
        
    private void LP_Reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LP_Reset_btnActionPerformed
        this.LP_Username_txt.setText("");
        this.LP_Password_txt.setText("");
    }//GEN-LAST:event_LP_Reset_btnActionPerformed

    private void LP_Password_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LP_Password_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LP_Password_txtActionPerformed

    private void LP_SignUp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LP_SignUp_btnActionPerformed
       
        SignUp s=new SignUp();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LP_SignUp_btnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LP_ForgotPassword_btn;
    private javax.swing.JLabel LP_Password_lbl;
    private javax.swing.JPasswordField LP_Password_txt;
    private javax.swing.JButton LP_Reset_btn;
    private javax.swing.JButton LP_SignIn_btn;
    private javax.swing.JButton LP_SignUp_btn;
    private javax.swing.JLabel LP_Username_lbl;
    private javax.swing.JTextField LP_Username_txt;
    private javax.swing.JPanel LoginPagePanel;
    private javax.swing.JLabel STMS_lbl4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
