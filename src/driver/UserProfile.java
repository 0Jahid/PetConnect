package driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfile extends JFrame {

    public UserProfile() {
        setTitle("User Profile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Welcome, User!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JButton viewPetsButton = new JButton("View Available Pets");
        viewPetsButton.setFont(new Font("Arial", Font.BOLD, 16));
        viewPetsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PetListingPage petListingPage = new PetListingPage();
                petListingPage.setVisible(true);
            }
        });

        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setFont(new Font("Arial", Font.BOLD, 16));
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to add selected pet to cart
                JOptionPane.showMessageDialog(UserProfile.this, "Pet added to cart!");
            }
        });

        JButton checkoutButton = new JButton("Proceed to Checkout");
        checkoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to proceed to checkout
                JOptionPane.showMessageDialog(UserProfile.this, "Proceeding to checkout!");
            }
        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add logic to handle logout
                JOptionPane.showMessageDialog(UserProfile.this, "Logged out successfully!");
                dispose();
                UserPage userPage = new UserPage();
                userPage.setVisible(true);
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(viewPetsButton);
        buttonPanel.add(addToCartButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(logoutButton);

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserProfile userProfile = new UserProfile();
                userProfile.setVisible(true);
            }
        });
    }
}

class PetListingPage extends JFrame {

    public PetListingPage() {
        setTitle("Available Pets");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Available Pets");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Add code to display available pets

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserProfile userProfile = new UserProfile();
                userProfile.setVisible(true);
            }
        });

        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(backButton, BorderLayout.SOUTH);

        add(mainPanel);
    }
}
