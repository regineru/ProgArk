package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;

public class Background {

    private Texture background;
    //TODO make background depended on input to variate between different backgrounds/modes
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
