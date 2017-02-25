package se.joelnystrom.pacman;

import java.awt.*;

/**
 * Created by jnys on 25/02/2017.
 */
public class Character {

    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private Color characterColor = Color.YELLOW;

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

    public Color getCharacterColor() {
        return this.characterColor;
    }

}
