package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Ground in bottom of screen for the player to run on
 **/

public class Grass extends Ground {

    public Grass() {
        ground = new Texture("ground.png");
        groundPos1 = new Vector3(0, 0, 0);
        groundPos2 = new Vector3(0 + ground.getWidth(), 0, 0);
        groundHeight = new Float(ground.getHeight());
    }

}
