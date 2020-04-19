package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by henrikforb on 07. April 2020.
 **/

public class ObstacleFactory {

    private Random random;
    private int chosenObstacle;
    private int chosenHeight;
    private int chosenWidth;

    //private static final int noSpike = 0;
    private static final int topSpike = 0;
    private static final int bottomSpike = 1;

    public ObstacleFactory() {
        random = new Random();
    }

    public Obstacle generateObstacle(float x) {

        chosenObstacle = random.nextInt(2);
        chosenHeight = 50 + random.nextInt(50);
        chosenWidth = 30 + random.nextInt(20);

        if (chosenObstacle == 0) {
            return new TopSpikes(x, chosenHeight, chosenWidth);

        } else if (chosenObstacle == 1) {
            return new BottomSpikes(x, chosenHeight, chosenWidth);
        }

        return null;
    }

}
