package clase2EnvioDeArchivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Recibe {//lado del servidor recibe un archivo por cliente
    public static void main(String[]args){//si quieres seleccionar la ruta de alm,acenimaineto concatenamos la ruta en el fileInputStream
        try{
            int pto=1234,n=0,percentage=0;
            ServerSocket server=new ServerSocket(pto);
            System.out.println("Service Started  waiting for files");
            for (;;){
                Socket client=server.accept();
                DataInputStream dis=new DataInputStream(client.getInputStream());
                String fileName=dis.readUTF();
                long tam=dis.readLong();
                DataOutputStream dos=new DataOutputStream(new FileOutputStream(fileName));
                System.out.println("Ready for  receive the file "+ fileName+" from "+client.getInetAddress()+" whit "+tam+" bytes of data");
                long received=0;
                while (received<tam){
                    byte[] buffer =new byte[1500];// del mismo tamaño del que envia
                    n=dis.read(buffer);
                    received+=n;
                    dos.write(buffer,0,n);
                    percentage=(int) ((received*100)/tam);
                    System.out.println("Transfer percentage "+percentage +" %");
                }
                System.out.println("transfer completed Archive received");
                dos.close();
                dis.close();
                client.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
