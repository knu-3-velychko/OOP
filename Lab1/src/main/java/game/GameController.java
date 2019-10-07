package game;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.PhysicsTickListener;
import com.jme3.bullet.collision.PhysicsCollisionEvent;
import com.jme3.bullet.collision.PhysicsCollisionListener;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.objects.PhysicsGhostObject;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Sphere;

import java.util.Objects;

public class GameController extends SimpleApplication {
    private BulletAppState bulletAppState;
    private SceneLoader sceneLoader;
    private Ball ball;

    @Override
    public void simpleInitApp() {
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.setDebugEnabled(true);
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));

        cam.setLocation(new Vector3f(0, 8f, 0));

        sceneLoader = new SceneLoader(rootNode, bulletAppState, assetManager);
        ball = new Ball(assetManager);

        setUpKeys();
        Sphere sphere = new Sphere(32, 32, 0.4f, true, false);
        sphere.setTextureMode(Sphere.TextureMode.Projected);


        bulletAppState.getPhysicsSpace().addTickListener(tickListener);
    }

    private void setUpKeys() {
        inputManager.addMapping("Shoot", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(shootListener, "Shoot");
    }

    static private Geometry ball0;
    private ActionListener shootListener = (name, isPressed, tpf) -> {
        if (!isPressed) {
            ball0=ball.shoot(rootNode, cam, bulletAppState);
        }
    };

    private PhysicsTickListener tickListener = new PhysicsTickListener() {
        @Override
        public void prePhysicsTick(PhysicsSpace space, float tpf) {
            for (PhysicsGhostObject i : space.getGhostObjectList()) {
                System.out.println(i.getUserObject().equals(ball0));
                if(i.getOverlappingObjects().get(0).equals(ball0.getControl(0)))
                    System.out.println("a");
            }

        }

        @Override
        public void physicsTick(PhysicsSpace space, float tpf) {

        }
    };

}
