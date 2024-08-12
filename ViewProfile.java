package ElectricityBillingSystem;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewProfile extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField usernameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField meterNumberField;

    private String username;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewProfile frame = new ViewProfile("username"); 
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
    public ViewProfile(String username) {
    	this.username = username;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel lblName = new JLabel("Full Name:");
        lblName.setBounds(50, 30, 150, 25);
        contentPane.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(200, 30, 200, 25);
        contentPane.add(nameField);
        nameField.setColumns(10);
        nameField.setEditable(false);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(50, 70, 150, 25);
        contentPane.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(200, 70, 200, 25);
        contentPane.add(usernameField);
        usernameField.setColumns(10);
        usernameField.setEditable(false);

        JLabel lblEmail = new JLabel("Email Address:");
        lblEmail.setBounds(50, 110, 150, 25);
        contentPane.add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(200, 110, 200, 25);
        contentPane.add(emailField);
        emailField.setColumns(10);
        emailField.setEditable(false);

        JLabel lblPhone = new JLabel("Phone Number:");
        lblPhone.setBounds(50, 150, 150, 25);
        contentPane.add(lblPhone);

        phoneField = new JTextField();
        phoneField.setBounds(200, 150, 200, 25);
        contentPane.add(phoneField);
        phoneField.setColumns(10);
        phoneField.setEditable(false);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(50, 190, 150, 25);
        contentPane.add(lblAddress);

        addressField = new JTextField();
        addressField.setBounds(200, 190, 200, 25);
        contentPane.add(addressField);
        addressField.setColumns(10);
        addressField.setEditable(false);

        JLabel lblMeterNumber = new JLabel("Meter Number:");
        lblMeterNumber.setBounds(50, 230, 150, 25);
        contentPane.add(lblMeterNumber);

        meterNumberField = new JTextField();
        meterNumberField.setBounds(200, 230, 200, 25);
        contentPane.add(meterNumberField);
        meterNumberField.setColumns(10);
        meterNumberField.setEditable(false);

        JButton btnEdit = new JButton("Edit Profile");
        btnEdit.setBounds(100, 310, 120, 25);
        contentPane.add(btnEdit);

        JButton btnSave = new JButton("Save Profile");
        btnSave.setBounds(240, 310, 120, 25);
        contentPane.add(btnSave);
        btnSave.setEnabled(false); 

        btnEdit.addActionListener(e -> {
            
            nameField.setEditable(true);
            emailField.setEditable(true);
            phoneField.setEditable(true);
            addressField.setEditable(true);
            meterNumberField.setEditable(true);

            // Enable save button
            btnSave.setEnabled(true);
        });

        btnSave.addActionListener(e -> {
            // Update user profile in database
            String query = "UPDATE Customers SET first_name = ?, last_name = ?, email = ?, phone_number = ?, address = ?, Meter_Number = ? WHERE Username = ?";

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE")) {
                PreparedStatement pstmt = conn.prepareStatement(query);
                String[] names = nameField.getText().split(" ");
                pstmt.setString(1, names[0]); // First name
                pstmt.setString(2, names.length > 1 ? names[1] : ""); // Last name
                pstmt.setString(3, emailField.getText());
                pstmt.setString(4, phoneField.getText());
                pstmt.setString(5, addressField.getText());
                pstmt.setString(6, meterNumberField.getText());
                pstmt.setString(7, username);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "Profile updated successfully.");
                    // Disable editing and save button
                    nameField.setEditable(false);
                    emailField.setEditable(false);
                    phoneField.setEditable(false);
                    addressField.setEditable(false);
                    meterNumberField.setEditable(false);
                    btnSave.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Update failed.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        loadData();
    }

    private void loadData() {
        System.out.println("Loading data for username: " + username); 

        String query = "SELECT * FROM Customers WHERE Username = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE")) {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nameField.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                usernameField.setText(rs.getString("Username"));
                emailField.setText(rs.getString("email"));
                phoneField.setText(rs.getString("phone_number"));
                addressField.setText(rs.getString("address"));
                meterNumberField.setText(rs.getString("Meter_Number"));
            } else {
                JOptionPane.showMessageDialog(null, "User not found");
                dispose();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
