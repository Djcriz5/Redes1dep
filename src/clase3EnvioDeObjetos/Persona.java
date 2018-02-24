package clase3EnvioDeObjetos;
import java.io.Serializable;

/**
 * Serialicacion
 *
 * Para el envio de objetos a travez de la conexion es necesario utilzar  los flujos orientados a Byte
 * "objectOutputStream" , Ademas de implementar la interfaz java.io.Serializable en la definicion de la clase objeto a ser trasnmitido
 *
 */
public class Persona implements  Serializable{
    String nombre;
    int edad;
    String telefono;
    //si yo no quiero que se mande un dato cuando se envia taravez de la red debemos anteponerle la propiedad transiet es decir
    //si ponemos  transient float sueldo; este dato no sera enviado cuandon un objeto persona se envie atravez de la red
    float sueldo;
    public Persona(String nombre, int edad, String telefono , float sueldo){
        this.nombre=nombre;
        this.edad=edad;
        this.telefono=telefono;
        this.sueldo=sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }
}
