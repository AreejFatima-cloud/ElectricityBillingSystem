package ElectricityBillingSystem;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCurrentBill extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblCustomerId, lblCustomerName, lblAddress, lblDueDate, lblPreviousCharges, lblCurrentCharges, lblTotalCharges;
    private String username;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewCurrentBill frame = new ViewCurrentBill("username"); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ViewCurrentBill(String username) {
    	this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1172, 737);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Bill Information");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        lblNewLabel.setBounds(394, 0, 233, 63);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Downloads\\pay.png"));
        lblNewLabel_1.setBounds(768, -31, 399, 564);
        contentPane.add(lblNewLabel_1);

        lblCustomerId = new JLabel("Customer ID:");
        lblCustomerId.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCustomerId.setBounds(52, 65, 113, 31);
        contentPane.add(lblCustomerId);
        
        textField = new JTextField();
        textField.setBounds(204, 65, 240, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        lblCustomerName = new JLabel("Customer Name:");
        lblCustomerName.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblCustomerName.setBounds(52, 96, 113, 31);
        contentPane.add(lblCustomerName);

        textField_1 = new JTextField();
        textField_1.setBounds(204, 95, 240, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblAddress.setBounds(52, 127, 113, 31);
        contentPane.add(lblAddress);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(204, 126, 243, 20);
        contentPane.add(textField_2);
        
        JLabel lblMeterInformation = new JLabel("Meter Information:");
        lblMeterInformation.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblMeterInformation.setBounds(37, 180, 159, 31);
        contentPane.add(lblMeterInformation);

        table = new JTable();
        table.setBackground(Color.WHITE);
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                },
                new String[]{
                        "Meter No", "Date", "Usage(kWh)", "Cost(per kWh)", "Amount $"
                }
        ));
        table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(83, 222, 648, 50); 

        contentPane.add(scrollPane); 

        JLabel lblBillSummary = new JLabel("Bill Summary:");
        lblBillSummary.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblBillSummary.setBounds(142, 283, 159, 31);
        contentPane.add(lblBillSummary);

        JPanel contentPane_1 = new JPanel();
        contentPane_1.setLayout(null);
        contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_1.setBackground(new Color(147, 222, 244));
        contentPane_1.setBounds(152, 319, 460, 197);
        contentPane.add(contentPane_1);

        lblPreviousCharges = new JLabel("Previous Charges($):");
        lblPreviousCharges.setBounds(10, 27, 194, 38);
        contentPane_1.add(lblPreviousCharges);
        lblPreviousCharges.setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(223, 25, 176, 29);
        contentPane_1.add(textField_3);

        lblCurrentCharges = new JLabel("Sub Total($):");
        lblCurrentCharges.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblCurrentCharges.setBounds(11, 72, 194, 38);
        contentPane_1.add(lblCurrentCharges);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(224, 68, 176, 29);
        contentPane_1.add(textField_4);

        lblTotalCharges = new JLabel("Total Charges($):");
        lblTotalCharges.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTotalCharges.setBounds(11, 106, 194, 38);
        contentPane_1.add(lblTotalCharges);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(223, 113, 176, 29);
        contentPane_1.add(textField_5);
        
        lblDueDate = new JLabel("Due Date:");
        lblDueDate.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblDueDate.setBounds(13, 143, 194, 38);
        contentPane_1.add(lblDueDate);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(223, 152, 176, 29);
        contentPane_1.add(textField_6);

        JLabel lblReminder = new JLabel("Reminder:");
        lblReminder.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblReminder.setBounds(49, 528, 194, 38);
        contentPane.add(lblReminder);

        JTextArea txtrPresentYourStatement = new JTextArea();
        txtrPresentYourStatement.setText("Present your Statement Of Account when paying utility Bills");
        txtrPresentYourStatement.setBounds(72, 572, 542, 22);
        contentPane.add(txtrPresentYourStatement);

        JTextArea txtrPleaseCheckYour = new JTextArea();
        txtrPleaseCheckYour.setText("Please check your online accounts after the payment to make sure the payment is pushed through");
        txtrPleaseCheckYour.setBounds(72, 595, 798, 50);
        contentPane.add(txtrPleaseCheckYour);

        JButton btnNewButton = new JButton("Generate Bill");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 BillGenerationForm generate = new BillGenerationForm(
        				    textField.getText(), // customer_id
        		            textField_1.getText(), // customer_name
        		            textField_2.getText(), // address
        		            table.getValueAt(0, 0).toString(), // meter_number
        		            table.getValueAt(0, 1).toString(), // date
        		            table.getValueAt(0, 2).toString(), // usage
        		            "$ 1.23", // cost per unit 
        		            textField_5.getText() // total_amount
        		        );
        		        generate.setVisible(true);
        	}
        });
        btnNewButton.setBackground(new Color(244, 166, 242));
        btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnNewButton.setBounds(996, 542, 159, 50);
        contentPane.add(btnNewButton);
        
        // Fetch and display the data
        fetchBillData(username);
    }
     
    private void fetchBillData(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE");

            
            String sql = "SELECT c.customer_id, c.first_name, c.address, b.billing_date, b.total_amount, b.previous_amount, c.Meter_Number, u.usage_date, u.units_consumed "
                        + "FROM Customers c "
                        + "JOIN Bill b ON c.customer_id = b.customer_id "
                        + "JOIN ElectricityUsage u ON c.customer_id = u.customer_id "
                        + "WHERE c.customer_id = (SELECT customer_id FROM Customers WHERE Username = ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                
                textField.setText(rs.getString("customer_id"));
                textField_1.setText(rs.getString("first_name"));
                textField_2.setText(rs.getString("address"));
                textField_3.setText(rs.getString("previous_amount"));
                textField_4.setText(rs.getString("total_amount"));
                textField_5.setText(rs.getString("total_amount"));
                textField_6.setText(rs.getString("usage_date"));

                // Update JTable with electricity usage data
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Clear the existing rows
                model.addRow(new Object[]{
                        rs.getString("Meter_Number"),
                        rs.getString("billing_date"),
                        rs.getString("units_consumed"),
                        "$ 1.23",  
                        rs.getString("total_amount")
                });
            } else {
                System.out.println("No data found for user: " + username);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}
