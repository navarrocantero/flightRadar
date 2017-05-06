package com.company.model;

import java.util.Date;

/**
 * Created by driftineo on 4/5/17.
 */
public class Airport   {

    private int dateNow;
    private Point positionNow;

    public int getDateNow() {
        return dateNow;
    }

    public void setDateNow(int dateNow) {
        this.dateNow = dateNow;
    }

    public Point getPositionNow() {
        return positionNow;
    }

    public void setPositionNow(Point positionNow) {
        this.positionNow = positionNow;
    }

    public  Airport(Point positionNow){
        this.dateNow = dateNow;
        this.positionNow = positionNow;
    }

    public Airport(int dateNow, Point positionNow) {
        this.dateNow = dateNow;
        this.positionNow = positionNow;
    }

    @Override
    public String toString() {
        return
                " Date =" + dateNow + "\n"+
                " Position =" + positionNow ;
    }


}
