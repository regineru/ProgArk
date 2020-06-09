package com.mygdx.game.controller;

import com.mygdx.game.model.Character;
import com.mygdx.game.model.Enemy;
import com.mygdx.game.view.PlayView;

public class LoadingController {

    private ViewController vc;

    public LoadingController(ViewController vc) {
        this.vc = vc;
    }

    public void startGame(){
        vc.set(new PlayView(vc, vc.multiplayer, new Enemy(new Character()))); //TODO Ememy skal være fra server
    }
}
