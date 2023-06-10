package driver;

import javax.swing.*;

import File.filepath;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UserPage extends JFrame {

	public UserPage() {
		setTitle("User Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel titleLabel = new JLabel("User Page");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Arial", Font.BOLD, 16));
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterPage registerPage = new RegisterPage();
				registerPage.setVisible(true);
			}
		});

		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Arial", Font.BOLD, 16));
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
			}
		});

		JButton welcomeButton = new JButton("Go to Welcome Page");
		welcomeButton.setFont(new Font("Arial", Font.BOLD, 16));
		welcomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				WelcomePage welcomePage = new WelcomePage();
				welcomePage.setVisible(true);
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
		buttonPanel.add(registerButton);
		buttonPanel.add(loginButton);
		buttonPanel.add(welcomeButton);

		mainPanel.add(titleLabel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);

		add(mainPanel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				UserPage userPage = new UserPage();
				userPage.setVisible(true);
			}
		});
	}
}

class RegisterPage extends JFrame {

	public RegisterPage() {
		setTitle("Register Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel titleLabel = new JLabel("Register");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField();

		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField();

		JLabel passwordLabel = new JLabel("Password:");
		JPasswordField passwordField = new JPasswordField();

		formPanel.add(nameLabel);
		formPanel.add(nameField);
		formPanel.add(emailLabel);
		formPanel.add(emailField);
		formPanel.add(passwordLabel);
		formPanel.add(passwordField);

		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = nameField.getText();
				String email = emailField.getText();
				String password = new String(passwordField.getPassword());

				try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath.FILE_PATH, true))) {
					writer.write(username + "," + password);
					writer.newLine();
				} catch (IOException e1) {
					System.out.println("Error occurred during registration.");
				}

				JOptionPane.showMessageDialog(RegisterPage.this, "Registration successful!");
			}
		});

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
			}
		});

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		buttonPanel.add(registerButton);
		buttonPanel.add(loginButton);

		mainPanel.add(titleLabel, BorderLayout.NORTH);
		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(mainPanel);
	}
}

class LoginPage extends JFrame {

	public LoginPage() {
		setTitle("Login Page");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		JLabel titleLabel = new JLabel("Login");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));

		JLabel usernameLabel = new JLabel("Username:");
		JTextField usernameField = new JTextField();

		JLabel passwordLabel = new JLabel("Password:");
		JPasswordField passwordField = new JPasswordField();

		formPanel.add(usernameLabel);
		formPanel.add(usernameField);
		formPanel.add(passwordLabel);
		formPanel.add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());

				try (BufferedReader reader = new BufferedReader(new FileReader(filepath.FILE_PATH))) {
					String line;
					boolean isLoggedIn = false;

					while ((line = reader.readLine()) != null) {
						String[] parts = line.split(",");

						if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
							isLoggedIn = true;
							break;
						}
					}
				} catch (IOException e2) {
				}
//				SwingUtilities.invokeLater(new Runnable() {
//		            @Override
//		            public void run() {
//		                UserProfile userProfile = new UserProfile();
//		                userProfile.setVisible(true);
//		            }
//		        });

				JOptionPane.showMessageDialog(LoginPage.this, "Login successful!");
				UserProfile userProfile = new UserProfile();
				userProfile.setVisible(true);
			}
		});

		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterPage registerPage = new RegisterPage();
				registerPage.setVisible(true);
			}
		});

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		buttonPanel.add(registerButton);
		buttonPanel.add(loginButton);

		mainPanel.add(titleLabel, BorderLayout.NORTH);
		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(mainPanel);
	}
}
