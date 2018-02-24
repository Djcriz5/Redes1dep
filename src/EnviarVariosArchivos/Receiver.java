package EnviarVariosArchivos;

import java.io.IOException;
import java.net.ServerSocket;

public class Receiver {
    private  int port;
    private ServerSocket server;
    public Receiver(int port){
        this.port=port;
        try {
            this.server=new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
