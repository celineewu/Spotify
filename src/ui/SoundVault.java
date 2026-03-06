package ui;

import model.*;
import service.*;


import java.util.ArrayList;
import java.util.Scanner;

public class SoundVault {

    public static void main (String[] args) {

        SongHandler handler = new SongHandler();

        handler.readSongFromFile();

        Scanner scanner = new Scanner(System.in);

        ArrayList<Song> songs = handler.getSongs();

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
        if (choice <= 0 || choice > 7) {
            System.out.println("Invalid choice");
        } else if (choice == 1) {
            System.out.println("Title: ");
            String title = scanner.nextLine();
            System.out.println("Genre in UPPERCASE: ");
            String genreInput = scanner.nextLine();
            Genre genre = Genre.valueOf(genreInput);
            Song newSong = new Song(title, genre);
            handler.addSong(newSong);

        } else if (choice == 2) {
            System.out.println("Hvilken sang vil du fjerne? (navn) ");
            String remove = scanner.nextLine();
            handler.removeSong(remove);
        } else if (choice == 3) {
            printSongs(songs);
        } else if (choice == 4) {
            System.out.println("Hvilken sang leder du efter? ");
            String songName = scanner.nextLine();
            System.out.println(handler.searchTitle(songName));
        } else if (choice == 5) {
            System.out.println("Hvilken sang vil du redigere? ");
            String oldTitle = scanner.nextLine();

            System.out.println("Nyt navn? ");
            String newTitle = scanner.nextLine();

            Song song = handler.searchTitle(oldTitle);

            handler.editSong(song, newTitle);

        } else if (choice == 6) {
            System.out.println("Funktion ikke tilgængelig lige nu.");
        }
    }
}