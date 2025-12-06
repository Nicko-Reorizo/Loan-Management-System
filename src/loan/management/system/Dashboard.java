package loan.management.system;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dashboard {

    public static int current_loans;
    public static int cumulative_loan_amount = 0;
    public static int cumulative_paid_amount = 0;

    private DatabaseConnection dtbs;
    private Connection conn;

    public Dashboard() {
        dtbs = new DatabaseConnection();
        conn = dtbs.getConnection();
        refreshDashboard();  // initial load
    }

    // Method to refresh the data
    public void refreshDashboard() {
        try {
            if (conn != null) {
                String sql = "SELECT COUNT(*) AS total FROM debtor";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    current_loans = rs.getInt("total");
                    System.out.println("Current loans: " + current_loans);
                }

                
            } else {
                JOptionPane.showMessageDialog(null, "Database connection is null");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
