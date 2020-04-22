package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.MenuController;
import com.mygdx.game.interactiveElements.HelpBtn;
import com.mygdx.game.interactiveElements.PlayBtn;
import com.mygdx.game.interactiveElements.QuitBtn;
import com.mygdx.game.interactiveElements.SettingsBtn;

public class MenuView extends SuperView{

    protected MenuController menuController;
    private Stage stage;

    // Import the necessary buttons for this view
    private PlayBtn playBtn;
    private QuitBtn quitBtn;
    private SettingsBtn settingsBtn;
    private HelpBtn helpBtn;

    //Constructor
    public MenuView(final MenuController menuController) {
        this.menuController = menuController;

        this.playBtn = new PlayBtn();
        this.settingsBtn = new SettingsBtn();
        this.helpBtn = new HelpBtn();
        this.quitBtn = new QuitBtn();

        // GameInstance is the equivalent to the FlappyDemo in the tutorial.
        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);

        // Setting up the stage, adding the actors (buttons)
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        // Buttons can be positioned and resized like this
        playBtn.getPlayBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT/2+150, Align.center);
        settingsBtn.getSettingsBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT/2+50, Align.center);
        helpBtn.getHelpBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2-50, Align.center);
        quitBtn.getQuitBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2-150, Align.center);

        // Resize if necessary
        /*playBtn.getPlayBtn().setSize(110, 50);
        settingsBtn.getSettingsBtn().setSize(110, 60);
        helpBtn.getHelpBtn().setSize(110, 60);
        quitBtn.getQuitBtn().setSize(110, 60);*/

        stage.addActor(playBtn.getPlayBtn());
        stage.addActor(settingsBtn.getSettingsBtn());
        stage.addActor(helpBtn.getHelpBtn());
        stage.addActor(quitBtn.getQuitBtn());

        // LISTENERS FOR CLICK GESTURES
        playBtn.getPlayBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("playBtn is clicked.");
                menuController.playGamePressed();
            }
        });

        settingsBtn.getSettingsBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("settingsBtn is clicked.");
                menuController.settingsPressed();
            }
        });

        helpBtn.getHelpBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("helpBtn is clicked.");
                menuController.helpPressed();

            }
        });

        quitBtn.getQuitBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("quitBtn is clicked");
                menuController.quit();
            }
        });

        // LISTENERS FOR TOUCH GESTURES
        playBtn.getPlayBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("playBtn is touched.");
                menuController.playGamePressed();
            }
        });

        settingsBtn.getSettingsBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("settingsBtn is touched.");
                menuController.settingsPressed();
            }
        });

        helpBtn.getHelpBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("helpBtn is touched.");
                menuController.helpPressed();
            }
        });

        quitBtn.getQuitBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("quitBtn is touched.");
                menuController.quit();
            }
        });
    }
    @Override
    public void show(){
        // Bruker ikke denne da eventListeners ligger i konstruktøren i stedet.
    }

    @Override
    public void handleInput() {
        // Bruker ikke denne da eventListeners ligger i konstruktøren i stedet.
    }

    @Override
    public void update(float dt) {
        show();
    }

    @Override
    // Draws background, the play button
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        //sb.draw(world.getBackground(), 0, 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        sb.draw(background.getBackground(), camera.position.x-(camera.viewportWidth/2), 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        background.dispose();
        System.out.println("Menu View Disposed");
    }
}
