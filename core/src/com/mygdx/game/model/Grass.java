package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by henrikforb on 21. April 2020.
 **/

public class Grass extends Ground {

    //TODO: se på playview, der kalles Ground og ikke Grass. Logikk må gjøres om (og fjernes fra playview egt)
    public Grass() {
        // ta inn cam.pos osv i playView
        ground = new Texture("ground.png");
        groundPos1 = new Vector3(0, 0, 0);
        groundPos2 = new Vector3(0 + ground.getWidth(), 0, 0);
        groundHeight = new Float(ground.getHeight());
    }
}
