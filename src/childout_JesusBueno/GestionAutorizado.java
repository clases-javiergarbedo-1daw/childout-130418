/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_JesusBueno;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW
 */
public class GestionAutorizado {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String dni;
    private Blob foto;
    private Blob firma;
    private String parentesco;
    private Blob huella;
    private int denegado;
    private int autoincrementoID;
    ResultSet rsLista = null;
    
    Autorizado findByDNI(String dni) {
        
        String sql = "Select * from autorizado where dni = '" + dni+"'" ;
        
        
        try {
            
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            ResultSet rs = sentenciaSQL.executeQuery(sql);
            rs.first();
             id = rs.getInt("id_autorizado");
             nombre = rs.getString("nombre");
             apellidos = rs.getString("apellidos");
             email = rs.getString("email");
             telefono = rs.getString("telefono");
            foto = rs.getBlob("foto");
             firma = rs.getBlob("firma");
             parentesco = rs.getString("parentesco");
             huella = rs.getBlob("huella");
            denegado = rs.getInt("denegado");
            
            Autorizado autorizado = new Autorizado( id,nombre, apellidos, email, telefono, dni, foto, firma, parentesco, huella, denegado);
            
            return autorizado;
            
        } catch (SQLException ex) {
            Logger.getLogger(GestionAutorizado.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
        
        
    }
    
    int Insert(Autorizado autorizado) {
        
        id = autorizado.getId();
         nombre = autorizado.getNombre();
         apellidos = autorizado.getApellidos();
         email = autorizado.getCorreo();
         telefono = autorizado.getTelefono();
         dni = autorizado.getDni();
         foto = autorizado.getFoto();
        firma = autorizado.getFirma();
         parentesco = autorizado.getParentesco();
        huella = autorizado.getHuella();
        denegado = autorizado.getDenegado();
        
        
        String sql = "INSERT INTO autorizado VALUES "
                + "("+0+",'" + nombre + "','"+apellidos+ "','" + dni + "','" + email + "','" + telefono + "','" + foto + "','" + firma + "','" + parentesco + "','" + huella + "','" + denegado + "')";
        
        
        try {
            Statement sentenciaSQL = Conexion.conexion.createStatement();
            sentenciaSQL.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);            
            ResultSet resultado = sentenciaSQL.getGeneratedKeys();
            
            if (resultado.next()) {
                autoincrementoID = resultado.getInt(1);
            } else {
                System.out.print("Error al Sacar el Id del Autorizado");
                
                
            }
            
        } catch (Exception e) {
            System.out.print("Error en la sentencia sql: ");
            System.out.print(sql);
            e.printStackTrace();
            
        }
        return autoincrementoID;
        
    }
}
