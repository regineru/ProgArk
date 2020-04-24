package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Superclass for obstacles (Lightning and cactus)
 * Obstacles are created during the game from the ObstacleFactory
 **/

public abstract class Obstacle {
    protected Vector3 position;
    protected Texture obstacle;
    protected Rectangle collision_bounds;
    protected int height;
    protected int width;

    public Obstacle(){}

    public void update(float dt) {}

    public Texture getObstacle() {
        return obstacle;
    }

    public Vector3 getPosition() {
        return position;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    /**
     * Helps with collision detection
     * @param player the player instance
     */
    public boolean collides(Rectangle player) {
        return player.overlaps(collision_bounds);
    }

    public void dispose() {
        obstacle.dispose();
    }
}
