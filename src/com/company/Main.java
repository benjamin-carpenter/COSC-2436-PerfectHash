/**
 *Description: This program is designed to make a perfect hashed structure
 *Class: spring - COSC 2436.83448
 *Assignment1: 5 perfect hashed structure
 *Date: 05/1/2019
 *@author  Ben Carpenter
 *@version 0.0.3
 */

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        PerfectHash dataBase = new PerfectHash(98000,2000);//calls PerfectHash and establishes dataBase

        while(true) {
            String ticket="";
            int ticketNum;
            String name="";


            BufferedReader in = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("To reserve your seat please enter your ticket number or if you already have a reservation type 0 to lookup a seat number.");
            try {
                ticket = in.readLine();
            } catch(IOException e) {
                System.err.println("Unexpected IO ERROR: " + e);
                System.exit(1);
            }
            if(ticket.equals("0")) {//terminates out of the while loop
                //System.out.println("Leaving user input stage.");
                break;
            }
            try {
                ticketNum = Integer.valueOf(ticket);
            } catch (NumberFormatException ex) {
                System.err.println("Ticket must be a number between 2,000 and 62,000. \n" + "Your input was"+ ticket); // error checking to make sure its a number
                continue;
            }
            if(ticketNum < 2000 || ticketNum > 62000) {
                System.out.println("Ticket number must be between 2,000 and 62,000."); //error checking to make sure its in the specifide range for tickets
                continue;
            }
            System.out.println("Enter your Name First then Last: ");
            try {
                name = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            dataBase.insert(Integer.valueOf(ticket), name);

        }
        while(true){
            String t;
            String searchNumber="";
            String nameCheck="";
            String repeat="";
            String modify="";
            String updateName="";
            BufferedReader lookUp = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Would you like to look up a seat. If so please enter your ticket number. ");
            try {
                searchNumber = lookUp.readLine();
            }
             catch (IOException e) {
                e.printStackTrace();
            }
            try {
                t = dataBase.fetch(Integer.valueOf(searchNumber));
            }
            catch(NumberFormatException ex){
                System.err.println("Ticket must be a number between 2,000 and 62,000. \n" + "Your input was" + searchNumber); // error checking to make sure its a number
                continue;
            }
            System.out.println("Please input your First and last name for verification purposes");//verify there name to prevent wrongful ticket access
            try {
                nameCheck = lookUp.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(nameCheck.equalsIgnoreCase(t)) {
                System.out.println("Thank you for verifying your name "+t+" your seat is number "+dataBase.seatNumber(Integer.valueOf(searchNumber)));

            }
            else{
                System.out.println("Where sorry but it appears your name does not match the name set for that ticket");//lets them know ifa mismatch
                continue;
            }
            System.out.println("Do you wish to modify your reservation information please enter yes or no.");
            try {
                modify = lookUp.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (modify.equalsIgnoreCase("yes")) {
                System.out.println("Would you like to delete this listing or update the name. Please enter delete or update.");//ask if they want to delete or update
                try {
                    modify = lookUp.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (modify.equalsIgnoreCase( "delete")){
                    dataBase.delete(Integer.valueOf(searchNumber));
                    System.out.println("Ok we have deleted this listing for you.");
                }
                if (modify.equalsIgnoreCase( "update")){
                    System.out.println("Please input the new name you would like attached to the seat");
                    try {
                        updateName = lookUp.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dataBase.update(Integer.valueOf(searchNumber),updateName);
                    System.out.println("Your name on the reservation has been updated");
                }
            }
            System.out.println("Would you like to look up another seat. (yes/no)");
            try {
                repeat = lookUp.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (repeat.equalsIgnoreCase( "no")){//checks for ending while loop
            break;
            }

        }



    }

    }

