package Packages;

import javax.swing.*;

import java.awt.*;

public class DetailsCourier extends Registration {
    String courierAddress;

    public void details1() {
        // Frame setup
        JFrame frame = new JFrame("Courier Details");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());

        // Panel to arrange components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 5, 5));
        panel.setBackground(Color.BLACK);

        // Product selection
        JLabel labelProduct = new JLabel("Select the type of product you want to courier:");
        labelProduct.setForeground(Color.GREEN);
        labelProduct.setFont(new Font("Courier", Font.BOLD, 14));
        labelProduct.setHorizontalAlignment(SwingConstants.CENTER);

        String[] products = {"Weed", "Cocaine", "Meth", "Gaza", "Heroin", "Acid (LSD)", "Others"};
        JComboBox<String> productBox = new JComboBox<>(products);
        productBox.setBackground(Color.BLACK);
        productBox.setForeground(Color.GREEN);
        productBox.setFont(new Font("Courier", Font.PLAIN, 14));

        // Address input
        JLabel labelAddress = new JLabel("Enter Courier Address:");
        labelAddress.setForeground(Color.GREEN);
        labelAddress.setFont(new Font("Courier", Font.BOLD, 14));
        labelAddress.setHorizontalAlignment(SwingConstants.CENTER);

        JTextField addressField = new JTextField();
        addressField.setBackground(Color.BLACK);
        addressField.setForeground(Color.GREEN);
        addressField.setCaretColor(Color.GREEN);
        addressField.setFont(new Font("Courier", Font.PLAIN, 14));

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.GREEN);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Courier", Font.BOLD, 14));

        submitButton.addActionListener(e -> {
            String productType = (String) productBox.getSelectedItem();
            courierAddress = addressField.getText().trim();

            if (courierAddress.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a courier address!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(
                        frame,
                        "You have selected: " + productType + "\nAddress: " + courierAddress,
                        "Confirmation",
                        JOptionPane.INFORMATION_MESSAGE
                );
                frame.dispose(); // close window after confirmation
            }
        });

        // Add components to panel
        panel.add(labelProduct);
        panel.add(productBox);
        panel.add(labelAddress);
        panel.add(addressField);
        panel.add(submitButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
