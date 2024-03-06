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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;

public class AllPastFixtures extends javax.swing.JFrame {
    DefaultTableModel data;
    private String name;
    LinkedList<Date> dates=new LinkedList<Date>();
    LinkedList fixtureid_list=new LinkedList();
    LinkedList fixtureName_list=new LinkedList();
    LinkedList Organisation_list=new LinkedList();
    LinkedList Sport_list=new LinkedList();
    LinkedList Venue_list=new LinkedList();
    LinkedList AgeGroup_list=new LinkedList();
    LinkedList Gender_list=new LinkedList();

    
    public AllPastFixtures() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.name = LoginPage.name;
        data = (DefaultTableModel)table.getModel();
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
        
        this.showPastFixtureRecords();
    }

    public void showPastFixtureRecords(){
        Date today = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        data.setRowCount(0);
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            ResultSet r = s.executeQuery("select * from fixture_details");
            while(r.next()){
                String pastfixturedate = r.getString("Date");
                Date past_fixturedate = df.parse(pastfixturedate);
                if(past_fixturedate.before(today)){
                    this.dates.add(past_fixturedate);    
                    this.fixtureid_list.add(r.getInt("Fixture_ID"));
                    this.fixtureName_list.add(r.getString("Fixture_Name"));
                    this.Organisation_list.add(r.getString("Organisation"));
                    this.Sport_list.add(r.getString("Sport"));
                    this.Venue_list.add(r.getString("Venue"));
                    this.AgeGroup_list.add(r.getString("Age_Group"));
                    this.Gender_list.add(r.getString("Gender"));                     
                }
            }
          DateBubbleSort();
          data.setRowCount(0);
          for(int i = 0; i < this.dates.size(); i++){
            String formatteddate = df.format(this.dates.get(i));
            data.addRow(new Object[]{false,this.fixtureid_list.get(i),this.fixtureName_list.get(i),
                formatteddate,this.Organisation_list.get(i),this.Sport_list.get(i),this.Venue_list.get(i),
                this.AgeGroup_list.get(i),this.Gender_list.get(i)});
            }
          
          DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
          centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
          
          for(int i = 1; i < table.getColumnCount(); i++){
              table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
          }
        } catch(Exception e){
            e.printStackTrace();
        }     
    }
    
   public void DateBubbleSort(){
       System.out.println("linked list date "+this.dates);
       
       boolean swap=true;
       while(swap){
           swap=false;
           for(int i=0;i<(this.dates.size()-1);i++){
               Date first=dates.get(i);
               Date next=dates.get(i+1);
               
               if(first.compareTo(next)<0){
             
                   Date temp=dates.get(i);
                   dates.set(i, dates.get(i+1));
                   dates.set(i+1, temp);
                   
                   int temp1=Integer.parseInt(this.fixtureid_list.get(i).toString());
                   this.fixtureid_list.set(i, this.fixtureid_list.get(i+1));
                   this.fixtureid_list.set(i+1, temp1);
                   
                   String temp2 = this.fixtureName_list.get(i).toString();
                   this.fixtureName_list.set(i, this.fixtureName_list.get(i+1));
                   this.fixtureName_list.set(i+1, temp2);

                   String temp3 = this.Organisation_list.get(i).toString();
                   this.Organisation_list.set(i, this.Organisation_list.get(i+1));
                   this.Organisation_list.set(i+1, temp3);

                   String temp4 = this.Sport_list.get(i).toString();
                   this.Sport_list.set(i, this.Sport_list.get(i+1));
                   this.Sport_list.set(i+1, temp4);

                   String temp5 = this.Venue_list.get(i).toString();
                   this.Venue_list.set(i, this.Venue_list.get(i+1));
                   this.Venue_list.set(i+1, temp5);

                   String temp6 = this.AgeGroup_list.get(i).toString();
                   this.AgeGroup_list.set(i, this.AgeGroup_list.get(i+1));
                   this.AgeGroup_list.set(i+1, temp6);

                   String temp7 = this.Gender_list.get(i).toString();
                   this.Gender_list.set(i,this.Gender_list.get(i+1));
                   this.Gender_list.set(i+1, temp7);
                   swap=true;
               }
           }
       }    
       System.out.println("linked list date after sort   : "+this.fixtureid_list+" "+this.fixtureName_list+" "+this.dates+" "
               +this.Organisation_list+" "+this.Sport_list+" "+this.Venue_list+" "+this.AgeGroup_list+" "+this.Gender_list);   
   } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AUF_back_btn1 = new javax.swing.JButton();
        AllUpcomingFixturesPanel = new javax.swing.JPanel();
        AUF_sp = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        PF_back_btn = new javax.swing.JButton();
        STMS_lbl1 = new javax.swing.JLabel();

        AUF_back_btn1.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        AUF_back_btn1.setForeground(new java.awt.Color(0, 102, 102));
        AUF_back_btn1.setText("Back");
        AUF_back_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUF_back_btn1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        PF_back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        PF_back_btn.setForeground(new java.awt.Color(0, 102, 102));
        PF_back_btn.setText("Back");
        PF_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PF_back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AllUpcomingFixturesPanelLayout = new javax.swing.GroupLayout(AllUpcomingFixturesPanel);
        AllUpcomingFixturesPanel.setLayout(AllUpcomingFixturesPanelLayout);
        AllUpcomingFixturesPanelLayout.setHorizontalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addGroup(AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                        .addGap(1081, 1081, 1081)
                        .addComponent(PF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AUF_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AllUpcomingFixturesPanelLayout.setVerticalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(AUF_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        STMS_lbl1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl1.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl1.setText("Sports Team Management System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AllUpcomingFixturesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(414, 414, 414)
                        .addComponent(STMS_lbl1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(STMS_lbl1)
                .addGap(38, 38, 38)
                .addComponent(AllUpcomingFixturesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PF_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PF_back_btnActionPerformed
        try {
            Class.forName("java.sql.DriverManager");
            Connection con = ConnectDB.getConnect();
            Statement s = con.createStatement();
            
            ResultSet r = s.executeQuery("SELECT CATEGORY FROM login_details WHERE CONCAT(FIRSTNAME, ' ', LASTNAME)='"+ name +"'");
            while(r.next()){
                String category = r.getString("CATEGORY");
                if(category.equals("Coach")){
                    CoachDashboard cd = new CoachDashboard();
                    cd.setVisible(true);
                    this.dispose();
                } else {
                    StudentDashboard sd = new StudentDashboard();
                    sd.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception e) {
            
        } 
    }//GEN-LAST:event_PF_back_btnActionPerformed

    private void AUF_back_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUF_back_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AUF_back_btn1ActionPerformed

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
            java.util.logging.Logger.getLogger(AllPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AllPastFixtures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AUF_back_btn1;
    private javax.swing.JScrollPane AUF_sp;
    private javax.swing.JPanel AllUpcomingFixturesPanel;
    private javax.swing.JButton PF_back_btn;
    private javax.swing.JLabel STMS_lbl1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
