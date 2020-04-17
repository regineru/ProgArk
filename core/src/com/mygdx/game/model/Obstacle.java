package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by henrikforb on 07. April 2020.
 *
 * Superclass for obstacles
 **/

/* TODO
    1. Se på CollisionDetection. Verden beveger seg vel ikke hos oss, men spilleren. Hmm.
 */

public abstract class Obstacle {

    protected Vector3 position;
    protected Texture spikes;

    public Obstacle(){}

    public void update(float dt) {

    }

    public Texture getSpikes() {
        return spikes;
    }

    public Vector3 getPosition() {
        return position;
    }

    public void dispose() {
        spikes.dispose();
    }
}
