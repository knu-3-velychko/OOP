package game;

import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

class SceneLoader {
    private Box ground;
    private Material material;

    SceneLoader(Node root, BulletAppState bulletAppState, AssetManager assetManager) {
        setTexture(assetManager);
        initialize(root, bulletAppState);
    }

    private void setTexture(AssetManager assetManager) {
        ground = new Box(100f, 100f, 0.1f);

        material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey groundKey = new TextureKey("Textures/Terrain/BrickWall/BrickWall.jpg");
        groundKey.setGenerateMips(true);
        Texture groundTexture = assetManager.loadTexture(groundKey);
        groundTexture.setWrap(Texture.WrapMode.MirroredRepeat);
        material.setTexture("ColorMap", groundTexture);
    }

    private void initialize(Node root, BulletAppState bulletAppState) {
        initializeBox(ground, "Ground", 0.1f, -0.1f, -100f, root, bulletAppState);
    }

    private void initializeBox(Box box, String name, Float x, Float y, Float z, Node root, BulletAppState bulletAppState) {
        Geometry geometry = new Geometry(name, box);
        geometry.setMaterial(material);
        geometry.setLocalTranslation(new Vector3f(x, y, z));
        geometry.setLocalTranslation(x, y, z);
        root.attachChild(geometry);
        geometry.addControl(new RigidBodyControl(0.0f));
        bulletAppState.getPhysicsSpace().add(geometry);
    }
}
