/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loan.management.system;

/**
 *
 * @author Onyx
 */
public class Debtor{
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
    }
    
    
}
