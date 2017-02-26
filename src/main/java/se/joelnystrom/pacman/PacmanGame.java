package se.joelnystrom.pacman;

import se.joelnystrom.pacman.ui.GameBoard;

import java.awt.*;

public class PacmanGame implements Runnable {

    private boolean running = false;
    private Thread thread;
    public static Image pacmanImage = CharacterImages.getPacman().getScaledInstance(32, 32, 0);
    public static Image ghostImage = CharacterImages.getGhost().getScaledInstance(32,32,0);

    private synchronized void start(){
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if(!running)
            return;

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void run(){
        //This is the game loop
        GameBoard gameBoard = new GameBoard();
        gameBoard.setResizable(false);
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta>= 1) {
                //tick();
                updates ++;
                delta--;
            }
            //gameBoard.render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public static void main( String[] args ) {
        ghostImage = CharacterImages.getGhost().getScaledInstance(32,32,0);
        pacmanImage = CharacterImages.getPacman().getScaledInstance(32,32,0);
        PacmanGame pacmanGame = new PacmanGame();

        pacmanGame.start();
    }
}
