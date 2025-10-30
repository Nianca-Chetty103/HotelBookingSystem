/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dja.project;

import java.util.Scanner;

/**
 *
 * @author nianc
 */
public class HotelSystem {
    
    
     public static void main(String[] args) {
        Building hotel = new Building(3, 5); // 3 floors, 5 rooms per floor
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Smart Hotel Booking System ====");
            System.out.println("1. Check-In Guest");
            System.out.println("2. Check-Out Guest");
            System.out.println("3. Show Room Status");
            System.out.println("4. Show Checkout History");
            System.out.println("5. Generate Daily Report");
            System.out.println("6. Exit");
            System.out.print("Select option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter guest name: ");
                    String nameIn = sc.nextLine();
                    hotel.checkIn(nameIn);
                    break;
                case 2:
                    System.out.print("Enter guest name to check out: ");
                    String nameOut = sc.nextLine();
                    hotel.checkOut(nameOut);
                    break;
                case 3:
                    hotel.showRoomStatus();
                    break;
                case 4:
                    hotel.showCheckoutHistory();
                    break;
                case 5:
                    hotel.generateDailyReport();
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
