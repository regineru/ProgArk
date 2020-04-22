package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

/*
THE PLAYER CONTAINING THE INTERACTION LOGIC
 */

public class Player {

    private int SPEED = 100;

    private Sprite player;
    private Vector3 position;
    private Rectangle bounds;
    private boolean jump;
    private float gravity;
    private Vector3 velocity;
    private int score;


    public Player(){
        this.player = new Sprite(new Texture("player.png")); // placeholder
        this.position = new Vector3(ImpossibleGravity.WIDTH/2 - player.getWidth()/2,-ImpossibleGravity.HEIGHT/2,0);
        this.bounds = new Rectangle(position.x, position.y, player.getWidth(), player.getHeight());
        this.gravity = ImpossibleGravity.GRAVITY; // set gravity to global value
        this.velocity = new Vector3(1, 0, 0);


        this.score = 0;
        this.jump = false;
    }

    public void update(float dt){

        position.add(SPEED * dt, 0, 0 );

        score = ((int) dt); //score follows delta time
        /** score and dt is not working properly
        System.out.println(dt);
         **/

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



        this.bounds.setPosition(position.x, position.y); // update bounds to players position
        //System.out.println("Rectangle: " + bounds.toString());
        //System.out.println("Player: " + getPosition() + " Width: " + player.getWidth() + " Height: " + player.getHeight());

    }

    public void increaseSPEED(){
        this.SPEED += 10;
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

    public int getSpeed() {
        return SPEED;
    }
}