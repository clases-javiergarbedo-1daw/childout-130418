package childout_Manu;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection conexion = null;

    public static boolean conectar(String host, String usuario, String pass) {
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://" + host + "/childout",
                    usuario, pass);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
    }
}
