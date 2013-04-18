/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_javier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

/**
 *
 * @author javier
 */
public class UtilCsv {
    
    /**
     * Permite al usuario seleccionar un archivo CSV y retorna un ArrayList de
     * arrays String con todo el contenido del archivo, eliminando las comillas
     * dobles que encierren a los textos
     * @return Contenido del archivo CSV seleccionado
     */
    public static ArrayList<String[]> csvFileChooseToArray() {
        ArrayList<String[]> retorno = new ArrayList();
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showOpenDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            BufferedReader br = null;
            try {
                File archivoElegido = fc.getSelectedFile();
                br = new BufferedReader(new InputStreamReader(new FileInputStream(archivoElegido),"8859_1"));
                Pattern p = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*(?![^\"]*\"))");
                String linea = br.readLine();
                while(linea!=null) {
                    String[] fields = p.split(linea);
                    for (int i = 0; i < fields.length; i++) {
                        fields[i] = fields[i].replace("\"", "");
                    }
                    retorno.add(fields);
                    linea = br.readLine();
                }
                return retorno;
            } catch (IOException ex) {
                Logger.getLogger(MainPruebas.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainPruebas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }
}
