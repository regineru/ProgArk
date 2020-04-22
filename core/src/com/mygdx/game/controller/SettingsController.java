package com.mygdx.game.controller;

import com.mygdx.game.model.SettingsModel;
import com.mygdx.game.view.MenuView;

public class SettingsController {

    private ViewController vc;
    private SettingsModel model;

    public SettingsController(ViewController vc) {
        this.model = vc.sm;
        this.vc = vc;
    }

    public void backToMenu(){

        vc.pop();
    }

    public void changeSoundVolume(float volume){
        //model.setSoundVolume(volume);
    }

    public void toggleGameMusic(){
        model.toggleGameMusic();
    }

    public SettingsModel getModel(){
        return this.model;
    }

}
