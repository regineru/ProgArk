package com.mygdx.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.controller.GameController;

import java.util.Random;

/*
EVERY TEXTURE PRESENT IN THE PLAY VIEW IS CREATED HERE:
GROUNDS BOTTOM AND TOP, OBSTACLES, GRAPHICS, MUSIC AND PLAYERS
 */

public class World {

    private Grass grass;
    private Heaven heaven;
    private Music music;

    // HELP ATTRIBUTES TO KEEP TRACK OF TIME ETC.
    private long timeCounter; //TODO to increase player speed after x seconds
    private long lastObstacle;
    private Random obstacle_occurrence;

    // GENERATE OBSTACLES
    private ObstacleFactory obstacleFactory;

    // PLAYER
    private Player character;

    public World() {
        grass = new Grass();
        heaven = new Heaven();

        timeCounter = System.currentTimeMillis();
        lastObstacle = System.currentTimeMillis();
        obstacle_occurrence = new Random();

        music = Gdx.audio.newMusic(Gdx.files.internal("marioTrack.mp3"));
        music.setLooping(true);

        obstacleFactory = new ObstacleFactory();
        character = new Player();
    }
    public ObstacleFactory getObstacleFactory(){
        return obstacleFactory;
    }

    public Grass getGrass() {
        return grass;
    }

    public Heaven getHeaven() {
        return heaven;
    }
    public long getTimeCounter(){
        return timeCounter;
    }

    public Player getCharacter(){
        return character;
    }

    public void playMusic(){music.play();}

    public void stopMusic(){music.stop();}

    public void pauseMusic(){music.pause();}

    /* Might need this to select different backgrounds
    public void setBackground(Texture background) {
        this.background = background;
    }

     */

    /* Might need this to select different backgrounds
    public void setGround(Texture ground) {
        this.ground = ground;
    }

     */

    public void update(float dt, OrthographicCamera camera, GameController gameController) {
        character.update(dt);

        /** This method increases the speed of the player a small amount every 2 seconds
         *
         */
        if (character.getSpeed() < 500 && System.currentTimeMillis() - timeCounter >= 2000) {
            timeCounter = System.currentTimeMillis();
            character.increaseSPEED();
        }

        grass.update(dt, camera);
        heaven.update(dt, camera);

        if (System.currentTimeMillis() - lastObstacle >= 500 + obstacle_occurrence.nextInt((2000-character.getSpeed()))) {
            obstacleFactory.update(dt, camera, getGrass(), getHeaven());
            lastObstacle = System.currentTimeMillis();
        }

        for (Obstacle obstacle : obstacleFactory.getObstacles()) {
            obstacle.update(dt); //no function in obstacle.update()
            if (obstacle.collides(character.getBounds())) {
                stopMusic();
                gameController.GameOver();
            }
        }
    }

    public void dispose() {
        character.dispose();
        music.dispose();
        for (Obstacle obstacle : obstacleFactory.getObstacles()) {
            obstacle.dispose();
        }
    }
}
