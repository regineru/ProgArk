package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//The FlappyDemo-import is the game itself/game screen.
//import com.brentaureli.game.FlappyDemo;

//This class will show the "game over" text
public class GameOverScreen extends SuperView{
    private Texture background;
    private Texture gameOver;

    //Constructor
    public GameOverScreen(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        //change to suitable background
        background = new Texture("bg.png");
        gameOver = new Texture("gameOver.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    //Draws background, the play button
    //Should add all the menu options later
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(gameOver, camera.position.x - gameOver.getWidth() / 2, camera.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOver.dispose();
        System.out.println("Game Over View Disposed");
    }
}
