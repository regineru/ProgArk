package com.mygdx.game.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.ImpossibleGravity;
import com.mygdx.game.model.Background;
import com.mygdx.game.model.World;

// Common setup goes into an abstract View class.
// Child classes build the specific layouts required.
public abstract class SuperView {

    // This is the superclass for all views
    protected OrthographicCamera camera;
    protected Vector3 mouse;
    protected Background background;


    // Constructor
    public SuperView(){

        camera = new OrthographicCamera();
        camera.setToOrtho(false, ImpossibleGravity.WIDTH, ImpossibleGravity.HEIGHT);
        mouse = new Vector3();
        background = new Background();
    }

    // Methods to be used by subclasses
    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
    public abstract void show();
    public abstract void startListeners();
}