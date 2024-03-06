/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportsteammgmtsystem;
import java.sql.*;


/**
 *
 * @author sidbohra
 */
public class ConnectDB {
    
    public static Connection getConnect()
    {
     Connection con=null;
        try{
            Class.forName("java.sql.DriverManager"); //loading drivers
           
            con=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/sports_db","root", "Jadefish2006*");
        }catch(Exception ex){
            ex.printStackTrace();
            }
        return con;//returning connection string   
    }    
    
    
}
