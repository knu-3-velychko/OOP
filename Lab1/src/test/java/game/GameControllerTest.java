package game;

import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.screen.Screen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {
    private GameController gameController = new GameController();

    @Before
    public void setUp() {
        gameController.start();
    }

    @Test
    public void simpleInitApp() {
        assertEquals(gameController.getViewPort().getProcessors().get(0).getClass(), NiftyJmeDisplay.class);
        assertTrue(gameController.getFlyByCamera().isDragToRotate());
    }

    @Test
    public void okButtonClick_branch1() {
        gameController.okButtonClick();
        assertEquals(gameController.getCamera().getLocation(), new Vector3f(0, 0f, 50));
        assertTrue(gameController.getViewPort().getProcessors().isEmpty());
        assertNotEquals(gameController.getStateManager().getState(BulletAppState.class), null);
    }

    @Test
    public void okButtonClick_branch2() {
        gameController.start();
        NiftyJmeDisplay controller = (NiftyJmeDisplay) gameController.getViewPort().getProcessors().get(0);
        Nifty nifty = controller.getNifty();
        Screen screen = nifty.getCurrentScreen();
        TextField field1, field2, field3, field4;
        assertNotNull(screen);
        field1 = screen.findNiftyControl("input" + 1 + "_1", TextField.class);
        field2 = screen.findNiftyControl("input" + 1 + "_2", TextField.class);
        field3 = screen.findNiftyControl("input" + 1 + "_3", TextField.class);
        field4 = screen.findNiftyControl("input" + 1 + "_4", TextField.class);
        assertNotNull(field1);
        field1.setText("10");
        assertNotNull(field2);
        field2.setText("20");
        assertNotNull(field3);
        field3.setText("30");
        assertNotNull(field4);
        field4.setText("40");



        gameController.okButtonClick();
        assertEquals(gameController.getCamera().getLocation(), new Vector3f(0, 0f, 50));
        assertTrue(gameController.getViewPort().getProcessors().isEmpty());
        assertNotEquals(gameController.getStateManager().getState(BulletAppState.class), null);
    }
}