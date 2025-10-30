/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dja.project;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author nianc
 */
public class Building {
    
    private int floors;
    private int roomsPerFloor;
    private Guests[][] rooms; // 2D array representing floors and rooms
    private Queue<Guests> last10CheckedOut; // Queue for last 10 guests who checked out

    public Building(int floors, int roomsPerFloor) {
        this.floors = floors;
        this.roomsPerFloor = roomsPerFloor;
        this.rooms = new Guests[floors][roomsPerFloor];
        this.last10CheckedOut = new LinkedList<>();
    }

    // i. Track available rooms and ii. Assign on First Available Room (FAR) basis
    public boolean checkIn(String guestName) {
        for (int f = 0; f < floors; f++) {
            for (int r = 0; r < roomsPerFloor; r++) {
                if (rooms[f][r] == null) {
                    rooms[f][r] = new Guests(guestName, f + 1, r + 1);
                    System.out.println(guestName + " checked into Floor " + (f + 1) + ", Room " + (r + 1));
                    return true;
                }
            }
        }
        System.out.println("No available rooms for " + guestName);
        return false;
    }

    // iii. Remove guest and update history
    public boolean checkOut(String guestName) {
        for (int f = 0; f < floors; f++) {
            for (int r = 0; r < roomsPerFloor; r++) {
                Guests guest = rooms[f][r];
                if (guest != null && guest.getName().equalsIgnoreCase(guestName)) {
                    rooms[f][r] = null;
                    addToCheckoutHistory(guest);
                    System.out.println(guestName + " has checked out from Floor " + (f + 1) + ", Room " + (r + 1));
                    return true;
                }
            }
        }
        System.out.println("Guest " + guestName + " not found.");
        return false;
    }

    // Maintain last 10 checked-out guests
    private void addToCheckoutHistory(Guests guest) {
        if (last10CheckedOut.size() >= 10) {
            last10CheckedOut.poll();
        }
        last10CheckedOut.offer(guest);
    }

    // iv. Generate daily report
    public void generateDailyReport() {
        System.out.println("\n--- Daily Report: Guests per Floor ---");
        for (int f = 0; f < floors; f++) {
            int count = 0;
            for (int r = 0; r < roomsPerFloor; r++) {
                if (rooms[f][r] != null) count++;
            }
            System.out.println("Floor " + (f + 1) + ": " + count + " guest(s)");
        }
    }

    // Display checkout history
    public void showCheckoutHistory() {
        System.out.println("\n--- Last 10 Checked-Out Guests ---");
        if (last10CheckedOut.isEmpty()) {
            System.out.println("No guests have checked out yet.");
        } else {
            for (Guests g : last10CheckedOut) {
                System.out.println(g);
            }
        }
    }

    // Display all room statuses
    public void showRoomStatus() {
        System.out.println("\n--- Room Status ---");
        for (int f = 0; f < floors; f++) {
            System.out.print("Floor " + (f + 1) + ": ");
            for (int r = 0; r < roomsPerFloor; r++) {
                if (rooms[f][r] == null) {
                    System.out.print("[Empty] ");
                } else {
                    System.out.print("[" + rooms[f][r].getName() + "] ");
                }
            }
            System.out.println();
        }
    }
}

    

