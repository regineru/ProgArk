package com.mygdx.game.view;

// Not planned in the view-section in architecture, but I made it læll since pausing the game
// is a functional requirement.

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// Here we need the import of the game instance!

public class PauseView extends SuperView{
    protected ViewController viewController;

    // Make a simple background and a pause-button and put it in the assets folder!
    private Texture background;
    private Texture playBtn;

    // Constructor
    public PauseView(ViewController viewController) {
        this.viewController = viewController;
        camera.setToOrtho(false, GameInstance.WIDTH / 2, GameInstance.HEIGHT / 2);

        // Change to suitable background.
        background = new Texture("bg.png");
        playBtn = new Texture("playBtn.png");
    }

    @Override
    public void handleInput() {
        // For example, a play button, making the player return to the game
        if(Gdx.input.justTouched()){
            viewController.set(new PlayView(viewController));
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
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Pause View Disposed");
    }
}