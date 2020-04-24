package com.mygdx.game.controller;

import com.mygdx.game.view.MenuView;

public class StartController {

    private ViewController vc;

    public StartController(ViewController vc){
        this.vc = vc;
    }

    public void multiPlayerPressed(){
        //TODO change this when multi player is set up
        vc.set(new MenuView(new MenuController(vc)));
    }

    public void singlePlayerPressed(){
        vc.set(new MenuView(new MenuController(vc)));
    }
}
