package se.joelnystrom.pacman;

/**
 * Created by jnys on 26/02/2017.
 */
public class Ghost extends Character {

    public Ghost(int xPos, int yPos, int width, int height) {
        super(xPos, yPos, width, height);

        characterImage = CharacterImages.getGhost().getScaledInstance(32,32,0);
    }
}
