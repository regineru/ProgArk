package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;


/**
 * Bottom obstacle generated from ObstacleFactory
 **/

public class Lightning extends Obstacle {

    public Lightning(float x, float y, int width, int height) {
        this.obstacle = new Texture("topSpikes.png");
        this.height = height;
        this.width = width;
        this.position = new Vector3(x, y-height, 0);
        this.collision_bounds = new Rectangle(position.x, position.y, width, height);
    }
}
