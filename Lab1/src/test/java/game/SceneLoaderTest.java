package game;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SceneLoaderTest {

    private GameController gameController = new GameController();

    private Node rootNode;
    private BulletAppState bulletAppState;
    private AssetManager assetManager;

    @Before
    public void setUp() {
        gameController.start();
        gameController.okButtonClick();

        rootNode = gameController.getRootNode();
        bulletAppState = gameController.getStateManager().getState(BulletAppState.class);
        assetManager = gameController.getAssetManager();

        SceneLoader sceneLoader = new SceneLoader(rootNode, bulletAppState, assetManager);
    }

    @Test
    public void setSceneLoader() {
        assertFalse(bulletAppState.getPhysicsSpace().getRigidBodyList().isEmpty());
        assertEquals(rootNode.getChildren().get(0).getName(), "Ground");
        assertEquals(rootNode.getChildren().get(0).getWorldTranslation(),new Vector3f(0.1f, -0.1f, -100f));
    }
}