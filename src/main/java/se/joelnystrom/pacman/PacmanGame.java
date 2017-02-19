package se.joelnystrom.pacman;

import se.joelnystrom.pacman.ui.GameBoard;

/**
 * Hello world!
 *
 */
public class PacmanGame
{
    private static void pacmanGame() {

        GameBoard gameBoard = new GameBoard(); //Construct game board

    }

    public static void main( String[] args )
    {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                pacmanGame();
            }
        });

    }
}
