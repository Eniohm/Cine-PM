package com.ejemplo1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    @Override
    public void start(Stage ventana) throws IOException {
        ventana.setTitle("Cine PM");
        //********************************************ESCENA BIENVENIDA*************************************************//
        VBox contenedor = new VBox();
        HBox botones = new HBox();
        HBox titulo = new HBox();
        
        Label textoBienvenida = new Label("Bienvenido a la pagina oficial de reservas del cine PM");
        Button botonSalir = new Button("Salir");
        Button botonReservar = new Button("Reservar");
        
        titulo.setAlignment(Pos.CENTER);
        botones.setAlignment(Pos.CENTER);
        
        titulo.getChildren().addAll(textoBienvenida);
        botones.getChildren().addAll(botonSalir, botonReservar);
        contenedor.getChildren().addAll(titulo, botones);

        Scene escena = new Scene(contenedor, 350, 300);
        
        ventana.setScene(escena);
        ventana.show();
        
        //********************************************ESCENA PELICULAS*************************************************//
        VBox contenedorPeliculas = new VBox();
        HBox tituloPeliculas = new HBox();
        HBox botonesPeliculas = new HBox();
        HBox botonesAtrasSiguientePeliculas = new HBox();

        Label textoPeliculas = new Label("Peliculas disponibles");
        Button pelicula1 = new Button("Ratman"); //pelicula.getNombre()
        Button atrasPeliculas = new Button("Atras");
        Button siguientePeliculas = new Button("Siguiente");

        tituloPeliculas.setAlignment(Pos.CENTER);
        botonesPeliculas.setAlignment(Pos.CENTER);
        botonesAtrasSiguientePeliculas.setAlignment(Pos.BOTTOM_LEFT);

        tituloPeliculas.getChildren().addAll(textoPeliculas);
        botonesPeliculas.getChildren().addAll(pelicula1);
        botonesAtrasSiguientePeliculas.getChildren().addAll(atrasPeliculas, siguientePeliculas);
        contenedorPeliculas.getChildren().addAll(tituloPeliculas, botonesPeliculas, botonesAtrasSiguientePeliculas);

        Scene escenaPelicula = new Scene(contenedorPeliculas, 350, 300);

        //pelicula1.setOnAction(e -> boleta.setPelicula());
        //pelicula2.setOnAction(e -> boleta.setPelicula());
        
        //********************************************ESCENA FUNCIONES*************************************************//
        VBox contenedorFunciones = new VBox();
        HBox tituloFunciones = new HBox();
        VBox botonesFunciones = new VBox();
        HBox botonesAtrasSiguienteFunciones = new HBox();

        Label textoFunciones = new Label("Funciones");
        Label textofuncion1 = new Label("Sala 1 \nHora de inicio: 10:00am\nHora de Termino: 11:30pm");
        Button funcion1 = new Button(textofuncion1.getText());
        Button atrasFunciones = new Button("Atras");
        Button siguienteFunciones = new Button("Siguiente");

        tituloFunciones.setAlignment(Pos.CENTER);
        botonesFunciones.setAlignment(Pos.CENTER);
        botonesAtrasSiguienteFunciones.setAlignment(Pos.BOTTOM_LEFT);

        tituloFunciones.getChildren().addAll(textoFunciones);
        botonesFunciones.getChildren().addAll(funcion1);
        botonesAtrasSiguienteFunciones.getChildren().addAll(atrasFunciones, siguienteFunciones);
        contenedorFunciones.getChildren().addAll(tituloFunciones, botonesFunciones, botonesAtrasSiguienteFunciones);

        Scene escenaFuncion = new Scene(contenedorFunciones, 350, 300);

        //********************************************ESCENA ASIENTOS**************************************************//
        // Creamos un objeto GridPane
        GridPane asientos = new GridPane();
        
        
        // Creamos un bucle para llenar el grid con rectángulos
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Creamos un rectángulo
                Button Silla = new Button((i+1)+","+(j+1));
                
                // Añadimos el rectángulo al grid en la posición i, j
                asientos.add(Silla, i, j);
            }
        }

        VBox contenedorAsientos = new VBox();
        HBox tituloAsientos = new HBox();
        HBox asientosHBox = new HBox();
        VBox botonesAsientos = new VBox();
        HBox botonesAtrasSiguienteAsientos = new HBox();

        Label textoAsientos = new Label("Sala 1");
        Button atrasAsientos = new Button("Atras");
        Button siguienteAsientos = new Button("Siguiente");

        tituloAsientos.setAlignment(Pos.CENTER);
        asientosHBox.setAlignment(Pos.CENTER);
        botonesAsientos.setAlignment(Pos.CENTER);
        botonesAtrasSiguienteAsientos.setAlignment(Pos.BOTTOM_LEFT);


        tituloAsientos.getChildren().addAll(textoAsientos);
        asientosHBox.getChildren().addAll(asientos);
        botonesAtrasSiguienteAsientos.getChildren().addAll(atrasAsientos, siguienteAsientos);
        contenedorAsientos.getChildren().addAll(tituloAsientos,asientosHBox, botonesAsientos, botonesAtrasSiguienteAsientos);

        Scene escenaAsiento = new Scene(contenedorAsientos, 350, 300);

        //********************************************ESCENA BOLETA**************************************************//

        VBox contenedorBoleta = new VBox();
        HBox tituloBoleta = new HBox();
        HBox botonesAtrasFinalizarBoleta = new HBox();

        Label textoBoletaLabel = new Label("BOLETA");
        Label textoBoleta = new Label("Pelicula: RATMAN\n Sala 1 \nHora de inicio: 10:00am\nHora de Termino: 11:30pm\n\nAsientos: XD\n\n\nPrecio Total: "+25*3000);
        Button atrasBoleta = new Button("Atras");
        Button finalizar = new Button("Finalizar");

        tituloBoleta.setAlignment(Pos.CENTER);
        botonesAtrasFinalizarBoleta.setAlignment(Pos.BOTTOM_LEFT);

        tituloBoleta.getChildren().addAll(textoBoletaLabel);
        botonesAtrasFinalizarBoleta.getChildren().addAll(atrasBoleta, finalizar);
        contenedorBoleta.getChildren().addAll(tituloBoleta, textoBoleta, botonesAtrasFinalizarBoleta);

        Scene escenaBoleta = new Scene(contenedorBoleta, 350, 300);

        //********************************************BOTONES MULTIESCENA*************************************************//
        botonSalir.setOnAction(e -> ventana.close());
        botonReservar.setOnAction(e -> {
            contenedor.setVisible(false);
            contenedorPeliculas.setVisible(true);
            ventana.setScene(escenaPelicula);
        }); 

        atrasPeliculas.setOnAction(e -> {
            contenedorPeliculas.setVisible(false);
            contenedor.setVisible(true);
            ventana.setScene(escena);
        });
        siguientePeliculas.setOnAction(e -> {
            contenedorPeliculas.setVisible(false);
            contenedorFunciones.setVisible(true);
            ventana.setScene(escenaFuncion);
        });

        atrasFunciones.setOnAction(e -> {
            contenedorFunciones.setVisible(false);
            contenedorPeliculas.setVisible(true);
            ventana.setScene(escenaPelicula);
        });
        siguienteFunciones.setOnAction(e -> {
            contenedorFunciones.setVisible(false);
            contenedorAsientos.setVisible(true);
            ventana.setScene(escenaAsiento);
        });

        atrasAsientos.setOnAction(e -> {
            contenedorAsientos.setVisible(false);
            contenedorFunciones.setVisible(true);
            ventana.setScene(escenaFuncion);
        });
        siguienteAsientos.setOnAction(e -> {
            contenedorAsientos.setVisible(false);
            contenedorBoleta.setVisible(true);
            ventana.setScene(escenaBoleta);
        });

        atrasBoleta.setOnAction(e -> {
            contenedorBoleta.setVisible(false);
            contenedorAsientos.setVisible(true);
            ventana.setScene(escenaAsiento);
        });
        finalizar.setOnAction(e -> ventana.close());
    }

    public static void main(String[] args) {
        launch();
    }

}