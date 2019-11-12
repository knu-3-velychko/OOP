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


class Ball {
    private Material material;

    private Sphere sphere;

    Ball(AssetManager assetManager) {
        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key = new TextureKey("Textures/Terrain/Rock/Rock.PNG");
        key.setGenerateMips(true);
        Texture texture = assetManager.loadTexture(key);
        material.setTexture("ColorMap", texture);

        sphere = new Sphere(32, 32, 3f, true, false);
        sphere.setTextureMode(Sphere.TextureMode.Projected);
    }

    Geometry shoot(Node root, BulletAppState bulletAppState, Vector3f start, Vector3f velocity) {
        Geometry geometry = new Geometry("ball", sphere);
        geometry.setMaterial(material);
        geometry.setLocalTranslation(start);
        root.attachChild(geometry);
        RigidBodyControl physics = new RigidBodyControl(20f);
        geometry.addControl(physics);
        bulletAppState.getPhysicsSpace().add(geometry);
        physics.setLinearVelocity(velocity);

        return geometry;
    }
}
