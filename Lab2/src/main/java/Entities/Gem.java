package Entities;

import java.util.Objects;

public class Gem implements Comparable<Gem> {
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

    public Preciousness getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(Preciousness preciousness) {
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
                ", origin: " +
                origin +
                ", visual parameters: " +
                visualParameters +
                ", value: " +
                value +
                "}";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Gem)) return false;
        if (this == object) return true;
        Gem gem = (Gem) object;
        return Objects.equals(this.name, gem.name) &&
                this.preciousness == gem.preciousness &&
                Objects.equals(this.origin, gem.origin) &&
                this.visualParameters == gem.visualParameters &&
                Objects.equals(this.value, gem.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, preciousness, origin, visualParameters, value);
    }

    @Override
    public int compareTo(Gem gem) {
        if (this.name == null && gem.name == null) return 0;
        else if (this.name == null) return 1;
        else if(gem.name==null) return -1;
        int result = this.name.compareTo(gem.name);
        if (result == 0) return Float.compare(this.value, gem.value);
        return result;
    }

}
