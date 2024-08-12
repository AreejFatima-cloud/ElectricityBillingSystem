package ElectricityBillingSystem;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Customer_DashBoard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_DashBoard frame = new Customer_DashBoard("");
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
	public Customer_DashBoard(String username) {
		setTitle("Customer DashBoard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome, "+username);
		lblWelcome.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(161, 75, 307, 62);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Arab Line\\Downloads\\image.png"));
		lblNewLabel.setBounds(0, 33, 586, 330);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 17, 34));
		menuBar.setBounds(0, 0, 597, 32);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Profile");
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProfile profile = new ViewProfile(username);
				profile.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Bill");
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("View Current Bill");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCurrentBill currentbill = new ViewCurrentBill(username);
				currentbill.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Usage");
		mnNewMenu_2.setForeground(Color.WHITE);
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Usage Entry");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsageEntryForm entry = new UsageEntryForm();
				entry.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Usage History");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsageHistory history = new UsageHistory();
				history.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Logout");
		mnNewMenu_3.setForeground(Color.WHITE);
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Exit");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
        		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
		            System.exit(0);
		        }
        	}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
	}
}
