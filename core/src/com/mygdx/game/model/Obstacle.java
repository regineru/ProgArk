package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by henrikforb on 07. April 2020.
 **/

/*
SUPERCLASS FOR OBSTACLES (TOP- AND BOTTOM SPIKES)
GENERATED IN THE OBSTACLE FACTORY
 */

public abstract class Obstacle {

    protected Vector3 position;
    protected Texture spikes;
    protected Rectangle bounds;
    protected int height;
    protected int width;

    public Obstacle(){}

    public void update(float dt) {

    }

    public Texture getSpikes() {
        return spikes;
    }

    public Vector3 getPosition() {
        return position;
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(bounds);
    }

    public void dispose() {
        spikes.dispose();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
