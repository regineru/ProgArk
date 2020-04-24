package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.StartController;
import com.mygdx.game.interactiveElements.MultiplayerBtn;
import com.mygdx.game.interactiveElements.SingleplayerBtn;

public class StartView extends SuperView {

    protected StartController startController;
    private Stage stage;

    private SingleplayerBtn singleplayerBtn;
    private MultiplayerBtn multiplayerBtn;

    public StartView(StartController startController) {

        this.startController = startController;
        this.singleplayerBtn = new SingleplayerBtn();
        this.multiplayerBtn = new MultiplayerBtn();

        /*
        int btnHeight = Gdx.graphics.getHeight() / 6;
        int btnWidth = btnHeight * 2;

        singleplayerBtn.getSingleplayerBtn().setSize(btnWidth, btnHeight);
        multiplayerBtn.getMultiplayerBtn().setSize(btnWidth, btnHeight);

         */

        singleplayerBtn.getSingleplayerBtn().setPosition((float)Gdx.graphics.getWidth() / 2,
                (float)Gdx.graphics.getHeight() /5 * 3, Align.center);
        multiplayerBtn.getMultiplayerBtn().setPosition((float)Gdx.graphics.getWidth() / 2,
                (float)Gdx.graphics.getHeight() / 5 * 2, Align.center);

        this.stage = new Stage(new ScreenViewport());
        startListeners();

    }

    @Override
    protected void handleInput() {

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
        System.out.println("Start View Disposed");

    }

    @Override
    public void show() {

    }

    @Override
    public void startListeners() {

        singleplayerBtn.getSingleplayerBtn().clearListeners();
        multiplayerBtn.getMultiplayerBtn().clearListeners();

        Gdx.input.setInputProcessor(this.stage);
        stage.addActor(singleplayerBtn.getSingleplayerBtn());
        stage.addActor(multiplayerBtn.getMultiplayerBtn());

        singleplayerBtn.getSingleplayerBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("singleplayerBtn is clicked.");
                startController.singlePlayerPressed();
            }
        });

        multiplayerBtn.getMultiplayerBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("multiplayerBtn is clicked.");
                startController.multiPlayerPressed();
            }
        });

        singleplayerBtn.getSingleplayerBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("singleplayerBtn is touched.");
                startController.singlePlayerPressed();
            }
        });

        multiplayerBtn.getMultiplayerBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("multiplayerBtn is touched.");
                startController.multiPlayerPressed();
            }
        });

    }
}
