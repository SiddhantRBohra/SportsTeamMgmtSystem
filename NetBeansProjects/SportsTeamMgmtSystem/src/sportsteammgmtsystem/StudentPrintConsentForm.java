/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsteammgmtsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author sidbohra
 */
public class StudentPrintConsentForm extends javax.swing.JFrame {
    private final String availability_status="Available";
    private final String status="Pending";
    int fixtureid,coachId;
    String fixture,venue,coachName,gender,date,organisation,agegroup,sport,acknowledgement_msg,student_name;
    public StudentPrintConsentForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public StudentPrintConsentForm(int fixtureid,String fixture, String gender, String date, String organisation, String agegroup, String sport){
        initComponents();
        this.setLocationRelativeTo(null);
        this.fixtureid=fixtureid;
        this.fixture=fixture;
        this.gender=gender;
        this.date=date;
        this.organisation=organisation;
        this.agegroup=agegroup;
        this.sport=sport;
        this.student_name=LoginPage.studentName;
        this.getFixtureDetails();
        this.getMessage();
        this.getCoachName();
        this.setDetails();
        this.gender_txt.setText(StudentMyFixture.gender);
        this.fixture_id_txt.setText(Integer.toString(this.fixtureid));
        
    }
    public void setDetails(){
        this.fixture_id_txt.setText(Integer.toString(fixtureid));
        this.fixname_txt.setText(fixture);
        this.agegroup_txt.setText(agegroup);
        this.cname_txt.setText(coachName);
        this.gender_txt.setText(gender);
        this.date_txt.setText(date);
        this.venue_txt.setText(venue);
        this.org_txt.setText(organisation);
        this.sport_txt.setText(sport);
        this.name_txt.setText(student_name);
        this.gender_txt.setText(this.gender);
    }   
    
    public void getFixtureDetails(){
         try{
         Class.forName("java.sql.DriverManager"); //loading JDBC driver for DB connection
         Connection con=ConnectDB.getConnect(); //Establishes connection to DB using custom method defined in ConnectDB class
         Statement s=con.createStatement(); //Statement object used to execute SQL queries
         //Executes SQL query selecting all columns that match with fixture id and storing row data into r object
         ResultSet r=s.executeQuery("select * from fixture_details where fixture_id= "+this.fixtureid); 
         //Reference variable to call instance variables and set to column header value if resultset has data
        if(r.next()){
           this.venue=r.getString("venue");
           this.coachId=r.getInt("coach_id");
           
                
            }
         }catch(Exception e){
             e.printStackTrace();
         }
        
        
        
        
        
        
    }
    
    public void getMessage(){
        
        try{
         Class.forName("java.sql.DriverManager");
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
        
         ResultSet r=s.executeQuery("select * from parentalconsent_details where fixtureid= "+this.fixtureid);
       
        if(r.next()){
          this.acknowledgement_msg=r.getString(2);
          this.msg_txt.setText(this.acknowledgement_msg);
                
            }
     
         }catch(Exception e){
             e.printStackTrace();
         }
        
    }
    
    public void getCoachName(){
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
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CoachMyFixturePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        chk_box = new javax.swing.JCheckBox();
        name_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        gender_txt = new javax.swing.JTextField();
        date_txt = new javax.swing.JTextField();
        agegroup_txt = new javax.swing.JTextField();
        org_txt = new javax.swing.JTextField();
        cname_txt = new javax.swing.JTextField();
        venue_txt = new javax.swing.JTextField();
        fixname_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        sport_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fixture_id_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        msg_txt = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        print_btn = new javax.swing.JButton();
        SPCF_back_btn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        STMS_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CoachMyFixturePanel.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Student Name");

        chk_box.setBackground(new java.awt.Color(0, 102, 102));
        chk_box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chk_box.setForeground(new java.awt.Color(255, 255, 255));
        chk_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_boxActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fixture ID");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fixture Name");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Venue");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fixture Date");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Coach Name");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fixture Organisation");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Age Group");

        org_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                org_txtActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sport");

        sport_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sport_txtActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Parent Consent Form");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Parent's Signature");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        msg_txt.setColumns(20);
        msg_txt.setLineWrap(true);
        msg_txt.setRows(5);
        jScrollPane2.setViewportView(msg_txt);
        msg_txt.getAccessibleContext().setAccessibleName("");
        msg_txt.getAccessibleContext().setAccessibleDescription("");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Parent or Guardian Name");

        print_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        print_btn.setForeground(new java.awt.Color(0, 102, 102));
        print_btn.setText("Print");
        print_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btnActionPerformed(evt);
            }
        });

        SPCF_back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        SPCF_back_btn.setForeground(new java.awt.Color(0, 102, 102));
        SPCF_back_btn.setText("Back");
        SPCF_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPCF_back_btnActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Coach's Message");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Please check the box to");

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("acknowledge this message");

        javax.swing.GroupLayout CoachMyFixturePanelLayout = new javax.swing.GroupLayout(CoachMyFixturePanel);
        CoachMyFixturePanel.setLayout(CoachMyFixturePanelLayout);
        CoachMyFixturePanelLayout.setHorizontalGroup(
            CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                        .addGap(329, 329, 329)
                        .addComponent(jLabel11))
                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel7)))
                        .addGap(48, 48, 48)
                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(40, 40, 40)
                                .addComponent(fixture_id_txt))
                            .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                .addComponent(gender_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel9)
                                .addGap(27, 27, 27)
                                .addComponent(agegroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(name_txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CoachMyFixturePanelLayout.createSequentialGroup()
                                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                        .addComponent(cname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                        .addComponent(org_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(venue_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sport_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fixname_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMyFixturePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addGap(51, 51, 51))
                            .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(chk_box))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel13))))
                                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel16)))
                                .addGap(18, 18, 18)))
                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(print_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SPCF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        CoachMyFixturePanelLayout.setVerticalGroup(
            CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMyFixturePanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel11)
                .addGap(31, 31, 31)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(gender_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(agegroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMyFixturePanelLayout.createSequentialGroup()
                        .addComponent(fixname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(fixture_id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(org_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(venue_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(sport_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CoachMyFixturePanelLayout.createSequentialGroup()
                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(chk_box))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMyFixturePanelLayout.createSequentialGroup()
                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CoachMyFixturePanelLayout.createSequentialGroup()
                        .addGroup(CoachMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(print_btn)
                            .addComponent(SPCF_back_btn))
                        .addGap(39, 39, 39))))
        );

        getContentPane().add(CoachMyFixturePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 820, 670));

        STMS_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl.setText("Sports Team Management System");
        getContentPane().add(STMS_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void org_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_org_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_org_txtActionPerformed

    private void chk_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_boxActionPerformed

    private void sport_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sport_txtActionPerformed
        
    }//GEN-LAST:event_sport_txtActionPerformed

    private void print_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btnActionPerformed
       
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            ResultSet r = s.executeQuery("SELECT acknowledgement_msg FROM parentalconsent_details WHERE fixtureid="+this.fixtureid);
            if(r.next()){
                showingInterestInFixture();
                new PrintPanelUtil().printComponent(CoachMyFixturePanel);
            } else {
                JOptionPane.showMessageDialog(this, "You cannot print form until your coach has added a message");
            }
        } catch(Exception e) {
            
        }   
    }//GEN-LAST:event_print_btnActionPerformed

    private void SPCF_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPCF_back_btnActionPerformed
        StudentMyFixture smf = new StudentMyFixture();
        smf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SPCF_back_btnActionPerformed
public void showingInterestInFixture(){
      int studentID=getStudentId();
      
      try {
            Class.forName("java.sql.DriverManager"); //loading drivers to connect GUI with databse
            Connection c = ConnectDB.getConnect(); //getting connection with Sports_db
            Statement st = c.createStatement(); //enabling SQL statements  in java code
            //Update query instead
            int y = st.executeUpdate("UPDATE participant_details "
            + "SET studentavailability_status = '"+availability_status+"' "
            + "WHERE student_id = " + studentID + " "
            + "AND fixture_id = " + this.fixtureid + " "
            + "AND coach_id = " + coachId);
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
      
      
      
      
      
      
}
public int getStudentId(){
    int studentId=0;
     String fname=student_name.toString().split(" ")[0];
     String lname=student_name.toString().split(" ")[1];
     try{              
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement st=con.createStatement();
            ResultSet r=st.executeQuery("select student_id from student_details where firstname='"+fname+"' and lastname='"+lname+"'" );
           if (r.next())
            {
               studentId=r.getInt(1);
                
            }
           
        }catch(Exception e){
            e.printStackTrace();
            
        }   
     return studentId;
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
            java.util.logging.Logger.getLogger(StudentPrintConsentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentPrintConsentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentPrintConsentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentPrintConsentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentPrintConsentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CoachMyFixturePanel;
    private javax.swing.JButton SPCF_back_btn;
    private javax.swing.JLabel STMS_lbl;
    private javax.swing.JTextField agegroup_txt;
    private javax.swing.JCheckBox chk_box;
    private javax.swing.JTextField cname_txt;
    private javax.swing.JTextField date_txt;
    private javax.swing.JTextField fixname_txt;
    private javax.swing.JTextField fixture_id_txt;
    private javax.swing.JTextField gender_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea msg_txt;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField org_txt;
    private javax.swing.JButton print_btn;
    private javax.swing.JTextField sport_txt;
    private javax.swing.JTextField venue_txt;
    // End of variables declaration//GEN-END:variables
}
