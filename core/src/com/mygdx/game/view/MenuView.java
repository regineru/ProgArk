package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.controller.MenuController;
// Here we need the import of the game instance!

public class MenuView extends SuperView{
    protected MenuController menuController;
    private Texture background;
    private Texture playBtn;

    //Constructor
    public MenuView(MenuController menuController) {
        this.menuController = menuController;

        // GameInstance is the equivalent to the FlappyDemo in the tutorial.
        camera.setToOrtho(false, GameInstance.WIDTH / 2, GameInstance.HEIGHT / 2);

        // Change to suitable background later (and put background in asset-folder!!!)
        background = new Texture("bg.png");
        playBtn = new Texture("playBtn.png");
    }

    @Override
    public void handleInput() {
        // When e.g. "New Game" button is pushed, the controller should make PlayView the new view.
        if(Gdx.input.justTouched()){
            menuController.playGamePressed();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    // Draws background, the play button
    // Should add all the menu options later, but at least a "PLAY" button or something.
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
        System.out.println("Menu View Disposed");
    }
}
