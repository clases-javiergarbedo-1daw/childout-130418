
package childout_javier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDerby {
    
    static Connection conexion = null;
    
    public static boolean conectar(String host, String usuario, String pass) {        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby:childout";
            conexion = DriverManager.getConnection(url);
            return true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionDerby.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDerby.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode());
            return false;
        }
    }
}
