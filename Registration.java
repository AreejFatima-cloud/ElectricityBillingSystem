package ElectricityBillingSystem;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Registeration extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField nameField2;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField CityField;
    private JTextField StateField;
    private JTextField Zip_CodeField;
    private JTextField meterNumberField;
    private JComboBox comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Registeration frame = new Registeration();
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
    public Registeration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Pictures\\register.PNG"));
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1322, 760);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(11, 5, 44));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel contentPane_1 = new JPanel();
        contentPane_1.setBounds(73, 81, 1125, 543);
        contentPane_1.setBorder(new LineBorder(Color.GRAY, 3, true));
        contentPane_1.setBackground(Color.WHITE);
        contentPane.add(contentPane_1);
        contentPane_1.setLayout(null);

        JLabel lblName = new JLabel("First Name:");
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblName.setBounds(193, 23, 150, 25);
        contentPane_1.add(lblName);

        nameField = new JTextField();
        nameField.setBounds(353, 24, 200, 25);
        contentPane_1.add(nameField);
        nameField.setColumns(10);

        JLabel lblName1 = new JLabel("Last Name:");
        lblName1.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblName1.setBounds(193, 59, 150, 25);
        contentPane_1.add(lblName1);

        nameField2 = new JTextField();
        nameField2.setBounds(353, 60, 200, 25);
        contentPane_1.add(nameField2);
        nameField2.setColumns(10);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblUsername.setBounds(193, 95, 150, 25);
        contentPane_1.add(lblUsername);

        usernameField = new JTextField();
        usernameField.setBounds(353, 98, 200, 25);
        contentPane_1.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblEmail = new JLabel("Email Address:");
        lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblEmail.setBounds(193, 131, 150, 25);
        contentPane_1.add(lblEmail);

        emailField = new JTextField();
        emailField.setBounds(353, 134, 200, 25);
        contentPane_1.add(emailField);
        emailField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPassword.setBounds(193, 167, 150, 25);
        contentPane_1.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(353, 170, 200, 25);
        contentPane_1.add(passwordField);

        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        lblConfirmPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblConfirmPassword.setBounds(193, 203, 150, 25);
        contentPane_1.add(lblConfirmPassword);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(353, 206, 200, 25);
        contentPane_1.add(confirmPasswordField);

        JLabel lblPhone = new JLabel("Phone Number:");
        lblPhone.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPhone.setBounds(193, 239, 150, 25);
        contentPane_1.add(lblPhone);

        phoneField = new JTextField();
        phoneField.setBounds(353, 242, 200, 25);
        contentPane_1.add(phoneField);
        phoneField.setColumns(10);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblAddress.setBounds(193, 277, 150, 25);
        contentPane_1.add(lblAddress);

        addressField = new JTextField();
        addressField.setBounds(353, 278, 200, 25);
        contentPane_1.add(addressField);
        addressField.setColumns(10);

        JLabel lblCity = new JLabel("City:");
        lblCity.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblCity.setBounds(193, 313, 150, 25);
        contentPane_1.add(lblCity);

        CityField = new JTextField();
        CityField.setBounds(353, 314, 200, 25);
        contentPane_1.add(CityField);
        CityField.setColumns(10);

        JLabel lblState = new JLabel("State:");
        lblState.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblState.setBounds(193, 349, 150, 25);
        contentPane_1.add(lblState);

        StateField = new JTextField();
        StateField.setBounds(353, 350, 200, 25);
        contentPane_1.add(StateField);
        StateField.setColumns(10);

        JLabel lblZipCode = new JLabel("Zip Code:");
        lblZipCode.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblZipCode.setBounds(193, 385, 150, 25);
        contentPane_1.add(lblZipCode);

        Zip_CodeField = new JTextField();
        Zip_CodeField.setBounds(353, 386, 200, 25);
        contentPane_1.add(Zip_CodeField);
        Zip_CodeField.setColumns(10);

        JLabel lblMeterNumber = new JLabel("Meter Number:");
        lblMeterNumber.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblMeterNumber.setBounds(193, 457, 150, 25);
        contentPane_1.add(lblMeterNumber);

        meterNumberField = new JTextField();
        meterNumberField.setBounds(353, 458, 200, 25);
        contentPane_1.add(meterNumberField);
        meterNumberField.setColumns(10);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = nameField.getText();
                String lastName = nameField2.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String phone = phoneField.getText();
                String address = addressField.getText();
                String city = CityField.getText();
                String state = StateField.getText();
                String zipCode = Zip_CodeField.getText();
                String meterNumber = meterNumberField.getText();
                String paymentMethod = (String) comboBox.getSelectedItem();

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Password does not match");
                    confirmPasswordField.setText("");
                } else if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phone.isEmpty() || address.isEmpty() || city.isEmpty() || state.isEmpty() || zipCode.isEmpty() || meterNumber.isEmpty() || paymentMethod.isEmpty() ) {
                    JOptionPane.showMessageDialog(null, "All fields are required");
                } else {
                    // Database connection
                    Connection conn = null;
                    PreparedStatement pstmt = null;

                    try {
                        // Connect to the database
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE");

                        
                        String sql = "INSERT INTO Customers (first_name, last_name, Username, email, password, confirmpassword, phone_number, address, city, state, zip_code, Meter_Number, payment_method) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, firstName);
                        pstmt.setString(2, lastName);
                        pstmt.setString(3, username);
                        pstmt.setString(4, email);
                        pstmt.setString(5, password);
                        pstmt.setString(6, confirmPassword);
                        pstmt.setString(7, phone);
                        pstmt.setString(8, address);
                        pstmt.setString(9, city);
                        pstmt.setString(10, state);
                        pstmt.setString(11, zipCode);
                        pstmt.setString(12, meterNumber);
                        pstmt.setString(13, paymentMethod); 

                        // Execute the insert statement
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Form submitted successfully");
                        dispose();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        // Close the resources
                        try {
                            if (pstmt != null) pstmt.close();
                            if (conn != null) conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnSubmit.setBounds(453, 505, 100, 27);
        contentPane_1.add(btnSubmit);

        JLabel lblNewLabel = new JLabel("Customer Registration Form");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblNewLabel.setBounds(475, 11, 388, 50);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Pictures\\registeration.jpg"));
        lblNewLabel_1.setBounds(721, 0, 416, 538);
        contentPane_1.add(lblNewLabel_1);
        
        JLabel lblPaymentMethod = new JLabel("Payment Method");
        lblPaymentMethod.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPaymentMethod.setBounds(193, 422, 150, 25);
        contentPane_1.add(lblPaymentMethod);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Cash", "Easy Paisa", "Jazz Cash", "Visa Card", "Bank Transfer"}));
        comboBox.setBounds(353, 422, 200, 25);
        contentPane_1.add(comboBox);
    }
}
