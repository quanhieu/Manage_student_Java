package main;


import java.util.Scanner;
import student.*;
import lecturer.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Soi Lan Tron
 */
public class Mainmenu {
    public static void main(String[] args) {
        // TODO code application logic here
        ManageStudent mnst = new ManageStudent();
        ManageLecture mnlc = new ManageLecture();
      

        char choose;
        while (true) {
            System.out.println("=======================");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Lecturers");
            System.out.println("3. Exit");
            System.out.println("=======================");
//            System.out.println("In the first input, if the program error occurs, you shouldn't care. Please continue to import");
            System.out.print("Please choose: ");
            Scanner myReader = new Scanner(System.in);
            choose = myReader.nextLine().charAt(0);
            System.out.println(choose);
            switch (choose) {
                case '1':
                    mnst.studentMenu();
                    break;
                case '2': 
                    mnlc.lectMenu();
                    break;
                case '3':
                    System.exit(0);
                    break;

                default:
                    System.out.print("Enter the selection from 1 to 3 \n");
            }
        }
    }
}
