package com.mygdx.game.view;

// Not planned in the view-section in architecture, but I made it læll since pausing the game
// is a functional requirement.

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.controller.PauseController;
// Here we need the import of the game instance!

public class PauseView extends SuperView{
    protected PauseController pauseController;

    // Make a simple background and a pause-button and put it in the assets folder!
    private Texture background;
    private Texture playBtn;
    private Texture menuBtn;


    // Constructor
    public PauseView(PauseController pauseController) {
        this.pauseController = pauseController;
        camera.setToOrtho(false, GameInstance.WIDTH / 2, GameInstance.HEIGHT / 2);

        // Change to suitable background.
        background = new Texture("bg.png");
        // In PauseView, playBtn will have the continue-function.
        playBtn = new Texture("playBtn.png");
        menuBtn = new Texture("menuBtn.png");
    }

    @Override
    public void handleInput() {
        // For example, a play button, making the player return to the game
        if(Gdx.input.justTouched()){
            pauseController.ContinueGame();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    // Draws background, and the "play"-button.
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(playBtn, camera.position.x - playBtn.getWidth() / 2, camera.position.y);
        sb.draw(menuBtn, camera.position.x - playBtn.getWidth() / 2, camera.position.y+50);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        menuBtn.dispose();
        System.out.println("Pause View Disposed");
    }
}