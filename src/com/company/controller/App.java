package com.company.controller;


import com.company.model.Airport;
import com.company.model.Plane;
import com.company.model.Point;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.company.controller.Menu.showMenu;


/**
 * Created by Jose on 29/04/2017.
 */
public class App {


    public static void run() {

        Point madridPoint = new Point(3, 4);
        Airport madrid = new Airport(madridPoint);

        int option;

        Point planePosition = new Point(32, 4);
        Date date = new Date();

        Long dateLong = date.getTime();

        double timeOfArrival = madridPoint.distancia(planePosition);

        Plane planeOne = new Plane("fd", "dsf", 232, planePosition, date, timeOfArrival);
        Plane planeTwo = new Plane("fdTwo", "dsfTwo", 140, planePosition, date, timeOfArrival);

        ArrayList<Plane> planeList = new ArrayList<>();
        planeList.add(planeOne);
        planeList.add(planeTwo);

        while ((option = showMenu()) != 0) {

            switch (option) {
                case 1: // Ver tareas
                    Menu.showAddMenu(planeList, madrid);
                    break;

                case 2: // Añadir tareas
                    Menu.showPlaneList(planeList, madrid);
                    break;

                case 3: // Añadir tareas
                    Menu.deletePlane(planeList);
                    break;

                default:
            }
        }
        System.out.println("off");
    }
}






















