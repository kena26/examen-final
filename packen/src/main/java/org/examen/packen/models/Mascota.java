package org.examen.packen.models;

public class Mascota {

    private String codmascota;
    private String nombre; 
    private double peso;
    private String fecha;
    private String genero;
    private String raza;
    private String cedulacli;

    public String getCodmascota() {
        return codmascota;
    }
    public void setCodmascota(String codmascota) {
        this.codmascota = codmascota;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getCedulacli() {
        return cedulacli;
    }
    public void setCedulacli(String cedulacli) {
        this.cedulacli = cedulacli;
    } 

}