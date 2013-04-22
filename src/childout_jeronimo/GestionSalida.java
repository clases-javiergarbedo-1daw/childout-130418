package childout_jeronimo;





import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestionSalida {
    
    private int idSalida;
    
    Salida salida = new Salida(0, null, null, 0, 0, "", "", null, null,null);
    
    public Salida get(int idSalida) {
        try {
            Statement stmt = Conexion.conexion.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM salida WHERE id_salida = "+this.idSalida);
            while (rs.next()) {
                this.idSalida = rs.getInt("id_salida");
                
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
        }
        return salida;
    }
    
    ArrayList<Salida> findByAlumno(int id) {
        ArrayList listaAlumnos = new ArrayList();
        
        return listaAlumnos;
    }
    
}
