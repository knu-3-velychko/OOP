package game;

import com.jme3.bullet.BulletAppState;
import com.jme3.math.Vector3f;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.system.AppSettings;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.TextField;
import de.lessvoid.nifty.screen.Screen;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameControllerTest {
    private static GameController gameController = new GameController();

    static {
        gameController.setShowSettings(false);

        AppSettings settings = new AppSettings(true);
        settings.setResolution(1280, 800);
        settings.setVSync(true);
        settings.setDepthBits(24);
        settings.setGammaCorrection(false);
        gameController.setSettings(settings);
    }

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
    public void okButtonClick_allZero() {
        gameController.okButtonClick();
        assertEquals(gameController.getCamera().getLocation(), new Vector3f(0, 0f, 50));
        assertTrue(gameController.getViewPort().getProcessors().isEmpty());
        assertNotEquals(gameController.getStateManager().getState(BulletAppState.class), null);
    }

    @Test
    public void okButtonClick_NoZero() {
        initAllParams("10", "20", "30", "40");
    }

    @Test
    public void okButtonClick_oneZero() {
        initAllParams("0", "20", "30", "40");
    }

    @Test
    public void okButtonClick_twoZero() {
        initAllParams("0", "0", "30", "40");
    }

    @Test
    public void okButtonClick_threeZero() {
        initAllParams("0", "0", "0", "40");
    }

    private void initAllParams(String text1, String text2, String text3, String text4) {
        gameController.start();
        NiftyJmeDisplay controller = (NiftyJmeDisplay) gameController.getViewPort().getProcessors().get(0);
        Nifty nifty = controller.getNifty();
        Screen screen = nifty.getCurrentScreen();
        TextField field1, field2, field3, field4;
        assertNotNull(screen);
        for (int i = 1; i <= 10; i++) {
            field1 = screen.findNiftyControl("input" + i + "_1", TextField.class);
            field2 = screen.findNiftyControl("input" + i + "_2", TextField.class);
            field3 = screen.findNiftyControl("input" + i + "_3", TextField.class);
            field4 = screen.findNiftyControl("input" + i + "_4", TextField.class);
            assertNotNull(field1);
            field1.setText(text1);
            assertNotNull(field2);
            field2.setText(text2);
            assertNotNull(field3);
            field3.setText(text3);
            assertNotNull(field4);
            field4.setText(text4);
        }

        gameController.okButtonClick();
        assertEquals(gameController.getCamera().getLocation(), new Vector3f(0, 0f, 50));
        assertTrue(gameController.getViewPort().getProcessors().isEmpty());
        assertNotEquals(gameController.getStateManager().getState(BulletAppState.class), null);
    }
}