package com.mygdx.game.interactiveElements;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Text extends Actor {
    BitmapFont font;
    //Score myScore;

    public Text(){
        font = new BitmapFont();
        font.setColor(0.5f,0.4f,0,1);   //Brown is an underated Colour
    }

    public void drawHelpText(SpriteBatch batch, float parentAlpha) {
        font.draw(batch, "This is the help text to be displayed in the help view", 0, 0);
        //Also remember that an actor uses local coordinates for drawing within
        //itself!
    }
}
