/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Diego;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */

public class GestionRelacion {

        Relacion relacion;
        
    boolean delete(Relacion relacion){
        this.relacion=relacion;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            String sql = "DELETE FROM relacion WHERE id_relacion="+relacion.getIdRelaccion();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GestionRelacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la base de datos");
            return false;
        }
        return true;
    }   
    
    boolean update(Relacion relacion){
        this.relacion=relacion;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            String sql = "UPDATE  relacion SET id_alumno="+relacion.getIdAlumno()+", id_autorizado="+relacion.getIdAutorizado()+"WHERE id_relacion="+relacion.getIdRelaccion();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GestionRelacion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al consultar la base de datos");
            return false;
        }
        return true;
    }   
}