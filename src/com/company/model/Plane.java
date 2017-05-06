package com.company.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by driftineo on 4/5/17.
 */
public class Plane {

    private String flightId;
    private String brand;
    private double velocity;
    private Date dateNow;
    private Point positionNow;
    private double kmToAirport;

    public Plane(String flightId, String brand, double velocity, Point positionNow) {

        Date date = new Date();
        this.setFlightId(flightId);
        this.setBrand(brand);
        this.setVelocity(velocity);
        this.setPositionNow(positionNow);
        this.setDateNow(dateNow);
    }

    public Plane(String flightId, String brand, double velocity, Point positionNow, Date dateNow) {
        this.setFlightId(flightId);
        this.setBrand(brand);
        this.setVelocity(velocity);
        this.setPositionNow(positionNow);
        this.setDateNow(dateNow);
    }

    public Plane(String flightId, String brand, double velocity, Point positionNow, Date dateNow, double kmToAirport) {

        this.setFlightId(flightId);
        this.setBrand(brand);
        this.setVelocity(velocity);
        this.setPositionNow(positionNow);
        this.setDateNow(dateNow);
        this.setKmToAirport(kmToAirport);
    }


    public String getFlightId() {
        return flightId;
    }

    public String getBrand() {
        return brand;
    }

    public double getVelocity() {
        return velocity;
    }

    public Date getDateNow() {
        return dateNow;
    }

    public Point getPositionNow() {
        return positionNow;
    }


    public double getKmToAirport() {
        return kmToAirport;
    }

    public void setKmToAirport(double kmToAirport) {

        if (kmToAirport < 0){
            this.setKmToAirport(0);
            this.setVelocity(0);
            
        }
        this.kmToAirport = kmToAirport;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setDateNow(Date dateNow) {
        this.dateNow = dateNow;
    }

    public void setPositionNow(Point positionNow) {
        this.positionNow = positionNow;
    }


    @Override
    public String toString() {
        calculateTimeToTravel();
        return
                " Flight Id = " + flightId + "\n" +
                        " Brand = " + brand + "\n" +
                        " Velocity = " + velocity + " KM/H\n" +
                        " Date = " + dateNow + " \n" +
                        " Date in ms = " + dateNow.getTime() + "mS \n" +
                        " Position = " + positionNow + "\n" +
                        " Distance to airport = " + kmToAirport + " KM\n";


    }


    public void calculateTimeToTravel() {
        Date date = new Date();
        double kmToMsValor = (3600 * 1000);
        double kmPorMs = this.getVelocity() / kmToMsValor;

        double msTraveled = date.getTime() - this.getDateNow().getTime();
        this.setKmToAirport(this.getKmToAirport() - (kmPorMs * msTraveled));

    }



    public static Comparator<Plane> comparatorWithDistanceToAirport = new Comparator<Plane>() {

        @Override
        public int compare(Plane planeOne, Plane planeTwo) {
            return ((int) planeOne.getKmToAirport() - (int) planeTwo.getKmToAirport());
        }
    };


}
