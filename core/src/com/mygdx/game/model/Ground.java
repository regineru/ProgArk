package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

import javax.xml.soap.Text;

public class Ground {

    private Texture ground;
    private Vector3 groundPos;
    public static final int GROUND_Y_OFFSET = 0;

    public Ground(){
        ground = new Texture("ground.png");
        groundPos = new Vector3(0, 0, 0);
    }

    public Ground(Vector3 groundPos) {
        ground = new Texture("ground.png");
        this.groundPos = groundPos;
    }

    public Texture getGround(){
        return ground;
    }

    public void setGround(Texture ground) {
        ground = ground;
    }

    public Vector3 getGroundPos(){
        return groundPos;
    }


    public void setGroundPos(Vector3 groundPos) {
        this.groundPos = groundPos;
    }

    public void update(float dt){

    }

    public void dispose() {
        ground.dispose();
    }
}
