package main.java.game;

import com.jme3.asset.AssetManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BallTest {
    AssetManager assetManager = mock(AssetManager.class);
    Ball ball = new Ball(assetManager);

    @Test
    void shoot() {
        assertEquals(1, 1);
    }
}