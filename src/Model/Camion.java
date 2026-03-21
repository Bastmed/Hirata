/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author broma
 */
public class Camion {
    private int idCamion;
    private String patente;
    private String marca;
    private String modelo;
    private int kilometraje;
    private int anio;
    private String nombreConductor;

    public Camion() {
    }

    public Camion(int idCamion, String patente, String marca, String modelo, int kilometraje, int anio, String nombreconductor) {
        this.idCamion = idCamion;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.anio = anio;
        this.nombreConductor = nombreconductor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreconductor) {
        this.nombreConductor = nombreconductor;
    }

    public int getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    
}
