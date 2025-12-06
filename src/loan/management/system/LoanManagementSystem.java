/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loan.management.system;

/**
 *
 * @author Onyx
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;

public class LoanManagementSystem extends DatabaseConnection{
    
    
    
    public static void main(String[] args) {
        DatabaseConnection dtbs = new DatabaseConnection();
        Connection conn = dtbs.getConnection();
        
        new Login().setVisible(true);
    }
    
}
