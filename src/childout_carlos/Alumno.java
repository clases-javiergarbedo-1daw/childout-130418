/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_carlos;



/**
 *
 * @author Castro
 */
public class Alumno {
    
    int id_alumno;
    String nombre;
    String grupo;
    
    public Alumno() {
        
    }

    public Alumno(int id_alumno, String nombre, String grupo) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
