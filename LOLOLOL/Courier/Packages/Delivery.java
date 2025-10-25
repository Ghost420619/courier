package Packages;

import javax.swing.*;
import java.awt.*;

public class Delivery extends DetailsCourier {

    public void details2() {
        // Create a simple GUI window
        JFrame frame = new JFrame("Delivery Information");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
        frame.getContentPane().setBackground(Color.BLACK);

        // Message label
        JLabel label = new JLabel("Your Product will reach the destination in standard delivery time 3 to 7 days.");
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.GREEN);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Add label to frame
        frame.add(label);

        // Make frame visible
        frame.setVisible(true);
    }
}
