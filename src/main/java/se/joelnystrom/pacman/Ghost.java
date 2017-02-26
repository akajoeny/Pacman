package se.joelnystrom.pacman;

import java.awt.*;

/**
 * Created by jnys on 26/02/2017.
 */
public class Ghost extends Character {

    public Ghost(int xPos, int yPos, int width, int height, Image image) {
        super(xPos, yPos, width, height);

        characterImage = image;
    }
}
