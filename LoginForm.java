package ElectricityBillingSystem;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Arab Line\\Downloads\\bill.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username or Email:");
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblUsername.setBounds(104, 105, 130, 25);
		contentPane.add(lblUsername);

		usernameField = new JTextField();
		usernameField.setBounds(244, 106, 237, 25);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPassword.setBounds(104, 158, 89, 25);
		contentPane.add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(244, 158, 237, 25);
		contentPane.add(passwordField);

		JCheckBox rememberMe = new JCheckBox("Remember Me");
		rememberMe.setBackground(Color.WHITE);
		rememberMe.setFont(new Font("Segoe UI", Font.BOLD, 13));
		rememberMe.setBounds(104, 245, 150, 25);
		contentPane.add(rememberMe);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(SystemColor.inactiveCaption);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLogin.setBounds(230, 289, 100, 36);
		contentPane.add(btnLogin);

		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(SystemColor.inactiveCaption);
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnRegister.setBounds(367, 289, 100, 36);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel = new JLabel("Login Credentials");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(179, 22, 284, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Downloads\\bill.png"));
		lblNewLabel_1.setBounds(0, -71, 528, 445);
		contentPane.add(lblNewLabel_1);

		// Action listener for the login button
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				

		        // SQL query to check if the card number and PIN exist
		        String query = "SELECT * FROM Customers WHERE Username = ? AND password = ?";

		        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem", "root", "Ak,3f.p8@&!wE")) {
		            PreparedStatement pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, username);
		            pstmt.setString(2, password);

		            ResultSet rs = pstmt.executeQuery();

		            if (rs.next()) {
		            	
		            	// Open the Customer Dashboard
		                Customer_DashBoard dashboard = new Customer_DashBoard(username);
		                dashboard.setVisible(true);
		                dispose();
		            } else {
		                JOptionPane.showMessageDialog(null, "Invalid username or Password.");
		                usernameField.setText("");
		                passwordField.setText("");
		            }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
			}
		});

		// Action listener for the register button
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registeration register = new Registeration();
				register.setVisible(true);
			}
		});
	}
}
