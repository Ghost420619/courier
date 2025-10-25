package Packages;

import javax.swing.*;

public class DeliveryExecutive {

    int R;

    public void FB(Registration registration, Information information, Payment payment) {
        // Step 1: Show product delivery message
        JOptionPane.showMessageDialog(
                null,
                "Dear Customer, your product has reached its destination.\n" +
                        "Let us know if there is any damage to your product.",
                "Delivery Feedback",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Step 2: Ask about product damage with options
        String[] options = {"Yes", "No"};
        R = JOptionPane.showOptionDialog(
                null,
                "Has there been any damage to your product?",
                "Product Condition",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        // Step 3: Handle user response
        if (R == 0) { // Yes
            JOptionPane.showMessageDialog(
                    null,
                    "We are really sorry to hear about that. We will fix our problem ASAP!",
                    "Apology",
                    JOptionPane.WARNING_MESSAGE
            );
        } else if (R == 1) { // No
            JOptionPane.showMessageDialog(
                    null,
                    "Thanks for your feedback!",
                    "Thank You",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        // Step 4: Continue to detailed feedback (calls your Feedback class)
        Feedback fb = new Feedback(registration, information, payment);
        fb.FB();
    }
}
