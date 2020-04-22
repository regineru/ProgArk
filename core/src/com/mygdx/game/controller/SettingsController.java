package com.mygdx.game.controller;

import com.mygdx.game.view.MenuView;

public class SettingsController {

    private ViewController vc;
    public boolean enableGameMusic;

    public SettingsController(ViewController vc, boolean enableGameMusic) {
        this.enableGameMusic = enableGameMusic;
        this.vc = vc;

    }

    public void backToMenu(){

        vc.set(new MenuView(new MenuController(vc)));
    }

    public void changeSoundVolume(float volume){
        //model.setSoundVolume(volume);
    }

    public void toggleGameMusic(){
        this.enableGameMusic = !this.enableGameMusic;
    }

    public void toggleMenuMusic(){}

}
