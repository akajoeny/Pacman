package se.joelnystrom.pacman.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

/**
 * Created by jnys on 19/02/2017.
 */
public class GameBoard extends JFrame {

    public GameBoard() {
        super();
        System.out.println("Created GUI on EDT? "+ SwingUtilities.isEventDispatchThread());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setFocusable(true);

        /*
        JMenuBar gameMenuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Main Menu");
        gameMenuBar.add(gameMenu);
        this.setJMenuBar(gameMenuBar);
        this.setIconImage(new ImageIcon(imgURL).getImage());
        */

        Dimension d = new Dimension(600, 600);

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        gamePanel.setFocusable(true);
        this.setSize(d);
        this.setVisible(true);
        gamePanel.requestFocusInWindow();

        //this.getContentPane().add(emptyLabel, BorderLayout.CENTER);
    }

    class  GamePanel extends JPanel {

        final int BLOCK_SIZE = 24;
        final int N_BLOCKS = 15;
        final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
        int score = 0;

        RedSquare redSquare = new RedSquare();


        public GamePanel() {
            JLabel gameLabel = new JLabel("Score: " + score);
            gameLabel.setFont(new Font("Helvetica", 1, 12));
            gameLabel.setForeground(Color.white);
            gameLabel.setSize(new Dimension(20, 20));

            this.setBackground(Color.black);
            this.setBorder(BorderFactory.createLineBorder(Color.red));

            KeyListener keyListener = new KeyListener() {
                public void keyTyped(KeyEvent e) {

                }

                public void keyPressed(KeyEvent e) {

                    if(e.VK_DOWN == e.getKeyCode()) {
                        System.out.println("Pressed Down");
                        moveSquare(0,5);
                    };
                    if (e.VK_UP == e.getKeyCode()) {
                        moveSquare(0,-5);
                    };
                    if (e.VK_LEFT == e.getKeyCode()) {
                        moveSquare(-5,0);
                    };
                    if (e.VK_RIGHT == e.getKeyCode()) {
                        moveSquare(5,0);
                    };
                }

                public void keyReleased(KeyEvent e) {

                }
            };
            this.addKeyListener(keyListener);

            this.add(gameLabel);
        }
            private void moveSquare(int x, int y) {

                // Current square state, stored as final variables
                // to avoid repeat invocations of the same methods.
                final int CURR_X = redSquare.getX();
                final int CURR_Y = redSquare.getY();
                final int CURR_W = redSquare.getWidth();
                final int CURR_H = redSquare.getHeight();
                final int OFFSET = 1;

                if ((CURR_X!=x) || (CURR_Y!=y)) {

                    // The square is moving, repaint background
                    // over the old square location.
                    repaint(CURR_X,CURR_Y,CURR_W+OFFSET,CURR_H+OFFSET);

                    // Update coordinates.
                    //TODO:Ensure it does not move out of bounds
                    redSquare.setX(CURR_X+x);
                    redSquare.setY(CURR_Y+y);

                    // Repaint the square at the new location.
                    repaint(redSquare.getX(), redSquare.getY(),
                            redSquare.getWidth()+OFFSET,
                            redSquare.getHeight()+OFFSET);
                }
            }


        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw Text
            g.drawString("This is my custom Panel!",10,20);

            redSquare.paintSquare(g);

        }

        class RedSquare{

            private int xPos = 50;
            private int yPos = 50;
            private int width = 20;
            private int height = 20;

            public void setX(int xPos){
                this.xPos = xPos;
            }

            public int getX(){
                return xPos;
            }

            public void setY(int yPos){
                this.yPos = yPos;
            }

            public int getY(){
                return yPos;
            }

            public int getWidth(){
                return width;
            }

            public int getHeight(){
                return height;
            }

            public void paintSquare(Graphics g){
                g.setColor(Color.RED);
                g.fillRect(xPos,yPos,width,height);
                g.setColor(Color.BLACK);
                g.drawRect(xPos,yPos,width,height);
            }

        }
    }

    /*
    private class GameInput implements KeyListener {
        public void keyTyped(KeyEvent e) {}

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == e.VK_DOWN) key_down = false;
            if (e.getKeyCode() == e.VK_UP) key_up = false;
            if (e.getKeyCode() == e.VK_RIGHT) key_right = false;
            if (e.getKeyCode() == e.VK_LEFT) key_left = false;
        }

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == e.VK_DOWN) key_down = true;
            if (e.getKeyCode() == e.VK_UP) key_up = true;
            if (e.getKeyCode() == e.VK_RIGHT) key_right = true;
            if (e.getKeyCode() == e.VK_LEFT) key_left = true;
        }
    }
    */
}
