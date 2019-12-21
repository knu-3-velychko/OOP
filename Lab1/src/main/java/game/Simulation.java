package game;

import com.jme3.asset.AssetManager;
import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;

import java.util.ArrayList;

class Simulation {
    private AssetManager assetManager;
    private Node root;
    private BulletAppState bulletAppState;


    Simulation(AssetManager assetManager, Node root, BulletAppState bulletAppState) {
        this.assetManager = assetManager;
        this.root = root;
        this.bulletAppState = bulletAppState;
    }

    ArrayList<Geometry> run(ArrayList<Velocity2D> vectors) {
        ArrayList<Geometry> balls = new ArrayList<>();
        for (Velocity2D i : vectors) {
            Ball ball = new Ball(assetManager);
            Vector3f start = new Vector3f(i.getStart().getKey(), i.getStart().getValue(), 10f);
            Vector3f velocity = new Vector3f(i.getVector().getKey(), i.getVector().getValue(), 0f);
            balls.add(ball.shoot(root, bulletAppState, start, velocity));
        }
        return balls;
    }
}
