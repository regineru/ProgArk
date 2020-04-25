package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.LoadingController;
// LoadingScreen can be displayed when a while-loop is true in another controller.

public class LoadingScreen extends SuperView{

    protected LoadingController loadingController;
    private Stage stage;
    private Texture loadingBar;
    private Image loadingBarImage;

    @Override
    public void show(){

    }

    @Override
    public void startListeners() {
        Gdx.input.setInputProcessor(stage);
        stage.addActor(loadingBarImage);

    }

    // Constructor
    public LoadingScreen(final LoadingController loadingController){

        this.loadingController = loadingController;
        this.loadingBar = new Texture("loadingBar.png");
        this.loadingBarImage = new Image(loadingBar);
        this.stage = new Stage(new ScreenViewport());

        loadingBarImage.setSize((float) Gdx.graphics.getWidth() / 10 * 7, (float)Gdx.graphics.getHeight() / 2);
        loadingBarImage.setPosition((float)Gdx.graphics.getWidth() / 2, (float)Gdx.graphics.getHeight() / 5 * 3, Align.center);
        //startListeners();
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    // Draws background, the loading texture.
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
        background.dispose();
        loadingBar.dispose();
        System.out.println("Loading View Disposed");
    }
}
