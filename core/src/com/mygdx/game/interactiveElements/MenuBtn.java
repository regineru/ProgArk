package com.mygdx.game.interactiveElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuBtn extends Actor {

    private Texture menuTexture;
    private Texture menuPressTexture;
    public ImageButton menuBtn;

    public MenuBtn(){
        // Making the menu button
        menuTexture = new Texture(Gdx.files.internal("playBtn.png"));
        menuPressTexture = new Texture(Gdx.files.internal("playBtn.png"));
        this.menuBtn = new ImageButton(new TextureRegionDrawable(new TextureRegion(menuTexture)),new TextureRegionDrawable(new TextureRegion(menuPressTexture)));
    }
    public ImageButton getMenuBtn(){
        return this.menuBtn;
    }
}
