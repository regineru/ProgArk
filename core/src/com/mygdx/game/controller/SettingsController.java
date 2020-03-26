package com.mygdx.game.controller;

public class SettingsController {

    private ViewController vc;
    private Settingsmodel model;

    public SettingsController(ViewController vc, SettingsModel model) {
        this.vc = vc;

    }

    public BackToMenu(){
        vc.set(new MenuView());
    }

    public void ChangeSoundVolume(float volume){
        model.setSoundVolume(volume);
    }

    public void toggleSound(Boolean enable){
        model.enableMusic(enable);
    }



}
