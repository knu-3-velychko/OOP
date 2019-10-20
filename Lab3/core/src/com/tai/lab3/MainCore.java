package com.tai.lab3;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class MainCore extends Game {

    @Override
    public void create() {
        this.screen = new MainScreen(this);
    }

    void changeScreen(Screen screen) {
        this.screen = screen;
    }
}
