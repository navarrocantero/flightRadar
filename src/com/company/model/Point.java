
package com.company.model;

import java.lang.Math;
import java.lang.*;


public class Point {

    private final double MIN = 0;
    private double x;
    private double y;

    // Constructores

    public Point() {

        this(0,0);
    }

    public Point(char coordinate, double number) {

        char variableX []= {'x','X'};
        char variableY []= {'y','Y'};



        for (int i = 0; i <variableX.length ; i++) {


            if( variableX [i] == coordinate) {
                this.setX(number);
            }

            else if(variableY [i] == coordinate) {
                this.setY(number);
            }
        }

    }


    public Point(double x, double y) {

        this.setX(x);
        this.setY(y);

    }

    public Point(Point parametro){

        this (parametro.getX (), parametro.getY());

    }

    // Accesors

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    // Helpers

    /**
     * Metodo helper para calcular el teorema de pitagoras
     *
     * @param parametro
     * @return
     */

    public Double distancia(Point parametro) {

        double distancia = Math.sqrt
                (Math.pow((this.getX() - parametro.getX()), 2)
                        +
                        (Math.pow((parametro.getY() - this.getY()), 2))
                );

        return  distancia;

    }

    /** Mismo metodo que el anterior con argumentos variables
     *
     * @param parametro
     * @return
     */
    public Double distancia(Point...parametro) {

        Double resultDistancia = 0.00;
        Double resultStep = 0.00;
        int count = 0;

        for (Point pointParametro : parametro)  {

            resultStep += this.distancia(pointParametro);

            if (count  > 0){
                System.out.println(" La distancia de " + this + " hasta " + pointParametro + " es de " + this.distancia(pointParametro) );
            }
            resultDistancia =+ resultStep;
            this.setX(pointParametro.getX());
            this.setY(pointParametro.getY());
            count++;
        }

        return resultDistancia;
    }

    /**
     * Metodo para averiguar en que cuadrante esta nuestra coordenada
     * @return
     */
    public int cuadrante() {
        int cuadrante;

        if (this.getX() > 0) {
            if (this.getY() > 0) {
                cuadrante = 1;
            } else {
                cuadrante = 4;
            }
        } else {
            if (this.getY() < 0) {
                cuadrante = 3;
            } else {
                cuadrante = 2;
            }

        }
        return cuadrante;
    }

    public String toString() {
        return  " X- " + x +
                " Y- " + y ;

    }

    public void clonar (Point parametro){
        this.setX(parametro.getX());
        this.setY(parametro.getY());
    }

}
