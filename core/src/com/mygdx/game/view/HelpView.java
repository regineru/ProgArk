package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.HelpController;
import com.mygdx.game.interactiveElements.MenuBtn;
import com.mygdx.game.interactiveElements.Text;

import java.awt.Label;

public class HelpView extends SuperView{

    protected HelpController helpController;
    private Stage stage;
    private MenuBtn menuBtn;
    //private Text helpText;
    private Texture helpTexture;


    public HelpView(final HelpController helpController) {
        this.helpController = helpController;
        this.menuBtn = new MenuBtn();
        //this.helpText = new Text();
        this.helpTexture = new Texture(Gdx.files.internal("helpText.png"));

        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);
        stage = new Stage(new ScreenViewport());

        //helpText.getHelpText().setPosition((Gdx.graphics.getWidth()/ - helpText.getHelpText().getWidth()), Gdx.graphics.getHeight() - helpText.getHelpText().getHeight());
        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2-200, Align.bottom);

        //stage.addActor(helpText.getHelpText());
        startListeners();
    }

    @Override
    public void show(){
    }

    @Override
    public void startListeners() {

        menuBtn.getMenuBtn().clearListeners();

        Gdx.input.setInputProcessor(stage);
        stage.addActor(menuBtn.getMenuBtn());

        // LISTENERS FOR CLICK GESTURES
        menuBtn.getMenuBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("menuBtn is clicked");
                helpController.backToMenu();
            }
        });

        // LISTENERS FOR TAP GESTURES
        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("menuBtn is touched.");
                helpController.backToMenu();
            }
        });

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
        sb.begin();
        sb.draw(background.getBackground(), 0, 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        sb.draw(helpTexture, Align.right+5,70, 200, 135);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        System.out.println("Help View Disposed");
    }

}
