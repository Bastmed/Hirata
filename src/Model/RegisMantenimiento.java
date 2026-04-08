package Model;

import java.util.Date;

public class RegisMantenimiento {

    private int idMantenimiento; // clave primaria
    private String modelo;
    private String patente;
    private Date fecha;
    private String tipo;
    private String descripcion;
    private int kilometraje;
    private int idCamion;

    // constructor vacío
    public RegisMantenimiento() {
    }

    // constructor completo
    public RegisMantenimiento(int idMantenimiento, String modelo, String patente, Date fecha, String tipo, String descripcion, int kilometraje, int idCamion) {
        this.idMantenimiento = idMantenimiento;
        this.modelo = modelo;
        this.patente = patente;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.kilometraje = kilometraje;
        this.idCamion = idCamion;
    }

    // GET y SET del ID
    public int getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(int idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public int getIdCamion() {
        return idCamion;
    }

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