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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author sidbohra
 */
public class CoachPastFixtures extends javax.swing.JFrame {
    
    int CoachID;
    DefaultTableModel data;

    public CoachPastFixtures() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.CoachID = AddFixture.getCoachId();
        data = (DefaultTableModel)table.getModel();
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80); 
        table.getColumnModel().getColumn(1).setMaxWidth(100); 
        table.getColumnModel().getColumn(1).setMinWidth(100); 
        table.getColumnModel().getColumn(2).setMaxWidth(250);
        table.getColumnModel().getColumn(2).setMinWidth(250);
        table.getColumnModel().getColumn(3).setMaxWidth(180);
        table.getColumnModel().getColumn(3).setMinWidth(180);
        table.getColumnModel().getColumn(4).setMaxWidth(150); 
        table.getColumnModel().getColumn(4).setMinWidth(150);
        table.getColumnModel().getColumn(5).setMaxWidth(120); 
        table.getColumnModel().getColumn(5).setMinWidth(120);
        table.getColumnModel().getColumn(6).setMaxWidth(250); 
        table.getColumnModel().getColumn(6).setMinWidth(250);
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
        
        this.showCoachPastFixtures();
    }
    
    private void showCoachPastFixtures(){
        Date today=new Date(); //fetching current system date
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        data.setRowCount(0);
        try {
            Class.forName("java.sql.DriverManager");
            Connection con=ConnectDB.getConnect();
            Statement s=con.createStatement();
        
            ResultSet r=s.executeQuery("select * from fixture_details where coach_id ="+this.CoachID);
            while(r.next()){
                String fixturedate = r.getString("date");
                Date fixture_date = df.parse(fixturedate);
                String formatteddate = df.format(fixture_date);
                if(fixture_date.before(today)){
                    data.addRow(new Object[]{false,r.getInt("Fixture_ID"), r.getString("Fixture_Name"),formatteddate ,
                     r.getString("Organisation"), r.getString("Sport"), r.getString("Venue"),
                     r.getString("Age_Group"), r.getString("Gender") });
                }
            }
            
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
          
            for(int i = 1; i < table.getColumnCount(); i++){
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
          }
        } catch(Exception e){
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        STMS_lbl1 = new javax.swing.JLabel();
        AllUpcomingFixturesPanel = new javax.swing.JPanel();
        AUF_sp = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        CPF_back_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        STMS_lbl1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        STMS_lbl1.setForeground(new java.awt.Color(0, 102, 102));
        STMS_lbl1.setText("Sports Team Management System");

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

        CPF_back_btn.setFont(new java.awt.Font("Helvetica Neue", 3, 14)); // NOI18N
        CPF_back_btn.setForeground(new java.awt.Color(0, 102, 102));
        CPF_back_btn.setText("Back");
        CPF_back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPF_back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AllUpcomingFixturesPanelLayout = new javax.swing.GroupLayout(AllUpcomingFixturesPanel);
        AllUpcomingFixturesPanel.setLayout(AllUpcomingFixturesPanelLayout);
        AllUpcomingFixturesPanelLayout.setHorizontalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AUF_sp, javax.swing.GroupLayout.DEFAULT_SIZE, 1377, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AllUpcomingFixturesPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CPF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AllUpcomingFixturesPanelLayout.setVerticalGroup(
            AllUpcomingFixturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllUpcomingFixturesPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(AUF_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CPF_back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(STMS_lbl1)
                .addGap(528, 528, 528))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AllUpcomingFixturesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(STMS_lbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(AllUpcomingFixturesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CPF_back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPF_back_btnActionPerformed
        CoachDashboard cd = new CoachDashboard();
        cd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CPF_back_btnActionPerformed


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
            java.util.logging.Logger.getLogger(CoachPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoachPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoachPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoachPastFixtures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoachPastFixtures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane AUF_sp;
    private javax.swing.JPanel AllUpcomingFixturesPanel;
    private javax.swing.JButton CPF_back_btn;
    private javax.swing.JLabel STMS_lbl1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
