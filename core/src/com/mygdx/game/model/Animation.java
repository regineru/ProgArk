package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Logic for animation of the textures: background and character
 **/

public class Animation {

    private Array<TextureRegion> frames;
    private float totalFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int currentFrame;

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        totalFrameTime = cycleTime / frameCount;
        currentFrame = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > totalFrameTime) {
            currentFrame ++;
            currentFrameTime = 0;
        }
        if (currentFrame >= frameCount) {
            currentFrame = 0;
        }
    }

    public void flip(){
        for (TextureRegion frame : frames){
            frame.flip(false, true);
        }
    }

    public TextureRegion getFrame() {
        return frames.get(currentFrame);
    }
}
