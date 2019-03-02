package net.mabdurrahman.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Cursor.HAND_CURSOR;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The GamePanel Class
 * @author:  MAbdurrahman
 * @date:  7 October 2017
 * @version:  1.0.0
 */
public class GamePanel extends JPanel {
    //Instance Variables for the GamePanel
    private final CardPanel cardPanel;
    private final JButton dealButton;
    private final JButton drawButton;
    private final JButton quitButton;
    private final JTextField wagerField;

    /**
     * GamePanel Constructor - Creates and instance of the GamePanel
     */
    public GamePanel() {
        setBackground(new Color(156, 95, 42));
        setLayout(new BorderLayout(3, 3));

        cardPanel = new CardPanel();
        add(cardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(156, 95, 42));
        add(buttonPanel, BorderLayout.SOUTH);

        dealButton = new JButton("Deal");
        dealButton.setBackground(Color.green);
        dealButton.setSize(60, 25);
        dealButton.setFont(new Font("Montserrat Alternates", Font.PLAIN, 18));
        dealButton.setToolTipText("Deal cards");

        buttonPanel.add(dealButton);

        drawButton = new JButton("Draw");
        drawButton.setBackground(Color.yellow);
        drawButton.setSize(60, 25);
        drawButton.setFont(new Font("Montserrat Alternates", Font.PLAIN, 18));
        drawButton.setToolTipText("Draw new cards");

        buttonPanel.add(drawButton);

        quitButton = new JButton("Quit");
        quitButton.setBackground(Color.red);
        quitButton.setSize(60, 25);
        quitButton.setFont(new Font("Montserrat Alternates", Font.PLAIN, 18));
        quitButton.setToolTipText("Exit game");

        buttonPanel.add(quitButton);

        JLabel wagerLabel = new JLabel("  Wager: $");
        wagerLabel.setFont(new Font("Montserrat Alternates", Font.PLAIN, 17));
        wagerField = new JTextField("25", 3);
        wagerField.setFont(new Font("Montserrat Alternates", Font.PLAIN, 18));
        wagerField.setBorder(BorderFactory.createLineBorder(Color.decode("#9C5F2A"), 1, false));
        wagerField.setBackground(Color.decode("#9C5F2A"));
        wagerField.setToolTipText("Click to change wager");

        buttonPanel.add(wagerLabel);
        buttonPanel.add(wagerField);

        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(13), Color.decode("#9C5F2A")));

    }//end of the GamePanel Constructor
    /**
     * CardPanel Class is a nested class, displays the cards, maintains the status of the
     * game, and responds to the actionEvents of the game.
     */
    private class CardPanel extends JPanel {
        //CardPanel Instance Variables
        PokerDeck deck;
        PokerHand playerHand;
        String message;
        Font gameFont;
        Image cardImages;
        boolean isGameInProgress;
        String moneyString;
        int playerMoney;
        int wager;

        /**
         * CardPanel Constructor - Creates an instance of the CardPanel
         */
        private CardPanel() {
            loadImages();
            setBackground(new Color(65, 110, 12));
            setForeground(new Color(237, 237, 69));

            gameFont = new Font("Montserrat Alternates", Font.PLAIN, 28);
            message = "Select cards to keep and/or Click \"Draw";
            playerMoney = 1000;
            moneyString = "Your money $" +getPlayerMoney();

        }//end of the CardPanel Constructor
        /**
         * loadImages Method - Loads the card images from the cardDeck file
         * @param - void
         */
        private void loadImages() {
            ClassLoader classLoader = this.getClass().getClassLoader();
            //URL imageURL = classLoader.getResource("\\img\\cardDeck.png");
            URL imageURL = classLoader.getResource("../res/img/cardDeck.png");

            if (imageURL != null) {
                cardImages = Toolkit.getDefaultToolkit().createImage(imageURL);

            } else {
                Toolkit.getDefaultToolkit().beep();
                String msg = "Card images not found!";
                JOptionPane.showConfirmDialog(cardPanel, message);
            }
        }//end of the loadImages Method
        /**
         * getPlayerMoney Method - Gets the amount of money of the player
         * @param - void
         * @return Int - Returns the player's money in the form of an integer
         */
        private int getPlayerMoney() {
            return playerMoney;

        }//end of the getPlayerMoney Method








        /**
         * paint Method - Overrides the paint Method of the Abstract JPanel Class, and paints the
         * CardPanel Class.  It draws the dealt cards and game status messages on the panel.
         * @param  - the graphic context
         */
        @Override
        public void paint(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2D = (Graphics2D) g;

            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2D.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            Font font = new Font("Montserrat Alternates", Font.PLAIN, 16);
            g.setColor(new Color(237, 237, 69));
            g.setFont(font);


        }//end of the paint Method
    }//end of the CardPanel Class

    /**
     * main Method - Contains the command line arguments
     * @param args
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException |
                InstantiationException |
                IllegalAccessException |
                javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamePanel.class.getName()).
                    log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /** Create and display the game */
        java.awt.EventQueue.invokeLater(()-> {
            JFrame frame = new JFrame("V i d e o  P o k e r");
            Image icon = Toolkit.getDefaultToolkit().getImage(GamePanel.class.
                    getResource("../res/img/videoPokerImage.png"));
            frame.setIconImage(icon);
            frame.setSize(800, 700);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setCursor(HAND_CURSOR);
            GamePanel gamePanel = new GamePanel();
            frame.setContentPane(gamePanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }//end of the main Method
}//end of the GamePanel Class

