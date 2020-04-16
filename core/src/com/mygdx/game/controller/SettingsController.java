package com.mygdx.game.controller;

import com.mygdx.game.model.SettingsModel;
import com.mygdx.game.view.MenuView;

public class SettingsController {

    private ViewController vc;
<<<<<<< HEAD
    //private Settingsmodel model;

    public SettingsController(ViewController vc/*, SettingsModel model)*/ ){
=======
    private SettingsModel model;

    public SettingsController(ViewController vc) {
>>>>>>> c194af2181633e43ef2a75eb723f7b533796d288
        this.vc = vc;

    }

    public void BackToMenu(){
        vc.set(new MenuView(new MenuController(vc)));
    }

    public void ChangeSoundVolume(float volume){
        //model.setSoundVolume(volume);
    }

    public void toggleSound(Boolean enable){
        //model.enableMusic(enable);
    }



}
