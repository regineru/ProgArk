package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Player {

    private TextureRegion texture;
    private Vector3 position;
    private Rectangle bounds;
    private Boolean jump;

    public Player(){
        texture = new TextureRegion("player.png"); // TODO: need a png, placeholder
        position = new Vector3(0,0,0); // TODO: replace placeholder values

    }

    public void update(float dt){

    }


    // called from controller based on input
    public void jump(){
        // if player positioned at "ground"
        //      jump == true;

    }



    public TextureRegion getTexture(){return this.texture;} // TODO: maybe return single texture instead?


}
