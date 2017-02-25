package se.joelnystrom.pacman.ui;

import se.joelnystrom.pacman.Character;

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

        Dimension d = new Dimension(BOARD_SIZE+N_BLOCKS, BOARD_SIZE+BLOCK_SIZE);
        this.setSize(d);
        this.setResizable(false);

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
        WEST (-1,0),
        STILL ( 0, 0);

        public final int dy, dx;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }

    class  GamePanel extends JPanel implements ActionListener {

        Character pacman = new Character(0, BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);

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
                    int key = e.getKeyCode();

                    if ((e.VK_LEFT == key) || (e.VK_UP == key) || (e.VK_DOWN == key) || (e.VK_RIGHT == key)){
                    }

                }

            };
            this.addKeyListener(keyListener);

            //Timer timer = new Timer(40, this);

            this.add(gameLabel);
        }
            private void movePacman(Direction d) {
                // movePacman x, y
                //Can only turn 90 degrees at square position
                final int CURR_X = pacman.getX();
                final int CURR_Y = pacman.getY();
                int new_x = CURR_X;
                int new_y = CURR_Y;
                int speed = BLOCK_SIZE/4;

                //System.out.print("Standing at: " + CURR_X + ", " + CURR_Y + "; ");

                int new_xpos = (CURR_X + d.dx*speed);
                int new_ypos = (CURR_Y + d.dy*speed);

                int offset_x = (new_xpos % BLOCK_SIZE)*d.dx;
                int offset_y = (new_ypos % BLOCK_SIZE)*d.dy;

                if (new_xpos <= BOARD_SIZE-BLOCK_SIZE && new_ypos <= BOARD_SIZE-BLOCK_SIZE && new_xpos >= 0 && new_ypos >= 0) {
                    //New pixel location are within the board

                    int x_coord = new_xpos/BLOCK_SIZE; //Only right when xpos is a block corner
                    int y_coord = new_ypos/BLOCK_SIZE; //Only right when ypos is a block corner

                    if (offset_x > 0 || offset_y > 0) {
                        //System.out.println("Offset X, Y: "+ d.dx + ", " + d.dy);
                        //Need to check maxe at x+1 or y+1
                        x_coord = x_coord + d.dx;
                        y_coord = y_coord + d.dy;
                    }

                    if (maze[y_coord][x_coord] == 0){
                        //System.out.println("Maze is open at: " + (x_coord+1) + ", " + (y_coord+1) + "; ");
                        if ((CURR_Y % BLOCK_SIZE == 0) && (d.dy == 0)) {
                            // At even pixel for Y, may turn 90, but not if wall up or down
                            //System.out.println("right or left;");
                            new_x = new_x + d.dx * speed;
                        } else if ((CURR_X % BLOCK_SIZE == 0) && (d.dx == 0)) {
                            // At even pixel for X, may turn 90
                            //System.out.println("up or down;");
                            new_y = new_y + d.dy * speed;
                        }
                    }

                }
                removeCharacter(pacman,getGraphics());
                pacman.setX(new_x);
                pacman.setY(new_y);
                paintCharacter(pacman,getGraphics());
            }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            for (int i=0;i<maze.length;i++){
                for (int j=0;j<maze.length;j++) {
                    if (maze[i][j] == 1) {
                        g.fillRect(j*BLOCK_SIZE, i*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    }
                }
            }

            paintCharacter(pacman, g);
        }

        private void paintCharacter(Character c, Graphics g){
            g.setColor(c.getCharacterColor());
            g.fillRect(c.getX(),c.getY(),c.getW(),c.getH());
        }

        private void removeCharacter(Character c, Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect(c.getX(),c.getY(),c.getW(),c.getH());
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("Action performed");
        }
    }
}
