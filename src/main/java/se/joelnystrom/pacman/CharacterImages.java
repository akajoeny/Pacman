package se.joelnystrom.pacman;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by jnys on 26/02/2017.
 */
public class CharacterImages {

    private static final String basePath = "images/";

    public static Image getGhost() {

        return getImage("ghost.png");
    }

    public static Image getPacman(){

        return getImage("pacman.png");
    }

    private static Image getImage(String imageName) {

        URL filePath = CharacterImages.class.getClassLoader().getResource(basePath + imageName);

        if (null == filePath) {
            throw new RuntimeException("Jens not found: " + filePath);
        }
        return new ImageIcon(filePath).getImage();
    }
}
