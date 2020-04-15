package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by henrikforb on 07. April 2020.
 *
 * Superclass for obstacles
 **/

/* TODO
    1. ObstacleFactory må kontinuerlig generere nye obstacles. Nå genereres kun EN. Fix en array.
    2. Fix reposition. Fixes samtidig som punkt 1. En løsning ganske lik FlappyBird-tutorialen vi funke.
    3. Se på CollisionDetection. Verden beveger seg vel ikke hos oss, men spilleren. Hmm.
 */

public abstract class Obstacle {

    protected Vector3 position;
    protected Texture spikes;

    private static final int MOVEMENT = -100;

    public Obstacle() {}

    public void update(float dt) {
        position.add(MOVEMENT * dt, 0, 0 );
    }
    public abstract Texture getSpikes();
    public abstract Vector3 getPosition();
    public abstract void dispose();
}
