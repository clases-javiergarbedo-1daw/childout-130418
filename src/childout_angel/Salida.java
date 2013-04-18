package childout_angel;


import java.sql.Blob;
import java.sql.Time;
import java.sql.Date;

public class Salida {
    
    private int idSalida;
    private Date fecha;
    private Time hora;
    private int idAutorizado;
    private int idAlumno;
    private String motivo;
    private String observaciones;
    private Blob firma;
    private Blob foto;
    
    public Salida(int idSalida, Date fecha, Time hora, int idAutorizado, int idAlumno, String motivo, String observaciones, Blob firma, Blob foto) {
        this.idSalida = idSalida;
        this.fecha = fecha;
        this.hora = hora;
        this.idAutorizado = idAutorizado;
        this.idAlumno = idAlumno;
        this.motivo = motivo;
        this.observaciones = observaciones;
        this.firma = firma;
        this.foto = foto;
    }
    
    public int getIdSalida() {
        return idSalida;
    }
    
    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getIdAutorizado() {
        return idAutorizado;
    }

    public void setIdAutorizado(int idAutorizado) {
        this.idAutorizado = idAutorizado;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Blob getFirma() {
        return firma;
    }

    public void setFirma(Blob firma) {
        this.firma = firma;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }
    
}