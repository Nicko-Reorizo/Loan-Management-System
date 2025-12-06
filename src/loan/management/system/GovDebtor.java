/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loan.management.system;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
/**
 *
 * @author Onyx
 */
public class GovDebtor extends Debtor{
    double InterestRate = 0.03;
    
    public GovDebtor(String name, int amount, String date, int term, String number, String address) throws SQLException {
        super(name, amount, date, term, number, address);
        
        InsertToDB();
    }
    
    double monthlydue = (getAmount()*InterestRate) + (getAmount()/getTerm());
    double balance = monthlydue * getTerm();
    
    @Override
    public void InsertToDB() throws SQLException{
    String sql = "INSERT INTO debtor (name, loan_amount, loan_date, loan_term, phone_number, address, interest, monthly_due, balance) " +
                 "VALUES ('" + getName() + "', " + getAmount() + ", '" + getDate() + "', " + getTerm() + ", '" + getNumber() + "', '" +
                 getAddress() + "', " + InterestRate + ", " + monthlydue + ", " + balance + ")";
    Statement stmt = conn.createStatement();
    stmt.executeUpdate(sql);
    }

    
}
