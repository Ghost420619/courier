package Packages;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Feedback extends DeliveryExecutive {

    private Registration registration;
    private Information information;
    private Payment payment;

    // Constructor
    public Feedback(Registration registration, Information information, Payment payment) {
        this.registration = registration;
        this.information = information;
        this.payment = payment;
    }

    public void FB() {
        // Frame for feedback
        JFrame frame = new JFrame("Customer Feedback");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));
        frame.getContentPane().setBackground(Color.BLACK);

        // Label
        JLabel label = new JLabel("Please give feedback about our Courier Management System:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.GREEN);
        label.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14)); // java.awt.Font

        // Dropdown
        String[] feedbackOptions = {"Excellent", "Very Good", "Good", "Not Bad", "Bad", "Disappointed"};
        JComboBox<String> feedbackBox = new JComboBox<>(feedbackOptions);
        feedbackBox.setBackground(Color.BLACK);
        feedbackBox.setForeground(Color.GREEN);
        feedbackBox.setFont(new java.awt.Font("Courier", java.awt.Font.PLAIN, 14)); // java.awt.Font

        // Submit button
        JButton submitButton = new JButton("Submit Feedback");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.GREEN);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new java.awt.Font("Courier", java.awt.Font.BOLD, 14)); // java.awt.Font

        submitButton.addActionListener(e -> {
            String feedbackText = (String) feedbackBox.getSelectedItem();
            generatePOSPDF(feedbackText);
            JOptionPane.showMessageDialog(frame,
                    "✅ Thank you for your feedback: " + feedbackText,
                    "Feedback Submitted",
                    JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
        });

        // Add components
        frame.add(label);
        frame.add(feedbackBox);
        frame.add(submitButton);
        frame.setVisible(true);
    }

    private void generatePOSPDF(String feedbackText) {
        try {
            // Timestamp for footer and filename
            LocalDateTime now = LocalDateTime.now();
            String formattedTimestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String fileTimestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

            String fileName = "OrderHistory_" + fileTimestamp + ".pdf";

            // PDF setup
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // iText PDF fonts (fully qualified)
            com.itextpdf.text.Font headerFont = new com.itextpdf.text.Font(
                    com.itextpdf.text.Font.FontFamily.COURIER, 14, com.itextpdf.text.Font.BOLD
            );
            com.itextpdf.text.Font normalFont = new com.itextpdf.text.Font(
                    com.itextpdf.text.Font.FontFamily.COURIER, 10, com.itextpdf.text.Font.NORMAL
            );

            // Header
            Paragraph header = new Paragraph("GHOST THE HOST COURIER MANAGEMENT SYSTEM\n", headerFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);
            document.add(new Paragraph("===========================================\n", normalFont));

            // Customer Info
            if (registration != null) {
                document.add(new Paragraph("Customer   : " + registration.getName(), normalFont));
                document.add(new Paragraph("Contact    : " + registration.getContactNo(), normalFont));
                document.add(new Paragraph("Email      : " + registration.getEmail(), normalFont));
                document.add(new Paragraph("Address    : " + registration.getAddress(), normalFont));
            } else {
                document.add(new Paragraph("Customer Info: [Unavailable]", normalFont));
            }

            document.add(new Paragraph("-------------------------------------------\n", normalFont));

            // Order Info
            if (information != null) {
                document.add(new Paragraph("Destination: " + information.a, normalFont));
                document.add(new Paragraph("Weight     : " + information.b + " KG", normalFont));
                document.add(new Paragraph("Bill       : " + information.T + " TK", normalFont));
            } else {
                document.add(new Paragraph("Courier Info: [Unavailable]", normalFont));
            }

            // Payment Info
            if (payment != null) {
                document.add(new Paragraph("Payment    : " + payment.getPaymentMethod(), normalFont));
            } else {
                document.add(new Paragraph("Payment    : [Unavailable]", normalFont));
            }

            document.add(new Paragraph("-------------------------------------------\n", normalFont));

            // Feedback Info
            document.add(new Paragraph("Feedback   : " + feedbackText, normalFont));
            document.add(new Paragraph("Timestamp  : " + formattedTimestamp + "\n", normalFont));

            document.add(new Paragraph("===========================================\n", normalFont));

            // Footer
            Paragraph footer = new Paragraph("THANK YOU FOR CHOOSING GHOST THE HOST ", headerFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.add(footer);

            document.close();

            // Auto-open PDF
            File pdfFile = new File(fileName);
            if (pdfFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(pdfFile);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error generating PDF:\n" + e.getMessage(),
                    "PDF Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
