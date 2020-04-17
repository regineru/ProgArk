package com.mygdx.game.interactiveElements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

// Making texture into a button
public class SettingsBtn extends Actor {
    private Texture settingsTexture;
    private Texture settingsPressTexture;
    public ImageButton settingsBtn;

    public SettingsBtn(){
        settingsTexture = new Texture(Gdx.files.internal("settingsBtn.png"));
        settingsPressTexture = new Texture(Gdx.files.internal("settingsBtn.png"));
        this.settingsBtn = new ImageButton(new TextureRegionDrawable(new TextureRegion(settingsTexture)),new TextureRegionDrawable(new TextureRegion(settingsPressTexture)));
    }
    public ImageButton getSettingsBtn(){
        return this.settingsBtn;
    }
}
