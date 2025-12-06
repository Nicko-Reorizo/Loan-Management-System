/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loan.management.system;

/**
 *
 * @author Onyx
 */
import java.sql.Connection;
import java.sql.SQLException;

public abstract class Debtor{
    
protected DatabaseConnection dtbs;
protected Connection conn;
    
    
    private String client_name;
    private int loan_amount;
    private String date;
    private int term;
    private String number;
    private String client_address;
    
    public Debtor(String name, int amount, String date, int term, String number, String address){
        this.client_name = name;
        this.loan_amount = amount;
        this.date = date;
        this.term = term;
        this.number = number;
        this.client_address = address;
        
    dtbs = new DatabaseConnection();
    conn = dtbs.getConnection();
    }
    
     public abstract void InsertToDB() throws SQLException;
    
    public String getName(){
        return client_name;
    }
    public int getAmount(){
        return loan_amount;
    }
    public String getDate(){
        return date;
    }
    public int getTerm(){
        return term;
    }
    public String getNumber(){
        return number;
    }
    public String getAddress(){
        return client_address;
    }
    
}
