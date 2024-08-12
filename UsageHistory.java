package ElectricityBillingSystem;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UsageHistory extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UsageHistory frame = new UsageHistory();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UsageHistory() {
       setTitle("Usage History");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Define column names
        String[] columnNames = {"Username", "Billing Date", "Units Consumed", "Total Amount"};

        // Create a DefaultTableModel and pass column names
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        // Creating a JTable with the model
        table = new JTable(model);
        table.setBounds(30, 40, 500, 300);

        // Add the table to a JScrollPane for scroll functionality
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 40, 540, 300);
        contentPane.add(scrollPane);

        // Fetch data from the Bill table and populate the table
        fetchAndPopulateData(model);
    }

    private void fetchAndPopulateData(DefaultTableModel model) {
        Connection conn = null;
        try {
            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE");
            
            // Query to fetch data 
            String query = "SELECT c.Username, b.billing_date, e.units_consumed, b.total_amount " +
                           "FROM Bill b " +
                           "JOIN Customers c ON b.customer_id = c.customer_id " +		
                           "JOIN ElectricityUsage e ON b.usage_id = e.usage_id";
            				
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
 
            while (rs.next()) {
                Object[] row = {
                    rs.getString("Username"),    
                    rs.getDate("billing_date"),
                    rs.getBigDecimal("units_consumed"),
                    rs.getBigDecimal("total_amount")
                };
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
