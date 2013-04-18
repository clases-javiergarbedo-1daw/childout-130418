/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_Diego;

/**
 *
 * @author diego
 */
public class Relacion {
    private int IdAlumno;
    private int IdAutorizado;
    private int IdRelacion;

    Relacion(int IdAlumno, int IdRelacion,int IdAutorizado) {
        this.IdAlumno = IdAlumno;
        this.IdAutorizado = IdAutorizado;
        this.IdRelacion = IdRelacion;
    }
    
    public int getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(int IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public int getIdAutorizado() {
        return IdAutorizado;
    }

    public void setIdAutorizado(int IdAutorizado) {
        this.IdAutorizado = IdAutorizado;
    }

    public int getIdRelaccion() {
        return IdRelacion;
    }

    public void setIdRelaccion(int IdRelaccion) {
        this.IdRelacion = IdRelaccion;
    }
}
