package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.controller.CharacterController;
import com.mygdx.game.controller.ViewController;
import com.mygdx.game.interactiveElements.MenuBtn;
import com.mygdx.game.interactiveElements.PauseBtn;
import com.mygdx.game.model.Obstacle;
import com.mygdx.game.model.World;

/**
 * The view shown when a game is playing
 * Contains all the textures from the world and a few buttons in addition to the SuperView
 * Several methods that handles input from the user to control the character in the came
 */
public class PlayView extends SuperView {

    protected GameController gameController;
    private CharacterController pc;
    private Stage stage;
    private World world;
    private boolean multiplayer;

    private MenuBtn menuBtn;
    private PauseBtn pauseBtn;

    public PlayView(ViewController vc, boolean multiplayer){

        this.world = new World();
        this.gameController = new GameController(vc, world);
        this.pc = new CharacterController(vc);

        //TODO fiks multiplayer
        this.multiplayer = multiplayer;
        System.out.println(multiplayer);

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

        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(new GestureDetector(new GestureDetector.GestureAdapter() {
            @Override
            public boolean tap(float x, float y, int count, int button) {
                world.getCharacter().jump();
                return true;
            }
            @Override
            public boolean fling(float velocityX, float velocityY, int button) {
                if (velocityY > 10){world.getCharacter().switchGravity(0);}
                if (velocityY < -10){world.getCharacter().switchGravity(1);}
                return true;
            }
        }));
        Gdx.input.setInputProcessor(multiplexer);

        stage.addActor(pauseBtn.getPauseBtn());
        stage.addActor(menuBtn.getMenuBtn());
        /*
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

         */

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

    /**
     * Inputs from the user calls on a function for the character
     * The action is defined in the characters Player model
     */
    @Override
    protected void handleInput() {

    }

    /**
     * Description
     */
    @Override
    public void update(float dt) {
        handleInput();

        world.update(dt, camera, gameController);
        background.update(dt);

        camera.position.set(world.getCharacter().getPosition().x + 100, ImpossibleGravity.HEIGHT/2, 0);
        camera.update();
    }

    /**
     * Each view is responsible for knowing what it needs to draw
     * The playView draws all the textures from the world model and the background
     *
     * @param sb SpriteBatch
     */
    @Override
    public void render (SpriteBatch sb){
        sb.setProjectionMatrix(camera.combined);
        sb.begin();

        sb.draw(background.getBackground(), camera.position.x-(camera.viewportWidth/2), 0, ImpossibleGravity.WIDTH, ImpossibleGravity.HEIGHT);

        for (Obstacle obstacle : world.getObstacleFactory().getObstacles()) {
            sb.draw(obstacle.getObstacle(), obstacle.getPosition().x, obstacle.getPosition().y, obstacle.getWidth(), obstacle.getHeight());
        }

        sb.draw(world.getCharacter().getSprite(), world.getCharacter().getPosition().x, world.getCharacter().getPosition().y);

        world.getCharacter().getScoreFont().setColor(Color.BLACK);
        world.getCharacter().getScoreFont().draw(sb, world.getCharacter().getScoreString(), camera.position.x+(ImpossibleGravity.WIDTH/3), ImpossibleGravity.HEIGHT-30);

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