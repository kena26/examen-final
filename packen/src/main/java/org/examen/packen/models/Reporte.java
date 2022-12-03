package org.examen.packen.models;


public class Reporte {
    private String servicios;
    private String nombremascota;
    private String nombreclie;
    private String fecha;
    private String diagnostico;
    private String tratamiento;
    public String getServicios() {
        return servicios;
    }
    public void setServicios(String servicios) {
        this.servicios = servicios;
    }
    public String getNombremascota() {
        return nombremascota;
    }
    public void setNombremascota(String nombremascota) {
        this.nombremascota = nombremascota;
    }
    public String getNombreclie() {
        return nombreclie;
    }
    public void setNombreclie(String nombreclie) {
        this.nombreclie = nombreclie;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
}