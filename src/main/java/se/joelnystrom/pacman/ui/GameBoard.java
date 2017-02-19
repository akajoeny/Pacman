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
        frame.pack();
        frame.setFocusable(true);

        JPanel gamePanel = new JPanel();
        gamePanel.setBackground(Color.black);

        JLabel gameLabel = new JLabel("Hello World");
        gameLabel.setFont(new Font("Verdana",1,12));
        gamePanel.add(gameLabel);
        gamePanel.setBorder(new LineBorder(Color.white));
        /*
        JMenuBar gameMenuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Main Menu");
        gameMenuBar.add(gameMenu);
        frame.setJMenuBar(gameMenuBar);
        frame.setIconImage(new ImageIcon(imgURL).getImage());
        */

        Dimension d = new Dimension(400, 400);

        frame.add(gamePanel);
        frame.setSize(d);
        frame.setVisible(true);
        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    }
}
