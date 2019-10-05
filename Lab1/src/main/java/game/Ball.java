package game;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;

import java.awt.*;

public class Ball {
    Material material;

    private RigidBodyControl physics;
    private Sphere sphere;

    private static int gravity;
    private static int speed;

    Ball(AssetManager assetManager) {
        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key = new TextureKey("Textures/Terrain/Rock/Rock.png");
        key.setGenerateMips(true);
        Texture texture = assetManager.loadTexture(key);
        material.setTexture("ColorMap", texture);
    }
}
