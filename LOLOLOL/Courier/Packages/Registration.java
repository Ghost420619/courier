package Packages;

import javax.swing.*;
import java.awt.*;

public class Registration {

    // Encapsulated fields
    private String name;
    private String address;
    private String contactNo;
    private String email;
    private String location;
    private String gender;
    private String password;

    // Getters and setters
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getContactNo() { return contactNo; }
    public String getEmail() { return email; }
    public String getLocation() { return location; }
    public String getGender() { return gender; }
    public String getPassword() { return password; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }
    public void setEmail(String email) { this.email = email; }
    public void setLocation(String location) { this.location = location; }
    public void setGender(String gender) { this.gender = gender; }
    public void setPassword(String password) { this.password = password; }

    // GUI Sign-Up
    public void SignUp() {
        JFrame frame = new JFrame("Customer Registration");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(9, 2, 10, 10));
        frame.getContentPane().setBackground(Color.BLACK);

        Font labelFont = new java.awt.Font("Courier", java.awt.Font.BOLD, 14);
        Font fieldFont = new java.awt.Font("Courier", java.awt.Font.PLAIN, 14);

        // Labels and fields
        JTextField nameField = new JTextField();
        JTextField genderField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField emailField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmField = new JPasswordField();

        JTextField[] textFields = {nameField, genderField, addressField, contactField, emailField, passwordField, confirmField};
        for (JTextField tf : textFields) {
            tf.setBackground(Color.BLACK);
            tf.setForeground(Color.GREEN);
            tf.setFont(fieldFont);
        }

        // Submit button
        JButton submitButton = new JButton("Sign Up");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.GREEN);
        submitButton.setFont(labelFont);
        submitButton.setFocusPainted(false);

        // Labels
        JLabel[] labels = {
                new JLabel("Name:"), new JLabel("Gender:"), new JLabel("Address:"),
                new JLabel("Contact No:"), new JLabel("Email:"), new JLabel("Password:"),
                new JLabel("Confirm Password:")
        };
        for (JLabel lbl : labels) {
            lbl.setForeground(Color.GREEN);
            lbl.setFont(labelFont);
        }

        // Add components
        frame.add(labels[0]); frame.add(nameField);
        frame.add(labels[1]); frame.add(genderField);
        frame.add(labels[2]); frame.add(addressField);
        frame.add(labels[3]); frame.add(contactField);
        frame.add(labels[4]); frame.add(emailField);
        frame.add(labels[5]); frame.add(passwordField);
        frame.add(labels[6]); frame.add(confirmField);
        frame.add(new JLabel()); frame.add(submitButton);

        // Button action
        submitButton.addActionListener(e -> {
            String tempPass = new String(passwordField.getPassword());
            String retype = new String(confirmField.getPassword());

            if (tempPass.length() < 8) {
                JOptionPane.showMessageDialog(frame, "❌ Password must be at least 8 characters long.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!tempPass.equals(retype)) {
                JOptionPane.showMessageDialog(frame, "❌ Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            setName(nameField.getText().trim());
            setGender(genderField.getText().trim());
            setAddress(addressField.getText().trim());
            setContactNo(contactField.getText().trim());
            setEmail(emailField.getText().trim());
            setPassword(tempPass);

            JOptionPane.showMessageDialog(frame,
                    "🎉 Congratulations! Your registration is successfully completed.",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        });

        frame.setVisible(true);
    }

    // Show customer details
    public void showCusDetails() {
        JTextArea details = new JTextArea(
                "Customer's Name    : " + getName() + "\n" +
                "Customer's Gender  : " + getGender() + "\n" +
                "Customer's Number  : " + getContactNo() + "\n" +
                "Customer's Email   : " + getEmail() + "\n" +
                "Customer's Address : " + getAddress()
        );
        details.setEditable(false);
        details.setBackground(Color.BLACK);
        details.setForeground(Color.GREEN);
        details.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 14));

        JOptionPane.showMessageDialog(null, details, "Customer Details", JOptionPane.INFORMATION_MESSAGE);
    }
}
