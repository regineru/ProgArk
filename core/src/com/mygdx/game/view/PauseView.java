package com.mygdx.game.view;

// Not planned in the view-section in architecture, but I made it læll since pausing the game
// is a functional requirement. Remember to add to the views in the document.

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.PauseController;
import com.mygdx.game.interactiveElements.MenuBtn;
import com.mygdx.game.interactiveElements.PlayBtn;
import com.mygdx.game.interactiveElements.SettingsBtn;
// Here we need the import of the game instance!

public class PauseView extends SuperView{

    protected PauseController pauseController;
    private Stage stage;

    private PlayBtn playBtn;
    private MenuBtn menuBtn;
    private SettingsBtn settingsBtn;

    // Constructor
    public PauseView(final PauseController pauseController) {
        this.pauseController = pauseController;
        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);

        this.playBtn = new PlayBtn();
        this.menuBtn = new MenuBtn();
        this.settingsBtn = new SettingsBtn();

        // Setting up the stage, adding the actors (buttons)
        stage = new Stage(new ScreenViewport());


        // Position the buttons
        // playBtn.setPosition(camera.position.x - playBtn.getWidth() / 2, camera.position.y);
        // menuBtn.setPosition(camera.position.x - menuBtn.getWidth() / 2, camera.position.y+20);
        // settingsBtn.setPosition(camera.position.x - settingsBtn.getWidth()/2, camera.position.y);

        //playBtn.getPlayBtn().setPosition(ImpossibleGravity.WIDTH / 10, ImpossibleGravity.HEIGHT, Align.left);
        //menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 3, ImpossibleGravity.HEIGHT, Align.left);
        playBtn.getPlayBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT/2+150, Align.center);
        settingsBtn.getSettingsBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT/2+50, Align.center);
        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT/2-50, Align.center);

        //playBtn.getPlayBtn().setSize(100, 40);
        //menuBtn.getMenuBtn().setSize(100, 40);

        startListeners();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        background.update(dt);

    }

    @Override
    // Draws background, and the "play"-button.
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background.getBackground(), 0, 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        sb.end();
        stage.draw();
        stage.act();
    }

    @Override
    public void show(){

    }

    @Override
    public void startListeners() {

        playBtn.getPlayBtn().clearListeners();
        settingsBtn.getSettingsBtn().clearListeners();
        menuBtn.getMenuBtn().clearListeners();

        Gdx.input.setInputProcessor(stage);
        stage.addActor(playBtn.getPlayBtn());
        stage.addActor(menuBtn.getMenuBtn());
        stage.addActor(settingsBtn.getSettingsBtn());

        // LISTENERS FOR CLICK GESTURES
        playBtn.getPlayBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("continueGame is clicked");
                pauseController.ContinueGame();
            }
        });

        menuBtn.getMenuBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("menuBtn is clicked");
                pauseController.BackToMenu();
            }
        });

        // LISTENERS FOR TOUCH GESTURES
        playBtn.getPlayBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("continueGame is touched.");
                pauseController.ContinueGame();
            }
        });

        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("menuBtn is touched.");
                pauseController.BackToMenu();
            }
        });

        settingsBtn.getSettingsBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("settingsBtn is touched.");
                pauseController.settings();
            }
        });
    }

    @Override
    public void dispose() {
        background.dispose();
        System.out.println("Pause View Disposed");
    }
}