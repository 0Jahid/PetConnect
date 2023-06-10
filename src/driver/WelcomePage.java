package driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {

    public WelcomePage() {
        setTitle("Welcome to Pet Connect");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Pet Connect");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        JButton adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Arial", Font.BOLD, 16));
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminLoginPage adminLoginPage = new AdminLoginPage();
                adminLoginPage.setVisible(true);
            }
        });

        JButton userButton = new JButton("User");
        userButton.setFont(new Font("Arial", Font.BOLD, 16));
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your user button functionality here
                JOptionPane.showMessageDialog(WelcomePage.this, "User button clicked!");
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        buttonPanel.add(adminButton);
        buttonPanel.add(userButton);

        mainPanel.add(welcomeLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WelcomePage welcomePage = new WelcomePage();
                welcomePage.setVisible(true);
            }
        });
    }
}
