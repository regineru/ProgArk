package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.HelpController;
import com.mygdx.game.interactiveElements.MenuBtn;

public class HelpView extends SuperView{

    protected HelpController helpController;
    private Stage stage;
    private MenuBtn menuBtn;


    public HelpView(final HelpController helpController) {
        this.helpController = helpController;
        this.menuBtn = new MenuBtn();

        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);
    }

    @Override
    public void show(){
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2, Align.top);

        // LISTENERS FOR CLICK GESTURES (LAGGED AND WILL REMOVE BEFORE COMPLETING PROJECT
        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                helpController.backToMenu();
            }
        });
        // FOR TOUCH GESTURES
        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                helpController.backToMenu();
            }
        });

        stage.addActor(menuBtn.getMenuBtn());

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
        BitmapFont font = new BitmapFont();
        sb.begin();
        sb.draw(world.getBackground(), 0, 0, world.getBackground().getWidth()/4, world.getBackground().getHeight()/4);
        //TODO: WRITE HELP TEXT
        font.draw(sb, "TODO: WRITE HELP TEXT HERE", 130, Align.center);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        world.dispose();
        System.out.println("Help View Disposed");
    }

}
