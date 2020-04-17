package com.mygdx.game.controller;

import com.mygdx.game.view.MenuView;
import com.mygdx.game.view.PlayView;

public class HelpController {
    private ViewController vc;

    public HelpController(ViewController vc) {
        this.vc = vc;
    }

    public void backToMenu(){
        vc.set(new MenuView(new MenuController(vc)));
    }

}
