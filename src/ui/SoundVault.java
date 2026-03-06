package ui;

import model.*;
import service.*;


import java.util.ArrayList;
import java.util.Scanner;

public class SoundVault {

    public static void main (String[] args) {

        SongHandler handler = new SongHandler();
        Scanner scanner = new Scanner(System.in);

        ArrayList<Song> songs = readSongsFromFile(handler);

        printSongs(songs);

        int choice = getUserChoice(scanner);

        handleChoice(choice, songs, handler, scanner);

        scanner.close();


    }

    /*
     Retrieves songs from file handler
    */
    private static ArrayList<Song> readSongsFromFile(SongHandler handler) {
        return handler.getSongs();
    }

    /*
     Prints available songs
    */
    private static void printSongs(ArrayList<Song> songs) {

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

        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    /*
     Handles user selection logic
    */
    private static void handleChoice(int choice,
                                     ArrayList<Song> songs,
                                     SongHandler handler, Scanner scanner) {

        if (choice == 1) {
            System.out.println("Title: ");
            String title = scanner.nextLine();
            System.out.println("Genre in UPPERCASE: ");
            String genreInput = scanner.nextLine();
            Genre genre =  Genre.valueOf(genreInput);
            Song newSong = new Song(title, genre);
            handler.addSong(newSong);
        } else if (choice == 2) {
            System.out.println("Hvilken sang vil du fjerne? (navn) ");
            String remove = scanner.nextLine();
            handler.removeSong(remove);
        } else if (choice == 3) {
            printSongs(songs);
        } else {
            System.out.println("Invalid choice.");
        }
    }




}