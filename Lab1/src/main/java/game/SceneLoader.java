package game;


import com.jme3.app.Application;
import com.jme3.asset.AssetManager;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

public class SceneLoader {
    private Box ground;
    private Material grountMaterial;
    private RigidBodyControl groundPhysics;

    SceneLoader(Node root, BulletAppState bulletAppState, AssetManager assetManager) {
        setTexture(assetManager);
        initialize(root,bulletAppState);
    }

    private void setTexture(AssetManager assetManager) {
        ground = new Box(100f, 0.1f, 100f);
        grountMaterial = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey groundKey = new TextureKey("Textures/Terrain/BrickWall/BrickWall.jpg");
        groundKey.setGenerateMips(true);
        Texture groundTexture = assetManager.loadTexture(groundKey);
        groundTexture.setWrap(Texture.WrapMode.MirroredRepeat);
        grountMaterial.setTexture("ColorMap", groundTexture);
    }

    private void initialize(Node root, BulletAppState bulletAppState) {
        Geometry groundGeometry = new Geometry("Ground", ground);
        groundGeometry.setMaterial(grountMaterial);
        groundGeometry.setLocalTranslation(0, -0.1f, 0);
        root.attachChild(groundGeometry);
        groundPhysics = new RigidBodyControl(0.0f);
        groundGeometry.addControl(groundPhysics);
        bulletAppState.getPhysicsSpace().add(groundPhysics);
    }
}
