package loan.management.system;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dashboard {

    public static int current_loans;
    public static double cumulative_loan_amount = 0;
    public static double cumulative_unpaid_amount = 0;

    private DatabaseConnection dtbs;
    private Connection conn;

    public Dashboard() {
        dtbs = new DatabaseConnection();
        conn = dtbs.getConnection();
        refreshDashboard();  
    }

    // Method to refresh the data
   public void refreshDashboard() {
    try {
        if (conn != null) {
            // 1️⃣ Count total loans
            String countSql = "SELECT COUNT(*) AS total FROM debtor";
            Statement stmt1 = conn.createStatement();
            ResultSet rs1 = stmt1.executeQuery(countSql);

            if (rs1.next()) {
                current_loans = rs1.getInt("total");
                System.out.println("Current loans: " + current_loans);
            }

            rs1.close();
            stmt1.close();

            // 2️⃣ Sum total loan amounts
            String sumSql = "SELECT SUM(loan_amount) AS total_amount FROM debtor";
            Statement stmt2 = conn.createStatement();
            ResultSet rs2 = stmt2.executeQuery(sumSql);

            if (rs2.next()) {
                cumulative_loan_amount = rs2.getDouble("total_amount");
                System.out.println("Total loan amount: " + cumulative_loan_amount);
            }

            rs2.close();
            stmt2.close();

            
            String sumSql2 = "SELECT SUM(Balance) AS total_unpaid FROM debtor";
            Statement stmt3 = conn.createStatement();
            ResultSet rs3 = stmt3.executeQuery(sumSql2);
            
            if(rs3.next()){
                cumulative_unpaid_amount = rs3.getDouble("total_unpaid");
                System.out.println("Total unpaid amount: " + cumulative_unpaid_amount);
            }
            
            rs3.close();
            stmt3.close();
        } else {
            JOptionPane.showMessageDialog(null, "Database connection is null");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
