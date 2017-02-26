package se.joelnystrom.pacman;

import java.awt.*;

/**
 * Created by jnys on 26/02/2017.
 */
public class Maze {

    public static final int[][] labyrinth = {
            { 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            { 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            { 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0},
            { 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0},
            { 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0},
            { 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            { 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0},
            { 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0},
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1},
            { 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
            { 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            { 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0},
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
    };

    private Color color = Color.GRAY;
    private Color brick = Color.BLUE;

    public boolean check (int x, int y){
        if (labyrinth[y][x] == 0) {
            return true;
        }
        return false;
    }

    public void render(Graphics g, int size){

        for (int i = 0; i< labyrinth.length; i++){
            for (int j = 0; j< labyrinth.length; j++) {
                if (labyrinth[i][j] == 1) {
                    g.setColor(brick);
                    g.fillRect(j*size, i*size, size, size);
                    g.setColor(color);
                    g.fillRect(j*size,i*size,size/4,size/4);
                    g.fillRect(j*size + (2*size/4),i*size,size/4,size/4);
                    g.fillRect(j*size,i*size + (2*size/4),size/4,size/4);
                    g.fillRect(j*size + (2*size/4),i*size + (2*size/4),size/4,size/4);
                    g.fillRect(j*size + (size/4),i*size + (size/4),size/4,size/4);
                    g.fillRect(j*size + (size/4),i*size + (3*size/4),size/4,size/4);
                    g.fillRect(j*size + (3*size/4),i*size + (size/4),size/4,size/4);
                    g.fillRect(j*size + (3*size/4),i*size + (3*size/4),size/4,size/4);
                }
            }
        }
    }
}
