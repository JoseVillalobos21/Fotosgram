package com.example.desempenio.ui.dashboard;

import java.util.List;

public class Peleador {
    private String nombre;
    private String fechaNac;
    private String planeta;
    private String universo;
    private String poder;
    private String raza;
    private List<String> tecnicas;

    // Constructor
    public Peleador(String nombre, String fechaNac, String planeta, String universo, String poder, String raza,  List<String> tecnicas) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.planeta = planeta;
        this.universo = universo;
        this.poder = poder;
        this.raza = raza;
        this.tecnicas = tecnicas;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getPlaneta() {
        return planeta;
    }
    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getUniverso() {
        return universo;
    }
    public void setUniverso(String universo) {
        this.universo = universo;
    }

    public String getPoder() {
        return poder;
    }
    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public List<String> getTecnicas() {
        return tecnicas;
    }
}
