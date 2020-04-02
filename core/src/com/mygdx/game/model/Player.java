package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

public class Player {

    private Texture texture;
    private Vector3 position;
    private Rectangle bounds;
    private Boolean jump;
    private int score;

    public Player(){
        texture = new Texture("player.png"); // placeholder
        position = new Vector3(ImpossibleGravity.WIDTH/2,ImpossibleGravity.HEIGHT/2,0);
        score = 0;
        System.out.println("player contructor");

    }

    public void update(float dt){

    }


    // called from controller based on input
    public void jump(){
        // if player positioned at "ground"
        //      jump == true;

    }

    public void switchGravity(){ // should this be handled here?

    }



    public Texture getTexture(){return this.texture;}

    public int getScore(){return this.score;}

    public Vector3 getPosition(){return this.position;}

    public void dispose(){
        texture.dispose();
    }


}
