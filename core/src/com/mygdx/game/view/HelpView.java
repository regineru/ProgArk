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

import java.awt.Label;

public class HelpView extends SuperView{

    protected HelpController helpController;
    private Stage stage;
    private MenuBtn menuBtn;
    private Texture helpTexture;
    private Image helpText;


    public HelpView(final HelpController helpController) {
        this.helpController = helpController;
        this.menuBtn = new MenuBtn();

        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2-200, Align.bottom);

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
        this.helpTexture = new Texture(Gdx.files.internal("pixil-frame-o.png"));
        this.helpText = new Image(new TextureRegionDrawable(new TextureRegion(helpTexture)));
        /*Label helpText = new Label();
        helpText.setText("TODO: WRITE HELP TEXT HERE");*/

        stage.addActor(helpText);
        stage.addActor(menuBtn.getMenuBtn());
    }

    @Override
    public void show(){
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
        //Text helpText = new Text();

        BitmapFont font = new BitmapFont();
        font.setColor(1,1,1,1);


        sb.begin();
        sb.draw(world.getBackground(), 0, 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        sb.end();
        stage.act();
        stage.draw();
        sb.begin();
        font.draw(sb, "TODO: WRITE HELP TEXT HERE", 5, 5-ImpossibleGravity.HEIGHT / 2);
        sb.end();
        //TODO: WRITE HELP TEXT

    }

    @Override
    public void dispose() {
        world.dispose();
        System.out.println("Help View Disposed");
    }

}
