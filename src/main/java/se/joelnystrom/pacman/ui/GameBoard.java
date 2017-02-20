package se.joelnystrom.pacman.ui;

import se.joelnystrom.pacman.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static se.joelnystrom.pacman.PacmanGame.*;

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

        Dimension d = new Dimension(BOARD_SIZE+N_BLOCKS, BOARD_SIZE+BLOCK_SIZE+10);
        this.setSize(d);

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        gamePanel.setFocusable(true);

        this.setVisible(true);
        gamePanel.requestFocusInWindow();
    }

    class  GamePanel extends JPanel {

        RedSquare redSquare = new RedSquare();

        public GamePanel() {
            final int SCORE = 0;
            JLabel gameLabel = new JLabel("Score: " + SCORE);
            gameLabel.setFont(new Font("Helvetica", 1, 12));
            gameLabel.setForeground(Color.white);
            gameLabel.setSize(new Dimension(BOARD_SIZE, BLOCK_SIZE));

            this.setBackground(Color.black);
            this.setBorder(BorderFactory.createLineBorder(Color.red));

            KeyListener keyListener = new KeyListener() {
                public void keyTyped(KeyEvent e) {

                }

                public void keyPressed(KeyEvent e) {

                    if(e.VK_DOWN == e.getKeyCode()) {
                        moveSquare(0,BLOCK_SIZE);
                    };
                    if (e.VK_UP == e.getKeyCode()) {
                        moveSquare(0,-BLOCK_SIZE);
                    };
                    if (e.VK_LEFT == e.getKeyCode()) {
                        moveSquare(-BLOCK_SIZE,0);
                    };
                    if (e.VK_RIGHT == e.getKeyCode()) {
                        moveSquare(BLOCK_SIZE,0);
                    };
                }

                public void keyReleased(KeyEvent e) {

                }
            };
            this.addKeyListener(keyListener);
            this.add(gameLabel);
            System.out.println(this.getWidth());
        }
            private void moveSquare(int x, int y) {

                // Current square state, stored as final variables
                // to avoid repeat invocations of the same methods.
                final int CURR_X = redSquare.getX();
                final int CURR_Y = redSquare.getY();
                final int CURR_W = redSquare.getWidth();
                final int CURR_H = redSquare.getHeight();

                System.out.print("Standing at: " + CURR_Y/BLOCK_SIZE + ", " + CURR_X/BLOCK_SIZE + "; ");
                if (y+CURR_Y<0 || (y+CURR_Y)>=BOARD_SIZE){
                    y = 0;
                }else if (x+CURR_X<0 || (x+CURR_X)>=BOARD_SIZE){
                    x = 0;
                }else if ((GameLogic.checkMaze((CURR_X+x)/BLOCK_SIZE, (CURR_Y+y)/BLOCK_SIZE))){
                    x = 0;
                    y = 0;
                }

                // The square is moving, repaint background
                // over the old square location.
                repaint(CURR_X,CURR_Y,CURR_W,CURR_H);

                // Update coordinates.
                redSquare.setX(CURR_X+x);
                redSquare.setY(CURR_Y+y);

                // Repaint the square at the new location.
                System.out.println("Move to: " + redSquare.getY()/BLOCK_SIZE + ", " + redSquare.getX()/BLOCK_SIZE + "; ");
                repaint(redSquare.getX(), redSquare.getY(),
                        redSquare.getWidth(),
                        redSquare.getHeight());
            }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            redSquare.paintSquare(g);
            g.setColor(Color.WHITE);

            for (int i=0;i<maze.length;i++){
                for (int j=0;j<maze.length;j++) {
                    if (maze[i][j] == 1) {
                        g.fillRect(j*BLOCK_SIZE, i*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    }
                }
            }
        }

        class RedSquare{

            private int xPos = BLOCK_SIZE;
            private int yPos = BLOCK_SIZE;
            private int width = BLOCK_SIZE;
            private int height = BLOCK_SIZE;

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
}
