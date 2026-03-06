package ui;

import model.User;
import service.*;


import java.util.ArrayList;
import java.util.Scanner;

public class SoundVault {

    public static void main (String[] args) {

        SongHandler handler = new SongHandler();
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> songs = getSongs(handler);

       printSongs(songs);

       int choice = getUserChoice(scanner);

       handleChoice(choice, songs, handler, scanner);

       scanner.close();


    }

    /*
     Retrieves songs from file handler
    */
    private static ArrayList<String> getSongs(SongHandler handler) {
        return handler.getSongNames();
    }

    /*
     Prints available songs
    */
    private static void printSongs(ArrayList<String> songs) {

        System.out.println("Songs in your playlist:");

        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    /*
     Gets user input
    */
    private static int getUserChoice(Scanner scanner) {

        System.out.print("Velkommen til hjemmelavede Spotify! Vælg en mulighed:\n" +
                "1. Tilføj ny sang\n2. Fjern en sang\n3. Vis alle sang\n4. Søg efter en sang\n" +
                "5. Søg efter en sang\n6. Rediger en sang\n7. Sorter sanglisten\n8. Afslut programmet\n");

        return scanner.nextInt();
    }

    /*
     Handles user selection logic
    */
    private static void handleChoice(int choice,
                                     ArrayList<String> songs,
                                     SongHandler handler, Scanner scanner) {

        if (choice == 1) {
            System.out.println("Title: ");
            String title = scanner.nextLine();
            System.out.println("Genre: ");
            String genre = scanner.nextLine();
            System.out.println("Duration: ");
            double duration = scanner.nextDouble();



        } else {
            System.out.println("Invalid choice.");
        }
    }




}
