package cv.scheduling;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchedulingClientGUI {
    private JFrame frame;
    private JButton checkAvailabilityButton;
    private JButton scheduleButton;
    private JButton batchScheduleButton;
    private JTextArea outputTextArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SchedulingClientGUI window = new SchedulingClientGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SchedulingClientGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        checkAvailabilityButton = new JButton("Check Availability");
        checkAvailabilityButton.setBounds(10, 11, 133, 30);
        frame.getContentPane().add(checkAvailabilityButton);

        scheduleButton = new JButton("Schedule");
        scheduleButton.setBounds(153, 11, 89, 30);
        frame.getContentPane().add(scheduleButton);

        batchScheduleButton = new JButton("Batch Schedule");
        batchScheduleButton.setBounds(252, 11, 111, 30);
        frame.getContentPane().add(batchScheduleButton);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        outputTextArea.setBounds(10, 45, 414, 205);
        frame.getContentPane().add(outputTextArea);

        // Set up action listeners
        addActionListeners();
    }

    private void addActionListeners() {
        checkAvailabilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the SchedulingClient method to check availability and display the results in the text area
                outputTextArea.append("Check Availability...\n");
            }
        });

        scheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the SchedulingClient method to schedule and display the results in the text area
                outputTextArea.append("Scheduling...\n");
            }
        });

        batchScheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the SchedulingClient method to batch schedule and display the results in the text area
                outputTextArea.append("Batch Scheduling...\n");
            }
        });
    }
}
