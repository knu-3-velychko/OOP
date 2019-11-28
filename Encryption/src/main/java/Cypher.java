public class Cypher {
    private Type type;
    private String keyword;
    private int shift;

    public Cypher(String keyword){
        this.keyword = keyword;
        this.type = Type.XOR;
    }
    public Cypher(int shift){
        this.shift = shift;
        this.type =Type.Caesar;
    }

    public Type getType(){
        return type;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getShift() {
        return shift;
    }
}
