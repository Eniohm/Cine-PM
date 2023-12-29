package com.ejemplo1;

import java.util.ArrayList;
import java.util.List;

public class Boleta{
    private Pelicula pelicula;
    private int totalPagar;
    private List<String> asientos;
    private String resultado;
    private Funcion funcion;

    public Boleta(Pelicula pelicula, int totalPagar, String resultado, Funcion funcion){
        this.pelicula = pelicula;
        this.totalPagar = 0;
        this.asientos = new ArrayList<String>();
        this.resultado = "";
        this.funcion = funcion;
    }

    public List<String> getAsientos(){
        return this.asientos;
    }
    public Pelicula getPelicula(){return this.pelicula;}
    public Funcion getFuncion(){return this.funcion;}
    public int getTotal(){
        return this.totalPagar = (this.funcion.getPrecio())*(this.asientos.size());
    }
    
    public void setPelicula(Pelicula newPelicula) {this.pelicula = newPelicula;}
    public void setFuncion(Funcion newFuncion) {this.funcion=newFuncion;}
    
    

    public void añadirAsiento(String newAsiento){
        if(!this.asientos.contains(newAsiento)){
            this.asientos.add(newAsiento);
        }
    }

    public void quitarAsiento(String asiento){
        this.asientos.remove(asiento);
    }

    public String asientosString(){
        this.resultado = String.join(" ", this.asientos);
        return this.resultado;
    }
}