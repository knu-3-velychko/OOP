import Entities.VisualParameters;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisualParametersTest {
    private String color = "red";
    private float opacity = 50.0f;
    private int cutType = 10;

    private VisualParameters emptyParameters = new VisualParameters();
    private VisualParameters parameters = new VisualParameters(color, opacity, cutType);

    @Test
    public void getColor() {
        assertNull(emptyParameters.getColor());
        assertNotNull(parameters.getColor());
        assertEquals(parameters.getColor(), color);
    }

    @Test
    public void setColor() {
        String newColor = "yellow";
        emptyParameters.setColor(newColor);
        parameters.setColor(newColor);

        assertNotNull(emptyParameters.getColor());
        assertNotNull(parameters.getColor());
        assertEquals(emptyParameters.getColor(), newColor);
        assertEquals(parameters.getColor(), newColor);
    }

    @Test
    public void getOpacity() {
        assertEquals(emptyParameters.getOpacity(), 0.0, 0.1e-10);
        assertEquals(parameters.getOpacity(), opacity, 0.1e-10);
    }

    @Test
    public void setOpacity() {
        float newOpacity = 30.0f;
        emptyParameters.setOpacity(newOpacity);
        parameters.setOpacity(newOpacity);

        assertEquals(emptyParameters.getOpacity(), newOpacity, 0.1e-10);
        assertEquals(parameters.getOpacity(), newOpacity, 0.1e-10);
    }

    @Test
    public void getCutType() {
        assertEquals(emptyParameters.getCutType(), 0);
        assertEquals(parameters.getCutType(), cutType);
    }

    @Test
    public void setCutType() {
        int newCutType = 12;
        emptyParameters.setCutType(newCutType);
        parameters.setCutType(newCutType);

        assertEquals(emptyParameters.getCutType(), newCutType);
        assertEquals(parameters.getCutType(), newCutType);
    }

    @Test
    public void testEquals() {
        parametersNotEquals(emptyParameters, parameters);

        parametersNotEquals(new Object(), parameters);
        parametersNotEquals(new Object(), emptyParameters);

        assertEquals(emptyParameters, emptyParameters);
        assertEquals(parameters, parameters);

        VisualParameters newEmptyParameters = new VisualParameters();
        VisualParameters newParameters = new VisualParameters(color, opacity, cutType);

        parametersEquals(emptyParameters, newEmptyParameters);
        parametersEquals(parameters, newParameters);

        newEmptyParameters.setColor(color);
        parametersNotEquals(parameters,newEmptyParameters);
        newEmptyParameters.setOpacity(opacity);
        parametersNotEquals(parameters,newEmptyParameters);

    }

    private void parametersNotEquals(Object parameters1, Object parameters2) {
        assertNotEquals(parameters1, parameters2);
        assertNotEquals(parameters2, parameters1);
    }

    private void parametersEquals(Object parameters1, Object parameters2) {
        assertEquals(parameters1, parameters2);
        assertEquals(parameters2, parameters1);
    }

    @Test
    public void testHashCode() {
        assertNotEquals(emptyParameters.hashCode(), parameters.hashCode());

        assertEquals(emptyParameters.hashCode(), emptyParameters.hashCode());
        assertEquals(parameters.hashCode(), parameters.hashCode());

        VisualParameters newEmptyParameters = new VisualParameters();
        VisualParameters newParameters = new VisualParameters(color, opacity, cutType);

        assertEquals(emptyParameters.hashCode(), newEmptyParameters.hashCode());
        assertEquals(parameters.hashCode(), newParameters.hashCode());
    }

    @Test
    public void testToString() {
        String emptyString = "Entities.VisualParameters{" +
                "color: " +
                null +
                ", opacity: " +
                0.0 +
                ", cut type: " +
                0 +
                "}";

        String parametersString = "Entities.VisualParameters{" +
                "color: " +
                color +
                ", opacity: " +
                opacity +
                ", cut type: " +
                cutType +
                "}";

        assertEquals(emptyString, emptyParameters.toString());
        assertEquals(parametersString, parameters.toString());
    }
}