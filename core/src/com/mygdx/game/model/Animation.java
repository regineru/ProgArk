package com.mygdx.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by henrikforb on 23. April 2020.
 **/

public class Animation {

    private Array<TextureRegion> frames; // all the frames
    private float totalFrameTime; // how long a frame can in the view
    private float currentFrameTime; // how long the animation has been in the current frame
    private int frameCount; // the number of frames in our animation
    private int currentFrame; // the current frame we are actually in

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
