package main.java.game;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyMethodInvoker;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.screen.Screen;

import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameController extends SimpleApplication {
    private BulletAppState bulletAppState;
    private SceneLoader sceneLoader;
    private Ball ball;

    private ArrayList<Pair> vectors = new ArrayList<>();

    private Nifty nifty;
    private NiftyJmeDisplay niftyDisplay;

    @Override
    public void simpleInitApp() {
        nifty();
    }

    private void setUp() {
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.setDebugEnabled(true);
        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));

        cam.setLocation(new Vector3f(0, 8f, 0));

        sceneLoader = new SceneLoader(rootNode, bulletAppState, assetManager);
        ball = new Ball(assetManager);

        setUpKeys();
    }

    private void setUpKeys() {
        inputManager.addMapping("Shoot", new KeyTrigger(KeyInput.KEY_SPACE));
        //inputManager.addListener(shootListener, "Shoot");
    }

//    static private Geometry ball0;
//    private ActionListener shootListener = (name, isPressed, tpf) -> {
//        if (!isPressed) {
//            ball0 = ball.shoot(rootNode, cam, bulletAppState);
//        }
//    };

    private void nifty() {
        niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
        nifty = niftyDisplay.getNifty();

        nifty.fromXml("GUI/Screen.xml", "start");
        viewPort.addProcessor(niftyDisplay);
        flyCam.setDragToRotate(true);

        // Controls onclick on button
        Element niftyElement = Objects.requireNonNull(nifty.getCurrentScreen()).findElementById("okButton");
        assert niftyElement != null;
        niftyElement.getElementInteraction().getPrimary().setOnClickMethod(new NiftyMethodInvoker(nifty, "wow()", this));
    }

    final void okButtonClick() {
        Logger LOGGER = Logger.getLogger(GameController.class.getName());

        Screen screen = nifty.getCurrentScreen();
        TextField field1, field2;
        double value1, value2;
        for (int i = 0; i < 10; i++) {
            assert screen != null;
            field1 = screen.findNiftyControl("input" + (i + 1) + "_1", TextField.class);
            field2 = screen.findNiftyControl("input" + (i + 1) + "_2", TextField.class);

            assert field1 != null;
            assert field2 != null;
            if ("0".equals(field1.getText()) && "0".equals(field2.getText()))
                break;
            value1 = Double.parseDouble(field1.getText());
            value2 = Double.parseDouble(field2.getText());
            vectors.add(new Pair(value1, value2));
        }

        for (int i = 0; i < vectors.size(); i++) {
            LOGGER.log(Level.WARNING, "Vector {0} : {1} - {2}", new Object[]{i, vectors.get(i).x, vectors.get(i).y});
        }
        guiViewPort.removeProcessor(niftyDisplay);
        setUp();
    }

}
