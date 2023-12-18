package com.ejemplo1;

public class Funcion{
    private Sala sala;
    private String horaInicio;
    private String horaTermino;
    private int precio;

    public Funcion(Sala sala, String horaInicio, String horaTermino, int precio){
        this.sala = null;
        this.horaInicio = null;
        this.horaTermino = null;
        this.precio = 3000;
    }
    
    public Sala getSala(){return this.sala;}
    public String getHoraInicio(){return this.horaInicio;}
    public String getHoraTermino(){return this.horaTermino;}
    public int getPrecio(){return this.precio;}
}