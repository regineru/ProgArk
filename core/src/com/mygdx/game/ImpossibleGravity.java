package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import com.mygdx.game.controller.MenuController;
import com.mygdx.game.controller.ViewController;
import com.mygdx.game.model.Player;
import com.mygdx.game.view.MenuView;
import com.mygdx.game.view.PlayView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ImpossibleGravity extends ApplicationAdapter {

	private SpriteBatch batch;
	private Socket socket;

	public static final int WIDTH = 480; //width of the screen
	public static final int HEIGHT = 480; //height of the screen
	public static final String TITLE = "Impossible Gravity";

	public static final float GRAVITY = -1;

	HashMap<String, Player> players;

	private ViewController vc;
	private MenuController mc;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		vc = new ViewController();
		mc = new MenuController(vc);
		Gdx.gl.glClearColor(1, 0, 0, 1);

		players = new HashMap<String, Player>();

		connectSocket();
		configSocketEvents();

		vc.push(new PlayView(vc));
		vc.push(new MenuView(mc));
	}

	public void connectSocket() {
		try {
			socket = IO.socket("http://localhost:8080");
			socket.connect();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void configSocketEvents() {
		socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
			@Override
			public void call(Object... args) {
				Gdx.app.log("SocketIO", "Connected");
			}
		}).on("socketID", new Emitter.Listener() {
			@Override
			public void call(Object... args) {
				JSONObject data = (JSONObject) args[0];
				try {
					String id = data.getString("id");
					Gdx.app.log("SocketIO", "My ID: " + id);
				} catch (JSONException e) {
					Gdx.app.log("SocketIO", "Error getting ID");
				}
			}
		}).on("newPlayer", new Emitter.Listener() {
			@Override
			public void call(Object... args) {
				JSONObject data = (JSONObject) args[0];
				try {
					String id = data.getString("id");
					Gdx.app.log("SocketIO", "New Player Connect: " + id);
				} catch (JSONException e) {
					Gdx.app.log("SocketIO", "Error getting New PlayerID");
				}
			}
		}).on("playerDisconnected", new Emitter.Listener() {
			@Override
			public void call(Object... args) {
				JSONObject data = (JSONObject) args[0];
				try {
					String id = data.getString("id");
					Gdx.app.log("SocketIO", "New Player Connect: " + id);
				} catch (JSONException e) {
					Gdx.app.log("SocketIO", "Error getting New PlayerID");
				}
			}
		});
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
