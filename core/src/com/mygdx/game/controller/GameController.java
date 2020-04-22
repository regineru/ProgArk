package com.mygdx.game.controller;

import com.mygdx.game.model.Player;
import com.mygdx.game.model.World;
import com.mygdx.game.view.GameOverScreen;
import com.mygdx.game.view.MenuView;
import com.mygdx.game.view.PauseView;

public class GameController {

    private ViewController vc;
    private World world;

    public GameController(ViewController vc, World world) {
        this.vc = vc;
        this.world = world;
        if (vc.sm.gameMusicIsEnabled()) {
            world.playMusic();
        }
    }

    public void GameOver(){
        vc.set(new GameOverScreen(new GameOverController(vc)));
    }

    public void pauseGame(){
        world.pauseMusic();
        vc.push(new PauseView(new PauseController(vc, world)));
    }

    public void quitGame(){
        world.dispose();
        vc.set(new MenuView(new MenuController(vc)));
    }

    public void update(long dt){

    }




}
