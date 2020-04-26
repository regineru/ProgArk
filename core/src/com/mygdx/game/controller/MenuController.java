package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.model.Character;
import com.mygdx.game.model.Enemy;
import com.mygdx.game.view.HelpView;
import com.mygdx.game.view.PlayView;
import com.mygdx.game.view.SettingsView;
import com.mygdx.game.view.StartView;

public class MenuController {

    private ViewController vc;

    public MenuController(ViewController vc) {
        this.vc = vc;
    }

    public void quit() {
        Gdx.app.exit();
    }

    public void settingsPressed(){
        vc.push(new SettingsView(new SettingsController(vc)));
    }

    public void playGamePressed(){

        vc.set(new PlayView(vc, vc.multiplayerChecked())); //TODO Enemy
    }

    public void helpPressed(){
        vc.push(new HelpView(new HelpController(vc)));
    }

    public boolean multiplayerChecked(){ return vc.multiplayerChecked();}

    public void toggleMultiplayer() {
        vc.toggleMultiplayer();

    }
}
