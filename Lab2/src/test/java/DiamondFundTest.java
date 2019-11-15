import Entities.DiamondFund;
import Entities.Gem;
import Entities.Preciousness;
import Entities.VisualParameters;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DiamondFundTest {

    private Gem gem;
    private List<Gem> gems;
    private DiamondFund emptyDiamondFund;
    private DiamondFund diamondFund;

    @Before
    public void setUp() throws Exception {
        final String name = "Ruby";
        final Preciousness preciousness = Preciousness.Precious;
        final String origin = "South Asia";
        final VisualParameters visualParameters = new VisualParameters("red", 20.0f, 10);
        final float value = 7.0f;

        gem = new Gem(name, preciousness, origin, visualParameters, value);
        gems = new ArrayList<>();
        gems.add(gem);

        emptyDiamondFund = new DiamondFund();
        diamondFund = new DiamondFund(gems);
    }

    @Test
    public void getGems() {
        assertTrue(emptyDiamondFund.getGems().isEmpty());
        assertFalse(diamondFund.getGems().isEmpty());
        assertEquals(diamondFund.getGems().size(), 1);
        assertSame(diamondFund.getGems(), gems);
        assertSame(diamondFund.getGems().get(0), gem);
    }

    @Test
    public void addGem() {
        Gem newGem = getNewGem();
        emptyDiamondFund.addGem(newGem);
        diamondFund.addGem(newGem);

        assertEquals(emptyDiamondFund.getGems().size(), 1);
        assertEquals(diamondFund.getGems().size(), 2);

        assertEquals(emptyDiamondFund.getGems().get(0), newGem);
        assertEquals(diamondFund.getGems().get(0), gem);
        assertEquals(diamondFund.getGems().get(1), newGem);
    }

    private Gem getNewGem() {
        final String name = "Emerald";
        final Preciousness preciousness = Preciousness.Precious;
        final String origin = "Colombia";
        final VisualParameters visualParameters = new VisualParameters("green", 50.0f, 10);
        final float value = 5.0f;

        return new Gem(name, preciousness, origin, visualParameters, value);
    }

    @Test
    public void sortGems() {
        Gem newGem = getNewGem();
        diamondFund.addGem(newGem);
        diamondFund.sortGems();

        assertEquals(diamondFund.getGems().get(0), newGem);
        assertEquals(diamondFund.getGems().get(1), gem);
    }
}