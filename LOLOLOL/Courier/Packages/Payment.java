package Packages;

import javax.swing.*;

import java.awt.*;

public class Payment {
    private int payment;
    private String paymentMethod;
    private Information info;  // reference to Information

    public Payment(Information info) {
        this.info = info;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public final void PM() {
        // Frame setup
        JFrame frame = new JFrame("Payment");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1, 10, 10));
        frame.getContentPane().setBackground(Color.BLACK);

        // Bill display
        int expectedAmount = info.T();
        JLabel billLabel = new JLabel("💰 Your total bill is: " + expectedAmount + " TK");
        billLabel.setHorizontalAlignment(SwingConstants.CENTER);
        billLabel.setForeground(Color.GREEN);
        billLabel.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14));

        // Payment method label
        JLabel methodLabel = new JLabel("Select Payment Method:");
        methodLabel.setForeground(Color.GREEN);
        methodLabel.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14));

        // Dropdown for payment method
        String[] methods = {"Paypal", "Visa Card", "Credit Card", "Cash"};
        JComboBox<String> methodBox = new JComboBox<>(methods);
        methodBox.setBackground(Color.BLACK);
        methodBox.setForeground(Color.GREEN);
        methodBox.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 14));

        // Payment amount label
        JLabel amountLabel = new JLabel("Enter Payment Amount:");
        amountLabel.setForeground(Color.GREEN);
        amountLabel.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14));

        // Payment amount input
        JTextField amountField = new JTextField();
        amountField.setBackground(Color.BLACK);
        amountField.setForeground(Color.GREEN);
        amountField.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 14));

        // Submit button
        JButton payButton = new JButton("Pay Now");
        payButton.setBackground(Color.BLACK);
        payButton.setForeground(Color.GREEN);
        payButton.setFocusPainted(false);
        payButton.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14));

        // Button action
        payButton.addActionListener(e -> {
            paymentMethod = (String) methodBox.getSelectedItem();

            try {
                payment = Integer.parseInt(amountField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "❌ Invalid input. Payment must be a number.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (payment == expectedAmount) {
                JOptionPane.showMessageDialog(frame,
                        "✅ Payment Completed using " + paymentMethod + "!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame,
                        "❌ Invalid payment amount!\nPlease pay the full amount: " + expectedAmount + " TK",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add components to frame
        frame.add(billLabel);
        frame.add(methodLabel);
        frame.add(methodBox);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(payButton);

        frame.setVisible(true);
    }
}
