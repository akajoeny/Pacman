package se.joelnystrom.pacman.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jnys on 19/02/2017.
 */
public class GameBoard extends JFrame {

    public GameBoard() {

        JFrame frame = new JFrame("PacMan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBackground(Color.black);
        frame.setFocusable(true);

        /*
        JMenuBar gameMenuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Main Menu");
        gameMenuBar.add(gameMenu);
        frame.setJMenuBar(gameMenuBar);
        frame.setIconImage(new ImageIcon(imgURL).getImage());
        */

        frame.setVisible(true);



        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    }
}
