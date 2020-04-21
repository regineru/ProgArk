package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

/**
 * Created by henrikforb on 21. April 2020.
 **/

public class Heaven extends Ground {

    public Heaven(){ // ta inn cam.pos osv i playView
        ground = new Texture("heaven.png");
        groundPos1 = new Vector3(0, ImpossibleGravity.HEIGHT - ground.getHeight() / 2, 0);
        groundPos2 = new Vector3(0 + ground.getWidth(), ImpossibleGravity.HEIGHT - ground.getHeight() / 2, 0);
        groundHeight = new Float(ground.getHeight());
    }

    @Override
    public void update() {

    }
}
