package net.mabdurrahman.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

/**
 * The HeadLabel Class
 * @author:  MAbdurrahman
 */
public class VideoPokerPanel extends JFrame {
    //Instance Variables
    private final JPanel contentPane;
    private final int labelTextLength;
    private int labelCounter;
    private final Timer timer;

    /**
     * VideoPokerPanel Constructor - Creates an instance of the VideoPoker
     */
    public VideoPokerPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.red);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel messageLabel = new JLabel("V I D E O  P O K E R");
        messageLabel.setFont(new Font("Montserrat Alternates", Font.BOLD, 16));
        messageLabel.setForeground(Color.yellow);
        messageLabel.setBackground(Color.red);
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
            public void actionPerformed(java.awt.event.ActionEvent e) {
                labelCounter++;

               /* if (labelCounter > labelTextLength) {
                    messageLabel.setText("");
                    labelCounter = 0;

                } else {
                    messageLabel.setText(text.substring(0, labelCounter));
                }
                */

                if (messageLabel.getForeground() == Color.red) {
                    messageLabel.setForeground(Color.yellow);

                } else {
                    messageLabel.setForeground(Color.red);
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
                    VideoPokerPanel fr = new VideoPokerPanel();
                    fr.setVisible(true);
                } catch (Exception ex) {
                }
            }//end of the run Method
        });
    }//end of the main Method
}//end of the VideoPokerPanel Class

