package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.controller.GameOverController;
import com.mygdx.game.interactiveElements.MenuBtn;
// Here we need the game instance import!

public class GameOverScreen extends SuperView{
    protected GameOverController gameOverController;
    private Stage stage;
    private MenuBtn menuBtn;
    private Texture gameOver;

    // Constructor
    public GameOverScreen(final GameOverController gameOverController) {
        this.gameOverController = gameOverController;
        this.menuBtn = new MenuBtn();

        camera.setToOrtho(false, ImpossibleGravity.WIDTH / 2, ImpossibleGravity.HEIGHT / 2);

        gameOver = new Texture("gameOver.png");
        Image gameOverImage = new Image(gameOver);

        // Setting up the stage, adding the actors (buttons)
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        // Position the button and text
        gameOverImage.setPosition(ImpossibleGravity.WIDTH /4+30, ImpossibleGravity.HEIGHT / 2+50, Align.top);
        menuBtn.getMenuBtn().setPosition(ImpossibleGravity.WIDTH / 2+26, ImpossibleGravity.HEIGHT / 4, Align.center);

        gameOverImage.setSize(350, 180);
        menuBtn.getMenuBtn().setSize(150, 80);

        // LISTENERS FOR CLICK GESTURES
        menuBtn.getMenuBtn().addListener(new ActorGestureListener(){
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("menuBtn is clicked");
                gameOverController.BackToMenu();
            }
        });

        // LISTENERS FOR TAP GESTURES
        menuBtn.getMenuBtn().addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                System.out.println("menuBtn is touched.");
                gameOverController.BackToMenu();
            }
        });

        stage.addActor(gameOverImage);
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

    }

    @Override
    // Draws background, and the "Back to menu"-button.
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(world.getBackground(), 0, 0, ImpossibleGravity.HEIGHT, ImpossibleGravity.HEIGHT);
        //sb.draw(gameOver, camera.position.x - gameOver.getWidth() / 2, camera.position.y+200);
        //sb.draw(gameOver, 50,50);
        sb.end();
        stage.draw();
        stage.act();
    }

    @Override
    public void dispose() {
        System.out.println("Game Over View Disposed");
    }
}
