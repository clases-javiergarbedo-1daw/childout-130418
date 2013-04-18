/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Alejandro;

/**
 *
 * @author DAW
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion.conectar("localhost","root","");
        GestionAlumno gestionAlumno = new GestionAlumno();
        //Alumno al = gestionAlumno.get(1);
        //System.out.println(gestionAlumno.get(1).id_alumno+","+gestionAlumno.get(1).nombre+","+gestionAlumno.get(1).grupo);
        //gestionAlumno.delete(al);
        //Alumno alumno = gestionAlumno.get(2);
        //alumno.setNombre("'Juan'");
        //alumno.setGrupo("'1ESO-A'");
        //gestionAlumno.update(alumno);
        for(int i=0; i<gestionAlumno.findByGrupo("1PRI-B").size(); i++){
        System.out.println(gestionAlumno.findByGrupo("1PRI-B").get(i));
        }

        
    }
}
