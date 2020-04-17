package com.mygdx.game.interactiveElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

// Making texture into a button
public class QuitBtn extends Actor {
    private Texture quitTexture;
    private Texture quitPressTexture;
    public ImageButton quitBtn;

    public QuitBtn(){
        quitTexture = new Texture(Gdx.files.internal("quitBtn.png"));
        quitPressTexture = new Texture(Gdx.files.internal("quitBtn.png"));
        this.quitBtn = new ImageButton(new TextureRegionDrawable(new TextureRegion(quitTexture)),new TextureRegionDrawable(new TextureRegion(quitPressTexture)));
    }
    public ImageButton getQuitBtn(){
        return this.quitBtn;
    }
}
