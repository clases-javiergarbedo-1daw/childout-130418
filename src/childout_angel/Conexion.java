/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_angel;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Castro
 */
public class Conexion {
    
    static Connection conexion = null;
    
    public static boolean conectar(String host, String usuario, String pass) {        
        try {
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://"+host+"/childout",
                    usuario, pass);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } 
}
    
}
