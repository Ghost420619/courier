package Packages;

import javax.swing.*;

import java.awt.*;

public class Information extends BillReport {
    String a;
    int b;
    int T;

    @Override
    public void sendInfo() {
        // Frame setup
        JFrame frame = new JFrame("Courier Information");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1, 10, 10));
        frame.getContentPane().setBackground(Color.BLACK);

        // Destination input
        JLabel labelDest = new JLabel("Enter Destination Address:");
        labelDest.setForeground(Color.GREEN);
        labelDest.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14));

        JTextField destField = new JTextField();
        destField.setBackground(Color.BLACK);
        destField.setForeground(Color.GREEN);
        destField.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 14));

        // Weight input
        JLabel labelWeight = new JLabel("Enter Product Weight (KG):");
        labelWeight.setForeground(Color.GREEN);
        labelWeight.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14));

        JSpinner weightSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 500, 1));
        JComponent spinnerEditor = weightSpinner.getEditor();
        if (spinnerEditor instanceof JSpinner.DefaultEditor) {
            JTextField spinnerText = ((JSpinner.DefaultEditor) spinnerEditor).getTextField();
            spinnerText.setBackground(Color.BLACK);
            spinnerText.setForeground(Color.GREEN);
            spinnerText.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 14));
        }

        // Submit button
        JButton submitButton = new JButton("Submit Information");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.GREEN);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14));

        // Action on button click
        submitButton.addActionListener(e -> {
            a = destField.getText().trim();
            b = (int) weightSpinner.getValue();

            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "❌ Please enter a valid destination!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            calculateTotal();

            JOptionPane.showMessageDialog(frame,
                    "✅ Information Submitted!\n\n" +
                            "Destination: " + a + "\n" +
                            "Weight: " + b + " KG\n" +
                            "Total Bill: " + T + " TK only (BDT) with delivery charge",
                    "Confirmation",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
        });

        // Add components
        frame.add(labelDest);
        frame.add(destField);
        frame.add(labelWeight);
        frame.add(weightSpinner);
        frame.add(submitButton);

        frame.setVisible(true);
    }

    void calculateTotal() {
        T = (b * 100) + 1000; // delivery + weight charge
    }

    int T() {
        return T;
    }
}
