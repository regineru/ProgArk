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
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.hide;
// Here we need the import of the game instance!

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
    }
    @Override
    public void show(){
        // Setting up the stage, adding the actors (buttons)
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(this.stage);

        // Buttons can be positioned and resized like this
        playBtn.getPlayBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT/2+150, Align.center);
        settingsBtn.getSettingsBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT/2+50, Align.center);
        helpBtn.getHelpBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2-50, Align.center);
        quitBtn.getQuitBtn().setPosition(ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2-150, Align.center);

        playBtn.getPlayBtn().setSize(100, 50);
        settingsBtn.getSettingsBtn().setSize(100, 60);
        helpBtn.getHelpBtn().setSize(100, 60);
        quitBtn.getQuitBtn().setSize(100, 60);

        stage.addActor(playBtn.getPlayBtn());
        stage.addActor(settingsBtn.getSettingsBtn());
        stage.addActor(helpBtn.getHelpBtn());
        stage.addActor(quitBtn.getQuitBtn());

        // LISTENERS FOR CLICK GESTURES TODO: FIX BUG)
        playBtn.getPlayBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button){
                System.out.println("playBtn is clicked.");
                menuController.playGamePressed();
                hide();
            }
        });

        /*playBtn.getPlayBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                System.out.println("playBtn is clicked.");
                menuController.playGamePressed();
                //dispose();
            }
        });*/
        /*settingsBtn.getSettingsBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                menuController.settingsPressed();
            }
        });*/

        helpBtn.getHelpBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //super.touchDown(event, x, y, pointer, button);
                System.out.println("helpBtn is clicked.");
                menuController.helpPressed();

            }
        });
        /*
        quitBtn.getQuitBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                System.out.println("Quit pressed");
                menuController.quit();
            }
        });
        quitBtn.getQuitBtn().addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Quit pressed");
                menuController.quit();
            }
        });

        // LISTENERS FOR TOUCH GESTURES
        settingsBtn.getSettingsBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                menuController.settingsPressed();
            }
        });
        playBtn.getPlayBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                System.out.println("playBtn is touched.");
                menuController.playGamePressed();
            }
        });
        helpBtn.getHelpBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                menuController.helpPressed();
            }
        });
        quitBtn.getQuitBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                super.tap(event, x, y, count, button);
                menuController.quit();
            }
        });*/



    }

    @Override
    public void handleInput() {
    // Bruker ikke denne da eventListeners ligger i show() i stedet.
    }

    @Override
    public void update(float dt) {
        show();
    }

    @Override
    // Draws background, the play button
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(world.getBackground(), 0, 0, world.getBackground().getWidth()/4, world.getBackground().getHeight()/4);
        sb.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        world.dispose();
        System.out.println("Menu View Disposed");
    }
}
