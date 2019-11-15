package Entities;

import java.util.Objects;

public class VisualParameters {
    private String color;
    private float opacity;
    private int cutType;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    public int getCutType() {
        return cutType;
    }

    public void setCutType(int cutType) {
        this.cutType = cutType;
    }

    public VisualParameters() {
    }

    public VisualParameters(String color, float opacity, int cutType) {
        this.color = color;
        this.opacity = opacity;
        this.cutType = cutType;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof VisualParameters)) return false;
        if (object == this) return true;

        VisualParameters parameters = (VisualParameters) object;
        return Objects.equals(this.color, parameters.color) &&
                this.opacity == parameters.opacity &&
                Objects.equals(this.cutType, parameters.cutType);

    }

    @Override
    public int hashCode() {
        return Objects.hash(color, opacity, cutType);
    }

    @Override
    public String toString() {
        return "Entities.VisualParameters{" +
                "color: " +
                color +
                ", opacity: " +
                opacity +
                ", cut type: " +
                cutType +
                "}";
    }
}
