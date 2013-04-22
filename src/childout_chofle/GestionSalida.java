/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Chofle;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class GestionSalida {
    ArrayList<Salida> findByAutorizado(int id){
        
        ArrayList<Salida> listaSalida = new ArrayList();
        try {
                      
            Statement sentenciaSQL = Conexion.conexion.createStatement();


            ResultSet resultados = sentenciaSQL.executeQuery("select * from salida where id_autorizado ="+ id);
            
            while (resultados.next()) {  
                int idSalida = resultados.getInt("idSalida"); 
                Date fecha = resultados.getDate("fecha");
                Time hora = resultados.getTime("hora");
                int idAutorizado = resultados.getInt("id_autorizado");      
                int idAlumno = resultados.getInt("idAlumno");
                String motivo = resultados.getString("motivo");
                String observaciones = resultados.getString("observaciones"); 
                Blob firma = resultados.getBlob("firma");
                Blob foto = resultados.getBlob("foto");
                
                Salida salida = new Salida(idSalida, fecha, hora, idAutorizado, idAlumno, motivo, observaciones, firma, foto);
                listaSalida.add(salida);
        
            }

        } catch (SQLException ex) {
            System.out.println("Error - Ejecucion sentencia SQL");
        }    
        
        return listaSalida;
    }
    
}
