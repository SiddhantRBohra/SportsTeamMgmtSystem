/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsteammgmtsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.sql.*;
/**
 *
 * @author sidbohra
 */
public class SignUp extends javax.swing.JFrame {
    private String firstName, lastName, emailID, password, category;
    public SignUp() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public SignUp(String firstName, String lastName, String emailID){
        initComponents();
        this.setLocationRelativeTo(null);
        this.SU_FirstName_txt.setText(firstName);
        this.SU_LastName_txt.setText(lastName);
        this.SU_EmailID_txt.setText(emailID);
        this.SU_Student_radbtn.setSelected(true);}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        STMS_lbl5 = new javax.swing.JLabel();
        SignUpPanel = new javax.swing.JPanel();
        SU_EmailIB_lbl = new javax.swing.JLabel();
        SU_FirstName_lbl = new javax.swing.JLabel();
        SU_Next_btn = new javax.swing.JButton();
        SignUp_Role_btn = new javax.swing.JPanel();
        SU_Coach_radbtn = new javax.swing.JRadioButton();
        SU_Student_radbtn = new javax.swing.JRadioButton();
        SU_LastName_lbl = new javax.swing.JLabel();
        SU_ConfirmPassword_lbl = new javax.swing.JLabel();
        SU_Password_lbl = new javax.swing.JLabel();
        SU_ConfirmPassword_txt = new javax.swing.JPasswordField();
        SU_Reset_btn = new javax.swing.JButton();
        SU_Back_btn = new javax.swing.JButton();
        SU_FirstName_txt = new javax.swing.JTextField();
        SU_EmailID_txt = new javax.swing.JTextField();
        SU_LastName_txt = new javax.swing.JTextField();
        SU_Password_txt = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        STMS_lbl5.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl5.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl5.setText("Sports Team Management System");

        SignUpPanel.setBackground(new java.awt.Color(0, 102, 102));

        SU_EmailIB_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SU_EmailIB_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SU_EmailIB_lbl.setText("Email ID");

        SU_FirstName_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SU_FirstName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SU_FirstName_lbl.setText("First Name");

        SU_Next_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        SU_Next_btn.setForeground(new java.awt.Color(0, 102, 102));
        SU_Next_btn.setText("Next");
        SU_Next_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_Next_btnActionPerformed(evt);
            }
        });

        SignUp_Role_btn.setBackground(new java.awt.Color(255, 255, 255));
        SignUp_Role_btn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Who are you?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(0, 102, 102))); // NOI18N

        buttonGroup1.add(SU_Coach_radbtn);
        SU_Coach_radbtn.setText("Coach");

        buttonGroup1.add(SU_Student_radbtn);
        SU_Student_radbtn.setText("Student");
        SU_Student_radbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_Student_radbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SignUp_Role_btnLayout = new javax.swing.GroupLayout(SignUp_Role_btn);
        SignUp_Role_btn.setLayout(SignUp_Role_btnLayout);
        SignUp_Role_btnLayout.setHorizontalGroup(
            SignUp_Role_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUp_Role_btnLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(SU_Coach_radbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(SU_Student_radbtn)
                .addGap(54, 54, 54))
        );
        SignUp_Role_btnLayout.setVerticalGroup(
            SignUp_Role_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SignUp_Role_btnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SignUp_Role_btnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SU_Coach_radbtn)
                    .addComponent(SU_Student_radbtn))
                .addGap(38, 38, 38))
        );

        SU_LastName_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SU_LastName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SU_LastName_lbl.setText("Last Name");

        SU_ConfirmPassword_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SU_ConfirmPassword_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SU_ConfirmPassword_lbl.setText("Confirm Password");

        SU_Password_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        SU_Password_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SU_Password_lbl.setText("Password");

        SU_ConfirmPassword_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_ConfirmPassword_txtActionPerformed(evt);
            }
        });

        SU_Reset_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        SU_Reset_btn.setForeground(new java.awt.Color(0, 102, 102));
        SU_Reset_btn.setText("Reset");
        SU_Reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_Reset_btnActionPerformed(evt);
            }
        });

        SU_Back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        SU_Back_btn.setForeground(new java.awt.Color(0, 102, 102));
        SU_Back_btn.setText("Back");
        SU_Back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_Back_btnActionPerformed(evt);
            }
        });

        SU_FirstName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_FirstName_txtActionPerformed(evt);
            }
        });

        SU_EmailID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_EmailID_txtActionPerformed(evt);
            }
        });

        SU_LastName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_LastName_txtActionPerformed(evt);
            }
        });

        SU_Password_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SU_Password_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SignUpPanelLayout = new javax.swing.GroupLayout(SignUpPanel);
        SignUpPanel.setLayout(SignUpPanelLayout);
        SignUpPanelLayout.setHorizontalGroup(
            SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUpPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addComponent(SU_Password_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SU_Password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SignUp_Role_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                                        .addComponent(SU_Next_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(SU_Reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(SU_Back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(SignUpPanelLayout.createSequentialGroup()
                                .addComponent(SU_ConfirmPassword_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SU_ConfirmPassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(SU_FirstName_lbl)
                                .addComponent(SU_LastName_lbl))
                            .addComponent(SU_EmailIB_lbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SU_FirstName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SU_EmailID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SU_LastName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 116, Short.MAX_VALUE))
        );
        SignUpPanelLayout.setVerticalGroup(
            SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignUpPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SU_EmailIB_lbl)
                    .addComponent(SU_EmailID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SU_FirstName_lbl)
                            .addComponent(SU_FirstName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SU_LastName_lbl)
                            .addComponent(SU_LastName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(SignUp_Role_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SU_Next_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SU_Back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SU_Reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SignUpPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SU_Password_lbl)
                            .addComponent(SU_Password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SignUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SU_ConfirmPassword_lbl)
                            .addComponent(SU_ConfirmPassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SignUpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(STMS_lbl5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(STMS_lbl5)
                .addGap(18, 18, 18)
                .addComponent(SignUpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SU_ConfirmPassword_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_ConfirmPassword_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SU_ConfirmPassword_txtActionPerformed

    private void SU_Student_radbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_Student_radbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SU_Student_radbtnActionPerformed

    private void SU_Next_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_Next_btnActionPerformed
        // TODO add your handling code here:
        
        
        if(validateEntries()==true)
            insertRecords();    
    }//GEN-LAST:event_SU_Next_btnActionPerformed
public boolean validateEntries(){
    boolean flag=true;
    //Regular Expression
//reference:https://regexr.com/3e48o
        /*
        [A-Z] characters allowed
        [a-z] characters allowed
        [0-9] numbers allowed
        Additionally email may contain only dot(.), dash(-) and underscore(_)
        Requires an @
            */
        
        if(!this.SU_EmailID_txt.getText().isEmpty()){
            String regex="^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
             Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(this.SU_EmailID_txt.getText());
            if(matcher.matches()==false){
                flag=false;
                JOptionPane.showMessageDialog(this, "Invalid Email Address");
            }
        }
        else{
             flag=false;
            JOptionPane.showMessageDialog(this, "Email field cannot be left blank");
         }
    if(this.SU_FirstName_txt.getText().isEmpty()){
        flag=false;
        JOptionPane.showMessageDialog(this, "First Name field cannot be left blank");
    }else if(this.SU_LastName_txt.getText().isEmpty()){
        flag=false;
        JOptionPane.showMessageDialog(this, "Last Name field cannot be left blank");
    } else if(this.SU_Password_txt.getText().isEmpty()){
        flag=false;
        JOptionPane.showMessageDialog(this, "Password field cannot be left blank");
    } else if(this.SU_ConfirmPassword_txt.getText().isEmpty()){
        flag=false;
        JOptionPane.showMessageDialog(this, "Confirm Password field cannot be left blank");
    } else if(!this.SU_ConfirmPassword_txt.getText().equals(this.SU_Password_txt.getText())){
        flag=false;
        JOptionPane.showMessageDialog(this, "Password and Confirm Password Field Does Not Match");
    } 
    
    else if(!this.SU_Coach_radbtn.isSelected() && !this.SU_Student_radbtn.isSelected()){
        flag=false;
        JOptionPane.showMessageDialog(this, "Please Select User Type");
    }
    
    if(flag==true){
        this.firstName=this.SU_FirstName_txt.getText();
        this.lastName=this.SU_LastName_txt.getText();
        this.emailID=this.SU_EmailID_txt.getText();
        this.password=this.SU_Password_txt.getText();
       if(this.SU_Coach_radbtn.isSelected())
           this.category="Coach";
       else
           this.category="Student";   
    }  
    return flag;
}

public void insertRecords(){
  boolean dataConfirmed = false;
  try {
        Class.forName("java.sql.DriverManager"); //loading drivers to connect GUI with databse
        Connection c = ConnectDB.getConnect(); //getting connection with Sports_db
        Statement st = c.createStatement(); //enabling SQL statements  in java code
        
        if(this.category.equals("Student")){
                int confirmation = JOptionPane.showConfirmDialog(this, "Can you confirm the data you have inputted is correct?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    dataConfirmed = true;
                    int y = st.executeUpdate("insert into login_details values('" + this.emailID + "','" 
                    + this.firstName + "','" +this.lastName+"','"+this.password+"','"+this.category+"')");
                    if (y > 0){
                        this.SU_EmailID_txt.setEnabled(false);
                        StudentSignUp lp=new StudentSignUp(this.firstName,this.lastName,this.emailID); 
                        lp.setVisible(true);
                        this.dispose(); 
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please review and correct your information."); 
                }   
            } else {
                int confirmation = JOptionPane.showConfirmDialog(this, "Can you confirm the data you have inputted is correct?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    dataConfirmed = true;
                    int y = st.executeUpdate("insert into login_details values('" + this.emailID + "','" 
                    + this.firstName + "','" +this.lastName+"','"+this.password+"','"+this.category+"')");
                    if (y > 0) {
                        CoachSignUp lp=new CoachSignUp(this.firstName,this.lastName,this.emailID); 
                        lp.setVisible(true);
                        this.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please review and correct your information.");
                }
            }    
      } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
    private void SU_Reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_Reset_btnActionPerformed
//        this.signup_emailID_txt.setText("");
//        this.signup_firstname_txt.setText("");
//        this.signup_lastname_txt.setText("");
//        this.signup_pwd_txt.setText("");
//        this.signup_cfm_pwd_txt.setText("");
//        this.signup_coach_radbtn.setSelected(false);
//        this.signup_student_radbtn.setSelected(false);

SignUp obj=new SignUp();
obj.setVisible(true);
this.dispose();
        
        
    }//GEN-LAST:event_SU_Reset_btnActionPerformed

    private void SU_Back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_Back_btnActionPerformed
        LoginPage lp=new LoginPage(); 
            lp.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_SU_Back_btnActionPerformed

    private void SU_FirstName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_FirstName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SU_FirstName_txtActionPerformed

    private void SU_EmailID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_EmailID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SU_EmailID_txtActionPerformed

    private void SU_LastName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_LastName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SU_LastName_txtActionPerformed

    private void SU_Password_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SU_Password_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SU_Password_txtActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel STMS_lbl5;
    private javax.swing.JButton SU_Back_btn;
    private javax.swing.JRadioButton SU_Coach_radbtn;
    private javax.swing.JLabel SU_ConfirmPassword_lbl;
    private javax.swing.JPasswordField SU_ConfirmPassword_txt;
    private javax.swing.JLabel SU_EmailIB_lbl;
    private javax.swing.JTextField SU_EmailID_txt;
    private javax.swing.JLabel SU_FirstName_lbl;
    private javax.swing.JTextField SU_FirstName_txt;
    private javax.swing.JLabel SU_LastName_lbl;
    private javax.swing.JTextField SU_LastName_txt;
    private javax.swing.JButton SU_Next_btn;
    private javax.swing.JLabel SU_Password_lbl;
    private javax.swing.JPasswordField SU_Password_txt;
    private javax.swing.JButton SU_Reset_btn;
    private javax.swing.JRadioButton SU_Student_radbtn;
    private javax.swing.JPanel SignUpPanel;
    private javax.swing.JPanel SignUp_Role_btn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
