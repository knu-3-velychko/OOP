public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 5010);
        client.connect();
        Student student = new Student("Tai", 19, "cybernetics");
        client.sendObject(student);
    }
}
