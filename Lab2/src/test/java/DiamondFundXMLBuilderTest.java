import Entities.Gem;
import Entities.Preciousness;
import Entities.VisualParameters;
import XML.DiamondFundXMLBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiamondFundXMLBuilderTest {

    private DiamondFundXMLBuilder builder = new DiamondFundXMLBuilder();

    @Test
    public void addGemTag() {
        builder.addOpenTag("gem").addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        assertEquals(builder.getRoot().getGems().get(0), new Gem());
    }

    @Test
    public void addNameTag() {
        String name = "Emerald";
        builder.addOpenTag("gem").
                addOpenTag("name").addData(name).addCloseTag("name").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getName(), name);
    }

    @Test
    public void addPreciousnessTag() {
        Preciousness preciousness = Preciousness.Precious;
        builder.addOpenTag("gem").
                addOpenTag("preciousness").addData(preciousness.toString()).addCloseTag("preciousness").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getPreciousness(), preciousness);
    }

    @Test
    public void addOriginTag() {
        String origin = "Columbia";
        builder.addOpenTag("gem").
                addOpenTag("origin").addData(origin).addCloseTag("origin").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getOrigin(), origin);
    }

    @Test
    public void addVisualParametersTag() {
        builder.addOpenTag("gem").
                addOpenTag("visual-parameters").addCloseTag("visual-parameters").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getVisualParameters(), new VisualParameters());
    }

    @Test
    public void addColorTag() {
        String color = "green";
        builder.addOpenTag("gem").
                addOpenTag("visual-parameters").
                addOpenTag("color").addData(color).addCloseTag("color").
                addCloseTag("visual-parameters").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getVisualParameters().getColor(), color);
    }

    @Test
    public void addOpacityTag() {
        float opacity = 50.0f;
        builder.addOpenTag("gem").
                addOpenTag("visual-parameters").
                addOpenTag("opacity").addData(Float.toString(opacity)).addCloseTag("opacity").
                addCloseTag("visual-parameters").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getVisualParameters().getOpacity(), opacity, 0.1e-12);
    }

    @Test
    public void addCutTypeTag() {
        int cutType = 10;
        builder.addOpenTag("gem").
                addOpenTag("visual-parameters").
                addOpenTag("cut-type").addData(Integer.toString(cutType)).addCloseTag("cut-type").
                addCloseTag("visual-parameters").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getVisualParameters().getCutType(), cutType);
    }

    @Test
    public void addValueTag() {
        float value = 10.0f;
        builder.addOpenTag("gem").
                addOpenTag("value").addData(Float.toString(value)).addCloseTag("value").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getValue(), value, 0.1e-12);
    }

    @Test
    public void addWrongTag() {
        builder.addOpenTag("gem").
                addOpenTag("tag").addData(null).addCloseTag("tag").
                addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertNull(gem.getId());
    }

    @Test
    public void addEmptyAttribute() {
        builder.addOpenTag("gem").addAttribute("id", null).addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getId(), "");
    }

    @Test
    public void addWrongAttribute() {
        builder.addOpenTag("gem").addAttribute("not-id", "value").addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertNull(gem.getId());
    }

    @Test
    public void addNullAttribute() {
        builder.addOpenTag("gem").addAttribute(null, "value").addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertNull(gem.getId());
    }

    @Test
    public void addAttribute() {
        String id = "emerald";
        builder.addOpenTag("gem").addAttribute("id", id).addCloseTag("gem");
        assertNotNull(builder.getRoot());
        assertEquals(builder.getRoot().getGems().size(), 1);
        Gem gem = builder.getRoot().getGems().get(0);
        assertEquals(gem.getId(), id);
    }

    @Test
    public void getRoot() {
        assertNotNull(builder.getRoot());
        assertTrue(builder.getRoot().getGems().isEmpty());
    }
}