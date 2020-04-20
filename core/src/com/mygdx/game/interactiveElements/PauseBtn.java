package com.mygdx.game.interactiveElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PauseBtn extends Actor {

    private Texture pauseTexture;
    //private TextureRegion pauseTextureRegion;
    //private TextureRegionDrawable pauseTexRegionDrawable;
    public Image pauseBtn;

    public PauseBtn() {
        // Making the play button
        pauseTexture = new Texture(Gdx.files.internal("pauseBtn.png"));
        //pauseTextureRegion = new TextureRegion(pauseTexture);
        //pauseTexRegionDrawable = new TextureRegionDrawable(pauseTextureRegion);
        this.pauseBtn = new Image(new TextureRegionDrawable(new TextureRegion(pauseTexture)));
    }

    public Image getPauseBtn(){
        return this.pauseBtn;
    }
}
