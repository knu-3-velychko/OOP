package game;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.system.AppSettings;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimulationTest {

    private static GameController gameController = new GameController(true, 20);

    static {
        gameController.setShowSettings(false);

        AppSettings settings = new AppSettings(true);
        settings.setResolution(1280, 800);
        settings.setVSync(true);
        settings.setDepthBits(24);
        settings.setGammaCorrection(false);
        gameController.setSettings(settings);
    }
    @Test
    public void run() {
        gameController.start();
        gameController.okButtonClick();
        BulletAppState bulletAppState = gameController.getStateManager().getState(BulletAppState.class);
        Simulation simulation = new Simulation(gameController.getAssetManager(), gameController.getRootNode(), bulletAppState);

        ArrayList<Velocity2D> velocities = new ArrayList<>();
        velocities.add(new Velocity2D(new Pair<>(1.0f, 1.0f), new Pair<>(3.0f, 3.0f)));
        ArrayList<Geometry> balls = simulation.run(velocities);
        assertEquals(balls.size(), 1);
        assertEquals(balls.get(0).getName(), "ball");
        assertEquals(balls.get(0).getLocalTranslation(),new Vector3f(1.0f, 1.0f,10.0f));
        assertEquals(balls.get(0).getControl(RigidBodyControl.class).getLinearVelocity(),new Vector3f(3.0f, 3.0f,0.0f));
    }
}