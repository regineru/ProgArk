package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

/**
 * Created by henrikforb on 07. April 2020.
 **/

public class BottomSpikes extends Obstacle {

    public BottomSpikes(float x, float y) {
        this.spikes = new Texture("bottomSpikes.png");
        this.position = new Vector3(x, y, 0); // x-pos må endres
        this.bounds = new Rectangle(position.x, position.y, spikes.getWidth(), spikes.getWidth() );

    }
    /*
    public BottomSpikes(float x, int height, int width) {
        this.spikes = new Texture("bottomSpikes.png");
        this.position = new Vector3(x, 0, 0); // x-pos må endres
        this.height = height;
        this.width = width;

    }
    */

}
