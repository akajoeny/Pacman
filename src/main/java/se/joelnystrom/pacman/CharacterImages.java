package se.joelnystrom.pacman;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by jnys on 26/02/2017.
 */
public class CharacterImages {

    private static final String BASE_PATH = "images/";
    public static final String GHOST = "ghost.png";
    public static final String PACMAN = "pacman.png";


    public static BufferedImage getImage(String imageName) {

        URL filePath = CharacterImages.class.getClassLoader().getResource(BASE_PATH + imageName);

        if (null == filePath) {
            throw new RuntimeException("Image not found: " + imageName);
        }
        try {
            return ImageIO.read(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
