package net.mabdurrahman.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 * The PayoutPanel Class
 * @author:  MAbdurrahman
 */
public class PayoutPanel extends JFrame {
    //Instance Variables
    private final JPanel contentPane;
    private int labelTextLength;
    private int labelCounter;
    private final Timer timer;

    /**
     * VideoPokerPanel Constructor - Creates an instance of the VideoPoker
     */
    public PayoutPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel messageLabel = new JLabel("P A Y O U T");
        messageLabel.setFont(new Font("Montserrat Alternates", Font.BOLD, 16));
        messageLabel.setBounds(138, 73, 313, 36);
        contentPane.add(messageLabel);

        String text = messageLabel.getText();
        labelTextLength = text.length();
        labelCounter = 0;

        timer = new Timer(500, new ActionListener() {
            /**
             * actionPerformed Method -
             * @param e - the ActionEvent
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCounter++;

                if (labelCounter > labelTextLength) {
                    messageLabel.setText("");
                    labelCounter = 0;

                } else {
                    messageLabel.setText(text.substring(0, labelCounter));
                }

            }//end of the actionPerformed Method
        });
        timer.start();
    }//end of the VideoPokerPanel Constructor
    /**
     * main Method - Contains the Command line arguments
     * @param args - the Command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    PayoutPanel fr = new PayoutPanel();
                    fr.setVisible(true);
                } catch (Exception ex) {
                }
            }//end of the run Method
        });
    }//end of the main Method
}//end of the VideoPokerPanel Class

