package game;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.shape.Sphere;

public class Game extends SimpleApplication {
    private BulletAppState bulletAppState;
    SceneLoader sceneLoader;

    @Override
    public void simpleInitApp() {
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.setDebugEnabled(true);

        cam.setLocation(new Vector3f(0, 4f, 0));

        sceneLoader = new SceneLoader(rootNode, bulletAppState, assetManager);

        Sphere sphere = new Sphere(32, 32, 0.4f, true, false);
        sphere.setTextureMode(Sphere.TextureMode.Projected);
    }
}
