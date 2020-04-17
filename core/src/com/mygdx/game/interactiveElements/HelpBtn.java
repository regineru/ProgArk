package com.mygdx.game.interactiveElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

// Making texture into a button
public class HelpBtn extends Actor {
    private Texture helpTexture;
    private Texture helpPressTexture;
    public ImageButton helpBtn;

    public HelpBtn(){
        helpTexture = new Texture(Gdx.files.internal("helpBtn.png"));
        helpPressTexture = new Texture(Gdx.files.internal("helpBtn.png"));
        this.helpBtn = new ImageButton(new TextureRegionDrawable(new TextureRegion(helpTexture)),new TextureRegionDrawable(new TextureRegion(helpPressTexture)));
    }

    public ImageButton getHelpBtn(){
        return this.helpBtn;
    }
}
