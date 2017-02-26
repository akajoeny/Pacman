package se.joelnystrom.pacman;

import java.awt.*;

/**
 * Created by jnys on 25/02/2017.
 */
public abstract class Character {

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color characterColor = Color.YELLOW;
    protected Image characterImage;

    public Character(int xPos, int yPos, int width, int height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public void setX(int xPos){
        this.xPos = xPos;
    }

    public int getX(){
        return xPos;
    }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getH(){
        return height;
    }

    public int getW(){
        return width;
    }

    public void setCharacterImage(Image image){
        this.characterImage = image;
    }

    public Image getCharacterImage() {
        return characterImage;
    }

    public void setCharacterColor(Color c) {
        this.characterColor = c;
    }

    public Color getCharacterColor() {
        return this.characterColor;
    }

    public void renderCharacter(Graphics g){
        g.drawImage(this.characterImage, this.xPos, this.yPos, null);
    }

}
