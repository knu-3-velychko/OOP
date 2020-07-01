package game;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.system.AppSettings;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BallTest {
    private static GameController gameController = new GameController(true, 20);

    static {
        gameController.setShowSettings(false);

        AppSettings settings = new AppSettings(true);
        settings.setResolution(1280, 800);
        settings.setVSync(true);
        settings.setDepthBits(24);
        settings.setGammaCorrection(false);
        gameController.setSettings(settings);
    }    private Ball ball;

    @Before
    public void setUp() {
        gameController.start();
        gameController.okButtonClick();
        ball = new Ball(gameController.getAssetManager());
    }

    @Test
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