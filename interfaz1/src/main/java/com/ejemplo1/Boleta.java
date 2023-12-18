package com.ejemplo1;

import java.util.ArrayList;
import java.util.List;

public class Boleta{
    private Pelicula pelicula;
    private int totalPagar;
    private List<String> asientos;

    public Boleta(Pelicula pelicula, int totalPagar){
        this.pelicula = null;
        this.totalPagar = 0;
        this.asientos = new ArrayList<String>();
    }

    public Pelicula getPelicula(){return this.pelicula;}
    public int totalPagar(){return this.totalPagar;}

    public void setPelicula(Pelicula newPelicula) {this.pelicula=newPelicula;}
    
    public void setTotal(){
        this.totalPagar = (this.pelicula.getFuncion().getPrecio())*(this.asientos.size());
    }

    public void añadirAsiento(String newAsiento){
        this.asientos.add(newAsiento);
    }

    public void mostrarAsientos(){
        for (String asiento : this.asientos) {
            System.out.println("|"+asiento+"| ");
        }
    }
}