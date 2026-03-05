package ui;

import model.*;
import service.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SoundVault {

    /*Programmet skal kunne:
    * tilføje en sang (title, genre (giv feedback hvis der gives en forkert genre))
    * fjerne en sang (giv feedback hvis sang ikke findes)
    * finde sang baseret på titel (giv feedback hvis sang ikke findes)
    * vise alle sange i listen
    * sortere listen
    * giv mulighed for at redigere titlen på en sang*/

    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        SongHandler handler = new SongHandler();

        handler.readSongFromFile(); //Sangene i txt bliver læst ind

        System.out.println("Velkommen til dit hjemmelavede Spotify");

        menu(scan, handler);

    }

    public static void menu(Scanner scan, SongHandler handler) {
        boolean checkLoop = true;

        while(checkLoop) {
            System.out.print("Vælg en mulighed:\n1.Tilføj ny sang\n2.Fjern en sang\n3.Vis alle sange\n4.Søg efter en sang" +
                    "\n5.Rediger en sang\n6.Sort sanglisten\n7.Afslut programmet\n");
            String answer = scan.nextLine();

            switch (answer.toLowerCase()){
                case "1":
                    System.out.println("Skriv sangens title: ");
                    String title = scan.nextLine();
                    System.out.println("Hvilken genre har sangen: ");
                    String genre = scan.nextLine();
                    if (genre.equalsIgnoreCase("rock")) {
                        handler.addSong(new Song(title, Genre.ROCK));
                    } else if (genre.equalsIgnoreCase("pop")) {
                        handler.addSong(new Song(title, Genre.POP));
                    } else if (genre.equalsIgnoreCase("jazz")) {
                        handler.addSong(new Song(title, Genre.JAZZ));
                    } else {
                        System.out.println("Unknown genre");
                    }
                    break;
                case "2":
                    System.out.println("Skriv titlen på den sang der skal fjernes: ");
                    String fjernTitle = scan.nextLine();
                    //Kald metode fra SongHandler til at fjerne sang både fra array og txt
                    break;
                case "3":
                    System.out.println(handler.getStringOfSongs());
                    break;
                case "4":
                    System.out.println("Indtast title: ");
                    String searchTitle = scan.nextLine();
                    Song foundSong = handler.searchTitle(searchTitle);
                    if(foundSong == null) {
                        System.out.println("The song was not found on the list :(");
                    } else {
                        System.out.println(foundSong);
                    }
                    break;
                case "5":
                    System.out.println("Indtast titlen på den sang du gerne vil redigere: ");
                    String redigerTitle = scan.nextLine();
                    break;
                case "6":
                    Collections.sort(handler.getSongs());
                    System.out.println(handler.getSongs());
                    break;
                case "7":
                    System.out.println("Tak for denne gang :)");
                    checkLoop = false;
                    break;
                default:
                    System.out.println("Ukendt input");
            }

        }

    }



    private static ArrayList<Song> getSongs(SongHandler handler) {
        //return handler.getSongNames();
        return handler.readSongFromFile();
    }

    private static void printSongs(ArrayList<Song> songs) {

        System.out.println("Song list: ");

        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }

    /*
     Gets user input
    */
    private static int getUserChoice(Scanner scanner) {

        System.out.print("Choose a recipe number: ");
        return scanner.nextInt();
    }

    /*
     Handles user selection logic
    */
    /*private static void handleChoice(int choice,
                                     ArrayList<String> songs,
                                     SongHandler handler) {

        if (choice > 0 && choice <= songs.size()) {

            String selectedRecipe = songs.get(choice - 1);

            ArrayList<Song> song =
                    handler.loadSong(selectedRecipe);

            handler.writeShoppingList(song);

            System.out.println("Shopping list created successfully.");

        } else {
            System.out.println("Invalid choice.");
        }
    }*/
}
