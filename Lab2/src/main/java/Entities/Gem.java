package Entities;

import Entities.Preciousness;

public class Gem {
    private String id;
    private String name;
    private Preciousness preciousness;
    private String origin;
    private VisualParameters visualParameters;
    private float value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Preciousness getPresiousness() {
        return preciousness;
    }

    public void setPresiousness(Preciousness preciousness) {
        this.preciousness = preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public VisualParameters getVisualParameters() {
        return visualParameters;
    }

    public void setVisualParameters(VisualParameters visualParameters) {
        this.visualParameters = visualParameters;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Gem() {
    }

    public Gem(String name, Preciousness preciousness, String origin, VisualParameters visualParameters, Float value) {
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.visualParameters = visualParameters;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Entities.VisualParameters{" +
                "id: " +
                id +
                ", name: " +
                name +
                ", preciousness: " +
                preciousness +
                ", preciousness: " +
                preciousness +
                ", origin: " +
                origin +
                ", visual parameters: " +
                visualParameters +
                ", value: " +
                value +
                "}";
    }
}
