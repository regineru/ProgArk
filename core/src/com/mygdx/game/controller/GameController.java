package com.mygdx.game.controller;

import com.mygdx.game.model.Player;
import com.mygdx.game.view.GameOverScreen;
import com.mygdx.game.view.MenuView;
import com.mygdx.game.view.PauseView;

public class GameController {

    private ViewController vc;


    public GameController(ViewController vc) {
        this.vc = vc;
    }

    public void GameOver(){
        vc.set(new GameOverScreen(new GameOverController(vc)));
    }

    public void pauseGame(){
        vc.push(new PauseView(new PauseController(vc)));
    }

    public void quitGame(){
        vc.set(new MenuView(new MenuController(vc)));
    }

    public void update(long dt){

    }




}
