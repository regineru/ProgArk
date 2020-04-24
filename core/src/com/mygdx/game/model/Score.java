package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * A players score equal to the time played in milliseconds
 * The score is shown in the playView
 */

public class Score {

    private int score;
    private long counter;
    private String scoreString;
    private BitmapFont scoreFont;

    public Score(){
        score = 0;
        counter = System.currentTimeMillis();
        scoreString = "Score: " + score;
        scoreFont = new BitmapFont();
    }

    public int getScore() {
        return score;
    }

    public BitmapFont getScoreFont() {
        return scoreFont;
    }

    public String getScoreString() {
        return scoreString;
    }

    public void update(){
        score += (System.currentTimeMillis()-counter);
        counter = System.currentTimeMillis();
        scoreString = "Score: " + score/100;
    }
}
