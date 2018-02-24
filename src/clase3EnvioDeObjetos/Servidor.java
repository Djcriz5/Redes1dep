package clase3EnvioDeObjetos;
import java.net.*;
import java.io.*;

public class Servidor {
    public static void main(String []args){
        try{
            int pto=8888;
            ServerSocket server = new ServerSocket(pto);
            System.out.println("Servicio Iniciado  .. esperando clientes ");
            for(;;){
                Socket client=server.accept();
                System.out.println("Cliente conectado desde "+client.getInetAddress()+" : "+client.getPort());
                ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
                ObjectInputStream ois= new ObjectInputStream(client.getInputStream());
                Persona p1=(Persona)ois.readObject();
                System.out.println("Nombre :"+p1.nombre+ "  Edad "+p1.edad+" Telefono "+p1.telefono+" Sueldo "+p1.sueldo);
                Persona p2= new Persona("Pepe",25,"53333333",10.8f);
                oos.writeObject(p2);
                oos.flush();
                System.out.println("objeto enviado");
                ois.close();
                oos.close();
                client.close();
                


            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
