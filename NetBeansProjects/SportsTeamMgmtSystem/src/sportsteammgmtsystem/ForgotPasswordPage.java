/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsteammgmtsystem;
import com.aspose.email.LocaleOptions;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.SmtpClient;
import java.nio.charset.Charset;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
public class ForgotPasswordPage extends javax.swing.JFrame {
int code;
private String name;
    public ForgotPasswordPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        int min=1000,max=9999;
        Random random=new Random();
        code=random.nextInt(max-min+1)+min;
        System.out.println("---"+code);
        
        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ForgotPasswordPanel = new javax.swing.JPanel();
        FP_EmailID_lbl = new javax.swing.JLabel();
        FP_EnterCode_lbl = new javax.swing.JLabel();
        FP_EmailID_txt = new javax.swing.JTextField();
        FP_SendCode_btn = new javax.swing.JButton();
        FP_Verify_btn = new javax.swing.JButton();
        FP_SendPassword_btn = new javax.swing.JButton();
        FP_EnterCode_txt = new javax.swing.JTextField();
        FP_EmailCodeMessage_lbl = new javax.swing.JLabel();
        FP_InputCodeMessage_lbl = new javax.swing.JLabel();
        FP_back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ForgotPasswordPanel.setBackground(new java.awt.Color(0, 102, 102));
        ForgotPasswordPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forgot Password ?", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Helvetica Neue", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        FP_EmailID_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        FP_EmailID_lbl.setForeground(new java.awt.Color(255, 255, 255));
        FP_EmailID_lbl.setText("Email ID");

        FP_EnterCode_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        FP_EnterCode_lbl.setForeground(new java.awt.Color(255, 255, 255));
        FP_EnterCode_lbl.setText("Enter Code");

        FP_EmailID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FP_EmailID_txtActionPerformed(evt);
            }
        });

        FP_SendCode_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        FP_SendCode_btn.setForeground(new java.awt.Color(0, 102, 102));
        FP_SendCode_btn.setText("Send Code");
        FP_SendCode_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FP_SendCode_btnActionPerformed(evt);
            }
        });

        FP_Verify_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        FP_Verify_btn.setForeground(new java.awt.Color(0, 102, 102));
        FP_Verify_btn.setText("Verify");
        FP_Verify_btn.setEnabled(false);
        FP_Verify_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FP_Verify_btnActionPerformed(evt);
            }
        });

        FP_SendPassword_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        FP_SendPassword_btn.setForeground(new java.awt.Color(0, 102, 102));
        FP_SendPassword_btn.setText("Send Password ");
        FP_SendPassword_btn.setEnabled(false);
        FP_SendPassword_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FP_SendPassword_btnActionPerformed(evt);
            }
        });

        FP_EnterCode_txt.setEnabled(false);
        FP_EnterCode_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FP_EnterCode_txtActionPerformed(evt);
            }
        });

        FP_EmailCodeMessage_lbl.setForeground(new java.awt.Color(255, 255, 255));
        FP_EmailCodeMessage_lbl.setText("A 4-digit code will be sent to your email ID linked to your account");

        FP_InputCodeMessage_lbl.setForeground(new java.awt.Color(255, 255, 255));
        FP_InputCodeMessage_lbl.setText("Please input the 4-digit code in the box below.");

        FP_back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        FP_back_btn.setForeground(new java.awt.Color(0, 102, 102));
        FP_back_btn.setText("Back");
        FP_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FP_back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ForgotPasswordPanelLayout = new javax.swing.GroupLayout(ForgotPasswordPanel);
        ForgotPasswordPanel.setLayout(ForgotPasswordPanelLayout);
        ForgotPasswordPanelLayout.setHorizontalGroup(
            ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ForgotPasswordPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ForgotPasswordPanelLayout.createSequentialGroup()
                        .addComponent(FP_EnterCode_lbl)
                        .addGap(18, 18, 18)
                        .addComponent(FP_EnterCode_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(FP_Verify_btn)
                        .addGap(29, 29, 29)
                        .addComponent(FP_SendPassword_btn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(ForgotPasswordPanelLayout.createSequentialGroup()
                        .addGroup(ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FP_InputCodeMessage_lbl)
                            .addComponent(FP_EmailCodeMessage_lbl))
                        .addGap(0, 153, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ForgotPasswordPanelLayout.createSequentialGroup()
                        .addGroup(ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ForgotPasswordPanelLayout.createSequentialGroup()
                                .addComponent(FP_EmailID_lbl)
                                .addGap(18, 18, 18)
                                .addComponent(FP_EmailID_txt))
                            .addGroup(ForgotPasswordPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(FP_SendCode_btn)))
                        .addGap(14, 14, 14))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ForgotPasswordPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(FP_back_btn)
                .addContainerGap())
        );
        ForgotPasswordPanelLayout.setVerticalGroup(
            ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ForgotPasswordPanelLayout.createSequentialGroup()
                .addGroup(ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ForgotPasswordPanelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FP_EmailID_lbl)
                            .addComponent(FP_EmailID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ForgotPasswordPanelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(FP_SendCode_btn)))
                .addGap(21, 21, 21)
                .addComponent(FP_EmailCodeMessage_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FP_InputCodeMessage_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(ForgotPasswordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FP_EnterCode_lbl)
                    .addComponent(FP_EnterCode_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FP_Verify_btn)
                    .addComponent(FP_SendPassword_btn))
                .addGap(41, 41, 41)
                .addComponent(FP_back_btn)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ForgotPasswordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ForgotPasswordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ForgotPasswordPanel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FP_EmailID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FP_EmailID_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FP_EmailID_txtActionPerformed

    private void FP_SendCode_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FP_SendCode_btnActionPerformed
          this.FP_EnterCode_txt.setEnabled(true);
         
        try{
         Class.forName("java.sql.DriverManager");
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
         ResultSet r=s.executeQuery("select * from login_details where email='"+this.FP_EmailID_txt.getText()+"'");
         if(r.next()){
           
             name=r.getString("FIRSTNAME")+" "+r.getString("LASTNAME");
             if(sendCode()){
                
             this.FP_Verify_btn.setEnabled(true);
            
             }
         }else{
           JOptionPane.showMessageDialog(this,"The email ID is not registered with the system");   
         }
         
         }catch(Exception e){
             e.printStackTrace();
         } 
    }//GEN-LAST:event_FP_SendCode_btnActionPerformed

    private void FP_EnterCode_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FP_EnterCode_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FP_EnterCode_txtActionPerformed

    private void FP_SendPassword_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FP_SendPassword_btnActionPerformed
       
        try{
         Class.forName("java.sql.DriverManager");
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
         ResultSet r=s.executeQuery("select * from login_details where email='"+this.FP_EmailID_txt.getText()+"'");
         if(r.next()){
             System.out.println("Hello");
             name=r.getString("FIRSTNAME")+" "+r.getString("LASTNAME");
            
             
             sendMailToUser(r.getString("password"));
             
         }
         
         }catch(Exception e){
             e.printStackTrace();
         }
    }//GEN-LAST:event_FP_SendPassword_btnActionPerformed

    private void FP_Verify_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FP_Verify_btnActionPerformed
       
         if(FP_EnterCode_txt.getText().isEmpty())
                     JOptionPane.showMessageDialog(this,"You cannot leave code blank");
         else {
                     int newcode=Integer.parseInt(FP_EnterCode_txt.getText());//converting string into int
                     if(this.code==newcode){
                          this.FP_SendPassword_btn.setEnabled(true);
                         JOptionPane.showMessageDialog(this,"Click send password button to get your password!");
                     }
                     else{
                          this.FP_SendPassword_btn.setEnabled(false);
                         JOptionPane.showMessageDialog(this, "The code does not match");
                          
                     }
                 }
                     
        
        
        
    }//GEN-LAST:event_FP_Verify_btnActionPerformed

    private void FP_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FP_back_btnActionPerformed
        LoginPage lp = new LoginPage();
            lp.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_FP_back_btnActionPerformed
public boolean sendCode(){
    
   LocaleOptions.setLocale(new Locale("en", "US"));
    MailMessage message = new MailMessage();
        // Set subject of the message, body and sender information
        message.setSubject("Sports Team Management System OTP");
        message.setHtmlBody("System generated Unique Code for Sports Team Management System:    "+code);
        message.setFrom(new MailAddress("sports_team_mgmt_2024@outlook.com", "Sports Team Management System", false));
        // Specify encoding 
        message.setBodyEncoding(Charset.forName("US-ASCII"));
        // Add To recipients and CC recipients
        message.getTo().addItem(new MailAddress(FP_EmailID_txt.getText().trim(),name, false));
        // Create an instance of SmtpClient Class
        SmtpClient client = new SmtpClient();
        // Specify your mailing host server, Username, Password, Port
        client.setHost("smtp-mail.outlook.com");
        client.setUsername("sports_team_mgmt_2024@outlook.com");
        client.setPassword("sports1234");
        client.setPort(587);
        try
        {
	// Client.Send will send this message
            client.send(message); 
            JOptionPane.showMessageDialog(this,"unique 4-digit code  has been successfully sent to your registered Email id.");
             return true;
        }
        catch (Exception ex){
	ex.printStackTrace();
        JOptionPane.showMessageDialog(this,"Code not sent.");
        return false;
        }
       
}
    public void sendMailToUser(String password){
       LocaleOptions.setLocale(new Locale("en", "US")); //Locale set to english (original is cantonese) 
        MailMessage message = new MailMessage(); //Create instance of new mail message which represents an email message
        message.setSubject("Sports Team Management System OTP"); //Setting subject of email
        //Setting HTML body of email with provided password concatenated with string
        message.setHtmlBody("Your Password to access Sports Team Management System is: "+password);
        //Setting sender of mail with displayed name
        message.setFrom(new MailAddress("sports_team_mgmt_2024@outlook.com", "Sports Team Management System", false));
        message.setBodyEncoding(Charset.forName("US-ASCII")); //Setting encoding to US characters
        //Adding recipient email address to send email
        message.getTo().addItem(new MailAddress(FP_EmailID_txt.getText().trim(),name, false));
        SmtpClient client = new SmtpClient(); // Using Simple Mail Transfer Protocol (Smtp) used by sender to recipient
        client.setHost("smtp-mail.outlook.com"); //Setting host of smtp server
        client.setUsername("sports_team_mgmt_2024@outlook.com"); //Setting username for smtp authentication
        client.setPassword("sports1234"); //Setting password for smtp authentication
        client.setPort(587); //587 is a common port used for secure email transmissions
        try
        {
            client.send(message); //Sending email message using configured smtp instance
            JOptionPane.showMessageDialog(this,"Your e-mail has been successfully sent.");
           LoginPage td=new LoginPage(); //sending user back to login page
            td.setVisible(true);
            this.dispose();
        }
        catch (Exception ex){
	ex.printStackTrace();      
        }
    }
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
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPasswordPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FP_EmailCodeMessage_lbl;
    private javax.swing.JLabel FP_EmailID_lbl;
    private javax.swing.JTextField FP_EmailID_txt;
    private javax.swing.JLabel FP_EnterCode_lbl;
    private javax.swing.JTextField FP_EnterCode_txt;
    private javax.swing.JLabel FP_InputCodeMessage_lbl;
    private javax.swing.JButton FP_SendCode_btn;
    private javax.swing.JButton FP_SendPassword_btn;
    private javax.swing.JButton FP_Verify_btn;
    private javax.swing.JButton FP_back_btn;
    private javax.swing.JPanel ForgotPasswordPanel;
    // End of variables declaration//GEN-END:variables

   
}
