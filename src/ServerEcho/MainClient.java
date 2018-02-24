package ServerEcho;

public class MainClient{
    public static void main(String[] args) {
        ClientEcho c = new ClientEcho();
        c.listenToServer();
    }
}
