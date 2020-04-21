package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

/**
 * Created by henrikforb on 21. April 2020.
 **/

public class Heaven {

    private Texture heaven;
    private Vector3 heavenPos1, heavenPos2;
    private float heavenHeight;
    //public static final int GROUND_Y_OFFSET = -50;

    public Heaven(){ // ta inn cam.pos osv i playView
        heaven = new Texture("heaven.png");
        heavenPos1 = new Vector3(0, ImpossibleGravity.HEIGHT - heaven.getHeight() / 2, 0);
        heavenPos2 = new Vector3(0 + heaven.getWidth(), ImpossibleGravity.HEIGHT - heaven.getHeight() / 2, 0);
        heavenHeight = new Float(heaven.getHeight());
    }

    //public Ground(Vector3 groundPos) {
    //ground = new Texture("ground.png");
    //this.groundPos = groundPos;
    //}

    public Texture getHeaven(){
        return heaven;
    }

    //public void setGround(Texture ground) {
    //ground = ground;
    //}

    public Vector3 getHeavenPos1(){
        return heavenPos1;
    }

    public Vector3 getHeavenPos2(){
        return heavenPos2;
    }

    public float getHeavenHeight() {
        return heavenHeight;
    }

    public void update(float dt){
    }

    public void dispose() {
        heaven.dispose();
    }

}
