package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

/**
 * Ground in top of screen for the player to run on
 **/
public class Heaven extends Ground {

    public Heaven() {
        ground = new Texture("heaven.png");
        groundPos1 = new Vector3(0, ImpossibleGravity.HEIGHT - ground.getHeight() / 2, 0);
        groundPos2 = new Vector3(0 + ground.getWidth(), ImpossibleGravity.HEIGHT - ground.getHeight() / 2, 0);
        groundHeight = new Float(ground.getHeight());
    }
}
