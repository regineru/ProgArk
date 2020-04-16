package com.mygdx.game.controller;

import com.mygdx.game.model.Player;
import com.mygdx.game.view.GameOverScreen;
import com.mygdx.game.view.PauseView;

public class GameController {

    ViewController vc;
    Player players;
    World world;


    public GameController(ViewController vc) {
        this.vc = vc;
    }

    public void GameOver(){
        vc.set(new GameOverScreen(new GameOverController(vc)));
    }

    public void pauseGame(){
        vc.set(new PauseView(new PauseController(vc)));
    }

    public void update(long dt){

    }




}
