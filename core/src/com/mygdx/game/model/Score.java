package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * A players score equal to the time played
 * The score is rendered to screen in the playView
 */

public class Score {

    private float score;
    private String scoreString;
    private BitmapFont scoreFont;

    public Score(){
        score = 0;
        scoreString = "Score: " + score;
        scoreFont = new BitmapFont();
    }

    public float getScore() {
        return score;
    }

    public BitmapFont getScoreFont() {
        return scoreFont;
    }

    public String getScoreString() {
        return scoreString;
    }

    public void update(float dt){
        score += dt;
        scoreString = "Score: " + score;
    }

    public void dispose() {
        scoreFont.dispose();
    }
}
