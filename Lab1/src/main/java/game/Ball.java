package game;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;

import java.awt.*;

public class Ball {
    Material material;

    private RigidBodyControl physics;
    private Sphere sphere;

    private static int gravity;
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

    void shoot(Node root, Camera camera, BulletAppState bulletAppState) {
        Geometry geometry = new Geometry("ball", sphere);
        geometry.setMaterial(material);
        root.attachChild(geometry);

        geometry.setLocalTranslation(camera.getLocation());
        physics = new RigidBodyControl(20f);

        geometry.addControl(physics);
        bulletAppState.getPhysicsSpace().add(physics);

        physics.setGravity(new Vector3f(0, -100, 0));
        Vector3f cameraDirection = camera.getDirection().mult(speed);
        physics.setLinearVelocity(new Vector3f(cameraDirection.x, 0f, cameraDirection.z));
    }
}
