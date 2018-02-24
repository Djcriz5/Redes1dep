package clase3EnvioDeObjetos;
import java.net.*;
import java.io.*;
//para validar tipos de datos se usaria instance of
public class Cliente {
    public static void main(String[] args){
         try{
             int pto=8888;
             String dst="127.0.0.1";
             Socket client=new Socket(dst,pto);
             System.out.println("Conexion establecida .. produciendo objeto");
             Persona per=new Persona("juan",11,"57519638",20.5f);
             System.out.println("Se enviara el objeto con los datos.");
             System.out.println("Nombre :"+per.nombre+ "  Edad "+per.edad+" Telefono "+per.telefono+" Sueldo "+per.sueldo);
             ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
             ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
             oos.writeObject(per);
             oos.flush();
             System.out.println("Objeto enviado ...  preparado para recibir un objeto ");
             Persona per2=(Persona) ois.readObject();
             System.out.println("Objeto recibido   Nombre :"+per2.nombre+ "  Edad "+per2.edad+" Telefono "+per2.telefono+" Sueldo "+per2.sueldo);
                ois.close();
                oos.close();
             client.close();


         }catch (Exception e){
             e.printStackTrace();
         }
    }
}
