package clase1BasicServerClientConnection;

import  java.net.*;
import  java.io.*;
public class ServerHolaMundo {




    public static void main(String[] args) {
        try {
                ServerSocket s=new ServerSocket(1234);
                s.setReuseAddress(true); //para evitar el error de  purto ya usado
                System.out.println("servicio iniciado esperando clientes");
                for (;;){
                    Socket cl=s.accept();
                    String msj="Hola Mundo desde un servidor de flujo bloqueante";
                    PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                    pw.println(msj); // print write + "\n\r"
                    pw.flush();//limpiar
                    pw.close();
                    cl.close();
                    /***
                     * En caso de necesitar enviar Bytes
                     * byte[] b =msj.getbytes();
                     * BufferedOutputStream bos=new bufferedOutputStream(cl.getOutputStream());
                     * bos.write(b);
                     * bos.flush();
                     * ...
                     * ..
                     */


                    /**
                     * DataOutputStream dos=new DataOutputStream(cl.getOutputScream());
                     * //primitivos=valores int, float, double,long
                     * //objetos=referencias  Integer,Float,Double ....
                     * dos.writeUTF(msj);
                     * dos.writeInt(s);
                     * dos.writeFloat(iof);
                     * ....
                     * ..
                     */

                }//for


        }catch (Exception e){
            e.printStackTrace();
        }//catch
    }//main
}
