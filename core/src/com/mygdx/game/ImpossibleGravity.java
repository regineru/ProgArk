package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.controller.StartController;
import com.mygdx.game.controller.ViewController;
import com.mygdx.game.view.StartView;

public class ImpossibleGravity extends ApplicationAdapter {

	private SpriteBatch batch;

	public static final int WIDTH = 854; //width of the screen
	public static final int HEIGHT = 480; //height of the screen
	public static final String TITLE = "Impossible Gravity";

	public static final float GRAVITY = -1;

	private ViewController vc;

	@Override
	public void create () {
		batch = new SpriteBatch();
		vc = new ViewController();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		vc.push(new StartView(new StartController(vc)));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		vc.update(Gdx.graphics.getDeltaTime());
		vc.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
