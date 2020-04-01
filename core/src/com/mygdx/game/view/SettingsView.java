package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.controller.SettingsController;

public class SettingsView extends SuperView{
    protected SettingsController settingsController;
    private Texture background;
    private Texture menuBtn;
    private Texture volumeBtn;
    private Texture toggleBtn;

    //Constructor
    public SettingsView(SettingsController settingsController) {
        this.settingsController = settingsController;

        // GameInstance is the equivalent to the FlappyDemo in the tutorial.
        camera.setToOrtho(false, GameInstance.WIDTH / 2, GameInstance.HEIGHT / 2);

        // Change to suitable background later (and put background in asset-folder!!!)
        background = new Texture("bg.png");
        menuBtn = new Texture("menuBtn.png");
        // Add specific settings
        volumeBtn = new Texture("volumeBtn.png"); // Should be a slider
        toggleBtn = new Texture("toggleBtn.png");

    }
    @Override
    public void handleInput() {
        // One for each button/setting
        if(Gdx.input.justTouched()){
            settingsController.playGamePressed();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    // Draws background, the menu button
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(menuBtn, camera.position.x - menuBtn.getWidth() / 2, camera.position.y);
        sb.draw(volumeBtn, camera.position.x - volumeBtn.getWidth() / 2, camera.position.y+20);
        sb.draw(toggleBtn, camera.position.x - toggleBtn.getWidth() / 2, camera.position.y+40);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        menuBtn.dispose();
        toggleBtn.dispose();
        volumeBtn.dispose();
        System.out.println("Settings View Disposed");
    }

}
