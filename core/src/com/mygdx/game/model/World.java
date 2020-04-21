package com.mygdx.game.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.controller.GameController;

/*
EVERY TEXTURE PRESENT IN THE PLAY VIEW IS CREATED HERE:
GROUNDS BOTTOM AND TOP, OBSTACLES, GRAPHICS, MUSIC AND PLAYERS
 */

public class World {

    private Texture background;
    //TODO make background depended on input to variate between different backgrounds/modes
    private static int BG_MODE;

    private Grass grass;
    private Heaven heaven;
    //private Sound sound;
    private long timeCounter; //TODO to increase player speed after x seconds

    // GENERATE OBSTACLES
    private ObstacleFactory obstacleFactory;

    // PLAYER
    private Player character;

    public World() {
        background = new Texture("background.png"); //locally saved
        grass = new Grass();
        heaven = new Heaven();
        timeCounter = System.currentTimeMillis();

        /* TODO Sound is working but is starting multiple times over each other
            and is delaying the game

        sound = Gdx.audio.newSound(Gdx.files.internal("marioTrack.mp3"));
        sound.play(1f);

         */
        obstacleFactory = new ObstacleFactory();
        character = new Player();
    }
    public ObstacleFactory getObstacleFactory(){
        return obstacleFactory;
    }

    public Texture getBackground() {
        return background;
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
        grass.update(dt, camera);
        heaven.update(dt, camera);
        obstacleFactory.update(dt, camera, getGrass(), getHeaven());

        for (Obstacle obstacle : obstacleFactory.getObstacles()) {
            obstacle.update(dt); //no function in obstacle.update()
            if (obstacle.collides(character.getBounds())) {
                //gameController.GameOver();
            }
        }

    }

    public void dispose() {
        background.dispose();
        character.dispose();
        for (Obstacle obstacle : obstacleFactory.getObstacles()) {
            obstacle.dispose();
        }

        //sound.dispose();
        //for (Ground ground : grounds) {
          //  ground.dispose();
        //}
    }
}
