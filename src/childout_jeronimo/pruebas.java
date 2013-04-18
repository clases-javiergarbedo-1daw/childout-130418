package childout_jeronimo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author DAW
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       
       Connection conexion = null;
       GestionRelacion gestRela = new GestionRelacion();
       Relacion rela = new Relacion(2,2,2);
       
      
        try {
            Conexion.conectar("localhost","root","");
            gestRela.insert(rela);
       
          
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ArrayList<Alumno> alumnos = new ArrayList();
        alumnos = gestRela.findByAutorizado(1);
        DefaultListModel listModel = new DefaultListModel();

        for(int i=0; i< alumnos.size(); i++) {
    
            listModel.add(i, alumnos.get(i));
            
            System.out.print(listModel);
        }
        
        
        
    }
    
    
}
    
