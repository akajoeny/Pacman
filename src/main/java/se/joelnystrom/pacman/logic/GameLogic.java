package se.joelnystrom.pacman.logic;

import static se.joelnystrom.pacman.PacmanGame.BLOCK_SIZE;
import static se.joelnystrom.pacman.PacmanGame.maze;

/**
 * Created by jnys on 20/02/2017.
 */
public class GameLogic {

    public static boolean checkMaze(int xpos, int ypos) {

        //Adding + 1 in print to compensate for array starting a 0
        //System.out.println("Check Maze: " + (xpos+1) + ", " + (ypos+1) + "; ");

        //TODO:Check that ypos and xpos are within boundaries of maze_size
        if (maze[ypos][xpos] == 0){
            return true;
        }
        return false;
    }
}
