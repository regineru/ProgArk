package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;

/**
 * Created by henrikforb on 07. April 2020.
 **/

public class BottomSpikes extends Obstacle {

    public BottomSpikes(float x, float y, int height, int width) {
        this.spikes = new Texture("bottomSpikes.png");
        this.position = new Vector3(x, y-5, 0);
        this.height = height;
        this.width = width;
        this.bounds = new Rectangle(position.x, position.y, width, height);

        //System.out.println("Bot Rec: " + bounds.toString());
        //System.out.println("Bot Spike: " + getPosition() + " Width: " + width + " Height: " + height);


    }
}
