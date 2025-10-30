/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dja.project;

/**
 *
 * @author nianc
 */

import java.util.*;

public class Guests {
    
    private String name;
    private int floor;
    private int roomNumber;

    public Guests(String name, int floor, int roomNumber) {
        this.name = name;
        this.floor = floor;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public int getFloor() {
        return floor;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return String.format("Guest{name='%s', floor=%d, room=%d}", name, floor, roomNumber);
    }
}



   

    

