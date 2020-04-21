package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.SettingsController;
import com.mygdx.game.interactiveElements.MenuBtn;

public class SettingsView extends SuperView{
    protected SettingsController settingsController;

    private Stage stage;
    private MenuBtn menuBtn;

    // These buttons are added later
    private Texture volumeBtn;
    private Texture toggleBtn;

    public SettingsView(final SettingsController settingsController) {

        this.settingsController = settingsController;
        this.menuBtn = new MenuBtn();

        // GameInstance is the equivalent to the FlappyDemo in the tutorial.
        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);

        // Add specific settings
        //volumeBtn = new Texture("volumeBtn.png"); // Should be a slider
        //toggleBtn = new Texture("toggleBtn.png");
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2+50, Align.top);

        // LISTENERS FOR CLICK GESTURES
        menuBtn.getMenuBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("menuBtn is clicked");
                settingsController.backToMenu();
            }
        });

        // LISTENERS FOR TAP GESTURES
        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("menuBtn is touched.");
                settingsController.backToMenu();
            }
        });

        stage.addActor(menuBtn.getMenuBtn());
    }
    @Override
    public void show(){

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        show();
    }

    @Override
    // Draws background, the menu button
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(world.getBackground(), 0, 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        world.dispose();
        System.out.println("Settings View Disposed");
    }

}
