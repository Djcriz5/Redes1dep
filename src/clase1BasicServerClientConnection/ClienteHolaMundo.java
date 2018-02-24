package clase1BasicServerClientConnection;

import java.net.*;
import java.io.*;

/**
 * Esto es par auna sola linea, si quisieramos leer mas lineas tendriamos que hacer
 * String dato="";
 * while((datos=br2.readLine())!=null){
 *     try{
 *         ...
 *         ...
 *     }catch .....
 * }
 */
public class ClienteHolaMundo {
        public static void main(String [] args){
            try{
                int pto=1234; //puerto
                BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Escribe la Ip del servidor ");
                String dir= br1.readLine();
                System.out.println("Intentando conectar con servidor ");
                Socket cl=new Socket(dir,pto);
                System.out.println("Conexion etablecida ... Recibiendo");
                BufferedReader br2=new BufferedReader(new InputStreamReader(cl.getInputStream()));
                String datos =br2.readLine();
                System.out.println("Datos:"+datos);



                /***
                 *   BufferedInputStream bis=New BufferedInputStream(cl.getInputStream());
                 *    byte []b =new byte[1500];
                 *    while(int n =bis.read(b)!=-1){// cuando son orientados a bytes es -1 cuando es a caracter se usa null la condicion de paro cuando no hay nada que leer
                 *    }
                 */

            }catch (Exception e ){
                e.printStackTrace();
            }
        }

}
