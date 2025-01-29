/**
 * @purpose: Attempting to create a password generator using while loops as well as
 * providing the user with a menu.
 *
 * @author Trisha Ganesh
 * @version 02/07/2021
 */

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;

public class SecretPasscodes {

    public static void main(String[] args) throws IOException {

        PrintWriter outFile = new PrintWriter(new File("password.txt"));
        while (true) {
            System.out.println("\t\t\t\t\t\tPassword Generator Menu\t\t\t\t");
            System.out.println("*********************************************************************");
            System.out.println("*   [1] Only Lowercase Letters                                      *");
            System.out.println("*   [2] Lowercase Letters and Numbers                               *");
            System.out.println("*   [3] Lowercase Letters, Uppercase Letters and Numbers            *");
            System.out.println("*   [4] Symbols, Lowercase Letters, Uppercase Letters and Numbers   *");
            System.out.println("*   [5] Quit                                                        *");
            System.out.println("*********************************************************************");
            System.out.print("Enter selection (1-5): ");

            Scanner in = new Scanner(System.in);
            int selection;

            while (true) {
                selection = in.nextInt();
               if (selection >= 1)
                    break;
                System.out.println("Invalid Selection: Please enter a selection of at least 1: ");
            }

            if (selection < 1 || selection > 5) {
                System.out.println("Invalid Selection: Please enter a selection between 1-5");
                continue;
            }
            if (selection == 5) {
                break;
            }

            System.out.print("Enter Password Length (6 or more): ");
            int passwordLength;
            while (true) {
                passwordLength = in.nextInt();
                if (passwordLength >= 6)
                    break;
                System.out.println("Invalid Length: Password Length too short. Please try again: ");
            }
            String password = "";
            int randomNumber = 0;
            Random randNumList = new Random();
            for (int counter = 0; counter < passwordLength; counter++) {

                if (selection == 1) {
                    while (true) {
                        randomNumber = randNumList.nextInt(127);
                        if (randomNumber >= 97 && randomNumber <= 122)
                            break;
                    }
                    password += (char) (randomNumber);
                }
                if (selection == 2) {
                    while (true) {
                        randomNumber = randNumList.nextInt(127);
                        if (randomNumber >= 48 && randomNumber <= 57)
                            break;
                        if (randomNumber >= 97 && randomNumber <= 122)
                            break;
                    }
                    password += (char) (randomNumber);

                }
                if (selection == 3) {
                    while (true) {
                        randomNumber = randNumList.nextInt(127);
                        if (randomNumber >= 48 && randomNumber <= 57)
                            break;
                        if (randomNumber >= 97 && randomNumber <= 122)
                            break;
                        if (randomNumber >= 65 && randomNumber <= 90)
                            break;
                    }
                    password += (char) (randomNumber);

                }
                if (selection == 4) {
                    while (true) {
                        randomNumber = randNumList.nextInt(127);
                        if (randomNumber >= 33 && randomNumber <= 126)
                            break;
                    }
                    password += (char) (randomNumber);
                }

            }
            outFile.println(password);
        }
        System.out.println("\n");
        System.out.println("Here are your randomly generated codes: ");
        outFile.close();
        File fileName = new File("password.txt");
        Scanner inFile = new Scanner(fileName);
        String token = "";
        while(inFile.hasNext()) {
            token = inFile.next();
            System.out.println(token);
        }
        inFile.close();
    }
}



