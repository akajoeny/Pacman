package se.joelnystrom.pacman.logic;

import static se.joelnystrom.pacman.PacmanGame.BLOCK_SIZE;
import static se.joelnystrom.pacman.PacmanGame.maze;

/**
 * Created by jnys on 20/02/2017.
 */
public class GameLogic {

    public static boolean checkMaze(int dx, int dy) {

        if (maze[dy][dx] == 1){
            return true;
        }
        return false;
    }
}
