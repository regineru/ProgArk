package com.mygdx.game.model;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class World {

    private Texture background;
    private Texture ground;
    private Vector2 groundPos1, groundPos2;
    //TODO add music
    //private Music music;

    public World() {
        background = new Texture("background.png"); //locally saved
        ground = new Texture("ground.png"); //locally saved
        //music = new Music();

    }

    public Texture getBackground() {
        return background;
    }

    public void setBackground(Texture background) {
        this.background = background;
    }

    public Texture getGround() {
        return ground;
    }

    public void setGround(Texture ground) {
        this.ground = ground;
    }

    public Vector2 getGroundPos1() {
        return groundPos1;
    }

    public Vector2 getGroundPos2() {
        return groundPos2;
    }

    public void setGroundPos1(Vector2 groundPos1) {
        this.groundPos1 = groundPos1;
    }

    public void setGroundPos2(Vector2 groundPos2) {
        this.groundPos2 = groundPos2;
    }


    public void dispose() {
        this.background.dispose();
        this.ground.dispose();
    }
}
