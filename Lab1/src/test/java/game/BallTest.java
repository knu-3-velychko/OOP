package game;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;

public class BallTest {
    private GameController gameController = new GameController();
    private Ball ball;

    @Before
    public void setUp() throws Exception {
        gameController.start();
        gameController.okButtonClick();
        ball = new Ball(gameController.getAssetManager());
    }

    @org.junit.Test
    public void shoot() {
        BulletAppState bulletAppState = gameController.getStateManager().getState(BulletAppState.class);
        Vector3f start = new Vector3f(3.0f, 3.0f, 3.0f);
        Vector3f velocity = new Vector3f(1.0f, 2.0f, 3.0f);
        Geometry geometry = ball.shoot(gameController.getRootNode(), bulletAppState, start, velocity);
        assertEquals(geometry.getName(), "ball");
        assertEquals(geometry.getLocalTranslation(), start);
        assertEquals(geometry.getControl(RigidBodyControl.class).getLinearVelocity(), velocity);
        assertEquals(gameController.getRootNode().getChildren().get(0).getName(), "Ground");
    }
}