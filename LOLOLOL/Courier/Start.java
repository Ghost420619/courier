import Packages.*;
import javax.swing.*;
import java.awt.*;

public class Start {

    public static void main(String[] args) {
        // Main Frame
        JFrame frame = new JFrame("Ghost-The-Host World Wide Courier Service");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1, 10, 10));
        panel.setBackground(Color.BLACK); // background color

        // Welcome label
        JLabel welcome = new JLabel("<html><center>-----------------------------------------------------------------------------------------<br>WELCOME TO Ghost-The-Host WORLD WIDE COURIER SERVICE<br>-----------------------------------------------------------------------------------------</center></html>");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        welcome.setForeground(Color.GREEN); // text color
        welcome.setFont(new Font("Courier", Font.BOLD, 16));
        welcome.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        // Buttons
        JButton registerBtn = new JButton("1. Register Customer");
        JButton productBtn = new JButton("2. Select Product");
        JButton deliveryBtn = new JButton("3. Delivery Info");
        JButton customerDetailsBtn = new JButton("4. Show Customer Details");
        JButton courierInfoBtn = new JButton("5. Enter Courier Info");
        JButton paymentBtn = new JButton("6. Payment");
        JButton feedbackBtn = new JButton("7. Feedback");

        JButton[] buttons = {registerBtn, productBtn, deliveryBtn, customerDetailsBtn, courierInfoBtn, paymentBtn, feedbackBtn};

        // Style buttons
        for (JButton btn : buttons) {
            btn.setBackground(Color.BLACK);
            btn.setForeground(Color.GREEN);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Courier", Font.BOLD, 14));
        }

        // Add buttons to panel
        for (JButton btn : buttons) {
            panel.add(btn);
        }

        // Create objects for each class
        Registration r = new Registration();
        DetailsCourier x = new DetailsCourier();
        Delivery d = new Delivery();
        Information c = new Information();
        Payment z = new Payment(c);

        // Button actions
        registerBtn.addActionListener(e -> r.SignUp());
        productBtn.addActionListener(e -> x.details1());
        deliveryBtn.addActionListener(e -> d.details2());
        customerDetailsBtn.addActionListener(e -> r.showCusDetails());
        courierInfoBtn.addActionListener(e -> c.sendInfo());
        paymentBtn.addActionListener(e -> z.PM());
        feedbackBtn.addActionListener(e -> {
            Feedback dp = new Feedback(r, c, z);
            dp.FB();
        });

        // Add components to frame
        frame.add(welcome, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.getContentPane().setBackground(Color.BLACK); // frame background
        frame.setVisible(true);
    }
}
