package game;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SceneLoaderTest {

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
    private Node rootNode;
    private BulletAppState bulletAppState;

    @Before
    public void setUp() {
        gameController.start();
        gameController.okButtonClick();

        rootNode = gameController.getRootNode();
        bulletAppState = gameController.getStateManager().getState(BulletAppState.class);
        AssetManager assetManager = gameController.getAssetManager();

        new SceneLoader(rootNode, bulletAppState, assetManager);
    }

    @Test
    public void setSceneLoader() {
        assertFalse(bulletAppState.getPhysicsSpace().getRigidBodyList().isEmpty());
        assertEquals(rootNode.getChildren().get(0).getName(), "Ground");
        assertEquals(rootNode.getChildren().get(0).getWorldTranslation(),new Vector3f(0.1f, -0.1f, -100f));
    }
}