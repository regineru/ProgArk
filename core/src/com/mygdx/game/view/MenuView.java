package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.controller.MenuController;
// Here we need the import of the game instance!

public class MenuView extends SuperView{
    protected MenuController menuController;

    private Stage stage;

    // Making every texture into a button
    private Texture playTexture;
    private TextureRegion playTextureRegion;
    private TextureRegionDrawable playTexRegionDrawable;
    private ImageButton playBtn;

    private Texture quitTexture;
    private TextureRegion quitTextureRegion;
    private TextureRegionDrawable quitTexRegionDrawable;
    private ImageButton quitBtn;

    private Texture settingsTexture;
    private TextureRegion settingsTextureRegion;
    private TextureRegionDrawable settingsTexRegionDrawable;
    private ImageButton settingsBtn;

    private Texture helpTexture;
    private TextureRegion helpTextureRegion;
    private TextureRegionDrawable helpTexRegionDrawable;
    private ImageButton helpBtn;

    private Texture background;

    //Constructor
    public MenuView(final MenuController menuController) {
        this.menuController = menuController;

        // Making the play button
        playTexture = new Texture(Gdx.files.internal("playBtn.png"));
        playTextureRegion = new TextureRegion(playTexture);
        playTexRegionDrawable = new TextureRegionDrawable(playTextureRegion);
        playBtn = new ImageButton(playTexRegionDrawable);

        // Making the quit button
        quitTexture = new Texture(Gdx.files.internal("quitBtn.png"));
        quitTextureRegion = new TextureRegion(quitTexture);
        quitTexRegionDrawable = new TextureRegionDrawable(quitTextureRegion);
        quitBtn = new ImageButton(quitTexRegionDrawable);

        // Making the settings button
        settingsTexture = new Texture(Gdx.files.internal("settingsBtn.png"));
        settingsTextureRegion = new TextureRegion(settingsTexture);
        settingsTexRegionDrawable = new TextureRegionDrawable(settingsTextureRegion);
        settingsBtn = new ImageButton(settingsTexRegionDrawable);

        // Making the help button
        helpTexture = new Texture(Gdx.files.internal("helpBtn.png"));
        helpTextureRegion = new TextureRegion(helpTexture);
        helpTexRegionDrawable = new TextureRegionDrawable(helpTextureRegion);
        helpBtn = new ImageButton(helpTexRegionDrawable);

        // Setting up the stage, adding the actors (buttons)
        stage = new Stage(new ScreenViewport());
        stage.addActor(playBtn);
        stage.addActor(quitBtn);
        stage.addActor(settingsBtn);
        Gdx.input.setInputProcessor(stage);

        // GameInstance is the equivalent to the FlappyDemo in the tutorial.
        camera.setToOrtho(false, GameInstance.WIDTH / 2, GameInstance.HEIGHT / 2);

        // Change to suitable background later (and put background in asset-folder!!!)
        background = new Texture("bg.png");
    }

    @Override
    public void handleInput() {
        // Add listeners to buttons
        // May have to move the listeners outside of a handleInput()-method.
        // Double clicks can be detected using getTapCount()playBtn.addListener(new ClickListener(){

        playBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("PlayBtn is pressed.");
                menuController.playGamePressed();
            }
        });

        quitBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("quitBtn is pressed.");
                menuController.quit();
            }
        });

        settingsBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("settingsBtn is pressed.");
                menuController.settingsPressed();
            }
        });

        helpBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("helpBtn is pressed.");
                menuController.helpPressed();
            }
        });
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
        sb.draw(playTexture, camera.position.x - playBtn.getWidth() / 2, camera.position.y);
        // Must draw the rest of the buttons here, and position them accordingly
        sb.draw(helpTexture, camera.position.x - helpBtn.getWidth() / 2, camera.position.y+20);
        sb.draw(quitTexture, camera.position.x - quitBtn.getWidth() / 2, camera.position.y+40);
        sb.draw(settingsTexture, camera.position.x - settingsBtn.getWidth() / 2, camera.position.y+60);

        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playTexture.dispose();
        helpTexture.dispose();
        quitTexture.dispose();
        settingsTexture.dispose();
        System.out.println("Menu View Disposed");
    }
}
