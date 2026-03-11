package ui;

import model.*;
import service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;

public class SoundVault {

    public static void main (String[] args) {

        SongHandler handler = new SongHandler();

        handler.readSongFromFile();

        Scanner scanner = new Scanner(System.in);

        ArrayList<Song> songs = handler.getSongs();

        user(scanner);

        System.out.println("""
                Velkommen til hjemmelavede Spotify!
                ------------------------------------------""");

        printSongs(songs);

        while (true) {

                int choice = getUserChoice(scanner);


            handleChoice(choice, songs, handler, scanner);
            if (choice == 7) {
                System.out.println("Tak for nu.");
                break;
            }

        }
        scanner.close();
    }

    //Creates the user
    public static void user(Scanner scan) {
        System.out.print("Indtast dit navn: ");
        String name = scan.nextLine();
        System.out.println("Hvilken type bruger er du?\n1.FreeUser\n2.PremiumUser");
        String input = scan.nextLine();

        switch (input.toLowerCase()) {
            case "1":
                FreeUser freeUser = new FreeUser(name);
                System.out.println(freeUser.ads());
                break;
            case "2":
                PremiumUser premiumUser = new PremiumUser(name);
                System.out.println(premiumUser.ads());
                break;
            default:
                System.out.println("Ukendt input");
        }
    }

    //Genre check
    public static Genre getGenreInput(Scanner scanner) {

        Genre genre = null;

        while ( genre == null){

            System.out.println("Genre: ");
            String genreInput = scanner.nextLine();

            try {
                genre = Genre.valueOf(genreInput.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("Ugyldigt valg. Vælg venligst en gyldig genre.");
            }
        }
        return genre;
    }

    //Title check
    public static Song getSongInput(Scanner scanner, SongHandler handler){

        Song song = null;

        while (song == null){

            String title = scanner.nextLine();
            song = handler.searchTitle(title);

            if (song == null ){
                System.out.println("Ugyldigt valg. Prøv igen.");
            }
        }
        return song;
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

        System.out.print("""
                ------------------------------------------
                Vælg en mulighed:
                1. Tilføj ny sang
                2. Fjern en sang
                3. Vis alle sang
                4. Søg efter en sang
                5. Rediger en sang
                6. Sorter sanglisten
                7. Afslut programmet
                """);


        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Venligst indtast et tal.");
                scanner.nextLine();
            }
        }
    }

    /*
     Handles user selection logic
    */
    private static void handleChoice(int choice,
                                     ArrayList<Song> songs,
                                     SongHandler handler, Scanner scanner) {
        if (choice <= 0 || choice > 7) {
            System.out.println("Invalid choice");
        } else if (choice == 1) {
            System.out.println("Title: ");
            String title = scanner.nextLine();
            Genre genre = getGenreInput(scanner);
            Song newSong = new Song(title, genre);
            handler.addSong(newSong);

        } else if (choice == 2) {
            System.out.println("Hvilken sang vil du fjerne? (navn) ");
            Song song = getSongInput (scanner, handler);
            handler.removeSong(song.getTitle());
        } else if (choice == 3) {
            printSongs(songs);
        } else if (choice == 4) {
            System.out.println("Hvilken sang leder du efter? ");
            Song song = getSongInput (scanner, handler);
            System.out.println(song);
        } else if (choice == 5) {
            System.out.println("Hvilken sang vil du redigere? ");
            Song song = getSongInput (scanner, handler);

            System.out.println("Nyt navn? ");
            String newTitle = scanner.nextLine();

            handler.editSong(song, newTitle);

        } else if (choice == 6) {
            Collections.sort(songs);
            printSongs(songs);
        }
    }
}