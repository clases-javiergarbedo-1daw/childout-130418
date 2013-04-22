package childout_jeronimo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class GestionRelacion {
    Relacion relacion;
    
    ArrayList<Alumno> findByAutorizado(int id_autorizado) {
        ArrayList<Alumno> alumnos = new ArrayList();
        try { 
            System.out.println("1--");
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            ResultSet resultados = sentenciaSQL.executeQuery("SELECT * FROM alumno NATURAL JOIN relacion WHERE id_autorizado = "+ id_autorizado);
            
            System.out.println("2--");
            while (resultados.next()) { 
                Alumno alumno = new Alumno(resultados.getInt("id_alumno"), resultados.getString("nombre"), resultados.getString("grupo"));
                alumnos.add(alumno);
                
                           
            System.out.println("3--");            
            }
                
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return alumnos;
    }
    
    
    
    
 
    int insert(Relacion relacion) {
        this.relacion=relacion;
        try { 
            
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            int resultados = sentenciaSQL.executeUpdate("INSERT relacion SET id_alumno='" + relacion.getIdAlumno()+
                    "', id_autorizado='"+ relacion.getIdAlumno()+"'");
            
            
            
                
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return 0;
        //executeUpdate
    }
}
