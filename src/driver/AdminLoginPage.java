package driver;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginPage extends JFrame {

	public AdminLoginPage() {
		setTitle("Admin Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setLocationRelativeTo(null);

		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameField = new JTextField(20);

		JLabel passwordLabel = new JLabel("Password:");
		JPasswordField passwordField = new JPasswordField(20);

		formPanel.add(usernameLabel);
		formPanel.add(usernameField);
		formPanel.add(passwordLabel);
		formPanel.add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());

				// Add your admin login validation logic here

				if (username.equals("Admin") && password.equals("Admin123")) {
					dispose();
					JOptionPane.showMessageDialog(null, "Login successful!");
					// Add your admin page or functionality here
					new AdminDashboard();
				} else {
					JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
				}

				// Clear the fields
				usernameField.setText("");
				passwordField.setText("");
			}
		});

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		buttonPanel.add(loginButton);

		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(mainPanel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				AdminLoginPage adminLoginPage = new AdminLoginPage();
				adminLoginPage.setVisible(true);
			}
		});
	}
}
