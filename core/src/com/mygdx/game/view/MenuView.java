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
    private Texture quitBtn;
    private Texture settingsBtn;
    private Texture helpBtn;

    //Constructor
    public MenuView(MenuController menuController) {
        this.menuController = menuController;

        // GameInstance is the equivalent to the FlappyDemo in the tutorial.
        camera.setToOrtho(false, GameInstance.WIDTH / 2, GameInstance.HEIGHT / 2);

        // Change to suitable background later (and put background in asset-folder!!!)
        background = new Texture("bg.png");
        playBtn = new Texture("playBtn.png");
        // These .pngs must be made
        quitBtn = new Texture("quitBtn.png");
        settingsBtn = new Texture("settingsBtn.png");
        helpBtn = new Texture("helpBtn.png");
    }

    @Override
    public void handleInput() {
        // When e.g. "New Game" button is pushed, the controller should make PlayView the new view.
        // Must make functionality (eventlisteners) for each of the buttons above
        // one for playBtn, quitBtn, settingsBtn and helpBtn
        if(Gdx.input.justTouched()){
            menuController.playGamePressed();
        }
        if(Gdx.input.justTouched()){
            menuController.playGamePressed();
        }
        if(Gdx.input.justTouched()){
            menuController.playGamePressed();
        }
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
        // Must draw the rest of the buttons here, and position them accordingly
        sb.draw(helpBtn, camera.position.x - helpBtn.getWidth() / 2, camera.position.y+20);
        sb.draw(quitBtn, camera.position.x - quitBtn.getWidth() / 2, camera.position.y+40);
        sb.draw(settingsBtn, camera.position.x - settingsBtn.getWidth() / 2, camera.position.y+60);

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
        helpBtn.dispose();
        quitBtn.dispose();
        settingsBtn.dispose();
        System.out.println("Menu View Disposed");
    }
}
