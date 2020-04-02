package com.mygdx.game.controller;

import com.mygdx.game.view.MenuView;

public class SettingsController {

    private ViewController vc;
    private Settingsmodel model;

    public SettingsController(ViewController vc, SettingsModel model) {
        this.vc = vc;

    }

    public void BackToMenu(){
        vc.set(new MenuView(new MenuController(vc)));
    }

    public void ChangeSoundVolume(float volume){
        model.setSoundVolume(volume);
    }

    public void toggleSound(Boolean enable){
        model.enableMusic(enable);
    }



}
