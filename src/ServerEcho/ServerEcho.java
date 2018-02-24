package ServerEcho;

import java.io.*;
import java.net.*;

public class ServerEcho {
    private Socket client;
    private ServerSocket server;

    public ServerEcho() {
        try {
            this.server = new ServerSocket(1234);
            this.server.setReuseAddress(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void launchServer(String firstMessage) {
        PrintWriter output;
        String messageReceived;
        Boolean flag = true;
        BufferedReader input;
        try {
            System.out.println("waiting for client");
            client = server.accept();
            System.out.println("Connection done: " + client.getInetAddress());
            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
            output.println(firstMessage);
            output.flush();
            while (flag) {
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                messageReceived = input.readLine();
                System.out.println("Message from client is  received : " + messageReceived + "\n Sending message back");
                output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                output.println(messageReceived + " Echo");

                //output.println(messageReceived+" Echo");
                output.flush();
                if (messageReceived.equals("salir")) {
                    flag = false;
                    client.close();
                }

            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void dropDownServer() {
        try {
            server.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
