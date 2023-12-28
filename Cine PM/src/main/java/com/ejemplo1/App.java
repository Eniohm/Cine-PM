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
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private void actualizarTextoBoleta(Label textoBoleta, Boleta boleta){
        textoBoleta.setText("Pelicula:"+boleta.getPelicula().getNombre()+"\n Sala "+boleta.getPelicula().getFuncion().getSala().getNum()+"\nHora de inicio:"+boleta.getPelicula().getFuncion().getHoraInicio()+"\nHora de Termino:"+boleta.getPelicula().getFuncion().getHoraTermino()+"\n\nAsientos:" + boleta.asientosString() + "\n\n\nPrecio Total: "+ boleta.getTotal());
    }
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage ventana) throws IOException {
        Sala salaNull = new Sala("0");
        Funcion funcionNull = new Funcion(salaNull, "null", "null", 0);
        Pelicula peliculaNull = new Pelicula("NULL", funcionNull);


        Sala sala1 = new Sala("1");
        Funcion funcionRatman = new Funcion(sala1, "10:00hrs", "11:30", 3000);
        Pelicula ratman = new Pelicula("Ratman", funcionRatman);
        Boleta boleta = new Boleta(peliculaNull, 0, null);
        ventana.setTitle("Cine PM");

        Label textoBoleta = new Label("");

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
        Button pelicula1 = new Button("Ratman");
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

        pelicula1.setOnAction(e -> {
            boleta.setPelicula(ratman);
            actualizarTextoBoleta(textoBoleta, boleta);
        });
        //pelicula2.setOnAction(e -> boleta.setPelicula());
        
        //********************************************ESCENA FUNCIONES*************************************************//
        VBox contenedorFunciones = new VBox();
        HBox tituloFunciones = new HBox();
        VBox botonesFunciones = new VBox();
        HBox botonesAtrasSiguienteFunciones = new HBox();

        Label textoFunciones = new Label("Funciones");
        Button funcion1 = new Button("Sala 1 \nHora de inicio: 10:00am\nHora de Termino: 11:30pm");
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

        funcion1.setOnAction(e -> {
            boleta.getPelicula().setFuncion(funcionRatman);
            actualizarTextoBoleta(textoBoleta, boleta);
        });

        //********************************************ESCENA ASIENTOS**************************************************//
        // Inicializar la matriz de asientos (por ejemplo, todos los asientos vacíos)

        char[][] asientos = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                asientos[i][j] = '_';
            }
        }

        // Crear un GridPane para representar los asientos en la interfaz gráfica
        GridPane gridPane = new GridPane();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Button btnAsiento = new Button("" + asientos[i][j]);
                int fila = i;
                int columna = j;

                // Manejar el evento de clic en el asiento
                btnAsiento.setOnAction(e -> {
                    // Marcar o desmarcar el asiento al hacer clic
                    if (asientos[fila][columna] == '_') {
                        asientos[fila][columna] = 'x';
                    } else {
                        asientos[fila][columna] = '_';
                    }

                    // Actualizar la representación gráfica del asiento
                    btnAsiento.setText("" + asientos[fila][columna]);
                    for (int h = 0; h < 5; h++) {
                        for (int k = 0; k < 5; k++) {
                            if (asientos[h][k] == 'x') {
                                boleta.añadirAsiento("["+h+","+k+"]");
                                System.out.println("\n"+boleta.asientosString());
                                actualizarTextoBoleta(textoBoleta, boleta);
                            }else{
                                if(asientos[h][k]== '_'){
                                    boleta.quitarAsiento("["+h+","+k+"]");
                                    System.out.println("\n"+boleta.asientosString());
                                    actualizarTextoBoleta(textoBoleta, boleta);
                                }
                            }
                        }
                    }
                });

                // Agregar el botón al GridPane
                gridPane.add(btnAsiento, j, i);
            }
        

    

        VBox contenedorAsientos = new VBox();
        HBox tituloAsientos = new HBox();
        HBox asientosHBox = new HBox();
        HBox botonesAtrasSiguienteAsientos = new HBox();

        Label textoAsientos = new Label("Sala 1");
        Button atrasAsientos = new Button("Atras");
        Button siguienteAsientos = new Button("Siguiente");

        tituloAsientos.setAlignment(Pos.CENTER);
        asientosHBox.setAlignment(Pos.CENTER);
        botonesAtrasSiguienteAsientos.setAlignment(Pos.BOTTOM_LEFT);


        tituloAsientos.getChildren().addAll(textoAsientos);
        asientosHBox.getChildren().addAll(gridPane);
        botonesAtrasSiguienteAsientos.getChildren().addAll(atrasAsientos, siguienteAsientos);
        contenedorAsientos.getChildren().addAll(tituloAsientos,asientosHBox, botonesAtrasSiguienteAsientos);

        Scene escenaAsiento = new Scene(contenedorAsientos, 350, 300);

       

        //********************************************ESCENA BOLETA**************************************************//

        VBox contenedorBoleta = new VBox();
        HBox tituloBoleta = new HBox();
        HBox botonesAtrasFinalizarBoleta = new HBox();
        

        Label textoBoletaLabel = new Label("BOLETA");
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

    

}}