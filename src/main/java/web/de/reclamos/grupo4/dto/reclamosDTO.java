package web.de.reclamos.grupo4.dto;

import java.sql.Date;
import java.util.Objects;

public class reclamosDTO {
    private int num_reclamos;
    private String rut;
    private Date fecha;
    private String categoria;
    private String reclamo;
    private String antecedentes;
    private String comentarios;
    private String estado;

    public reclamosDTO(int num_reclamos, String rut, Date fecha, String categoria, String reclamo, String antecedentes, String comentarios, String estado) {
        this.num_reclamos = num_reclamos;
        this.rut = rut;
        this.fecha = fecha;
        this.categoria = categoria;
        this.reclamo = reclamo;
        this.antecedentes = antecedentes;
        this.comentarios = comentarios;
        this.estado = estado;
    }

    public int getNum_reclamos() {
        return num_reclamos;
    }

    public void setNum_reclamos(int num_reclamos) {
        this.num_reclamos = num_reclamos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        reclamosDTO that = (reclamosDTO) o;
        return num_reclamos == that.num_reclamos &&
                Objects.equals(rut, that.rut) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(categoria, that.categoria) &&
                Objects.equals(reclamo, that.reclamo) &&
                Objects.equals(antecedentes, that.antecedentes) &&
                Objects.equals(comentarios, that.comentarios) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num_reclamos, rut, fecha, categoria, reclamo, antecedentes, comentarios, estado);
    }

    @Override
    public String toString() {
        return "reclamosDTO{" +
                "num_reclamos=" + num_reclamos +
                ", rut='" + rut + '\'' +
                ", fecha=" + fecha +
                ", categoria='" + categoria + '\'' +
                ", reclamo='" + reclamo + '\'' +
                ", antecedentes='" + antecedentes + '\'' +
                ", comentarios='" + comentarios + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
