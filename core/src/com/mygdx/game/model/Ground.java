package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import javax.xml.soap.Text;

public class Ground {

    private Texture ground;
    private Vector3 groundPos;
    private static final int MOVEMENT = -100;
    public static final int GROUND_Y_OFFSET = -50;

    public Ground(){
        ground = new Texture("ground.png");
        groundPos = new Vector3(0, GROUND_Y_OFFSET, 0);
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
        groundPos.add(MOVEMENT * dt, 0, 0 );
    }

    public void dispose() {
        ground.dispose();
    }
}
