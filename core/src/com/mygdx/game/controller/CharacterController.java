package com.mygdx.game.controller;

import com.mygdx.game.model.Character;
import com.mygdx.game.view.GameOverScreen;

public class CharacterController {

    private ViewController vc;

    public CharacterController(ViewController vc){
        this.vc = vc;
    }

    public void touch(Character character){
        character.jump();
    }

    public void swipe(Character character, int deltaY) {
        character.switchGravity(deltaY);
    }

    public void gameOver(){
        vc.set(new GameOverScreen(new GameOverController(vc)));
    }



}
