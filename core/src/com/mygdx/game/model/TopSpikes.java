package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;


/**
 * Created by henrikforb on 07. April 2020.
 **/

public class TopSpikes extends Obstacle {

    public TopSpikes() {
        this.spikes = new Texture("topSpikes.png");
        this.position = new Vector3(ImpossibleGravity.WIDTH + 1, ImpossibleGravity.HEIGHT - spikes.getHeight()/2, 0);
    }
}
