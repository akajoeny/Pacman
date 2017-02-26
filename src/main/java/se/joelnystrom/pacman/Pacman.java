package se.joelnystrom.pacman;

/**
 * Created by jnys on 26/02/2017.
 */
public class Pacman extends Character {

    public Pacman(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);

        characterImage = CharacterImages.getImage(CharacterImages.PACMAN);
    }
}
