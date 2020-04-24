package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;


//TODO fix score and dt
/**
 * The player containing the interaction logic and movement of player
 */
public class Character {

    private int SPEED = 100;
    private Sprite player;
    private Vector3 position;
    private Rectangle bounds;
    private boolean jump;
    private float gravity;
    private Vector3 velocity;
    private Score score;

    /**
     * help attribute for update-method
     */
    private long increaseSpeedCounter;


    public Character() {
        player = new Sprite(new Texture("player.png")); // placeholder
        position = new Vector3(ImpossibleGravity.WIDTH / 2 - player.getWidth() / 2, -ImpossibleGravity.HEIGHT / 2, 0);
        bounds = new Rectangle(position.x, position.y, player.getWidth(), player.getHeight());
        gravity = ImpossibleGravity.GRAVITY; // set gravity to global value
        velocity = new Vector3(1, 0, 0);
        jump = false;
        increaseSpeedCounter = System.currentTimeMillis();
        score = new Score();
    }

    public Sprite getSprite() {
        return this.player;
    }

    public int getSpeed() {
        return SPEED;
    }

    public int getScore() {
        return score.getScore();
    }

    public BitmapFont getScoreFont(){
        return score.getScoreFont();
    }

    public String getScoreString(){
        return score.getScoreString();
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Called from controller based on user input. Makes the player jump if touched
     */
    public void jump() {
        if (this.velocity.y == 0) {
            if (this.gravity < 0) {
                this.velocity.add(0, 15, 0);
            } else if (this.gravity > 0) {
                this.velocity.add(0, -15, 0);
            }
        }
    }

    /**
     * Called from controller based on user input. Makes the player switch gravity if swiped
     */
    public void switchGravity(int deltaY) {
        if (deltaY * this.gravity > 0 && this.velocity.y == 0) {
            this.gravity = -this.gravity;
            this.player.flip(false, true);
        }
    }

    /**
     * Called on condition update-method. Increases player speed
     */
    public void increaseSPEED() {
        this.SPEED += 10;
    }

    /**
     * Called from worlds update-method. Makes the player move in game world and makes sure the collision bounds follows and score is updated
     * Calls method for increasing the speed of the player a small amount every 2 seconds up to a speed of 500
     *
     * @param dt delta time
     */
    public void update(float dt) {

        position.add(SPEED * dt, 0, 0);
        score.update();

        this.position.y += this.velocity.y;
        this.position.x += this.velocity.x;

        this.velocity.add(0, gravity, 0);

        if (this.position.y <= 50 && velocity.y < 0) {
            this.velocity.y = 0;
            this.position.y = 50;
        }
        if (this.position.y >= 430 && velocity.y > 0) {
            this.velocity.y = 0;
            this.position.y = 430;
        }
        this.bounds.setPosition(position.x, position.y); // update bounds to players position

        if (getSpeed() < 500 && System.currentTimeMillis() - increaseSpeedCounter >= 2000) {
            increaseSpeedCounter = System.currentTimeMillis();
            increaseSPEED();
        }
    }

    public void dispose() {
        this.player.getTexture().dispose();
    }
}