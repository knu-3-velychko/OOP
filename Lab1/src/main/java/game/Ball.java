package game;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.GhostControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;


public class Ball {
    private Material material;

    private RigidBodyControl physics;
    private GhostControl ghost;
    private Sphere sphere;

    private static int gravity = -100;
    private static int speed = 50;

    Ball(AssetManager assetManager) {
        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key = new TextureKey("Textures/Terrain/Rock/Rock.PNG");
        key.setGenerateMips(true);
        Texture texture = assetManager.loadTexture(key);
        material.setTexture("ColorMap", texture);

        sphere = new Sphere(32, 32, 3f, true, false);
        sphere.setTextureMode(Sphere.TextureMode.Projected);
    }

    Geometry shoot(Node root, Camera camera, BulletAppState bulletAppState) {
        Geometry geometry = new Geometry("ball", sphere);
        geometry.setMaterial(material);
        root.attachChild(geometry);

        geometry.setLocalTranslation(camera.getLocation());
        physics = new RigidBodyControl(20f);
        CapsuleCollisionShape shape=new CapsuleCollisionShape(3.1f, 0.2f);
        ghost=new GhostControl(shape);

        geometry.addControl(physics);
        geometry.addControl(ghost);
        bulletAppState.getPhysicsSpace().add(physics);
        bulletAppState.getPhysicsSpace().add(ghost);

        physics.setGravity(new Vector3f(0, gravity, 0));
        Vector3f cameraDirection = camera.getDirection().mult(speed);
        physics.setLinearVelocity(new Vector3f(cameraDirection.x, 0f, cameraDirection.z));
        return geometry;
    }
}
