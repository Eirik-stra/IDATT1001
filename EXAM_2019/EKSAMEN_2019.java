package EKSAMEN_2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class EKSAMEN_2019 - client program
 *
 * Here I could have added the option to search by type, which the task required one to do, but I have not implemented
 * the option here simply because I ran out of time. I would then get the type from user input and call
 * .searchHearingAids(type) and print the results.
 *
 */
public class EKSAMEN_2019 {
    static Scanner sc = new Scanner(System.in);
    // Constants representing the different menu choices
    private static final int ADD_HEARING_AID = 1;
    private static final int LIST_ALL_HEARING_AIDS = 2;
    private static final int RENT_HEARING_AID = 3;
    private static final int TERMINATE_RENT = 4;
    // ---- add more constants as needed ---
    private static final int EXIT = 9;

    // Initializing an empty central to ease the task
    private static HearingAidCentral hearingAidCentral = new HearingAidCentral("NTNU-Sentralen");

    public static void main(String[] args) {
        start();
    }

    /**
     * Presents the menu for the user, and awaits input from the user. The menu
     * choice selected by the user is being returned.
     *
     * @return the menu choice by the user as a positive number starting from 1.
     *                 If 0 is returned, the user has entered a wrong value
     */
    private static int showMenu()

    {
        int menuChoice = 0;

        System.out.println("\n***** Hearing Aid Central v0.1 *****\n" +
                            "1. Add hearing aid \n" +
                            "2. List all hearing aids \n" +
                            "3. Rent a hearing aid\n" +
                            "4. Terminate a renting contract\n" +
                            "9. Quit \n" + // Or another number than 9
                            "\nPlease select from the menu.\n"
        );

        if (sc.hasNextInt())
        {
            menuChoice = sc.nextInt();
            sc.nextLine();
        } else
        {
            System.out.println("You must enter a number, not text");
        }
        return menuChoice;
    }

    /**
     * Starts the application. This is the main loop of the application,
     * presenting the menu, retrieving the selected menu choice from the user,
     * and executing the selected functionality.
     */
    public static void start() {
        boolean finished = false;

        // The while-loop will run as long as the user has not selected
        // to quit the application
        while (!finished) {
            int menuChoice = showMenu();
            switch (menuChoice)
            {
                case ADD_HEARING_AID:

                    if (addHearingAid()) {
                        System.out.println("Hearing aid successfully added.");
                    } else {
                        System.out.println("Hearing aid could not be added.");
                    }
                    break;

                case LIST_ALL_HEARING_AIDS:
                    System.out.println(hearingAidCentral);
                    break;

                case RENT_HEARING_AID:
                    if (rentHearingAid()) {
                        System.out.println("Hearing aid successfully rented.");
                    } else {
                        System.out.println("Hearing aid could not be rented.");
                    }
                    break;

                case TERMINATE_RENT:
                    if (terminateRentingContract()) {
                        System.out.println("Rent successfully terminated.");
                    } else {
                        System.out.println("Could not terminate rent.");
                    }
                    break;

                case EXIT:
                    System.out.println("Thank you for using the Properties app!\n");
                    finished = true;
                    break;

                default:
                    System.out.println("Unrecognized menu selected..");
                    break;
            }
        }
    }

    /**
     * Gets the input from the user and registeres the hearing aid.
     *
     * @return boolean if the add was successful.
     */
    private static boolean addHearingAid() {
        try {
            System.out.println("Registering new hearing aid.\n");

            System.out.println("Enter type/description:");
            String type = sc.nextLine();

            return hearingAidCentral.regHearingAid(type);
        } catch (
                InputMismatchException e)  {
            System.out.println("\nInvalid value.");
        } catch (IllegalArgumentException e) {
            // Here one would normally do a e.printStackTrace to trace the error, but since this client is to be
            // used directly by the client, this is not user friendly (hence it is left out).
            System.out.println(e.getMessage());
        }

        return false;
    }

    /**
     * Gets the input from the user and rents the hearing aid.
     *
     * @return boolean if the registration was successful.
     */
    private static boolean rentHearingAid() {
        try {
            System.out.println("Renting a hearing aid.");

            System.out.println("Enter type/description:");
            String type = sc.nextLine();

            System.out.println("Enter name of person to rent:");
            String renter = sc.nextLine();

            return hearingAidCentral.rentHearingAid(type, renter);
        } catch (
                InputMismatchException e)  {
            System.out.println("\nInvalid value.");
        } catch (IllegalArgumentException e) {
            // Here one would normally do a e.printStackTrace to trace the error, but since this client is to be
            // used directly by the client, this is not user friendly (hence it is left out).
            System.out.println(e.getMessage());
        }

        return false;
    }

    /**
     * Gets the input from the user and terminates the renting contract.
     *
     * @return boolean if the termination was successful.
     */
    private static boolean terminateRentingContract() {
        try {
            System.out.println("Terminating a renting contract.\n");

            System.out.println("Enter type/description:");
            String type = sc.nextLine();

            System.out.println("Enter renter:");
            String renter = sc.nextLine();


            return hearingAidCentral.terminateRental(type, renter);
        } catch (
                InputMismatchException e)  {
            System.out.println("\nInvalid value.");
        } catch (IllegalArgumentException e) {
            // Here one would normally do a e.printStackTrace to trace the error, but since this client is to be
            // used directly by the client, this is not user friendly (hence it is left out).
            System.out.println(e.getMessage());
        }

        return false;
    }
}
