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
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

//FixtureTeamSheet is a derived class inheriting from the javax.swing.JFrame class
public class FixtureTeamSheet extends javax.swing.JFrame { 
    //Declaration of private instance variables to store data related to fixture team sheet
    private int fixtureId,coachId,studentId;
    private final String StudentAvailability_status="Pending",status="Pending";
    private String CoachName;
    private DefaultTableModel data;
    
    public FixtureTeamSheet() {
        initComponents();
        this.setLocationRelativeTo(null); //Initialisation of graphical components of JFrame, sets it to be centered
    }
    public FixtureTeamSheet(int fixtureid,String fixture_name, String date, String sport, String agegroup, String gender){
         initComponents();
         this.setLocationRelativeTo(null);
         this.sport_txt.setText(sport); //setting values of various textfields (GUI components) with passed parameters
         this.gender_txt.setText(gender);
         this.agegroup_txt.setText(agegroup);
         this.fixture_txt.setText(fixture_name);
         this.date_txt.setText(date);
         this.coachname_txt.setText(LoginPage.coachName); 
         
         this.fixtureId=fixtureid;
         //Assigning values to reference instances based on information obtain from other classes
         this.CoachName=LoginPage.coachName; 
         this.coachId=AddFixture.getCoachId();
         showTableRecords();
    }
public void showTableRecords(){
    
    data=(DefaultTableModel)table.getModel(); 
     table.getColumnModel().getColumn(0).setMaxWidth(80);
     table.getColumnModel().getColumn(0).setMinWidth(80); 
     table.getColumnModel().getColumn(1).setMaxWidth(100); 
     table.getColumnModel().getColumn(1).setMinWidth(100); 
     table.getColumnModel().getColumn(2).setMaxWidth(250);
     table.getColumnModel().getColumn(2).setMinWidth(250);
     table.getColumnModel().getColumn(3).setMaxWidth(350);
     table.getColumnModel().getColumn(3).setMinWidth(350);
     table.getColumnModel().getColumn(4).setMaxWidth(100); 
     table.getColumnModel().getColumn(4).setMinWidth(100);
     table.getColumnModel().getColumn(5).setMaxWidth(120); 
     table.getColumnModel().getColumn(5).setMinWidth(120);
     table.getColumnModel().getColumn(6).setMaxWidth(250); 
     table.getColumnModel().getColumn(6).setMinWidth(250);

  
    
     JTableHeader header=table.getTableHeader();//header is an object of JTableHeader class
     header.setFont(new Font ("Arial",Font.BOLD,16)); //heading
     table.setRowHeight(40);
     table.setGridColor(Color.blue);
     table.setShowGrid(true);
     table.setFont(new Font ("Arial",Font.BOLD,14)); //records
    data.setRowCount(0);
    try{
         Class.forName("java.sql.DriverManager");
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
        
         ResultSet rr=s.executeQuery("select student_id from participant_details where fixture_id="+this.fixtureId);
         
         while(rr.next()){
             
            int student_id=rr.getInt("Student_ID");
             getStudentDetails(student_id);
         }
           
          
         }catch(Exception e){
             e.printStackTrace();
         } 
}

public void getStudentDetails(int student_id){
    //data.setRowCount(0);
    try{
         Class.forName("java.sql.DriverManager");
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
         ResultSet r=s.executeQuery("select * from student_details where  student_id="+student_id+" and coach_id ="+this.coachId+"  "
                 + " and  sport='"+this.sport_txt.getText()+"'  and agegroup='"+this.agegroup_txt.getText()+"' "
                         + "and gender='"+this.gender_txt.getText()+"'");
         while(r.next()){
              
              
              String Student_Name=r.getString("firstname")+" "+r.getString("lastname");
              String Email_ID=r.getString("Email_ID");
              String grade=r.getString("grade");
              String house=r.getString("house");
              String tutor_name=r.getString("tutorname");
              data.addRow(new Object[]{false,student_id,Student_Name,Email_ID,grade,house,tutor_name});
          }
          
         }catch(Exception e){
             e.printStackTrace();
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

        AllUpcomingFixturesPanel = new javax.swing.JPanel();
        AUF_sp = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        SA_CreateTeam_btn = new javax.swing.JButton();
        AUF_back_btn = new javax.swing.JButton();
        SA_SeeTeam_btn = new javax.swing.JButton();
        STMS_lbl1 = new javax.swing.JLabel();
        StudentMyFixturePanel = new javax.swing.JPanel();
        SMF_StudentName_lbl = new javax.swing.JLabel();
        sport_txt = new javax.swing.JTextField();
        SMF_StudentSport_lbl = new javax.swing.JLabel();
        agegroup_txt = new javax.swing.JTextField();
        SMF_AgeGroup_lbl = new javax.swing.JLabel();
        SMF_CoachName_lbl = new javax.swing.JLabel();
        fixture_txt = new javax.swing.JTextField();
        coachname_txt = new javax.swing.JTextField();
        SMF_StudentName_lbl1 = new javax.swing.JLabel();
        gender_txt = new javax.swing.JTextField();
        SMF_StudentName_lbl2 = new javax.swing.JLabel();
        date_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AllUpcomingFixturesPanel.setBackground(new java.awt.Color(0, 102, 102));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Select", "Student ID", "Student Name", "Email ID", "Grade", "House", "Tutor Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AUF_sp.setViewportView(table);

        SA_CreateTeam_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        SA_CreateTeam_btn.setForeground(new java.awt.Color(0, 102, 102));
        SA_CreateTeam_btn.setText("Add Student To Final Team");
        SA_CreateTeam_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SA_CreateTeam_btnActionPerformed(evt);
            }
        });

        AUF_back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        AUF_back_btn.setForeground(new java.awt.Color(0, 102, 102));
        AUF_back_btn.setText("Back");
        AUF_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUF_back_btnActionPerformed(evt);
            }
        });

        SA_SeeTeam_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        SA_SeeTeam_btn.setForeground(new java.awt.Color(0, 102, 102));
        SA_SeeTeam_btn.setText("View Final Team");
        SA_SeeTeam_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SA_SeeTeam_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AllUpcomingFixturesPanelLayout = new javax.swing.GroupLayout(AllUpcomingFixturesPanel);
        AllUpcomingFixturesPanel.setLayout(AllUpcomingFixturesPanelLayout);
        AllUpcomingFixturesPanelLayout.setHorizontalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(SA_CreateTeam_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(SA_SeeTeam_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(368, 368, 368)
                .addComponent(AUF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AUF_sp)
                .addContainerGap())
        );
        AllUpcomingFixturesPanelLayout.setVerticalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(AUF_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AUF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SA_SeeTeam_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SA_CreateTeam_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        STMS_lbl1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl1.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl1.setText("Sports Team Management System");

        StudentMyFixturePanel.setBackground(new java.awt.Color(0, 102, 102));

        SMF_StudentName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_StudentName_lbl.setText("Sport");

        sport_txt.setEditable(false);
        sport_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sport_txtActionPerformed(evt);
            }
        });

        SMF_StudentSport_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_StudentSport_lbl.setText("Age Group");

        agegroup_txt.setEditable(false);
        agegroup_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agegroup_txtActionPerformed(evt);
            }
        });

        SMF_AgeGroup_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_AgeGroup_lbl.setText("Fixture");

        SMF_CoachName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        SMF_CoachName_lbl.setText("Coach Name");

        fixture_txt.setEditable(false);
        fixture_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixture_txtActionPerformed(evt);
            }
        });

        coachname_txt.setEditable(false);
        coachname_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachname_txtActionPerformed(evt);
            }
        });

        SMF_StudentName_lbl1.setForeground(new java.awt.Color(255, 255, 255));
        SMF_StudentName_lbl1.setText("Gender");

        gender_txt.setEditable(false);
        gender_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_txtActionPerformed(evt);
            }
        });

        SMF_StudentName_lbl2.setForeground(new java.awt.Color(255, 255, 255));
        SMF_StudentName_lbl2.setText("Date");

        date_txt.setEditable(false);
        date_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                date_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StudentMyFixturePanelLayout = new javax.swing.GroupLayout(StudentMyFixturePanel);
        StudentMyFixturePanel.setLayout(StudentMyFixturePanelLayout);
        StudentMyFixturePanelLayout.setHorizontalGroup(
            StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentMyFixturePanelLayout.createSequentialGroup()
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(SMF_StudentName_lbl2))
                    .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(SMF_StudentName_lbl1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gender_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SMF_StudentSport_lbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(agegroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(SMF_StudentName_lbl)
                        .addGap(8, 8, 8)
                        .addComponent(sport_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SMF_AgeGroup_lbl)
                    .addComponent(SMF_CoachName_lbl))
                .addGap(18, 18, 18)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fixture_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(coachname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        StudentMyFixturePanelLayout.setVerticalGroup(
            StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentMyFixturePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SMF_StudentName_lbl)
                    .addComponent(sport_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SMF_AgeGroup_lbl)
                    .addComponent(fixture_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SMF_StudentName_lbl1)
                    .addComponent(gender_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SMF_StudentSport_lbl)
                        .addComponent(agegroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SMF_CoachName_lbl)
                        .addComponent(coachname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StudentMyFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SMF_StudentName_lbl2)
                        .addComponent(date_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(464, 464, 464)
                .addComponent(STMS_lbl1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(StudentMyFixturePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AllUpcomingFixturesPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(STMS_lbl1)
                .addGap(69, 69, 69)
                .addComponent(StudentMyFixturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AllUpcomingFixturesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SA_CreateTeam_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SA_CreateTeam_btnActionPerformed
        int count = 0;
        int student_id=0;
       for(int i=0;i<data.getRowCount();i++){   
        if(data.getValueAt(i, 0).toString().equals("true")){   
            count++;
            student_id=Integer.parseInt(data.getValueAt(i, 1).toString());
            createTeam(student_id);
        } 
        }    
       if(count == 0){
            JOptionPane.showMessageDialog(this, "Please select students to add into the team"); 
        } else if (count > 1){
            JOptionPane.showMessageDialog(this, "Please select only one student at a time"); 
        }
    }//GEN-LAST:event_SA_CreateTeam_btnActionPerformed
public void createTeam(int student_id){
    String status="Approved";
    try {
            Class.forName("java.sql.DriverManager"); //loading drivers to connect GUI with databse
            Connection c = ConnectDB.getConnect(); //getting connection with Sports_db
            Statement st = c.createStatement(); //enabling SQL statements  in java code
            
            ResultSet r = st.executeQuery("SELECT studentavailability_status FROM participant_details WHERE student_id="+student_id);
            if(r.next()){
                String availability_status = r.getString("studentavailability_status");
                if(availability_status.equals("Available")){
                    int y = st.executeUpdate("UPDATE participant_details SET status ='"+status+"'where student_id="+student_id);   
                    JOptionPane.showMessageDialog(this, "Student has been added to final team."); 
                    CoachMyFixture cmf=new CoachMyFixture();
                    cmf.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Student cannot be added to team because they have yet to update their availability.");
                } 
            } else {
                JOptionPane.showMessageDialog(this, "Student not found");
            }       
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }      
    
    
    
    
}
    private void AUF_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUF_back_btnActionPerformed
        CoachMyFixture cmf = new CoachMyFixture();
        cmf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AUF_back_btnActionPerformed

    private void sport_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sport_txtActionPerformed

    }//GEN-LAST:event_sport_txtActionPerformed

    private void agegroup_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agegroup_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agegroup_txtActionPerformed

    private void fixture_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixture_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fixture_txtActionPerformed

    private void coachname_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachname_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachname_txtActionPerformed

    private void gender_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender_txtActionPerformed

    private void date_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_date_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_date_txtActionPerformed

    private void SA_SeeTeam_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SA_SeeTeam_btnActionPerformed
        FixtureFinalTeamViewer ftv = new FixtureFinalTeamViewer(fixtureId);
        ftv.setVisible(true);
        this.dispose();   
    }//GEN-LAST:event_SA_SeeTeam_btnActionPerformed

    
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
            java.util.logging.Logger.getLogger(FixtureTeamSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FixtureTeamSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FixtureTeamSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FixtureTeamSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FixtureTeamSheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AUF_back_btn;
    private javax.swing.JScrollPane AUF_sp;
    private javax.swing.JPanel AllUpcomingFixturesPanel;
    private javax.swing.JButton SA_CreateTeam_btn;
    private javax.swing.JButton SA_SeeTeam_btn;
    private javax.swing.JLabel SMF_AgeGroup_lbl;
    private javax.swing.JLabel SMF_CoachName_lbl;
    private javax.swing.JLabel SMF_StudentName_lbl;
    private javax.swing.JLabel SMF_StudentName_lbl1;
    private javax.swing.JLabel SMF_StudentName_lbl2;
    private javax.swing.JLabel SMF_StudentSport_lbl;
    private javax.swing.JLabel STMS_lbl1;
    private javax.swing.JPanel StudentMyFixturePanel;
    private javax.swing.JTextField agegroup_txt;
    private javax.swing.JTextField coachname_txt;
    private javax.swing.JTextField date_txt;
    private javax.swing.JTextField fixture_txt;
    private javax.swing.JTextField gender_txt;
    private javax.swing.JTextField sport_txt;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
