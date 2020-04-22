package com.mygdx.game.controller;

import com.mygdx.game.model.World;
import com.mygdx.game.view.MenuView;
import com.mygdx.game.view.PlayView;

public class PauseController {

    private ViewController vc;
    private World world;

    public PauseController(ViewController vc, World world) {
        this.vc = vc;
        this.world = world;
    }

    public void BackToMenu(){
        world.dispose();
        vc.set(new MenuView(new MenuController(vc)));
    }

    public void ContinueGame(){
        world.playMusic();
        vc.pop();
        if (vc.peek() instanceof PlayView){
            ((PlayView) vc.peek()).startListeners();
        }
    }

}
