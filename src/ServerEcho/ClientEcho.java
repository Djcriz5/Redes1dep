package ServerEcho;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientEcho {
    private Socket client;

    public ClientEcho() {
        try {
            this.client = new Socket("localhost", 1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listenToServer() {
        System.out.println("Listening Server");
        Boolean flag = true;
        String newMessage;
        Scanner scanner = new Scanner(System.in);
        PrintWriter output;
        try {
        while (flag) {
            //System.out.println("here1");

            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //System.out.println("here2");

            System.out.println("Message received :" + input.readLine());
           // System.out.println("here3");

            newMessage = scanner.nextLine();
                client.getOutputStream();
                if (newMessage.equals("exit")) {
                    client.close();
                    flag=false;
                }else {
                    System.out.println("Sending message : " + newMessage);
                    output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
                    output.println(newMessage);
                    output.flush();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
