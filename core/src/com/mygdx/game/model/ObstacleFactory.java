package com.mygdx.game.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.ImpossibleGravity;

import java.util.Random;

/**
 * Created by henrikforb on 07. April 2020.
 **/

/*
CREATES A LIST OF OBSTACLES AND GENERATES NEW OBSTACLES EVERY X*RANDOM SECOND
SIZE IS RANDOMIZED
 */

public class ObstacleFactory {

    private int chosenObstacle;
    private int chosenHeight;
    private int chosenWidth;

    private Array<Obstacle> obstacles;
    private Random random;

    public ObstacleFactory() {
        random = new Random();
        obstacles = new Array<Obstacle>();
    }

    public Obstacle generateObstacle(OrthographicCamera camera, Grass grass, Heaven heaven) {

        chosenObstacle = random.nextInt(3);
        chosenHeight = 20 + random.nextInt(50);
        chosenWidth = chosenHeight * (70/30);

        if (chosenObstacle == 0) {
            /**
            the position here is hard coded in to make it work. width = y and height = x for some reason
            **/
            return new TopSpikes(camera.position.x * 2, ImpossibleGravity.HEIGHT-heaven.getGroundHeight()-10, chosenHeight, chosenWidth*3);

        } else if (chosenObstacle == 1 || chosenObstacle == 2) {
            return new BottomSpikes(camera.position.x * 2, grass.getGroundHeight()-10, chosenHeight, chosenWidth);
        }
        return null;
    }

    public Array<Obstacle> getObstacles(){
        return obstacles;
    }

    public void update(float dt, OrthographicCamera camera, Grass grass, Heaven heaven) {
        obstacles.add(generateObstacle(camera, grass, heaven));
    }
}
