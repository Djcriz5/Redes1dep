package clase2EnvioDeArchivos;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Envia{
    public static void main(String []args){
        int pto=1234,n=0,percentage=0;
        String host="127.0.0.1";
        JFileChooser fileChooser=new JFileChooser();
        int selection=fileChooser.showOpenDialog(null);// here we save the user selection accept or cancel
        fileChooser.requestFocus();

        if(selection==JFileChooser.APPROVE_OPTION){
            File file=fileChooser.getSelectedFile();
            String nombre= file.getName();
            long tam=file.length();
            long enviados=0;
            String path= file.getAbsolutePath();
            try {
                Socket client = new Socket(host, pto);
                System.out.println("Connection done, starting file trasnfer" + file);
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());//usamos esto y no printwriter porque vamos a mandar diferentes tipos de datos
                DataInputStream dis = new DataInputStream(new FileInputStream(path));//si quiesieramos enviar objetos seria con Object output stream y tienen que estar serializados
                dos.writeUTF(nombre);
                dos.flush();
                dos.writeLong(tam);
                dos.flush();
                byte[] buffer = new byte[1500];//enviaremos el archivo en pedazos creamos un buffer lo suficientemente grande sin exder lo que podemos enviar
                while (enviados < tam) {//hasta que se hallan enviado todos los fatos del archivo
                    n = dis.read(buffer);// leemos del dis el tamaño del buffer y alamacenams cuanto se leyo para controlar el envio
                    enviados += n;
                    dos.write(buffer, 0, n);//escribe en el dos los datos que estan en el buffer desde el byte 0 hasta el n ( el tamaño de bits que se leyeron)
                    dos.flush();
                    percentage = (int) ((enviados * 100) / tam);
                }
                System.out.println("File transfer complete");
                dis.close();
                dos.close();
                client.close();


            } catch (IOException e) {
                e.printStackTrace();

            }


        }
        //para poder enviar varios archivos meter el metodo del client y envoquenlo por cada vez que se tenga que mandar un archivo
    }
}
