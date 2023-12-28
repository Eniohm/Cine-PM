package com.ejemplo1;
//import java.io.File;

public class Pelicula{
    private String nombre;
    private Funcion funcion;
    //private File portada;

    public Pelicula(String nombre, Funcion funcion/*,  File portada*/){
        this.nombre = "";
        this.funcion = funcion;
        //this.portada = null;
    }

    public String getNombre(){return this.nombre;}
    public Funcion getFuncion(){return this.funcion;}
    
    public void setFuncion(Funcion newFuncion) {this.funcion=newFuncion;}
    /*public void setPortada(String rutaDeArchivo){
        this.portada = new File(rutaDeArchivo);
    }*/
} 