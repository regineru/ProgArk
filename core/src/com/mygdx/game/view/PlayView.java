package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

//Importer sprites her, når disse er laget fra model.
/*import com.brentaureli.game.FlappyDemo;
import com.brentaureli.game.sprites.Bird;
import com.brentaureli.game.sprites.Tube;*/

public class PlayView extends SuperView {

    //These are to be changed to our obstacles
    private static final int OBSTACLE_SPACING = 125;
    private static final int OBSTACLE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -50;

    //Her skal karakteren vår være, når laget i model
    //Character er en sprite som må importeres fra model
    private Character character;
    private Texture background;
    private Texture ground;
    private Vector2 groundPos1, groundPos2;

    private Array<Obstacle> obstacles;

    public PlayView(GameStateManager gsm) {

        super(gsm);
        //bird er byttet ut med character, Bird med Character osv
        character = new Character(50, 300);
        camera.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("bg.png");
        ground = new Texture("ground.png");
        groundPos1 = new Vector2(camera.position.x - camera.viewportWidth / 2, GROUND_Y_OFFSET);
        groundPos2 = new Vector2((camera.position.x - camera.viewportWidth / 2) + ground.getWidth(), GROUND_Y_OFFSET);

        //GENERATING NEW OBSTACLES
        /*obstacles = new Array<Obstacle>();
        for(int i = 1; i <= OBSTACLE_COUNT; i++){
            obstacles.add(new Obstacle(i * (OBSTACLE_SPACING + Obstacle.OBSTACLE_WIDTH)));
        }*/
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
            character.jump();
    }

    @Override
    //dt is delta time
    public void update(float dt) {
        handleInput();
        updateGround();
        character.update(dt);
        camera.position.x = character.getPosition().x + 80;

        for(int i = 0; i < obstacles.size; i++){
            Obstacle obstacle = obstacles.get(i);

            //When obstacle is out of camera view, reposition to other end
            if(camera.position.x - (camera.viewportWidth / 2) > obstacle.getPosTopTube().x + obstacle.getTopTube().getWidth()){
                obstacle.reposition(obstacle.getPosTopTube().x  + ((Obstacle.TUBE_WIDTH + OBSTACLE_SPACING) * OBSTACLE_COUNT));
            }
            //If character hits obstacle, change to menu state
            if(obstacle.collides(character.getBounds()))
                gsm.set(new MenuState(gsm));
        }
        //If character hits ground, change to menu state
        if(character.getPosition().y <= ground.getHeight() + GROUND_Y_OFFSET)
            gsm.set(new MenuState(gsm));
        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
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
    public void dispose() {
        background.dispose();
        character.dispose();
        ground.dispose();
        for(Obstacle obstacle : obstacles)
            tube.dispose();

        System.out.println("Play State Disposed");
    }

    private void updateGround(){
        if(camera.position.x - (camera.viewportWidth / 2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if(camera.position.x - (camera.viewportWidth / 2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }
}