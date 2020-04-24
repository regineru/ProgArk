package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.controller.PlayerController;
import com.mygdx.game.controller.ViewController;
import com.mygdx.game.interactiveElements.MenuBtn;
import com.mygdx.game.interactiveElements.PauseBtn;
import com.mygdx.game.model.Obstacle;
import com.mygdx.game.model.World;

/**
 * Description
 */
public class PlayView extends SuperView {

    protected GameController gameController;
    private PlayerController pc;
    private Stage stage;
    private World world;

    private MenuBtn menuBtn;
    private PauseBtn pauseBtn;

    public PlayView(ViewController vc){

        this.world = new World();
        this.gameController = new GameController(vc, world);
        this.pc = new PlayerController(vc);
        this.pauseBtn = new PauseBtn();
        this.menuBtn = new MenuBtn();

        stage = new Stage(new ScreenViewport());

        int btnHeight = Gdx.graphics.getHeight() / 10;
        int btnWidth = btnHeight * 2;

        menuBtn.getMenuBtn().setSize(btnWidth, btnHeight);
        pauseBtn.getPauseBtn().setSize(btnWidth, btnHeight);

        menuBtn.getMenuBtn().setPosition(
                (float)btnWidth/4,
                Gdx.graphics.getHeight() - (float)btnHeight/4,
                Align.topLeft);

        pauseBtn.getPauseBtn().setPosition(
                btnWidth + (float)btnWidth/4*2,
                Gdx.graphics.getHeight() - (float)btnHeight/4,
                Align.topLeft);

        startListeners();
    }

    /**
     * Description
     */
    public void startListeners(){

        pauseBtn.getPauseBtn().clearListeners();
        menuBtn.getMenuBtn().clearListeners();

        Gdx.input.setInputProcessor(stage);
        stage.addActor(pauseBtn.getPauseBtn());
        stage.addActor(menuBtn.getMenuBtn());

        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("menuBtn is clicked");
                gameController.quitGame();
            }
        });

        pauseBtn.getPauseBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("pauseBtn is clicked");
                gameController.pauseGame();
            }
        });

        // LISTENERS FOR TOUCH GESTURES
        pauseBtn.getPauseBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("pauseBtn is touched.");
                gameController.pauseGame();
            }
        });

        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("menuBtn is touched.");
                gameController.quitGame();
            }
        });
    }

    @Override
    protected void handleInput() {
        // Every input from the user should call on a function for the character.
        // The action is defined in the model-class of the character.

        int deltaY = swipe();

        if (deltaY != 0) {
            System.out.println(deltaY);
            pc.swipe(world.getCharacter(), deltaY);
        } else if (Gdx.input.justTouched()) {
            pc.touch(world.getCharacter());
        }
    }
    /**
     * Description
     */
    public int swipe() {
        if (Gdx.input.justTouched() && (Gdx.input.getDeltaY() > 10 || Gdx.input.getDeltaY() < -10)) {
            return Gdx.input.getDeltaY();
        }
        return 0;
    }

    @Override
    public void update(float dt) {
        handleInput();

        world.update(dt, camera, gameController);
        background.update(dt);

        camera.position.set(world.getCharacter().getPosition().x + 100, ImpossibleGravity.HEIGHT/2, 0);
        camera.update();
    }

    @Override
    // Each view is responsible for knowing what it needs to draw.
    public void render (SpriteBatch sb){
        // camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw(background.getBackground(), camera.position.x-(camera.viewportWidth/2), 0, ImpossibleGravity.WIDTH, ImpossibleGravity.HEIGHT);

        for (Obstacle obstacle : world.getObstacleFactory().getObstacles()) {
            sb.draw(obstacle.getObstacle(), obstacle.getPosition().x, obstacle.getPosition().y, obstacle.getWidth(), obstacle.getHeight());
        }

        sb.draw(world.getCharacter().getSprite(), world.getCharacter().getPosition().x, world.getCharacter().getPosition().y);

        sb.draw(world.getGrass().getGround(), world.getGrass().getGroundPos1().x, world.getGrass().getGroundPos1().y);
        sb.draw(world.getGrass().getGround(), world.getGrass().getGroundPos2().x, world.getGrass().getGroundPos2().y);
        sb.draw(world.getHeaven().getGround(), world.getHeaven().getGroundPos1().x, world.getHeaven().getGroundPos1().y);
        sb.draw(world.getHeaven().getGround(), world.getHeaven().getGroundPos2().x, world.getHeaven().getGroundPos2().y);

        sb.end();

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose(){
        background.dispose();
        world.dispose();
        System.out.println("PlayView Disposed");
    }

    @Override
    public void show() {}
}
