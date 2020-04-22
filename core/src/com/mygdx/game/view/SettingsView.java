package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.SettingsController;
import com.mygdx.game.interactiveElements.MenuBtn;
import com.mygdx.game.model.SettingsModel;

public class SettingsView extends SuperView{
    protected SettingsController settingsController;

    private Stage stage;
    private MenuBtn menuBtn;
    private CheckBox checkBox;
    private TextureRegionDrawable checked;
    private TextureRegionDrawable unchecked;
    private SettingsModel model;

    public SettingsView(final SettingsController settingsController) {

        this.settingsController = settingsController;
        this.menuBtn = new MenuBtn();
        this.model = settingsController.getModel();
        CheckBoxStyle checkBoxStyle = new CheckBoxStyle();
        this.checked = new TextureRegionDrawable(new TextureRegion(new Texture("checked.png")));
        this.unchecked = new TextureRegionDrawable(new TextureRegion(new Texture("unchecked.png")));


        checkBoxStyle.checkboxOn = checked;
        checkBoxStyle.checkboxOff = unchecked;
        checkBoxStyle.font = model.getFont();
        this.checkBox = new CheckBox(" GAME MUSIC", checkBoxStyle);
        this.checkBox.setChecked(true);

        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 4+50, Align.top);
        checkBox.setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT - ImpossibleGravity.HEIGHT / 4, Align.top);
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
        stage.addActor(checkBox);

        // CHECKBOX LISTENER
        checkBox.addListener(new ChangeListener() {
            public void changed (ChangeEvent event, Actor actor) {
                settingsController.toggleGameMusic();
            }
        });
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
        sb.draw(background.getBackground(), 0, 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        background.dispose();
        System.out.println("Settings View Disposed");
    }

}
