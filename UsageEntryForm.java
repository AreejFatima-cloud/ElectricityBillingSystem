package ElectricityBillingSystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import java.sql.Statement;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsageEntryForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField customerIdField;
    private JTextField unitsField;
    private JTextField amountField;
    private JTextField previousAmountField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UsageEntryForm frame = new UsageEntryForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UsageEntryForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Pictures\\usage.PNG"));
        setTitle("UsageEntryForm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 637, 451);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 28, 55));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel contentPane_1 = new JPanel();
        contentPane_1.setBackground(new Color(255, 255, 255));
        contentPane_1.setLayout(null);
        contentPane_1.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(192, 192, 192)));
        contentPane_1.setBounds(53, 71, 508, 308);
        contentPane.add(contentPane_1);
        
        JLabel lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCustomerID.setBounds(62, 38, 123, 25);
        contentPane_1.add(lblCustomerID);
        
        customerIdField = new JTextField();
        customerIdField.setColumns(10);
        customerIdField.setBounds(215, 37, 200, 30);
        contentPane_1.add(customerIdField);
        
        JLabel lblUnitsConsumed = new JLabel("Units Consumed:");
        lblUnitsConsumed.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblUnitsConsumed.setBounds(62, 86, 123, 25);
        contentPane_1.add(lblUnitsConsumed);
        
        unitsField = new JTextField();
        unitsField.setColumns(10);
        unitsField.setBounds(215, 85, 200, 30);
        contentPane_1.add(unitsField);
        
        JLabel lblPreviousAmount = new JLabel("Previous Amount:");
        lblPreviousAmount.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblPreviousAmount.setBounds(62, 136, 123, 25);
        contentPane_1.add(lblPreviousAmount);
        
        previousAmountField = new JTextField();
        previousAmountField.setEditable(false);
        previousAmountField.setColumns(10);
        previousAmountField.setBounds(215, 135, 200, 30);
        contentPane_1.add(previousAmountField);
        
        JLabel lblAmountToPay = new JLabel("Amount to Pay:");
        lblAmountToPay.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAmountToPay.setBounds(62, 181, 123, 25);
        contentPane_1.add(lblAmountToPay);
        
        amountField = new JTextField();
        amountField.setEditable(false);
        amountField.setColumns(10);
        amountField.setBounds(215, 180, 200, 30);
        contentPane_1.add(amountField);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setForeground(Color.WHITE);
        btnSubmit.setBackground(new Color(0, 28, 55));
        btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnSubmit.setBounds(317, 246, 98, 36);
        contentPane_1.add(btnSubmit);

        JLabel lblNewLabel = new JLabel("Usage Entry Form");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(229, 25, 193, 40);
        contentPane.add(lblNewLabel);
        
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customer_id = customerIdField.getText();
                try {
                    int unitsConsumed = Integer.parseInt(unitsField.getText());

                    // Calculate the bill amount
                    double amountToPay = calculateBill(unitsConsumed);

                    // Retrieve and display the previous bill amount
                    double previousAmount = getPreviousAmount(customer_id);
                    previousAmountField.setText(String.format("$%.2f", previousAmount));

                    // Set the calculated amount to the amount field
                    amountField.setText(String.format("$%.2f", amountToPay));

                    // Submit the usage data to the database
                    submitUsageData(customer_id, unitsConsumed, previousAmount);
                } catch (NumberFormatException ex) {
                    amountField.setText("Invalid input");
                }
            }
        });
    }

    private double calculateBill(int unitsConsumed) {
        double ratePerUnit = 0.75; // Example rate per unit
        return unitsConsumed * ratePerUnit;
    }

    private double getPreviousAmount(String customer_id) {
        Connection conn = null;
        double previousAmount = 0.0;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE");

            // Query to get the last bill amount for the customer
            String query = "SELECT total_amount FROM Bill WHERE customer_id = ? ORDER BY billing_date DESC LIMIT 1";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, customer_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                previousAmount = rs.getDouble("total_amount");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return previousAmount;
    }

    private void submitUsageData(String customer_id, int unitsConsumed, double previousAmount) {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE");

            // Check if customer_id exists in the Customers table
            String checkCustomerQuery = "SELECT * FROM Customers WHERE customer_id = ?";
            PreparedStatement checkCustomerStmt = conn.prepareStatement(checkCustomerQuery);
            checkCustomerStmt.setString(1, customer_id);
            ResultSet rs = checkCustomerStmt.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Customer ID not found. Please enter a valid Customer ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Calculate the bill amount
            double amountToPay = calculateBill(unitsConsumed);

            // Insert into ElectricityUsage table
            String insertUsageQuery = "INSERT INTO ElectricityUsage (customer_id, units_consumed, usage_date) VALUES (?, ?, CURDATE())";
            PreparedStatement usageStmt = conn.prepareStatement(insertUsageQuery, Statement.RETURN_GENERATED_KEYS);
            usageStmt.setInt(1, Integer.parseInt(customer_id));
            usageStmt.setInt(2, unitsConsumed);
            usageStmt.executeUpdate();

            // Retrieve the generated usage_id
            ResultSet generatedKeys = usageStmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int usage_id = generatedKeys.getInt(1);

                // Insert into Bill table
                String insertBillQuery = "INSERT INTO Bill (customer_id, billing_date, usage_id, total_amount, previous_amount) VALUES (?, CURDATE(), ?, ?, ?)";
                PreparedStatement billStmt = conn.prepareStatement(insertBillQuery);
                billStmt.setInt(1, Integer.parseInt(customer_id));
                billStmt.setInt(2, usage_id);
                billStmt.setDouble(3, amountToPay);
                billStmt.setDouble(4, previousAmount);
                
                billStmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Usage and bill data submitted successfully for Customer ID: " + customer_id, "Success", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while submitting data. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
