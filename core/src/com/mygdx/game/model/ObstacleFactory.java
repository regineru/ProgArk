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

    private Random random;
    private int chosenObstacle;
    private int chosenHeight;
    private int chosenWidth;

    private Array<Obstacle> obstacles;
    private long lastObstacle;
    private Random obstacle_occurrence;

    public ObstacleFactory() {
        obstacles = new Array<Obstacle>();
        lastObstacle = System.currentTimeMillis();
        obstacle_occurrence = new Random();
        random = new Random();
    }

    public Obstacle generateObstacle(float x, float y_top, float y_bottom) {

        chosenObstacle = random.nextInt(3);
        chosenHeight = 20 + random.nextInt(50);
        chosenWidth = chosenHeight * (70/30);

        if (chosenObstacle == 0) {
            return new TopSpikes(x, y_top, chosenHeight, chosenWidth);

        } else if (chosenObstacle == 1 || chosenObstacle == 2) {
            return new BottomSpikes(x, y_bottom, chosenHeight, chosenWidth);
        }
        return null;
    }

    public Array<Obstacle> getObstacles(){
        return obstacles;
    }

    public void update(float dt, OrthographicCamera camera, Grass grass, Heaven heaven) {

        if (System.currentTimeMillis() - lastObstacle >= 500 + obstacle_occurrence.nextInt(2000)) {
            lastObstacle = System.currentTimeMillis();
            obstacles.add(generateObstacle(camera.position.x * 2, ImpossibleGravity.HEIGHT-heaven.getGroundHeight(), grass.getGroundHeight()-10));
        }
    }
}
