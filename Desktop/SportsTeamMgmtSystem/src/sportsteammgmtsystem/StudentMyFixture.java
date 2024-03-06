/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsteammgmtsystem;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sidbohra
 */
public class StudentMyFixture extends javax.swing.JFrame {
    private int coachId=0;
    public static String gender=null;
    DefaultTableModel data;
    
    public StudentMyFixture() {
        initComponents();
        this.setLocationRelativeTo(null);
        data=(DefaultTableModel)table.getModel(); 
     table.getColumnModel().getColumn(0).setMaxWidth(80);
     table.getColumnModel().getColumn(0).setMinWidth(80); 
     table.getColumnModel().getColumn(1).setMaxWidth(100); 
     table.getColumnModel().getColumn(1).setMinWidth(100); 
     table.getColumnModel().getColumn(2).setMaxWidth(200);
     table.getColumnModel().getColumn(2).setMinWidth(200);
     table.getColumnModel().getColumn(3).setMaxWidth(180);
     table.getColumnModel().getColumn(3).setMinWidth(180);
     table.getColumnModel().getColumn(4).setMaxWidth(150); 
     table.getColumnModel().getColumn(4).setMinWidth(150);
     table.getColumnModel().getColumn(5).setMaxWidth(330); 
     table.getColumnModel().getColumn(5).setMinWidth(330);
   
    
     JTableHeader header=table.getTableHeader();//header is an object of JTableHEader class
     header.setFont(new Font ("Arial",Font.BOLD,16)); //heading
     table.setRowHeight(40);
     table.setGridColor(Color.blue);
     table.setShowGrid(true);
     table.setFont(new Font ("Arial",Font.BOLD,14)); //records
        try{
            
               Class.forName("java.sql.DriverManager"); //loading and registering drivers required for MYSQL
               
               Connection con=ConnectDB.getConnect();
               Statement s=con.createStatement();
                ResultSet r=s.executeQuery("select * from student_details where firstname='"+LoginPage.studentName.split(" ")[0]+"'and lastname='"+LoginPage.studentName.split(" ")[1]+"'"); 
                if(r.next()){ 
                       
                this.SMF_StudentName_txt.setText(r.getString("firstname")+" "+r.getString("lastname"));
                this.SMF_AgeGroup_txt.setText(r.getString("agegroup"));
                this.SMF_StudentSport_txt.setText(r.getString("sport"));
                this.coachId=r.getInt("coach_id");
                gender=r.getString("gender");
                this.SMF_CoachName_txt.setText(getCoachName());
                 }
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            
            for(int i = 1; i < table.getColumnCount(); i++){
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
                 
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        
   this.showFixtureRecords();
        
         
    }
    
    
    public void showFixtureRecords(){
        boolean flag=false;//false indicates that coach did not add any fixture for logged in person's age group
        data.setRowCount(0); //refresh JTable
        int counter=0;
       try{
         Class.forName("java.sql.DriverManager");
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
        
         ResultSet r=s.executeQuery("select * from fixture_details where coach_id="+this.coachId+" and "
                 + "age_group='"+this.SMF_AgeGroup_txt.getText()+"' and  gender='"+this.gender+"'");
       
          while(r.next()){   
              flag=true;
              String fixtureDate=r.getString("date");
             if(isValidateDate(fixtureDate)){
                data.addRow(new Object[]{false,r.getInt("Fixture_ID"), r.getString("Fixture_Name"), fixtureDate,
                 r.getString("Organisation"), r.getString("description")});
                counter++;
             }
            
            }
          if(counter==0)
              JOptionPane.showMessageDialog(this, "You have no upcoming fixtures");
         }catch(Exception e){
             e.printStackTrace();
         }
       
       
       
       if(flag==false){
           JOptionPane.showMessageDialog(this, "There is no fixture  for Coach "+this.SMF_CoachName_txt.getText()+"");
       }
    }
    
    
    public boolean isValidateDate(String fixtureDate) throws ParseException{
       boolean flag=true;
       Date today=new Date(); //fetching current system date
       DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
       Date fixture_Date=df.parse(fixtureDate); //concverting string into date object
       if(fixture_Date.after(today)){
           flag=true;
       }
       else{
           flag=false;
       }
       
        return flag;
          
    }
public String getCoachName(){
    String coachName=null;
    
    try{
            
               Class.forName("java.sql.DriverManager"); //loading and registering drivers required for MYSQL
               
               Connection con=ConnectDB.getConnect();
               Statement s=con.createStatement();
                ResultSet r=s.executeQuery("select * from coach_details where coach_id="+this.coachId+""); 
                if(r.next()){ 
                     coachName=r.getString("firstname")+" "+r.getString("lastname");
               
                 }
                
                 
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
    
    
    
    return coachName;
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentMyFixtureTablePanel = new javax.swing.JPanel();
        SMF_sp = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        SMF_back_btn = new javax.swing.JButton();
        printform_btn = new javax.swing.JButton();
        StudentMyFixturePanel = new javax.swing.JPanel();
        SMF_StudentName_lbl = new javax.swing.JLabel();
        SMF_StudentName_txt = new javax.swing.JTextField();
        SMF_StudentSport_lbl = new javax.swing.JLabel();
        SMF_StudentSport_txt = new javax.swing.JTextField();
        SMF_AgeGroup_lbl = new javax.swing.JLabel();
        SMF_CoachName_lbl = new javax.swing.JLabel();
        SMF_AgeGroup_txt = new javax.swing.JTextField();
        SMF_CoachName_txt = new javax.swing.JTextField();
        STMS_lbl3 = new javax.swing.JLabel();
        STMS_lbl4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StudentMyFixtureTablePanel.setBackground(new java.awt.Color(0, 102, 102));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Select", "Fixture ID", "Fixture", "Date", "Organisation", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SMF_sp.setViewportView(table);

        SMF_back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        SMF_back_btn.setForeground(new java.awt.Color(0, 102, 102));
        SMF_back_btn.setText("Back");
        SMF_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMF_back_btnActionPerformed(evt);
            }
        });

        printform_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        printform_btn.setForeground(new java.awt.Color(0, 102, 102));
        printform_btn.setText("Print Parent Consent Form");
        printform_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printform_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StudentMyFixtureTablePanelLayout = new javax.swing.GroupLayout(StudentMyFixtureTablePanel);
        StudentMyFixtureTablePanel.setLayout(StudentMyFixtureTablePanelLayout);
        StudentMyFixtureTablePanelLayout.setHorizontalGroup(
            StudentMyFixtureTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentMyFixtureTablePanelLayout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addComponent(printform_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(SMF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(328, 328, 328))
            .addGroup(StudentMyFixtureTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SMF_sp)
                .addContainerGap())
        );
        StudentMyFixtureTablePanelLayout.setVerticalGroup(
            StudentMyFixtureTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentMyFixtureTablePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(SMF_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(StudentMyFixtureTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(printform_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SMF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        StudentMyFixturePanel.setBackground(new java.awt.Color(0, 102, 102));

        SMF_StudentName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_StudentName_lbl.setText("Student Name");

        SMF_StudentName_txt.setEditable(false);
        SMF_StudentName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMF_StudentName_txtActionPerformed(evt);
            }
        });

        SMF_StudentSport_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_StudentSport_lbl.setText("Sport");

        SMF_StudentSport_txt.setEditable(false);
        SMF_StudentSport_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMF_StudentSport_txtActionPerformed(evt);
            }
        });

        SMF_AgeGroup_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_AgeGroup_lbl.setText("Age Group");

        SMF_CoachName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_CoachName_lbl.setText("Coach Name");

        SMF_AgeGroup_txt.setEditable(false);
        SMF_AgeGroup_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMF_AgeGroup_txtActionPerformed(evt);
            }
        });

        SMF_CoachName_txt.setEditable(false);
        SMF_CoachName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SMF_CoachName_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StudentMyFixturePanelLayout = new javax.swing.GroupLayout(StudentMyFixturePanel);
        StudentMyFixturePanel.setLayout(StudentMyFixturePanelLayout);
        StudentMyFixturePanelLayout.setHorizontalGroup(
            StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentMyFixturePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                        .addComponent(SMF_StudentName_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SMF_StudentName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                        .addComponent(SMF_StudentSport_lbl)
                        .addGap(18, 18, 18)
                        .addComponent(SMF_StudentSport_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SMF_AgeGroup_lbl)
                    .addComponent(SMF_CoachName_lbl))
                .addGap(18, 18, 18)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SMF_AgeGroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SMF_CoachName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(207, 207, 207))
        );
        StudentMyFixturePanelLayout.setVerticalGroup(
            StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SMF_StudentName_lbl)
                    .addComponent(SMF_StudentName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SMF_AgeGroup_lbl)
                    .addComponent(SMF_AgeGroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SMF_StudentSport_lbl)
                        .addComponent(SMF_StudentSport_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SMF_CoachName_lbl)
                        .addComponent(SMF_CoachName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        STMS_lbl3.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl3.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl3.setText("Sports Team Management System");

        STMS_lbl4.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl4.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl4.setText("My Fixtures");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(STMS_lbl4)
                                .addGap(445, 445, 445))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(STMS_lbl3)
                                .addGap(311, 311, 311))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StudentMyFixturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(StudentMyFixtureTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(STMS_lbl3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(STMS_lbl4)
                .addGap(18, 18, 18)
                .addComponent(StudentMyFixturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StudentMyFixtureTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SMF_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMF_back_btnActionPerformed
        StudentDashboard sd = new StudentDashboard();
            sd.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_SMF_back_btnActionPerformed

    
    private void SMF_StudentName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMF_StudentName_txtActionPerformed
     
        
    }//GEN-LAST:event_SMF_StudentName_txtActionPerformed

    private void SMF_StudentSport_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMF_StudentSport_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SMF_StudentSport_txtActionPerformed

    private void SMF_AgeGroup_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMF_AgeGroup_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SMF_AgeGroup_txtActionPerformed

    private void SMF_CoachName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SMF_CoachName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SMF_CoachName_txtActionPerformed

    private void printform_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printform_btnActionPerformed
        int count=0; //no of records selected
        int fixtureid=0;
        String fixture=null,agegroup=null,gender=null,date=null,sport=null,organisation=null;
        for(int i=0;i<data.getRowCount();i++){
            
            if(data.getValueAt(i, 0).toString().equals("true")){
                count++;
                fixtureid=Integer.parseInt(data.getValueAt(i, 1).toString());
                fixture=data.getValueAt(i, 2).toString();
                date=data.getValueAt(i, 3).toString();
                organisation=data.getValueAt(i,4).toString();
             }
        }
        if(count==0)
            JOptionPane.showMessageDialog(this, "Please select fixture from a table");
        else if(count>1)
         JOptionPane.showMessageDialog(this, "Please select only one fixture at a time");
        else{
             agegroup=this.SMF_AgeGroup_txt.getText();
             sport=this.SMF_StudentSport_txt.getText();
            StudentPrintConsentForm spcf = new StudentPrintConsentForm(fixtureid,fixture,gender,date,organisation,agegroup,sport);
            spcf.setVisible(true);
            this.dispose();
            
            
        }  
        
        
        
        
        
    }//GEN-LAST:event_printform_btnActionPerformed

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
            java.util.logging.Logger.getLogger(StudentMyFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentMyFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentMyFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentMyFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentMyFixture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SMF_AgeGroup_lbl;
    private javax.swing.JTextField SMF_AgeGroup_txt;
    private javax.swing.JLabel SMF_CoachName_lbl;
    private javax.swing.JTextField SMF_CoachName_txt;
    private javax.swing.JLabel SMF_StudentName_lbl;
    private javax.swing.JTextField SMF_StudentName_txt;
    private javax.swing.JLabel SMF_StudentSport_lbl;
    private javax.swing.JTextField SMF_StudentSport_txt;
    private javax.swing.JButton SMF_back_btn;
    private javax.swing.JScrollPane SMF_sp;
    private javax.swing.JLabel STMS_lbl3;
    private javax.swing.JLabel STMS_lbl4;
    private javax.swing.JPanel StudentMyFixturePanel;
    private javax.swing.JPanel StudentMyFixtureTablePanel;
    private javax.swing.JButton printform_btn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
