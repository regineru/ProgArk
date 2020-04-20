package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

import static java.lang.Math.abs;

public class Player {

    private static final float MOVEMENT = 100;

    // TODO: make the texture into a sprite
    private Texture texture;
    private Sprite player;
    private Vector3 position;
    private Rectangle bounds;
    private boolean jump;
    private float gravity;
    private Vector3 velocity;
    private int score;
    private int SPEED;

    public Player(){
        this.player = new Sprite(new Texture("player.png")); // placeholder
        this.position = new Vector3(ImpossibleGravity.WIDTH/2 - this.player.getTexture().getWidth()/2,-ImpossibleGravity.HEIGHT/2,0);
        this.bounds = new Rectangle(position.x, position.y, this.player.getTexture().getWidth(), this.player.getTexture().getHeight());
        this.gravity = ImpossibleGravity.GRAVITY; // set gravity to global value
        this.SPEED = 20; // this needs to be updated
        this.velocity = new Vector3(1, 0, 0);

        this.score = 0;
        this.jump = false;
    }

    public void start() {
        this.velocity.add(SPEED, 0, 0);
    }

    public void update(float dt){

        position.add(MOVEMENT * dt, 0, 0 );

        score = ((int) dt); //score follows delta time
        this.position.y += this.velocity.y;
        this.position.x += this.velocity.x;

        this.velocity.add(0, gravity, 0);

        if (this.position.y <= 50 && velocity.y < 0){
            this.velocity.y = 0;
            this.position.y = 50;
        }

        if (this.position.y >= 430 && velocity.y > 0){
            this.velocity.y = 0;
            this.position.y = 430;
        }



        this.bounds.setPosition(this.position.x, this.position.y); // update bounds to players position

    }


    // called from controller based on input
    public void jump(){
        if (this.velocity.y == 0){
            if (this.gravity < 0) {
                this.velocity.add(0, 15, 0);
            } else if (this.gravity > 0){
                this.velocity.add(0, -15, 0);
            }
        }
    }

    // called from controller based on input
    public void switchGravity(int deltaY){
        if (deltaY*this.gravity > 0 && this.velocity.y == 0) {
            this.gravity = -this.gravity;
            this.player.flip(false, true);
        }
    }

    public Sprite getSprite(){return this.player;}

    //TODO make score an interactive element/texture to render it to screen
    public int getScore(){return this.score;}

    public Vector3 getPosition(){return this.position;}

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose(){
        this.player.getTexture().dispose();
    }


}