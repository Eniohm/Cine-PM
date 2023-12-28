package com.ejemplo1;

import java.util.ArrayList;
import java.util.List;

public class Boleta{
    private Pelicula pelicula;
    private int totalPagar;
    private List<String> asientos;
    private String resultado;

    public Boleta(Pelicula pelicula, int totalPagar, String resultado){
        this.pelicula = pelicula;
        this.totalPagar = 0;
        this.asientos = new ArrayList<String>();
        this.resultado = "";
    }

    public Pelicula getPelicula(){return this.pelicula;}

    public void setPelicula(Pelicula newPelicula) {this.pelicula=newPelicula;}
    
    public int getTotal(){
        return this.totalPagar = (this.pelicula.getFuncion().getPrecio())*(this.asientos.size());
    }

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