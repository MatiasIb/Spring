package web.de.reclamos.grupo4.dto;

import java.util.Objects;

public class registroDTO {
    private String rut;
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String nom_usuario;
    private String clave;
    private String rol;

    public registroDTO(String rut, String nombre, String apellido, String direccion, String correo, String nom_usuario, String clave, String rol) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.nom_usuario = nom_usuario;
        this.clave = clave;
        this.rol = rol;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        registroDTO that = (registroDTO) o;
        return Objects.equals(rut, that.rut) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellido, that.apellido) &&
                Objects.equals(direccion, that.direccion) &&
                Objects.equals(correo, that.correo) &&
                Objects.equals(nom_usuario, that.nom_usuario) &&
                Objects.equals(clave, that.clave) &&
                Objects.equals(rol, that.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rut, nombre, apellido, direccion, correo, nom_usuario, clave, rol);
    }

    @Override
    public String toString() {
        return "registroDTO{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", correo='" + correo + '\'' +
                ", nom_usuario='" + nom_usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}