package com.mygdx.game.controller;

import com.mygdx.game.view.MenuView;

public class SettingsController {

    private ViewController vc;


    public SettingsController(ViewController vc) {
        this.vc = vc;

    }

    public void backToMenu(){

        vc.set(new MenuView(new MenuController(vc)));
    }

    public void changeSoundVolume(float volume){
        //model.setSoundVolume(volume);
    }

    public void toggleSound(Boolean enable){
        //model.enableMusic(enable);
    }

}
