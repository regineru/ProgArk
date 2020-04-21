package com.mygdx.game.model;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

import javax.xml.soap.Text;

public class Ground {

    protected Texture ground;
    protected Vector3 groundPos1, groundPos2;
    protected float groundHeight;
    //public static final int GROUND_Y_OFFSET = -50;

    public Ground() {}

    public Texture getGround(){
        return ground;
    }

    public Vector3 getGroundPos1(){
        return groundPos1;
    }

    public Vector3 getGroundPos2(){
        return groundPos2;
    }

    public float getGroundHeight() {
        return groundHeight;
    }

    public void update(float dt, OrthographicCamera camera) {
        if (camera.position.x -(camera.viewportWidth / 2) > getGroundPos1().x + ImpossibleGravity.WIDTH) {
            getGroundPos1().add(ImpossibleGravity.WIDTH * 2, 0, 0);
        }
        if (camera.position.x -(camera.viewportWidth / 2) > getGroundPos2().x + ImpossibleGravity.WIDTH) {
            getGroundPos2().add(ImpossibleGravity.WIDTH * 2, 0, 0);
        }

    }

    public void dispose() {
        ground.dispose();
    }

}
