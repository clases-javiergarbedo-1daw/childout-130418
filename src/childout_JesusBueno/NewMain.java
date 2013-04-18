package childout_JesusBueno;


import childout_JesusBueno.GestionAutorizado;
import java.sql.Blob;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAW
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Blob foto=null;
        Blob firma=null;
        Blob huella=null;
        Conexion.conectar("localhost","root","");
        
        GestionAutorizado autorizado = new GestionAutorizado();
        Autorizado a =autorizado.findByDNI("11111112b");
        System.out.println("\n Apellidos: "+a.getApellidos()+"\n Correo: "+a.getCorreo()+"\n Dni: "+a.getDni());
        
        Autorizado aut = new Autorizado(0,"Juan","Perez","15435258g","sdfsdfdsfs@sdfsdf.com","664438009",foto,firma,"padre",huella,1);
        int newwid = autorizado.Insert(aut);
       System.out.println( aut.getApellidos());
         System.out.println(aut.getId());
         System.out.println(newwid);
    }
}