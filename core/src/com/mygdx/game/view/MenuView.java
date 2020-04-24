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
import com.mygdx.game.interactiveElements.StartBtn;

public class MenuView extends SuperView{

    protected MenuController menuController;
    private Stage stage;

    // Import the necessary buttons for this view
    private PlayBtn playBtn;
    private QuitBtn quitBtn;
    private SettingsBtn settingsBtn;
    private HelpBtn helpBtn;
    private StartBtn startBtn;

    //Constructor
    public MenuView(final MenuController menuController) {

        this.menuController = menuController;
        this.playBtn = new PlayBtn();
        this.settingsBtn = new SettingsBtn();
        this.helpBtn = new HelpBtn();
        this.quitBtn = new QuitBtn();
        this.startBtn = new StartBtn();

        int btnHeight = Gdx.graphics.getHeight() / 6;
        int btnWidth = btnHeight * 2;

        playBtn.getPlayBtn().setSize(btnWidth, btnHeight);
        settingsBtn.getSettingsBtn().setSize(btnWidth, btnHeight);
        helpBtn.getHelpBtn().setSize(btnWidth, btnHeight);
        quitBtn.getQuitBtn().setSize(btnWidth, btnHeight);
        startBtn.getStartBtn().setSize(btnWidth, btnHeight);

        playBtn.getPlayBtn().setPosition((float)Gdx.graphics.getWidth() / 2,
                (float)Gdx.graphics.getHeight() / 5 * 4, Align.center);
        settingsBtn.getSettingsBtn().setPosition((float)Gdx.graphics.getWidth() / 2,
                (float)Gdx.graphics.getHeight() / 5 * 3, Align.center);
        helpBtn.getHelpBtn().setPosition((float)Gdx.graphics.getWidth() / 2,
                (float)Gdx.graphics.getHeight() / 5 * 2, Align.center);
        quitBtn.getQuitBtn().setPosition((float)Gdx.graphics.getWidth() / 2,
                (float)Gdx.graphics.getHeight() / 5 * 1, Align.center);
        startBtn.getStartBtn().setPosition((float)Gdx.graphics.getWidth() / 8,
                (float)Gdx.graphics.getHeight() / 5 * 4, Align.center);

        this.stage = new Stage(new ScreenViewport());
        startListeners();

    }

    @Override
    public void show(){
    }

    @Override
    public void startListeners() {

        playBtn.getPlayBtn().clearListeners();
        settingsBtn.getSettingsBtn().clearListeners();
        helpBtn.getHelpBtn().clearListeners();
        quitBtn.getQuitBtn().clearListeners();
        startBtn.getStartBtn().clearListeners();

        Gdx.input.setInputProcessor(this.stage);
        stage.addActor(playBtn.getPlayBtn());
        stage.addActor(settingsBtn.getSettingsBtn());
        stage.addActor(helpBtn.getHelpBtn());
        stage.addActor(quitBtn.getQuitBtn());
        stage.addActor(startBtn.getStartBtn());

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

        startBtn.getStartBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("startBtn is clicked.");
                menuController.startPressed();
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

        startBtn.getStartBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("startBtn is touched.");
                menuController.startPressed();
            }
        });
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void update(float dt) {
        show();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background.getBackground(), camera.position.x-(camera.viewportWidth/2), 0, ImpossibleGravity.WIDTH, ImpossibleGravity.HEIGHT);
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
