package com.mygdx.game.model;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.GameController;

import java.util.Random;


public class World {

    private Texture background;
    private Grass grass;
    private Heaven heaven;



    //private Sound sound;
    private long timeCounter; //TODO to increase player speed after x seconds

    //Generate obstacles
    private ObstacleFactory obstacleFactory;
    private Array<Obstacle> obstacles;
    private long lastObstacle;
    private Random obstacle_occurrence;

    //Create player
    private Player character;
    //TODO private Ground ground;

    //TODO make background depended on input to variate between different backgrounds/modes
    private static int BG_MODE;

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
        obstacles = new Array<Obstacle>();
        //obstacles.add(obstacleFactory.generateObstacle(camera.position.x * 2));
        lastObstacle = System.currentTimeMillis();
        obstacle_occurrence = new Random();

        character = new Player();
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

    public ObstacleFactory getObstacleFactory(){
        return obstacleFactory;
    }

    public Array<Obstacle> getObstacles(){
        return obstacles;
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
            for (Obstacle obstacle : obstacles) {
                //obstacle.update(dt);

                if (obstacle.collides(character.getBounds())) {
                    gameController.GameOver();
                }

            }


        if (System.currentTimeMillis() - lastObstacle >= 500 + obstacle_occurrence.nextInt(2000)) {
            lastObstacle = System.currentTimeMillis();
            //obstacles.add(obstacleFactory.generateObstacle(camera.position.x * 2, ground.getGroundHeight() - 10));
            obstacles.add(obstacleFactory.generateObstacle(camera.position.x * 2, 0));
        }

    }

    public void dispose() {
        background.dispose();
        character.dispose();
        for (Obstacle obstacle : obstacles) {
            obstacle.dispose();
        }

        //sound.dispose();
        //for (Ground ground : grounds) {
          //  ground.dispose();
        //}
    }
}
