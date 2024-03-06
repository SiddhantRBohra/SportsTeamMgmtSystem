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
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author sidbohra
 */
public class AddStudentToFixture extends javax.swing.JFrame {

    private DefaultTableModel data;
    
  private int coachID;
  private String gender,agegroup;
  private int rowSize; //Access modifier for number of rows only for this declared class
  //2D array to store details of those students who meet the criteria of gender, coachID and age group
  private String student_Records[][]; 
  public AddStudentToFixture(){
      initComponents();
      this.setLocationRelativeTo(null);
  }
    public AddStudentToFixture(int fixtureid,String fixture,String agegroup,String gender,String date,String sport) {
        initComponents();
        this.setLocationRelativeTo(null);
        data=(DefaultTableModel)table.getModel(); 
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(1).setMaxWidth(100);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setMaxWidth(150);
        table.getColumnModel().getColumn(4).setMaxWidth(100);
        table.getColumnModel().getColumn(4).setMaxWidth(100);
        table.getColumnModel().getColumn(5).setMaxWidth(100);
        table.getColumnModel().getColumn(5).setMaxWidth(100);
        table.getColumnModel().getColumn(6).setMaxWidth(150);
        table.getColumnModel().getColumn(6).setMaxWidth(150);
        table.getColumnModel().getColumn(7).setMaxWidth(300);
        table.getColumnModel().getColumn(7).setMaxWidth(300);
         
        JTableHeader header=table.getTableHeader();//header is an object of JTableHEader class
        header.setFont(new Font ("Arial",Font.BOLD,16)); //heading
        table.setRowHeight(40);
        table.setGridColor(Color.blue);
        table.setShowGrid(true);
        table.setFont(new Font ("Arial",Font.BOLD,14)); //records
        data.setRowCount(0);
        this.coachID=AddFixture.getCoachId();
        System.out.println("coach id = "+this.coachID);
        this.gender=gender;
        this.agegroup=agegroup;
        this.ASTF_FixtureID_txt.setText(Integer.toString(fixtureid));
        this.ASTF_FixtureName_txt.setText(fixture);
        this.ASTF_AgeGroup_txt.setText(agegroup);
        this.ASTF_Gender_txt.setText(gender);
        this.ASTF_FixtureDate_txt.setText(date);
        this.ASTF_Sport_txt.setText(sport);
        showTableRecords();
        
        
        
        
        
        
        
    }
    public void showTableRecords(){
         try{
         Class.forName("java.sql.DriverManager"); //Establishing connection to DB using abstraction
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
         System.out.println("age ="+this.agegroup+ "  gender = "+this.gender); //Ouputting criteria parameters to be matched with table data
         //Finding number of rows with students data matching with defined criteria
         ResultSet r=s.executeQuery("select count(*) from student_details where coach_id="
                 +this.coachID+" and agegroup='"+this.agegroup+"' and gender='"+this.gender+"'");  
        if(r.next())  
              rowSize=r.getInt(1);//Indicates the total values of rows from the database table student_details 
              
        this.student_Records=new String[this.rowSize][7]; //Establishing 2-D array with fixed number of columns and respective row size
        ResultSet rr=s.executeQuery("select student_id,firstname,lastname,grade,house,tutorname,email_id from student_details where coach_id="
                +this.coachID+" and agegroup='"+this.agegroup+"' and gender='"+this.gender+"'"); //Collecting matched results to be displayed 
        int row=0,col;
        while(rr.next()) {
            col=0;
            
            this.student_Records[row][col]=Integer.toString(rr.getInt(1)); //Getting student_id
            int counter=2; //Setting next column number to be iterated for obtaining data
            for(int i=1; i<7; i++) { //iterating through columns 
                this.student_Records[row][i]=rr.getString(counter); //Obtaining column data from student_details
                counter++; //incrementing counter indiciating next column to be iterated
            }
            row++;   //after all columns iterated, row value incremented, next row traversed to obtain student_details 
        } 
         for(int i=0;i<this.rowSize;i++){ //Using nested loop to output all the results of the 2-D array stored resulting from above code
             for(int j=0;j<7;j++){
                 System.out.print("  "+this.student_Records[i][j]); //Printing 2-D array in a matrix format
             }
             System.out.println(" "); //printing new line for new row of student details to be printed
         }   
         }catch(Exception e){
             e.printStackTrace();
         }     
         selectionSort(); //calling selection sort method to sort names of students lexicographically
         
         System.out.println("---after sorting ----");
         for(int i=0;i<this.rowSize;i++)  {
             int col=0;
             data.addRow(new Object[]{false , this.student_Records[i][col],this.student_Records[i][++col] ,this.student_Records[i][++col],
                 this.student_Records[i][++col],this.student_Records[i][++col],this.student_Records[i][++col],
                 this.student_Records[i][++col]}); 
         }  
    }
public void selectionSort(){
        //sorting 2-D array elements  in dictionary order through selection sort technique
        for (int i = 0; i < (this.rowSize-1); i++) {
            int minIndex = i;
           for(int j=i+1; j<this.rowSize; j++){
               if(this.student_Records[minIndex][1].compareTo(this.student_Records[j][1]) >0){
                   minIndex=j;
               }
           } /*comparetTo() will compare  two Strings lexicographically in java 
                returns 0 if the string is equal to the other string. A value less than 0 is returned 
                        if the string is less than the other string (less characters) 
                and a value greater than 0 if the string is greater than the other string */ 
               if(minIndex!=i){
                  String  temp1=this.student_Records[minIndex][0];
                  this.student_Records[minIndex][0]=this.student_Records[i][0];
                   this.student_Records[i][0]=temp1;
                   
                   String  temp2=this.student_Records[minIndex][1];
                  this.student_Records[minIndex][1]=this.student_Records[i][1];
                   this.student_Records[i][1]=temp2;
                   
                   String  temp3=this.student_Records[minIndex][2];
                  this.student_Records[minIndex][2]=this.student_Records[i][2];
                   this.student_Records[i][2]=temp3;
                   
                   String  temp4=this.student_Records[minIndex][3];
                  this.student_Records[minIndex][3]=this.student_Records[i][3];
                   this.student_Records[i][3]=temp4;
                   
                   String  temp5=this.student_Records[minIndex][4];
                  this.student_Records[minIndex][4]=this.student_Records[i][4];
                   this.student_Records[i][4]=temp5;
                   
                   String  temp6=this.student_Records[minIndex][5];
                  this.student_Records[minIndex][5]=this.student_Records[i][5];
                   this.student_Records[i][5]=temp6;
                   
                   String  temp7=this.student_Records[minIndex][6];
                  this.student_Records[minIndex][6]=this.student_Records[i][6];
                   this.student_Records[i][6]=temp7;                
               }   
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

        AddStudentToFixturePanel = new javax.swing.JPanel();
        ASTF_FixtureID_lbl = new javax.swing.JLabel();
        ASTF_FixtureID_txt = new javax.swing.JTextField();
        ASTF_FixtureName_lbl = new javax.swing.JLabel();
        ASTF_FixtureName_txt = new javax.swing.JTextField();
        ASTF_FixtureDate_lbl = new javax.swing.JLabel();
        ASTF_AgeGroup_lbl = new javax.swing.JLabel();
        ASTF_FixtureDate_txt = new javax.swing.JTextField();
        ASTF_AgeGroup_txt = new javax.swing.JTextField();
        ASTF_Gender_lbl = new javax.swing.JLabel();
        ASTF_Gender_txt = new javax.swing.JTextField();
        ASTF_Sport_lbl = new javax.swing.JLabel();
        ASTF_Sport_txt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        ASTF_Save_btn = new javax.swing.JButton();
        ASTF_Back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddStudentToFixturePanel.setBackground(new java.awt.Color(0, 102, 102));

        ASTF_FixtureID_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ASTF_FixtureID_lbl.setText("Fixture ID");

        ASTF_FixtureID_txt.setEditable(false);
        ASTF_FixtureID_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_FixtureID_txtActionPerformed(evt);
            }
        });

        ASTF_FixtureName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ASTF_FixtureName_lbl.setText("Fixture Name");

        ASTF_FixtureName_txt.setEditable(false);
        ASTF_FixtureName_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_FixtureName_txtActionPerformed(evt);
            }
        });

        ASTF_FixtureDate_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ASTF_FixtureDate_lbl.setText("Fixture Date");

        ASTF_AgeGroup_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ASTF_AgeGroup_lbl.setText("Age Group");

        ASTF_FixtureDate_txt.setEditable(false);
        ASTF_FixtureDate_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_FixtureDate_txtActionPerformed(evt);
            }
        });

        ASTF_AgeGroup_txt.setEditable(false);
        ASTF_AgeGroup_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_AgeGroup_txtActionPerformed(evt);
            }
        });

        ASTF_Gender_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ASTF_Gender_lbl.setText("Gender");

        ASTF_Gender_txt.setEditable(false);
        ASTF_Gender_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_Gender_txtActionPerformed(evt);
            }
        });

        ASTF_Sport_lbl.setForeground(new java.awt.Color(255, 255, 255));
        ASTF_Sport_lbl.setText("Sport");

        ASTF_Sport_txt.setEditable(false);
        ASTF_Sport_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_Sport_txtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddStudentToFixturePanelLayout = new javax.swing.GroupLayout(AddStudentToFixturePanel);
        AddStudentToFixturePanel.setLayout(AddStudentToFixturePanelLayout);
        AddStudentToFixturePanelLayout.setHorizontalGroup(
            AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddStudentToFixturePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ASTF_FixtureName_lbl)
                    .addComponent(ASTF_FixtureID_lbl))
                .addGap(18, 18, 18)
                .addGroup(AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AddStudentToFixturePanelLayout.createSequentialGroup()
                        .addComponent(ASTF_FixtureName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ASTF_AgeGroup_lbl))
                    .addGroup(AddStudentToFixturePanelLayout.createSequentialGroup()
                        .addComponent(ASTF_FixtureID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(ASTF_FixtureDate_lbl)))
                .addGap(18, 18, 18)
                .addGroup(AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ASTF_FixtureDate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASTF_AgeGroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ASTF_Gender_lbl)
                    .addComponent(ASTF_Sport_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ASTF_Sport_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASTF_Gender_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(185, 185, 185))
        );
        AddStudentToFixturePanelLayout.setVerticalGroup(
            AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStudentToFixturePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ASTF_FixtureID_lbl)
                    .addComponent(ASTF_FixtureID_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASTF_FixtureDate_lbl)
                    .addComponent(ASTF_FixtureDate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASTF_Gender_lbl)
                    .addComponent(ASTF_Gender_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddStudentToFixturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ASTF_FixtureName_lbl)
                    .addComponent(ASTF_FixtureName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASTF_AgeGroup_lbl)
                    .addComponent(ASTF_AgeGroup_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASTF_Sport_lbl)
                    .addComponent(ASTF_Sport_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Select", "Student ID", "First Name", "Last Name", "Grade", "House", "Tutor Name", "Email ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        ASTF_Save_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        ASTF_Save_btn.setForeground(new java.awt.Color(0, 102, 102));
        ASTF_Save_btn.setText("Save");
        ASTF_Save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_Save_btnActionPerformed(evt);
            }
        });

        ASTF_Back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        ASTF_Back_btn.setForeground(new java.awt.Color(0, 102, 102));
        ASTF_Back_btn.setText("Back");
        ASTF_Back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASTF_Back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(ASTF_Save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124)
                        .addComponent(ASTF_Back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ASTF_Save_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASTF_Back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(AddStudentToFixturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddStudentToFixturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ASTF_FixtureID_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_FixtureID_txtActionPerformed

    }//GEN-LAST:event_ASTF_FixtureID_txtActionPerformed

    private void ASTF_FixtureName_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_FixtureName_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASTF_FixtureName_txtActionPerformed

    private void ASTF_FixtureDate_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_FixtureDate_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASTF_FixtureDate_txtActionPerformed

    private void ASTF_AgeGroup_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_AgeGroup_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASTF_AgeGroup_txtActionPerformed

    private void ASTF_Back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_Back_btnActionPerformed
        CoachMyFixture cmf = new CoachMyFixture();
        cmf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ASTF_Back_btnActionPerformed

    private void ASTF_Save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_Save_btnActionPerformed

                int count=0; //no of records selected
                int studentid=0;
                int fixtureid = 0;
                for(int i=0;i<data.getRowCount();i++){
                        if(data.getValueAt(i, 0).toString().equals("true")){
                                count++;
                                studentid=Integer.parseInt(data.getValueAt(i, 1).toString());
                                fixtureid = Integer.parseInt(this.ASTF_FixtureID_txt.getText());
                            }
                    }
                if(count==0) {
                    JOptionPane.showMessageDialog(this, "Please select a student from the table");
                } else if(count>1) {
                    JOptionPane.showMessageDialog(this, "Please select only one student at a time");
                } else {
                    AddStudentToFixture(studentid, fixtureid);
                }         
    }//GEN-LAST:event_ASTF_Save_btnActionPerformed

    public void AddStudentToFixture(int studentid, int fixtureid){
        String studentavailability = "Pending";
        String status = "Pending";
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            int y = s.executeUpdate("INSERT INTO participant_details (STUDENT_ID, FIXTURE_ID, COACH_ID, STUDENTAVAILABILITY_STATUS, status) VALUES (" 
                    + studentid + ", " + fixtureid + ", " + this.coachID + ", 'Pending', 'Pending')");
            
            if (y > 0) {
                JOptionPane.showMessageDialog(this,"Student has been added to fixture");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    
    
    private void ASTF_Gender_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_Gender_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASTF_Gender_txtActionPerformed

    private void ASTF_Sport_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASTF_Sport_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASTF_Sport_txtActionPerformed

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
            java.util.logging.Logger.getLogger(AddStudentToFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudentToFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudentToFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudentToFixture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddStudentToFixture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ASTF_AgeGroup_lbl;
    private javax.swing.JTextField ASTF_AgeGroup_txt;
    private javax.swing.JButton ASTF_Back_btn;
    private javax.swing.JLabel ASTF_FixtureDate_lbl;
    private javax.swing.JTextField ASTF_FixtureDate_txt;
    private javax.swing.JLabel ASTF_FixtureID_lbl;
    private javax.swing.JTextField ASTF_FixtureID_txt;
    private javax.swing.JLabel ASTF_FixtureName_lbl;
    private javax.swing.JTextField ASTF_FixtureName_txt;
    private javax.swing.JLabel ASTF_Gender_lbl;
    private javax.swing.JTextField ASTF_Gender_txt;
    private javax.swing.JButton ASTF_Save_btn;
    private javax.swing.JLabel ASTF_Sport_lbl;
    private javax.swing.JTextField ASTF_Sport_txt;
    private javax.swing.JPanel AddStudentToFixturePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
