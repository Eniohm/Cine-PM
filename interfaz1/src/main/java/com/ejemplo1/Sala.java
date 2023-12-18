package com.ejemplo1;

class Sala{
    private String num;
    private String[][] asientos;

    public Sala(String num){
        this.num = null;
        this.asientos = new String[5][5];
    }

    public String getNum(){return this.num;}

    public void vaciarAsientos(){
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.asientos[i][j] = "_";
            }
        }
    }

    public void llenarAsiento(int i, int j){
        this.asientos[i][j] = "X";
    }
}