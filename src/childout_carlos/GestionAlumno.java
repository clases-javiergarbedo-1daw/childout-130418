/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_carlos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAW
 */
public class GestionAlumno {

    
    

    public Alumno get(int id_alumno) {
        Alumno alumno = null;
        try {

            String sql = "SELECT * FROM alumno where id_alumno =" + id_alumno;
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            id_alumno = rs.getInt("id_alumno");
            String nombre = rs.getString("nombre");
            String grupo = rs.getString("grupo");
            alumno = new Alumno(id_alumno, nombre, grupo);
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
        }
        return alumno;
    }

    public ArrayList<String> findGrupos() {
        ArrayList<String> grupos = new ArrayList();
        try {
            String sql = "Select grupo from alumno group by grupo";
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String grupo = rs.getString("grupo");
                grupos.add(grupo);
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
        }
        return grupos;
    }

    public boolean delete(Alumno alumno) {
        
        try {
            
            Statement stmt = Conexion.conexion.createStatement();
            String sql = "Delete * from alumno where id_alumno ="+ alumno.getId_alumno();
            stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(Alumno alumno) {
        try {
            
            Statement stmt = Conexion.conexion.createStatement();
            String sql = "Update alumno set " + alumno.getId_alumno()+ alumno.getNombre()+ alumno.getGrupo();
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
