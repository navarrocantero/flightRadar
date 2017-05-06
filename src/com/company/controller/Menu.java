package com.company.controller;

import com.company.model.Airport;
import com.company.model.Plane;
import com.company.model.Point;
import java.util.Collections;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by driftineo on 4/5/17.
 */
public class Menu {

    public static int showMenu() {

        ArrayList<Integer> optionMenu = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("***********************");
        System.out.println("**********Menu*********");
        System.out.println("***********************");
        System.out.println("*1 -  Add new plane   *");
        System.out.println("*1 -  Plane list      *");
        System.out.println("*2 -  Delete plane    *");
        System.out.println("*0 -       Exit       *");
        System.out.println("***********************");
        System.out.printf("option :\n");

        return input.nextInt();
    }

    public static void showAddMenu(ArrayList<Plane> planeList, Airport madrid) {

        Scanner input = new Scanner(System.in);
        String flightId;
        String brand;
        double velocity;
        Date dateNow = new Date();

        Long dateLong = dateNow.getTime();

        double kmToAirport;
        Point positionNow = new Point();

        System.out.println("Input the flight ID");
        flightId = input.nextLine();

        System.out.println("Input the flight Brand");
        brand = input.nextLine();

        System.out.println("Input the actual Velocity in KM/H");
        velocity = input.nextDouble();

        System.out.println("Input the flight X coordinate");
        positionNow.setX(input.nextInt());

        System.out.println("Input the flight Y coordinate");
        positionNow.setY(input.nextInt());

        kmToAirport = positionNow.distancia(madrid.getPositionNow());


        Plane plane = new Plane(flightId, brand, velocity, positionNow, dateNow, kmToAirport);

        planeList.add(plane);

    }

    public static void showPlaneList(ArrayList<Plane> planeList, Airport airport) {

        Collections.sort(planeList, Plane.comparatorWithDistanceToAirport);

        for (Plane plane : planeList) {

            System.out.println(plane.toString());

        }

    }

    public static void deletePlane(ArrayList<Plane> planeList) {


    }
}
