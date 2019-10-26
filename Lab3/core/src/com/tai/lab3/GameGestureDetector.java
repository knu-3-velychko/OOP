package com.tai.lab3;

import com.badlogic.gdx.input.GestureDetector;

public class GameGestureDetector extends GestureDetector {

    public interface TouchListener{
        
    }

    public GameGestureDetector(GestureListener listener) {
        super(listener);
    }


}
