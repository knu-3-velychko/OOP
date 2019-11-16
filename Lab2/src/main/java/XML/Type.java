package XML;

public enum Type {
    Empty("empty"),
    Gem("gem"),
    Name("name"),
    Preciousness("preciousness"),
    Origin("origin"),
    VisualParameters("visual-parameters"),
    Color("color"),
    Opacity("opacity"),
    CutType("cut-type"),
    Value("value");

    private String type;

    Type(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
