package driver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame {

	private JButton addPetsButton;
	private JButton deletePetButton;
	private JButton updatePetButton;
	private JButton logoutButton;

	private JComboBox<String> petTypeComboBox;
	private JTextField nameTextField;
	private JTextField breedTextField;
	private JTextField ageTextField;
	private JTextField priceTextField;
	private JTextField speciesTextField;
	private JTextField additionalTextField;

	public AdminDashboard() {
		initComponents();
		setupLayout();
	}

	private void initComponents() {
		addPetsButton = new JButton("Add pets");
		deletePetButton = new JButton("Delete pet");
		updatePetButton = new JButton("Update pet");
		logoutButton = new JButton("Logout");

		String[] petTypes = { "Dog", "Cat", "Bird", "Fish" };
		petTypeComboBox = new JComboBox<>(petTypes);
		petTypeComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedPetType = (String) petTypeComboBox.getSelectedItem();
				updateInputFields(selectedPetType);
			}
		});

		nameTextField = new JTextField();
		breedTextField = new JTextField();
		ageTextField = new JTextField();
		priceTextField = new JTextField();
		speciesTextField = new JTextField();
		additionalTextField = new JTextField();
	}

	private void setupLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Admin Dashboard");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(new JLabel("Select Pet Type:"));
		panel.add(petTypeComboBox);
		panel.add(new JLabel("Name:"));
		panel.add(nameTextField);
		panel.add(new JLabel("Breed:"));
		panel.add(breedTextField);
		panel.add(new JLabel("Age:"));
		panel.add(ageTextField);
		panel.add(new JLabel("Price:"));
		panel.add(priceTextField);
		panel.add(new JLabel("Species:"));
		panel.add(speciesTextField);
		panel.add(new JLabel("Additional Field:"));
		panel.add(additionalTextField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(addPetsButton);
		buttonPanel.add(deletePetButton);
		buttonPanel.add(updatePetButton);
		buttonPanel.add(logoutButton);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		container.add(panel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	private void updateInputFields(String selectedPetType) {
		// Clear all input fields
		nameTextField.setText("");
		breedTextField.setText("");
		ageTextField.setText("");
		priceTextField.setText("");
		speciesTextField.setText("");
		additionalTextField.setText("");

		// Show/hide additional input fields based on pet type
		if (selectedPetType.equals("Dog") || selectedPetType.equals("Cat")) {
			additionalTextField.setVisible(true);
			additionalTextField.setToolTipText("Enter color");
		} else if (selectedPetType.equals("Bird")) {
			additionalTextField.setVisible(true);
			additionalTextField.setToolTipText("Enter can fly (true/false)");
		} else if (selectedPetType.equals("Fish")) {
			additionalTextField.setVisible(true);
			additionalTextField.setToolTipText("Enter water type");
		} else {
			additionalTextField.setVisible(false);
		}
	}

}
