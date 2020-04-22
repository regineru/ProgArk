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

public class PlayView extends SuperView {

    //CONTROLLERS AND STAGE
    protected GameController gameController;
    private PlayerController pc;
    private Stage stage;
    private World world;

    private int touchPos;

    // BUTTONS
    private MenuBtn menuBtn;
    private PauseBtn pauseBtn;

    //  CONSTRUCTOR
    public PlayView(ViewController vc){

        camera.setToOrtho(false, ImpossibleGravity.WIDTH, ImpossibleGravity.HEIGHT);

        this.world = new World();
        this.gameController = new GameController(vc, world);
        this.pc = new PlayerController(vc);
        this.pauseBtn = new PauseBtn();
        this.menuBtn = new MenuBtn();


        stage = new Stage(new ScreenViewport());

        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 10, ImpossibleGravity.HEIGHT, Align.left);
        pauseBtn.getPauseBtn().setPosition(ImpossibleGravity.WIDTH / 3, ImpossibleGravity.HEIGHT, Align.left);

        menuBtn.getMenuBtn().setSize(100, 40);
        pauseBtn.getPauseBtn().setSize(100, 40);

        stage = new Stage(new ScreenViewport());
        startListeners();
    }

    public void startListeners(){

        pauseBtn.getPauseBtn().clearListeners();
        menuBtn.getMenuBtn().clearListeners();

        // Setting up the stage, adding the actors (buttons)
        Gdx.input.setInputProcessor(stage);
        stage.addActor(pauseBtn.getPauseBtn());
        stage.addActor(menuBtn.getMenuBtn());

        // LISTENERS FOR CLICK GESTURES
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

        camera.position.set(world.getCharacter().getPosition().x + 100, ImpossibleGravity.HEIGHT/2, 0);
        camera.update();
    }

    @Override
    // Each view is responsible for knowing what it needs to draw.
    public void render (SpriteBatch sb){

        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw(background.getBackground(), camera.position.x-(camera.viewportWidth/2), camera.position.y-(camera.viewportHeight/2), ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);

        sb.draw(world.getCharacter().getSprite(), world.getCharacter().getPosition().x, world.getCharacter().getPosition().y);

        sb.draw(world.getGrass().getGround(), world.getGrass().getGroundPos1().x, world.getGrass().getGroundPos1().y);
        sb.draw(world.getGrass().getGround(), world.getGrass().getGroundPos2().x, world.getGrass().getGroundPos2().y);
        sb.draw(world.getHeaven().getGround(), world.getHeaven().getGroundPos1().x, world.getHeaven().getGroundPos1().y);
        sb.draw(world.getHeaven().getGround(), world.getHeaven().getGroundPos2().x, world.getHeaven().getGroundPos2().y);

        for (Obstacle obstacle : world.getObstacleFactory().getObstacles()) {
            sb.draw(obstacle.getSpikes(), obstacle.getPosition().x, obstacle.getPosition().y, obstacle.getHeight(), obstacle.getWidth());
        }
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
