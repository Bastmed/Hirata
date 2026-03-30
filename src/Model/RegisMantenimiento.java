package Model;

import java.util.Date;

public class RegisMantenimiento {

    private String modelo;
    private String patente;
    private Date fecha;
    private String tipo;
    private String descripcion;
    private int kilometraje;
    private int idCamion;

    // Constructor vacío (IMPORTANTE para el DAO)
    public RegisMantenimiento() {
    }

    // Constructor con parámetros (opcional)
    public RegisMantenimiento(String modelo, String patente, Date fecha, String tipo, String descripcion, int kilometraje, int idCamion) {
        this.modelo = modelo;
        this.patente = patente;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.kilometraje = kilometraje;
        this.idCamion = idCamion;
        
    }

    public int getIdCamion() {
        return idCamion;
    }

    // Getters y Setters
    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
}