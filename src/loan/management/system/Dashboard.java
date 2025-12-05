/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loan.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Onyx
 */
public class Dashboard {
    Connection conn = DatabaseConnection.connect();
    
        try{
         String sql = "SELECT COUNT(*) FROM loan_management_system";
         Statement stmt =  conn.createStatement();
         ResultSet total = stmt.executeQuery(sql);
        }
        catch(Exception e){
    
        }
    
        public static int cumulative_loan_amount = 0;
        public static int cumulative_paid_amount = 0;
        public static int current_loans = 0;
        
        
    
}
