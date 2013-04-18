/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Diego;

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

    Statement stmt =null;
    ResultSet rsLista = null;


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
            String sql = "Delete from alumno where id_alumno ="+ alumno.getId_alumno();
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
    
    
    public ArrayList<Alumno> findByGrupo(String grupo) {
        ArrayList<Alumno> resultadoAlumno = new ArrayList();
        try {
            Statement stmt = Conexion.conexion.createStatement();
            String sql = "SELECT * FROM alumno WHERE (grupo like '%"+grupo+"%')";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                    int id_alumno = rs.getInt("id_alumno");
                    String nombre = rs.getString("nombre");
                    grupo = rs.getString("grupo");
                Alumno alumno = new Alumno (id_alumno,nombre,grupo);
                resultadoAlumno.add(alumno);
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            ex.printStackTrace();
        }
        return resultadoAlumno;
    }
    public int insert(Alumno alumno) {
        int autoincrementoID = -1;
         try {
            stmt = Conexion.conexion.createStatement();
        } catch (SQLException ex) {
            System.out.print("Error en el statement");
            
        }
        
        
        String nombre = alumno.nombre;
        String grupo = alumno.grupo;
        
        
        String sql = "INSERT INTO alumno (nombre,grupo) VALUES "
                + "('"+nombre+"','"+grupo+"')";
        
        try {
                 stmt.executeUpdate(sql);

        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
        
        
        
             sql = "SELECT DISTINCT LAST_INSERT_ID() FROM alumno ";
        
        try {
                 rsLista=stmt.executeQuery(sql);
                 if (rsLista.next()) 
                 {
               // al llamar el método getGeneratedKeys(); devuelve una tabla con una sola columna, solo vamos a usar la columna con índice 1 de tipo int
               autoincrementoID = rsLista.getInt(1);
               } else 
                 {
                   System.out.print("Error al Sacar el Id del Alumno");
                 } 
                 
                 
        }catch (Exception e) {
            System.out.print("Error");
            System.out.print(sql);
            e.printStackTrace();
        }
        
        
        
        return autoincrementoID;
 
    }
}
