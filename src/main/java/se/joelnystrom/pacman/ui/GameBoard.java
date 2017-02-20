package se.joelnystrom.pacman.ui;

import se.joelnystrom.pacman.logic.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static se.joelnystrom.pacman.PacmanGame.*;
import static se.joelnystrom.pacman.ui.GameBoard.Direction.*;

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

    public enum Direction {
        NORTH (0,-1),
        SOUTH (0, 1),
        EAST (1, 0),
        WEST (-1,0);

        public final int dy, dx;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    class  GamePanel extends JPanel implements ActionListener {

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
                        movePacman(SOUTH);
                    };
                    if (e.VK_UP == e.getKeyCode()) {
                        movePacman(NORTH);
                    };
                    if (e.VK_LEFT == e.getKeyCode()) {
                        movePacman(WEST);
                    };
                    if (e.VK_RIGHT == e.getKeyCode()) {
                        movePacman(EAST);
                    };
                }

                public void keyReleased(KeyEvent e) {

                }

            };
            this.addKeyListener(keyListener);

            Timer timer = new Timer(40, this);

            this.add(gameLabel);
        }
            private void movePacman(Direction d) {

                // movePacman x, y
                //Can only turn 90 degrees at square position

                final int CURR_X = redSquare.getX();
                final int CURR_Y = redSquare.getY();
                final int CURR_W = redSquare.getWidth();
                final int CURR_H = redSquare.getHeight();
                int new_x = CURR_X;
                int new_y = CURR_Y;

                //System.out.print("Standing at: " + CURR_X + ", " + CURR_Y + "; ");

                int new_xpos = (CURR_X + d.dx*BLOCK_SIZE)/BLOCK_SIZE;
                int new_ypos = (CURR_Y + d.dy*BLOCK_SIZE)/BLOCK_SIZE;

                if (GameLogic.checkMaze(new_xpos, new_ypos)){
                    //System.out.print("True, you can walk ");
                    if ((CURR_Y % BLOCK_SIZE == 0) && (d.dy == 0)) {
                        // At even pixel for Y, may turn 90
                        System.out.println("right or left;");
                        new_x = new_x + d.dx;
                    }else if ((CURR_X % BLOCK_SIZE == 0) && (d.dx == 0 )) {
                        // At even pixel for X, may turn 90
                        System.out.println("up or down;");
                        new_y = new_y+d.dy;
                    }
                    System.out.println("Moved to: " + new_x + ", " + new_y + "; ");
                }

                repaint(CURR_X, CURR_Y, CURR_W, CURR_H);

                redSquare.setX(new_x);
                redSquare.setY(new_y);

                repaint(redSquare.getX(), redSquare.getY(), redSquare.getWidth(), redSquare.getHeight());

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

        public void actionPerformed(ActionEvent e) {

        }

        class RedSquare{

            private int xPos = BLOCK_SIZE;
            private int yPos = BLOCK_SIZE;
            private int width = BLOCK_SIZE;
            private int height = BLOCK_SIZE;

            private Direction direction = NORTH;

            public void setX(int xPos){
                this.xPos = xPos;
            }

            public int getX(){
                return xPos;
            }

            public void setY(int yPos){
                this.yPos = yPos;
            }

            public void setDirection(Direction d){
                this.direction = d;
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

            public Direction getDirection(){
                return direction;
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
