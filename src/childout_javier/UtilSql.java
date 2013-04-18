/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_javier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilSql {
    public static void ejecutarRecursoSQL(Connection conexion, String archivoResorce) {
        try {
            String consulta = "";
            InputStream is = UtilSql.class.getResourceAsStream(archivoResorce);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linea = null;
            while((linea = br.readLine())!=null) {
                consulta += linea;
            }
            br.close();
            isr.close();
            is.close();

            String[] listaSentencias = consulta.split(";");
            Statement stmt = conexion.createStatement();
            for(String sentencia : listaSentencias) {
                stmt.executeUpdate(sentencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(UtilSql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
