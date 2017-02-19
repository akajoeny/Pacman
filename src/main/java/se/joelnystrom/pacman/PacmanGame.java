package se.joelnystrom.pacman;

import se.joelnystrom.pacman.ui.GameBoard;

/**
 * Hello world!
 *
 */
public class PacmanGame
{
    private PacmanGame() {

        GameBoard gameBoard = new GameBoard(); //Construct game board

    }

    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        PacmanGame Pacman = new PacmanGame();

    }
}
