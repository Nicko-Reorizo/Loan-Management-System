/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loan.management.system;

/**
 *
 * @author Onyx
 */
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Main extends javax.swing.JFrame {
   
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Main.class.getName());

    /**
     * Creates new form Main
     */
    private DatabaseConnection dtbs;
    private Connection conn;
    Dashboard dashboard = new Dashboard();
    public Main() {
        
        
        dtbs = new DatabaseConnection();
        conn = dtbs.getConnection();
        
       
        initComponents();
        DPanel.setVisible(true);
        LRPanel.setVisible(false);
        ALPanel.setVisible(false);
        PPanel.setVisible(false);
        CPAdata.setText(String.valueOf(Dashboard.cumulative_unpaid_amount));
        CLAdata.setText(String.valueOf(Dashboard.cumulative_loan_amount));
        CLdata.setText(String.valueOf(Dashboard.current_loans));
    }
    
    public void loadLoansToTable(JTable loan_table) {
    try {
        if (conn != null) {
            String sql = "SELECT name, loan_amount, Balance, loan_date, loan_term, address FROM debtor";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            
            
//            This was created with the help of ChatGPT, and I modified the variables and table names.
            DefaultTableModel model = new DefaultTableModel(
                new String[]{"Name", "Loan Amount", "Balance", "Date", "Term", "Address"}, 0
            );

           
            while (rs.next()) {
                String name = rs.getString("name");
                double loanAmount = rs.getInt("loan_amount");
                double balance = rs.getDouble("Balance");
                String date = rs.getString("loan_date");
                int term = rs.getInt("loan_term");
                String address = rs.getString("address");

                model.addRow(new Object[]{name, loanAmount, balance, date, term, address});
            }

            
            loan_table.setModel(model);

            rs.close();
            stmt.close();

        } else {
            JOptionPane.showMessageDialog(null, "Database connection is null");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

        public void PaymentTable(String SName) {
    try {
        if (conn != null) {
            String sql = "SELECT name, Balance,monthly_due FROM debtor WHERE name = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, SName);
            ResultSet rs = pstmt.executeQuery();
            
            
            

            boolean found = false;

            if (rs.next()) {
                double balance = rs.getDouble("Balance");

                // Skip deleted rows
                if (balance <= 0) {
                    JOptionPane.showMessageDialog(null, SName + " is fully paid! Record will be deleted");
                    String del = "DELETE FROM debtor WHERE Balance <= 0 AND name = ?";
                    PreparedStatement delStmt = conn.prepareStatement(del);
                    delStmt.setString(1, rs.getString("name"));
                    delStmt.executeUpdate();
                    delStmt.close();
                    
                }

                found = true;
              String n = rs.getString("name");
              double b = rs.getDouble("Balance");
              double m = rs.getDouble("monthly_due");
              
             NameInfo.setText(n);
             BalanceInfo.setText(String.valueOf(b));
             MonthlyInfo.setText(String.valueOf(m));
            }

            PayButton.setEnabled(found);
            
            rs.close();
            pstmt.close();

        } else {
            JOptionPane.showMessageDialog(null, "Database connection is null");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

        
        public void DeductLoan(String name) throws SQLException{
            String sql = "UPDATE debtor SET Balance = Balance - monthly_due WHERE name = '" + name + "'";
   
            Statement stmt = conn.createStatement();
            
            
            int rows = stmt.executeUpdate(sql);
            
            if(rows > 0){
                JOptionPane.showMessageDialog(null,name + " Succesfully Paid this Month's Loan Amount");
            }
            PaymentTable(name);
            loadLoansToTable(PTable);
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        DButton = new javax.swing.JButton();
        ALButton = new javax.swing.JButton();
        LRButton = new javax.swing.JButton();
        PButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        DPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CLAdata = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CLdata = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        CPAdata = new javax.swing.JLabel();
        LRPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loan_table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        ALPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        CName = new javax.swing.JTextField();
        LAmount = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Number = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Term = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CAddress = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        JType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PTable = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        NameSearch = new javax.swing.JTextField();
        PayButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        NameInfo = new javax.swing.JLabel();
        BalanceInfo = new javax.swing.JLabel();
        MonthlyInfo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jTextField5.setText("jTextField5");

        jLabel18.setText("jLabel18");

        jLabel24.setText("jLabel24");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        DButton.setBackground(new java.awt.Color(0, 153, 153));
        DButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DButton.setForeground(new java.awt.Color(255, 255, 255));
        DButton.setText("Dashboard");
        DButton.setBorder(null);
        DButton.setName("DButton"); // NOI18N
        DButton.addActionListener(this::DButtonActionPerformed);

        ALButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ALButton.setForeground(new java.awt.Color(102, 102, 102));
        ALButton.setText("Add Loan");
        ALButton.setBorder(null);
        ALButton.setName("ALButton"); // NOI18N
        ALButton.addActionListener(this::ALButtonActionPerformed);

        LRButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LRButton.setForeground(new java.awt.Color(102, 102, 102));
        LRButton.setText("Loan Records");
        LRButton.setBorder(null);
        LRButton.setName("LRButton"); // NOI18N
        LRButton.addActionListener(this::LRButtonActionPerformed);

        PButton.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        PButton.setForeground(new java.awt.Color(102, 102, 102));
        PButton.setText("Payment");
        PButton.setBorder(null);
        PButton.setName("LRButton"); // NOI18N
        PButton.addActionListener(this::PButtonActionPerformed);

        jPanel1.setBackground(new java.awt.Color(255, 111, 97));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Loan Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(25, 25, 25))
        );

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DPanel.setName("DPanel"); // NOI18N
        DPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Overall Statistics");
        DPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 10, -1, 19));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cumulative Loan Amount");

        CLAdata.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CLAdata.setForeground(new java.awt.Color(255, 255, 255));
        CLAdata.setText("DATA HERE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CLAdata, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CLAdata)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        DPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 41, -1, 109));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Current Loans");

        CLdata.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CLdata.setForeground(new java.awt.Color(255, 255, 255));
        CLdata.setText("DATA HERE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addContainerGap(230, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(CLdata, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(42, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(CLdata)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        DPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 41, -1, 110));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cumulative Unpaid Amount");

        CPAdata.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CPAdata.setForeground(new java.awt.Color(255, 255, 255));
        CPAdata.setText("DATA HERE");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addContainerGap(169, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(CPAdata, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(CPAdata)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        DPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(717, 41, -1, 110));

        jLayeredPane1.add(DPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 536));

        LRPanel.setName("LRPanel"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("LOAN RECORDS");

        loan_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loan_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Creditor Name", "Loan Amount", "Balance", "Date", "Term", "Address"
            }
        ));
        jScrollPane1.setViewportView(loan_table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LRPanelLayout = new javax.swing.GroupLayout(LRPanel);
        LRPanel.setLayout(LRPanelLayout);
        LRPanelLayout.setHorizontalGroup(
            LRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LRPanelLayout.createSequentialGroup()
                .addGroup(LRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LRPanelLayout.createSequentialGroup()
                        .addGap(1169, 1169, 1169)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LRPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(LRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LRPanelLayout.setVerticalGroup(
            LRPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LRPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.add(LRPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 540));

        ALPanel.setName("ALPanel"); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Loan Input Form");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Creditor Name");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Loan Amount");

        CName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CName.addActionListener(this::CNameActionPerformed);

        LAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LAmount.addActionListener(this::LAmountActionPerformed);

        Date.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Date.setText("YYYY-MM-DD");
        Date.addActionListener(this::DateActionPerformed);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Date");

        Number.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Number.addActionListener(this::NumberActionPerformed);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Phone Number");

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        Term.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Term.addActionListener(this::TermActionPerformed);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Term (Months)");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Creditor Address");

        CAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CAddress.addActionListener(this::CAddressActionPerformed);

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CLEAR");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        JType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Government Employee", "Private Employee" }));
        JType.addActionListener(this::JTypeActionPerformed);

        jLabel1.setText("Job Type");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Notice: Government Workers Interest Rate per month is 3% while Private Employees interest rate are at 5%.");

        javax.swing.GroupLayout ALPanelLayout = new javax.swing.GroupLayout(ALPanel);
        ALPanel.setLayout(ALPanelLayout);
        ALPanelLayout.setHorizontalGroup(
            ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ALPanelLayout.createSequentialGroup()
                        .addComponent(CName, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(LAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addGroup(ALPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304)
                        .addComponent(jLabel11))
                    .addGroup(ALPanelLayout.createSequentialGroup()
                        .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Term, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(ALPanelLayout.createSequentialGroup()
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ALPanelLayout.createSequentialGroup()
                            .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(jLabel1))
                            .addGap(18, 18, 18)
                            .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel15)
                                .addComponent(CAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ALPanelLayout.createSequentialGroup()
                            .addComponent(JType, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        ALPanelLayout.setVerticalGroup(
            ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ALPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ALPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(53, 53, 53))
                    .addGroup(ALPanelLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(37, 37, 37)
                        .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Term, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ALPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ALPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(ALPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        jLayeredPane1.add(ALPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 540));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Loan Payment");

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Search");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Name");

        PTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "Loan Amount", "Balance", "Term", "Monthly Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(PTable);
        if (PTable.getColumnModel().getColumnCount() > 0) {
            PTable.getColumnModel().getColumn(0).setResizable(false);
            PTable.getColumnModel().getColumn(1).setResizable(false);
            PTable.getColumnModel().getColumn(2).setResizable(false);
            PTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Please enter the name of the debtor before marking it as paid.");

        NameSearch.addActionListener(this::NameSearchActionPerformed);

        PayButton.setText("PAID THIS MONTH");
        PayButton.setEnabled(false);
        PayButton.addActionListener(this::PayButtonActionPerformed);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel20.setText("Name:");

        jLabel21.setText("Balance:");

        jLabel22.setText("Monthly Due:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Loan Info");

        NameInfo.setText(".");

        BalanceInfo.setText(".");

        MonthlyInfo.setText(".");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NameInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BalanceInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MonthlyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel23)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(NameInfo))
                .addGap(43, 43, 43)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(BalanceInfo))
                .addGap(41, 41, 41)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(MonthlyInfo))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PPanelLayout = new javax.swing.GroupLayout(PPanel);
        PPanel.setLayout(PPanelLayout);
        PPanelLayout.setHorizontalGroup(
            PPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(PPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PPanelLayout.createSequentialGroup()
                        .addGroup(PPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PPanelLayout.createSequentialGroup()
                                .addGroup(PPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(NameSearch))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(PayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        PPanelLayout.setVerticalGroup(
            PPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(PPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(4, 4, 4)
                        .addGroup(PPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLayeredPane1.add(PPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LRButton, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(PButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ALButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1105, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ALButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(476, 476, 476))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DButtonActionPerformed
 
      LRButton.setBackground(Color.WHITE);
      LRButton.setForeground(Color.GRAY);
      
      PButton.setBackground(Color.WHITE);
        PButton.setForeground(Color.GRAY);
        
      ALButton.setBackground(Color.WHITE);
      ALButton.setForeground(Color.GRAY);
      
      DButton.setBackground(new Color(0,153,153));
      DButton.setForeground(Color.WHITE);
      
      DPanel.setVisible(true);
      ALPanel.setVisible(false);
      LRPanel.setVisible(false);
      PPanel.setVisible(false);
      
      dashboard.refreshDashboard();
      CLdata.setText(String.valueOf(Dashboard.current_loans));
      CLAdata.setText(String.valueOf(Dashboard.cumulative_loan_amount));
      CPAdata.setText(String.valueOf(Dashboard.cumulative_unpaid_amount));
    }//GEN-LAST:event_DButtonActionPerformed

    private void LRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LRButtonActionPerformed
        DButton.setBackground(Color.WHITE);
        DButton.setForeground(Color.GRAY);
        
        PButton.setBackground(Color.WHITE);
        PButton.setForeground(Color.GRAY);
        
        ALButton.setBackground(Color.WHITE);
        ALButton.setForeground(Color.GRAY);
        
        LRButton.setBackground(new Color(0,153,153));
        LRButton.setForeground(Color.WHITE);
        
        DPanel.setVisible(false);
        ALPanel.setVisible(false);
        LRPanel.setVisible(true);
        PPanel.setVisible(false);
        
        loadLoansToTable(loan_table);
    }//GEN-LAST:event_LRButtonActionPerformed

    private void ALButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALButtonActionPerformed
        DButton.setBackground(Color.WHITE);
        DButton.setForeground(Color.GRAY);
         
        LRButton.setBackground(Color.WHITE);
        LRButton.setForeground(Color.GRAY);
        
        PButton.setBackground(Color.WHITE);
        PButton.setForeground(Color.GRAY);
        
        
        ALButton.setBackground(new Color(0,153,153));
        ALButton.setForeground(Color.WHITE);
        
        DPanel.setVisible(false);
        ALPanel.setVisible(true);
        LRPanel.setVisible(false);
        PPanel.setVisible(false);
        
    }//GEN-LAST:event_ALButtonActionPerformed

    private void CNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNameActionPerformed

    private void LAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LAmountActionPerformed

    private void DateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateActionPerformed

    private void NumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumberActionPerformed

    private void TermActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TermActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TermActionPerformed

    private void CAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CAddressActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        if(conn!=null){
        String client_name = CName.getText().trim();
        String loan_amountText = LAmount.getText().trim();
        String date = Date.getText().trim();
        String termText = Term.getText().trim();
        String number = Number.getText().trim();
        String client_address = CAddress.getText().trim();
        String job_type = (String) JType.getSelectedItem();


        if (client_name.isEmpty() || loan_amountText.isEmpty() || date.isEmpty() ||
        termText.isEmpty() || number.isEmpty() || client_address.isEmpty() ||
        job_type == null || job_type.trim().isEmpty()) {

        JOptionPane.showMessageDialog(null, "Please fill in all fields!");
        return; 
        }

 
        int loan_amount = Integer.parseInt(loan_amountText);
        int term = Integer.parseInt(termText);
        
        
        if(job_type == "Government Employee"){
            try {
                GovDebtor gd = new GovDebtor(client_name, loan_amount, date, term, number,client_address);
                JOptionPane.showMessageDialog(null, "Inputted Succesfully!");
            } catch (SQLException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
        }
        else{
            try {
                PrivateDebtor pd = new PrivateDebtor(client_name, loan_amount, date, term, number,client_address);
                JOptionPane.showMessageDialog(null, "Inputted Succesfully!");
            } catch (SQLException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
        }
        
        CName.setText("");
        LAmount.setText("");
        Date.setText("");
        Term.setText("");
        Number.setText("");
        CAddress.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "No Database Connection!");
        }
        
      
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PButtonActionPerformed
        DButton.setBackground(Color.WHITE);
        DButton.setForeground(Color.GRAY);
         
        LRButton.setBackground(Color.WHITE);
        LRButton.setForeground(Color.GRAY);
        
        ALButton.setBackground(Color.WHITE);
        ALButton.setForeground(Color.GRAY);
        
        PButton.setBackground(new Color(0,153,153));
        PButton.setForeground(Color.WHITE);
        
        PPanel.setVisible(true);
        DPanel.setVisible(false);
        ALPanel.setVisible(false);
        LRPanel.setVisible(false);
        loadLoansToTable(PTable);
    }//GEN-LAST:event_PButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CName.setText("");
        LAmount.setText("");
        Date.setText("");
        Term.setText("");
        Number.setText("");
        CAddress.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTypeActionPerformed

    private void NameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameSearchActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       String name_search = NameSearch.getText();
       
       if(conn!=null){
           PaymentTable(name_search);
       }
       
    }//GEN-LAST:event_jButton3ActionPerformed

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed
        // TODO add your handling code here:
        String name_search = NameSearch.getText();
        
        if(conn!=null){
            try {
                DeductLoan(name_search);
            } catch (SQLException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }//GEN-LAST:event_PayButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Main().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ALButton;
    private javax.swing.JPanel ALPanel;
    private javax.swing.JLabel BalanceInfo;
    private javax.swing.JTextField CAddress;
    private javax.swing.JLabel CLAdata;
    public javax.swing.JLabel CLdata;
    private javax.swing.JTextField CName;
    private javax.swing.JLabel CPAdata;
    private javax.swing.JButton DButton;
    private javax.swing.JPanel DPanel;
    private javax.swing.JTextField Date;
    private javax.swing.JComboBox<String> JType;
    private javax.swing.JTextField LAmount;
    private javax.swing.JButton LRButton;
    private javax.swing.JPanel LRPanel;
    private javax.swing.JLabel MonthlyInfo;
    private javax.swing.JLabel NameInfo;
    private javax.swing.JTextField NameSearch;
    private javax.swing.JTextField Number;
    private javax.swing.JButton PButton;
    private javax.swing.JPanel PPanel;
    private javax.swing.JTable PTable;
    private javax.swing.JButton PayButton;
    private javax.swing.JTextField Term;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable loan_table;
    // End of variables declaration//GEN-END:variables
}
