package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

// Import the sprites here, when these are created in model (e.g. the character, obstacles)

public class PlayView extends SuperView {
    protected ViewController viewController;

    // Variables that can be used for our obstacles.
    private static final int OBSTACLE_SPACING = 125;
    private static final int OBSTACLE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -50;

    // The elements in our view - instantiate character, obstacles etc.
    // Can also import e.g. gameWorld, engine etc.
    private Character character;
    private Texture background;
    // The pauseBtn needs to be made and put in the assets-folder.
    private Texture pauseBtn;
    // Ground could be the platform our character is running on.
    private Texture ground;
    private Vector2 groundPos1, groundPos2;



    // Make an array of the obstacles (obstacle must be made as a model).
    private Array<Obstacle> obstacles;

    public PlayView(ViewController viewController){
        this.viewController = viewController;

        character = new Character(50, 300);
        camera.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("bg.png");
        ground = new Texture("ground.png");
        groundPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);

        // GENERATING NEW OBSTACLES
        obstacles = new Array<Obstacle>();
        for(int i = 1; i <= OBSTACLE_COUNT; i++){
            obstacles.add(new Obstacle(i * (OBSTACLE_SPACING + Obstacle.OBSTACLE_WIDTH)));
        }
    }

    @Override
    protected void handleInput() {
        // Every input from the user should call on a function for the character.
        // The action is defined in the model-class of the character.

        if (Gdx.input.justTouched()) {
            // E.g. for our character/player, it should jump, shift gravity etc. The character-related methods should be made in the model!
            character.jump();
        }
        // Put the rest of the actions here!

        //The playBtn needs to have an eventListener called btnPushed in order to switch to right view.
        if (Gdx.playBtn.btnPushed()) {
            viewController.set(new PauseView(viewController));
        }
    }

    @Override
    //dt is delta time

    // In the update-method, we call on every function that handles everything that happens in this view.

    public void update(float dt) {
        // Input from player
        handleInput();
        // Animation of ground. We need the
        updateGround();

        // The character must have an update -and getPosition-method in its model.
        // For other methods required, see which functions are called upon character below.
        character.update(dt);
        camera.position.x = character.getPosition().x + 80;

        // This is for making the obstacles "move", and then repositioning them
        for(int i = 0; i < obstacles.size; i++){
            Obstacle obstacle = obstacles.get(i);

            // When obstacle is out of camera view, reposition to other end
            if(camera.position.x - (camera.viewportWidth / 2) > obstacle.getPosTopTube().x + obstacle.getTopTube().getWidth()){
                obstacle.reposition(obstacle.getPosTopTube().x  + ((Obstacle.TUBE_WIDTH + OBSTACLE_SPACING) * OBSTACLE_COUNT));
            }

            // If character hits obstacle, change to menu state
            if(obstacle.collides(character.getBounds()))
                viewController.set(new MenuState(viewController));
        }

        // If character hits ground, change to menu state
        if(character.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET)
            viewController.set(new MenuState(viewController));
        camera.update();

    }

    @Override
    // Each view is responsible for knowing what it needs to draw.
    // Here we draw the background, character, obstacles and ground.
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(background, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(character.getTexture(), character.getPosition().x, character.getPosition().y);

        for(Obstacle obstacle : obstacles) {
            sb.draw(obstacle.getTopTube(), obstacle.getPosTopTube().x, obstacle.getPosTopTube().y);
            sb.draw(obstacle.getBottomTube(), obstacle.getPosBotTube().x, obstacle.getPosBotTube().y);
        }

        sb.draw(ground, groundPos1.x, groundPos1.y);
        sb.draw(ground, groundPos2.x, groundPos2.y);
        sb.end();
    }

    @Override
    public void dispose(){
        // Remember to dispose of everything drawn on the screen.
        background.dispose();
        character.dispose();
        ground.dispose();
        pauseBtn.dispose();
        for(Obstacle obstacle : obstacles)
            obstacle.dispose();
        System.out.println("Play State Disposed");
    }

    private void updateGround(){
        if(camera.position.x - (camera.viewportWidth / 2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if(camera.position.x - (camera.viewportWidth / 2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }

}
