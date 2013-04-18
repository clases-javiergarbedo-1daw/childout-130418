/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package childout_carlos;

import java.sql.Blob;

/**
 *
 * @author DAW
 */
public class Autorizado {

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Autorizado(int id, String nombre, String apellidos, String dni, String email, String telefono, Blob foto, Blob firma, String parentesco, Blob huella, int denegado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.foto = foto;
        this.firma = firma;
        this.parentesco = parentesco;
        this.huella = huella;
        this.denegado = denegado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Blob getFirma() {
        return firma;
    }

    public void setFirma(Blob firma) {
        this.firma = firma;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public Blob getHuella() {
        return huella;
    }

    public void setHuella(Blob huella) {
        this.huella = huella;
    }

    public int getDenegado() {
        return denegado;
    }

    public void setDenegado(int denegado) {
        this.denegado = denegado;
    }
}
