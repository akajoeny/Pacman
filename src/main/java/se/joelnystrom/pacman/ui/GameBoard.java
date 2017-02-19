package se.joelnystrom.pacman.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by jnys on 19/02/2017.
 */
public class GameBoard extends JFrame {

    public GameBoard() {

        JFrame frame = new JFrame("PacMan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);

        /*
        JMenuBar gameMenuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Main Menu");
        gameMenuBar.add(gameMenu);
        frame.setJMenuBar(gameMenuBar);
        frame.setIconImage(new ImageIcon(imgURL).getImage());
        */

        Dimension d = new Dimension(600, 600);

        frame.add(gamePanel());
        frame.setSize(d);
        frame.setVisible(true);
        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    }

    private JPanel gamePanel() {

        JPanel gamePanel = new JPanel();

        //Adding label with Hello World
        JLabel gameLabel = new JLabel("Hello World");
        gameLabel.setFont(new Font("Verdana",1,12));
        gameLabel.setForeground(Color.white);

        
        gamePanel.setBackground(Color.black);
        gamePanel.add(gameLabel);
        gamePanel.setBorder(new LineBorder(Color.white));

        return gamePanel;
    }
}
