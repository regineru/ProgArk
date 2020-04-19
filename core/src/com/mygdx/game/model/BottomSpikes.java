package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

/**
 * Created by henrikforb on 07. April 2020.
 **/

public class BottomSpikes extends Obstacle {

    public BottomSpikes(float x) {
        this.spikes = new Texture("bottomSpikes.png");
        this.position = new Vector3(x, 0, 0); // x-pos må endres
    }
}
