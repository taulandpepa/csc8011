package csc8011;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MuseumIO {

    private static Museum museum;


    Scanner s = new Scanner(System.in); // reading user input for numbers
    Scanner in = new Scanner(System.in); // reading user input for String (museum name)

    boolean quit = false;

    {
        int choice = 0;
        printMenu(); //user console menu,  code source: https://ncl.instructure.com/courses/45262/files/6162276?module_item_id=2525649
        String schoice = s.next();
        try {
            choice = Integer.parseInt(schoice);
            while (choice != 5) {
                switch (choice) {
                    case 1:
                        System.out.println("You have selected option 1, please enter museum name: \n");
                        String str = in.nextLine();
                        System.out.println(" Museum name: " + str);
                        museum = new Museum(str);
                        break;
                    case 2:
                        System.out.println("You have selected option 2, read in information on the exhibits: \n");
                        try {
                            File names = new File("src\\exhibits.csv"); // reading csv file method, code source:https://github.com/newcastleuniversity-computing/CSC8011_codeSamples_2021/blob/master/src/FileReading2.java
                            Scanner myReader = new Scanner(names);
                            while (myReader.hasNext()) {
                                String temp = myReader.nextLine();
                                String[] exhibitString = temp.split(",");
                                Exhibit exhibit = new Exhibit(exhibitString[0], exhibitString[1], Integer.parseInt(exhibitString[2]), Double.parseDouble(exhibitString[3])); //creating exhibit objects.
                                museum.addExhibit(exhibit); // method adding exhibits into museum ArrayList.
                                System.out.println(exhibitString[0] + "," + exhibitString[1] + "," + exhibitString[2] + "," + exhibitString[3]);
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        System.out.println("You have selected option 3, print a summary of the museum name and exhibits:\n");
                        System.out.println("Museum name: " + museum.getmName());
                        for (Exhibit exhibit : museum.getExhibits()) {
                            System.out.println(exhibit);
                        }
                        break;
                    case 4:
                        System.out.println("You have selected option 4, print statistics on exhibits:\n");
                        System.out.println("The statistics on highest value, first exhibit acquired and average value of exhibits: "
                                + "\n" + String.format("Highest value exhibit: %s", museum.getHvalueExhibit()) // calling and formatting the output of the getFirstExhibit() method.
                                + "\n" + String.format("First exhibit required: %s", museum.getFirstExhibit())  // calling and formatting the output of the getFirstExhibit() method.
                                + "\n" + String.format("Average value of exhibits: £%.2f", museum.getAverageExhibit())); //calling and formatting the output of the getAverageExhibit() method.
                        break;
                    case 5:
                        System.out.println("Exit");
                        quit = true;
                        break;
                    default:
                        System.out.println("Not a valid choice");
                }
                printMenu();
                choice = s.nextInt();

            }
        } catch (NumberFormatException e) {
            System.out.println("Not a valid choice" + e.getMessage());

        }
    }

    public void printMenu() {  //method, printing menu options
        System.out.println("\n Please select one of the following options: \n"
                + "1: Enter the name of the museum:\n"
                + "2: Read in information on the exhibits:\n"
                + "3: Print a summary of the museum exhibits:\n"
                + "4: Print statistics on exhibits: \n"
                + "5: Exit");
    }

    public static void main(String[] args) {

        MuseumIO menu = new MuseumIO(); // Create an object named "menu" under the Main method.
        menu.printMenu(); // calling printMenu method.

    }
}










