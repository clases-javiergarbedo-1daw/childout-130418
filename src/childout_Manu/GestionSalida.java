package childout_Manu;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class GestionSalida {

    public ArrayList<Salida> listaSalidas;
    
    public Salida get(int idSalida) {
        Salida salida = null;
        String sql = "SELECT * FROM salida WHERE id_salida = " + idSalida;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id_salida");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                int id_alumno = rs.getInt("id_alumno");
                int id_autorizado = rs.getInt("id_autorizado");
                String motivo = rs.getString("motivo");
                String observaciones = rs.getString("observacion");
                Blob firma = rs.getBlob("firma");
                Blob foto = rs.getBlob("foto");
                
                if (idSalida == id) {
                    salida = new Salida(id, fecha, hora, id_alumno, id_autorizado, motivo, observaciones, firma, foto);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar la base de datos");
            System.out.println(sql);
        }
        return salida;
    }

    public ArrayList<Salida> findByAlumno(int id) {
        Salida salida;
        listaSalidas = new ArrayList();
        String sql = "SELECT * FROM salida WHERE id_alumno = " + id;
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int idSalida = rs.getInt("id_salida");
                Date fecha = rs.getDate("fecha");
                Time hora = rs.getTime("hora");
                int id_alumno = rs.getInt("id_alumno");
                int id_autorizado = rs.getInt("id_autorizado");
                String motivo = rs.getString("motivo");
                String observaciones = rs.getString("observacion");
                Blob firma = rs.getBlob("firma");
                Blob foto = rs.getBlob("foto");
                
                salida = new Salida(idSalida, fecha, hora, id_autorizado, id_alumno, motivo, observaciones, firma, foto);
                listaSalidas.add(salida);
            }
        } catch (SQLException ex) {
            System.out.println("Error al consultar los datos");
        }
        return listaSalidas;
    }

    public ArrayList<Integer[]> findByFecha() {
        ArrayList<Integer[]> listaFechas = new ArrayList();
        return listaFechas;
    }

    public ArrayList<Integer[]> findByGrupo() {
        ArrayList<Integer[]> listaGrupos = new ArrayList();
        return listaGrupos;
    }
}