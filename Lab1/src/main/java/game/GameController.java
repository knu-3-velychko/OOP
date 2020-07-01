package game;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
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

import javafx.util.Pair;

public class GameController extends SimpleApplication {
    private boolean isSelfTerminated = false;
    private int secondsTillTermination = 0;
    private long startTime = 0L;

    GameController(boolean isSelfTerminated, int secondsTillTermination) {
        this.isSelfTerminated = isSelfTerminated;
        this.secondsTillTermination = secondsTillTermination;
    }

    GameController() {

    }

    private BulletAppState bulletAppState;

    private ArrayList<Velocity2D> velocities = new ArrayList<>();

    private Nifty nifty;
    private NiftyJmeDisplay niftyDisplay;

    @Override
    public void simpleInitApp() {
        nifty();
    }

    private void setUp() {
        this.startTime = System.currentTimeMillis();
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);

        viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));

        cam.setLocation(new Vector3f(0f, 0f, 50f));
        bulletAppState.getPhysicsSpace().setGravity(new Vector3f(0.0f, 0.0f, 0.0f));

        SceneLoader sceneLoader = new SceneLoader(rootNode, bulletAppState, assetManager);
        Simulation simulation = new Simulation(assetManager, rootNode, bulletAppState);

        simulation.run(velocities);
    }


    private void nifty() {
        niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(assetManager, inputManager, audioRenderer, guiViewPort);
        nifty = niftyDisplay.getNifty();

        nifty.fromXml("GUI/Screen.xml", "start");
        viewPort.addProcessor(niftyDisplay);
        flyCam.setDragToRotate(true);

        // Controls onclick on button
        Element niftyElement = Objects.requireNonNull(nifty.getCurrentScreen()).findElementById("okButton");
        niftyElement.getElementInteraction().getPrimary().setOnClickMethod(new NiftyMethodInvoker(nifty, "okButtonClick()", this));
        System.out.println(this.getViewPort().getProcessors().get(0));
    }

    public final void okButtonClick() {
        Logger LOGGER = Logger.getLogger(GameController.class.getName());

        Screen screen = nifty.getCurrentScreen();
        TextField field1, field2, field3, field4;
        float value1, value2, value3, value4;
        for (int i = 0; i < 10; i++) {

            field1 = screen.findNiftyControl("input" + (i + 1) + "_1", TextField.class);
            field2 = screen.findNiftyControl("input" + (i + 1) + "_2", TextField.class);
            field3 = screen.findNiftyControl("input" + (i + 1) + "_3", TextField.class);
            field4 = screen.findNiftyControl("input" + (i + 1) + "_4", TextField.class);

            if ("0".equals(field1.getText()) && "0".equals(field2.getText()) && "0".equals(field3.getText()) && "0".equals(field4.getText()))
                break;
            value1 = (float) Double.parseDouble(field1.getText());
            value2 = (float) Double.parseDouble(field2.getText());
            value3 = (float) Double.parseDouble(field3.getText());
            value4 = (float) Double.parseDouble(field4.getText());

            System.out.println(value3);
            System.out.println(value4);

            velocities.add(new Velocity2D(new Pair<>(value1, value2), new Pair<>(value3, value4)));
        }

        for (int i = 0; i < velocities.size(); i++) {
            LOGGER.log(Level.WARNING, "Vector {0} : {1} - {2}", new Object[]{i, velocities.get(i).getStart().getKey(), velocities.get(i).getStart().getValue()});
        }

        viewPort.removeProcessor(niftyDisplay);
        setUp();
    }

    @Override
    public void simpleUpdate(float ptf) {
        if (isSelfTerminated) {
            long endTime = System.currentTimeMillis();
            if (endTime - startTime >= secondsTillTermination * 1000L) {
                stop();
            }
        }
    }

}
