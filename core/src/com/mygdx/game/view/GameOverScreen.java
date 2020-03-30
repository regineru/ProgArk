package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
// Here we need the game instance import!

// This view will display the "Game over"-screen.
public class GameOverScreen extends SuperView{
    protected ViewController viewController;

    // Make a simple background and a game over-logo and put it in the assets folder!
    private Texture background;
    private Texture gameOver;
    // Need to make a backToMenu-button and put it in assets folder!
    private Texture backToMenuBtn;

    // Constructor
    public GameOverScreen(ViewController viewController) {
        this.viewController = viewController;
        camera.setToOrtho(false, GameInstance.WIDTH / 2, GameInstance.HEIGHT / 2);
        // Change to suitable background.
        background = new Texture("bg.png");
        gameOver = new Texture("gameOver.png");

        // This btn has not been made yet.
        backToMenuBtn = new Texture("backToMenuBtn.png");
    }

    @Override
    public void handleInput() {
        // For example, there could be a button that displays a "Back to menu" option.
        // Upon clicking it, the new view will be MenuView.
        if(Gdx.input.justTouched()){
            viewController.set(new MenuView(viewController));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    // Draws background, and the "Back to menu"-button.
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(gameOver, camera.position.x - gameOver.getWidth() / 2, camera.position.y);
        sb.draw(backToMenuBtn, camera.position.x - backToMenuBtn.getWidth() / 2, camera.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();
        backToMenuBtn.dispose();
        System.out.println("Game Over View Disposed");
    }
}
