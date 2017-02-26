package se.joelnystrom.pacman;

import se.joelnystrom.pacman.ui.GameBoard;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static se.joelnystrom.pacman.ui.GameBoard.Direction.*;

/**
 * Created by jnys on 26/02/2017.
 */
public class KeyInput extends KeyAdapter {

    GameBoard gameBoard;

    public KeyInput(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public void keyPressed(KeyEvent e) {
        gameBoard.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        gameBoard.keyReleased(e);
    }
}
