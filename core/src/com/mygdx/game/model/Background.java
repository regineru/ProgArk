package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;

/**
 * Background shown in all views
 */
public class Background {

    private Texture background;
    private static int BG_MODE;

    public Background(){
        this.background = new Texture("background.png"); //locally saved
    }

    public Texture getBackground() {
        return background;
    }

    public void dispose() {
        background.dispose();
    }

}
