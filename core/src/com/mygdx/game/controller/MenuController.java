package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.model.SettingsModel;
import com.mygdx.game.view.PlayView;
import com.mygdx.game.view.SettingsView;

public class MenuController {

    private ViewController vc;

    public MenuController(ViewController vc) {
        this.vc = vc;
    }

    public void quit() {
        Gdx.app.exit();
    }

    public void settingsPressed(){
        vc.set(new SettingsView(new SettingsController(vc)));
    }

    public void playGamePressed(){
<<<<<<< HEAD
        vc.set(new PlayView(new GameController(vc)));
=======
        vc.set(new PlayView(vc));
>>>>>>> c194af2181633e43ef2a75eb723f7b533796d288
    }

    /*
    public void helpPressed(){
        vc.set(new HelpView());
    }

     */


}
