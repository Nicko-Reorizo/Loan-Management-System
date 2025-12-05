/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loan.management.system;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Onyx
 */

public class DatabaseConnection {
 public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/loan_management_system",
                "root", ""  
            );
            return conn;
        } catch (Exception e) {
            System.out.println("Connection Error: " + e);
            return null;
        }
    }
 
 
}
