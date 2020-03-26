package com.mygdx.game.controller;

public class PauseController {

    private ViewController vc;

    public PauseController(ViewController vc) {
        this.vc = vc;
    }

    public BackToMenu(){
        vc.set(new MenuView());
    }

    public ContinueGame(){
        vc.pop();
    }

}
