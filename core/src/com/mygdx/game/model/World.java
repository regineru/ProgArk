package com.mygdx.game.model;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import javax.swing.JPasswordField;

public class World {

    private Texture background;
    private Array<Ground> grounds;

    private Music music;
    private static float VOLUME;

    //TODO make background depended on input to variate between different backgrounds/modes
    private static int BG_MODE;

    public World() {
        background = new Texture("background.png"); //locally saved
        grounds = new Array<Ground>();
        grounds.add(new Ground());

        /* Trenger en musikkfil for at dette skal kunne brukes
        music = Gdx.audio.newMusic("musikkfil.mp3");
        music.setLooping(true);
        music.setVolume(1F);
        music.play();
         */
    }

    public Texture getBackground() {
        return background;
    }
    /* Might need this to select different backgrounds
    public void setBackground(Texture background) {
        this.background = background;
    }

     */

    public Array getGrounds() {
        return grounds;
    }

    /* Might need this to select different backgrounds
    public void setGround(Texture ground) {
        this.ground = ground;
    }

     */

    public Vector3 getGroundPos() { //last added grounds position
        return grounds.peek().getGroundPos();
    }

    public void update(float dt) {
        for (Ground ground : grounds){
            ground.update(dt);
        }

        if(grounds.peek().getGroundPos().x < 0) {
            grounds.add(new Ground(new Vector3(grounds.peek().getGroundPos().x+grounds.peek().getGround().getWidth(), Ground.GROUND_Y_OFFSET, 0)));
        }
    }

    public void dispose() {
        background.dispose();
        for (Ground ground : grounds) {
            ground.dispose();
        }
    }

}
