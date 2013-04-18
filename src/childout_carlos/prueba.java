/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_carlos;

/**
 *
 * @author Susana
 */
public class prueba {
   
    public static void main(String [] args){
        
        Conexion.conectar("localhost","root","");
    gestionAutorizado auto = new gestionAutorizado();
    
    System.out.println(auto.get(2)+","+ auto.get(2).getNombre()+"," + auto.get(2).getCorreo()+"," + auto.get(2).getTelefono()+"," + auto.get(2).getDni() +"," + auto.get(2).getFoto()+"," + auto.get(2).getFirma()+"," + auto.get(2).getParentesco()+","+ auto.get(2).getHuella()+","+ auto.get(2).getDenegado());
    }
}
