/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sportsteammgmtsystem;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author sidbohra
 */
public class AllUpcomingFixtures extends javax.swing.JFrame {
    LinkedList<Date> dates = new LinkedList<Date>();
    LinkedList fixtureId_list = new LinkedList();
    LinkedList fixturename_list = new LinkedList();
    LinkedList organisation_list = new LinkedList();
    LinkedList sport_list = new LinkedList();
    LinkedList venue_list = new LinkedList();
    LinkedList age_group_list = new LinkedList();
    LinkedList gender_list = new LinkedList();

    private String Name;
    DefaultTableModel data;
    
    public AllUpcomingFixtures(String name) {
        initComponents();
       this.setLocationRelativeTo(null);
       this.Name = LoginPage.name;
        data=(DefaultTableModel)table.getModel(); 
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80); 
        table.getColumnModel().getColumn(1).setMaxWidth(100); 
        table.getColumnModel().getColumn(1).setMinWidth(100); 
        table.getColumnModel().getColumn(2).setMaxWidth(200);
        table.getColumnModel().getColumn(2).setMinWidth(200);
        table.getColumnModel().getColumn(3).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setMinWidth(150);
        table.getColumnModel().getColumn(4).setMaxWidth(120); 
        table.getColumnModel().getColumn(4).setMinWidth(120);
        table.getColumnModel().getColumn(5).setMaxWidth(120); 
        table.getColumnModel().getColumn(5).setMinWidth(120);
        table.getColumnModel().getColumn(6).setMaxWidth(200); 
        table.getColumnModel().getColumn(6).setMinWidth(200);
        table.getColumnModel().getColumn(7).setMaxWidth(120); 
        table.getColumnModel().getColumn(7).setMinWidth(120);
        table.getColumnModel().getColumn(8).setMaxWidth(120); 
        table.getColumnModel().getColumn(8).setMinWidth(120);
    
     JTableHeader header=table.getTableHeader();//header is an object of JTableHEader class
     header.setFont(new Font ("Arial",Font.BOLD,16)); //heading
     table.setRowHeight(40);
     table.setGridColor(Color.blue);
     table.setShowGrid(true);
     table.setFont(new Font ("Arial",Font.BOLD,14)); //records
      
       this.showFixtureRecords();
    }

    public void showFixtureRecords(){
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        data.setRowCount(0);
       try{
         Class.forName("java.sql.DriverManager");
         Connection con=ConnectDB.getConnect();
         Statement s=con.createStatement();
        
         ResultSet r=s.executeQuery("select * from fixture_details ");
       
          while(r.next()){
            String fixtureDate = r.getString("Date");
            Date fixture_date = df.parse(fixtureDate);
            if (fixture_date.after(today)) {
                this.dates.add(fixture_date);
                this.fixtureId_list.add(r.getInt("Fixture_ID"));
                this.fixturename_list.add(r.getString("Fixture_Name"));
                this.organisation_list.add(r.getString("Organisation"));
                this.sport_list.add(r.getString("Sport"));
                this.venue_list.add(r.getString("Venue"));
                this.age_group_list.add(r.getString("Age_Group"));
                this.gender_list.add(r.getString("Gender"));
            }
          }
          DateBubbleSort();
          data.setRowCount(0);
          for(int i = 0; i<this.dates.size(); i++){
              String formatteddate = df.format(this.dates.get(i));
              data.addRow(new Object[]{false,this.fixtureId_list.get(i),this.fixturename_list.get(i),
                  formatteddate,this.organisation_list.get(i),this.sport_list.get(i),this.venue_list.get(i),
                  this.age_group_list.get(i),this.gender_list.get(i)});
          }
          
          DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
          centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
          
          for(int i = 1; i < table.getColumnCount(); i++){
              table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
          }
          
         }catch(Exception e){
             e.printStackTrace();
         }
    }

    public void DateBubbleSort(){
        System.out.println("Linked List Date: "+this.dates); //Printing unsorted fixture dates
        boolean swap = true; //Indicator that swapping of dates is possible given that mutliple dates remaining in linkedlist.
        while(swap){ //When swapping element is done 
            swap = false;
            for(int i = 0; i<this.dates.size()-1; i++){ //Iterating over fixture dates in linked list sequentially
                Date first = dates.get(i); //Date datatype first date assigned to index i element in linked list
                Date next = dates.get(i+1); //Date datatype next date assigned to the next element in linked list for comparison
                if(first.compareTo(next)>0){ //Condition returns an integer > 0 if first date more later than next date
                    Date temp = dates.get(i); //using temp to swap index positions of dates
                    dates.set(i, dates.get(i+1));
                    dates.set(i+1, temp);
                    
                    int temp1 = Integer.parseInt(this.fixtureId_list.get(i).toString()); //swapping respective parameters
                    this.fixtureId_list.set(i, this.fixtureId_list.get(i+1));
                    this.fixtureId_list.set(i+1, temp1);
                    
                    String temp2 = this.fixturename_list.get(i).toString();
                    this.fixturename_list.set(i, this.fixturename_list.get(i+1));
                    this.fixturename_list.set(i+1, temp2);
                    
                    String temp3 = this.organisation_list.get(i).toString();
                    this.organisation_list.set(i, this.organisation_list.get(i+1));
                    this.organisation_list.set(i+1, temp3);
                    
                    String temp4 = this.sport_list.get(i).toString();
                    this.sport_list.set(i, this.sport_list.get(i+1));
                    this.sport_list.set(i+1, temp4);
                    
                    String temp5 = this.venue_list.get(i).toString();
                    this.venue_list.set(i, this.venue_list.get(i+1));
                    this.venue_list.set(i+1, temp5);
                    
                    String temp6 = this.age_group_list.get(i).toString();
                    this.age_group_list.set(i, this.age_group_list.get(i+1));
                    this.age_group_list.set(i+1, temp6);
                    
                    String temp7 = this.gender_list.get(i).toString();
                    this.gender_list.set(i, this.gender_list.get(i+1));
                    this.gender_list.set(i+1, temp7);
                    swap = true; //swap set to true for next iteration of date
                }
            }
        }
} 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        AllUpcomingFixturesPanel = new javax.swing.JPanel();
        AUF_sp = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        AUF_AddFixture_btn = new javax.swing.JButton();
        AUF_back_btn = new javax.swing.JButton();
        AUF_UpdateFixture_btn = new javax.swing.JButton();
        AUF_DeleteFixture_btn = new javax.swing.JButton();
        STMS_lbl1 = new javax.swing.JLabel();
        CMF_lbl = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("jCheckBoxMenuItem3");

        jCheckBoxMenuItem4.setSelected(true);
        jCheckBoxMenuItem4.setText("jCheckBoxMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AllUpcomingFixturesPanel.setBackground(new java.awt.Color(0, 102, 102));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Select", "Fixture ID", "Fixture", "Date", "Organisation", "Sport", "Venue", "Age Group", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AUF_sp.setViewportView(table);

        AUF_AddFixture_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        AUF_AddFixture_btn.setForeground(new java.awt.Color(0, 102, 102));
        AUF_AddFixture_btn.setText("Add Fixture");
        AUF_AddFixture_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUF_AddFixture_btnActionPerformed(evt);
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

        AUF_UpdateFixture_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        AUF_UpdateFixture_btn.setForeground(new java.awt.Color(0, 102, 102));
        AUF_UpdateFixture_btn.setText("Update Fixture");
        AUF_UpdateFixture_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUF_UpdateFixture_btnActionPerformed(evt);
            }
        });

        AUF_DeleteFixture_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        AUF_DeleteFixture_btn.setForeground(new java.awt.Color(0, 102, 102));
        AUF_DeleteFixture_btn.setText("Delete Fixture");
        AUF_DeleteFixture_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUF_DeleteFixture_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AllUpcomingFixturesPanelLayout = new javax.swing.GroupLayout(AllUpcomingFixturesPanel);
        AllUpcomingFixturesPanel.setLayout(AllUpcomingFixturesPanelLayout);
        AllUpcomingFixturesPanelLayout.setHorizontalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addGroup(AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(AUF_AddFixture_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AUF_UpdateFixture_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AUF_DeleteFixture_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(326, 326, 326)
                        .addComponent(AUF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AUF_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        AllUpcomingFixturesPanelLayout.setVerticalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(AUF_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AUF_AddFixture_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AUF_UpdateFixture_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AUF_DeleteFixture_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AUF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(AllUpcomingFixturesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1240, -1));

        STMS_lbl1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl1.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl1.setText("Sports Team Management System");
        getContentPane().add(STMS_lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, -1, -1));

        CMF_lbl.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        CMF_lbl.setForeground(new java.awt.Color(0, 102, 102));
        CMF_lbl.setText("All Upcoming Fixtures");
        getContentPane().add(CMF_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AUF_AddFixture_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUF_AddFixture_btnActionPerformed

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            ResultSet r = s.executeQuery("SELECT CATEGORY FROM login_details WHERE CONCAT(FIRSTNAME, ' ', LASTNAME) = '" + Name + "'");
            while(r.next()){
                String category = r.getString("category");
                if(category.equals("Student")){
                    JOptionPane.showMessageDialog(this, "Students have no coach permissions");
                } else {
                    AddFixture ad=new AddFixture();
                    ad.setVisible(true);
                    this.dispose();

                }
            }
        } catch (Exception e){
            
        }    
    }//GEN-LAST:event_AUF_AddFixture_btnActionPerformed

    private void AUF_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUF_back_btnActionPerformed
        
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            ResultSet r = s.executeQuery("SELECT CATEGORY FROM login_details WHERE CONCAT(FIRSTNAME, ' ', LASTNAME) = '" + Name + "'");
            while(r.next()){
                String category = r.getString("category");
                if(category.equals("Student")){
                    StudentDashboard sd = new StudentDashboard();
                    sd.setVisible(true);
                    this.dispose();
                } else {
                    CoachDashboard cd = new CoachDashboard();
                    cd.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception e){
            
        }  
    }//GEN-LAST:event_AUF_back_btnActionPerformed

    private void AUF_UpdateFixture_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUF_UpdateFixture_btnActionPerformed
        try {
            Class.forName("java.sql.DriverManager"); //Establishing connection to database
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            ResultSet r = s.executeQuery("SELECT CATEGORY FROM login_details WHERE CONCAT(FIRSTNAME, ' ', LASTNAME) = '" 
            + Name + "'"); //Fetching category from login details where full name = logged in user's name
            while(r.next()){ //Condition that target name match is found 
                String category = r.getString("category"); 
                if(category.equals("Student")){ //Condition to check whether user = student
                    JOptionPane.showMessageDialog(this, "Students have no coach permissions");
                } else { //user is determined as coach
                    int count=0; //no of records selected
                    int fixtureid=0;
                    for(int i=0;i<data.getRowCount();i++){
                        if(data.getValueAt(i, 0).toString().equals("true")){
                            count++; //counting the number of selections (marked checkboxes)
                            //getting fixtureid for every selection
                            fixtureid=Integer.parseInt(data.getValueAt(i, 1).toString());                      
                        }
                    }
                    if(count==0)
                        JOptionPane.showMessageDialog(this, "Please select fixture from a table");
                    else if(count>1)
                        JOptionPane.showMessageDialog(this, "Please select only one fixture at a time");
                    else{
                        AddFixture ad=new AddFixture(fixtureid);
                        ad.setVisible(true);
                        this.dispose();  
                    }
                }   
            }
        } catch (Exception e){
            
        }        
    }//GEN-LAST:event_AUF_UpdateFixture_btnActionPerformed

    private void AUF_DeleteFixture_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUF_DeleteFixture_btnActionPerformed

        try {
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            ResultSet r = s.executeQuery("SELECT CATEGORY FROM login_details WHERE CONCAT(FIRSTNAME, ' ', LASTNAME) = '" + Name + "'");
            while(r.next()){
                String category = r.getString("category");
                if(category.equals("Student")){
                    JOptionPane.showMessageDialog(this, "Students have no coach permissions");
                } else {
                    int count=0; //no of records selected
                    int fixtureid=0;
                    for(int i=0;i<data.getRowCount();i++){            
                        if(data.getValueAt(i, 0).toString().equals("true")){
                            count++;
                            fixtureid=Integer.parseInt(data.getValueAt(i, 1).toString());
                        }
                    }
                    if(count==0)
                        JOptionPane.showMessageDialog(this, "Please select fixture from a table");
                    else if(count>1)
                        JOptionPane.showMessageDialog(this, "Please select only one fixture at a time");
                    else{
                        deleteFixture(fixtureid);
                    }
                }
            }
        } catch (Exception e){           
        }                 
    }//GEN-LAST:event_AUF_DeleteFixture_btnActionPerformed
public void deleteFixture(int fixtureid){
    int result = JOptionPane.showConfirmDialog(this,"Are you sure to delete fixure  "+fixtureid+" "
                + "from the system?", "Delete teacher",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION)
            {
                try{
                        Class.forName("java.sql.DriverManager");
                        Connection con = ConnectDB.getConnect();
                        Statement s = con.createStatement();
                        int x=s.executeUpdate(" delete from  fixture_details where fixture_ID="+fixtureid+"");
                        int y=s.executeUpdate(" delete from  participant_details where fixture_ID="+fixtureid+"");
                        //mysql command to delete row
                        if(x>0 || y>0){
                            JOptionPane.showMessageDialog(this, "Fixture Details has been deleted successfully");
                            AllUpcomingFixtures AUF = new AllUpcomingFixtures(LoginPage.name);
                            AUF.setVisible(true); 
                            this.dispose();
                        }
                        
                            //error handling if deletion code did not execute
                    } 
                    catch(Exception e){
                          e.printStackTrace();
                          JOptionPane.showMessageDialog(this, e.getMessage());
                        }
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
            java.util.logging.Logger.getLogger(AllUpcomingFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllUpcomingFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllUpcomingFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllUpcomingFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllUpcomingFixtures(LoginPage.name).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AUF_AddFixture_btn;
    private javax.swing.JButton AUF_DeleteFixture_btn;
    private javax.swing.JButton AUF_UpdateFixture_btn;
    private javax.swing.JButton AUF_back_btn;
    private javax.swing.JScrollPane AUF_sp;
    private javax.swing.JPanel AllUpcomingFixturesPanel;
    private javax.swing.JLabel CMF_lbl;
    private javax.swing.JLabel STMS_lbl1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
