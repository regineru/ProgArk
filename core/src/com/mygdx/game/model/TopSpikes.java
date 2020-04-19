package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;


/**
 * Created by henrikforb on 07. April 2020.
 **/

public class TopSpikes extends Obstacle {

    public TopSpikes(float x, int height, int width) {
        this.spikes = new Texture("topSpikes.png");
        this.position = new Vector3(x, ImpossibleGravity.HEIGHT-height, 0);
        this.height = height;
        this.width = width;
    }
}
