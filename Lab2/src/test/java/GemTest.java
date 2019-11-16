import Entities.Gem;
import Entities.Preciousness;
import Entities.VisualParameters;
import org.junit.Test;

import static org.junit.Assert.*;

public class GemTest {
    private final String name = "Emerald";
    private final Preciousness preciousness = Preciousness.Precious;
    private final String origin = "Colombia";
    private final VisualParameters visualParameters = new VisualParameters("green", 50.0f, 10);
    private final float value = 5.0f;

    private Gem emptyGem = new Gem();
    private Gem gem = new Gem(name, preciousness, origin, visualParameters, value);

    @Test
    public void getId() {
        assertNull(emptyGem.getId());
        assertNull(gem.getId());
    }

    @Test
    public void setId() {
        String id = "123";
        emptyGem.setId(id);
        gem.setId(id);

        assertEquals(emptyGem.getId(), id);
        assertEquals(gem.getId(), id);
    }

    @Test
    public void getName() {
        assertNull(emptyGem.getName());
        assertNotNull(gem.getName());
        assertEquals(gem.getName(), name);
    }

    @Test
    public void setName() {
        String newName = "Ruby";
        emptyGem.setName(newName);
        gem.setName(newName);

        assertNotNull(emptyGem.getName());
        assertNotNull(gem.getName());
        assertEquals(emptyGem.getName(), newName);
        assertEquals(gem.getName(), newName);
    }

    @Test
    public void getPreciousness() {
        assertNull(emptyGem.getPreciousness());
        assertNotNull(gem.getPreciousness());
        assertEquals(gem.getPreciousness(), preciousness);
    }

    @Test
    public void setPreciousness() {
        Preciousness newPreciousness = Preciousness.Semiprecious;
        emptyGem.setPreciousness(newPreciousness);
        gem.setPreciousness(newPreciousness);

        assertNotNull(emptyGem.getPreciousness());
        assertNotNull(gem.getPreciousness());
        assertEquals(emptyGem.getPreciousness(), newPreciousness);
        assertEquals(gem.getPreciousness(), newPreciousness);
    }

    @Test
    public void getOrigin() {
        assertNull(emptyGem.getOrigin());
        assertNotNull(gem.getOrigin());
        assertEquals(gem.getOrigin(), origin);
    }

    @Test
    public void setOrigin() {
        String newOrigin = "Muzo";
        emptyGem.setOrigin(newOrigin);
        gem.setOrigin(newOrigin);

        assertNotNull(emptyGem.getOrigin());
        assertNotNull(gem.getOrigin());
        assertEquals(emptyGem.getOrigin(), newOrigin);
        assertEquals(gem.getOrigin(), newOrigin);
    }

    @Test
    public void getVisualParameters() {
        assertNull(emptyGem.getVisualParameters());
        assertNotNull(gem.getVisualParameters());
        assertEquals(gem.getVisualParameters(), visualParameters);
    }

    @Test
    public void setVisualParameters() {
        VisualParameters newVisualParameters = new VisualParameters("yellow", 30.0f, 12);
        emptyGem.setVisualParameters(newVisualParameters);
        gem.setVisualParameters(newVisualParameters);

        assertNotNull(emptyGem.getVisualParameters());
        assertNotNull(gem.getVisualParameters());
        assertEquals(emptyGem.getVisualParameters(), newVisualParameters);
        assertEquals(gem.getVisualParameters(), newVisualParameters);
    }

    @Test
    public void getValue() {
        assertEquals(emptyGem.getValue(), 0.0f, 0.1e-12);
        assertEquals(gem.getValue(), value, 0.1e-12);
    }

    @Test
    public void setValue() {
        float newValue = 10.0f;
        emptyGem.setValue(newValue);
        gem.setValue(newValue);

        assertEquals(emptyGem.getValue(), newValue, 0.1e-12);
        assertEquals(gem.getValue(), newValue, 0.1e-12);
    }

    @Test
    public void testToString() {
        String emptyString = "Gem{" +
                "id: " +
                null +
                ", name: " +
                null +
                ", preciousness: " +
                null +
                ", origin: " +
                null +
                ", visual parameters: " +
                null +
                ", value: " +
                0.0f +
                "}";

        String gemString = "Gem{" +
                "id: " +
                null +
                ", name: " +
                name +
                ", preciousness: " +
                preciousness +
                ", origin: " +
                origin +
                ", visual parameters: " +
                visualParameters +
                ", value: " +
                value +
                "}";

        assertEquals(emptyString, emptyGem.toString());
        assertEquals(gemString, gem.toString());
    }

    @Test
    public void testEquals() {
        gemsNotEquals(emptyGem, gem);

        gemsNotEquals(new Object(), emptyGem);
        gemsNotEquals(new Object(), gem);

        assertEquals(emptyGem, emptyGem);
        assertEquals(gem, gem);

        Gem newEmptyGem = new Gem();
        Gem newGem = new Gem(name, preciousness, origin, visualParameters, value);

        gemsEquals(emptyGem, newEmptyGem);
        gemsEquals(gem, newGem);

        newEmptyGem.setName(name);
        gemsNotEquals(gem, newEmptyGem);

        newEmptyGem.setPreciousness(preciousness);
        gemsNotEquals(gem, newEmptyGem);

        newEmptyGem.setOrigin(origin);
        gemsNotEquals(gem, newEmptyGem);

        newEmptyGem.setVisualParameters(visualParameters);
        gemsNotEquals(gem, newEmptyGem);
    }


    private void gemsEquals(Object gem1, Object gem2) {
        assertEquals(gem1, gem2);
        assertEquals(gem2, gem1);
    }

    private void gemsNotEquals(Object gem1, Object gem2) {
        assertNotEquals(gem1, gem2);
        assertNotEquals(gem2, gem1);
    }

    @Test

    public void testHashCode() {
        assertNotEquals(emptyGem.hashCode(), gem.hashCode());

        assertEquals(emptyGem.hashCode(), emptyGem.hashCode());
        assertEquals(gem.hashCode(), gem.hashCode());

        Gem newEmptyGem = new Gem();
        Gem newGem = new Gem(name, preciousness, origin, visualParameters, value);

        assertEquals(emptyGem.hashCode(), newEmptyGem.hashCode());
        assertEquals(gem.hashCode(), newGem.hashCode());
    }

    @Test
    public void compareTo() {
        Gem newEmptyGem = new Gem();
        Gem newGem = new Gem(name, preciousness, origin, visualParameters, value);

        assertEquals(emptyGem.compareTo(gem), 1);
        assertEquals(gem.compareTo(emptyGem), -1);
        assertEquals(emptyGem.compareTo(newEmptyGem), 0);

        assertEquals(newGem.compareTo(gem), 0);
        assertEquals(gem.compareTo(newGem), 0);

        newGem.setValue(10.0f);
        assertEquals(newGem.compareTo(gem) ,Float.compare(newGem.getValue(), gem.getValue()));
        assertEquals(gem.compareTo(newGem) ,Float.compare(gem.getValue(), newGem.getValue()));

        newGem.setName("yellow");
        assertEquals(newGem.compareTo(gem) ,newGem.getName().compareTo(gem.getName()));
        assertEquals(gem.compareTo(newGem) ,gem.getName().compareTo(newGem.getName()));

    }
}