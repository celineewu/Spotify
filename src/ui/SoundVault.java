package ui;

import model.User;
import service.*;


import java.util.ArrayList;
import java.util.Scanner;

public class SoundVault {

    public static void main (String[] args) {

        //System.out.println(getSongs(SongHandler());

        SongHandler handler = new SongHandler();
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> songs = getSongs(handler);

       printSongs(songs);

       int choice = getUserChoice(scanner);

       handleChoice(choice, songs, handler);

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

        System.out.print("Velkommen til hjemmelavede Spotify! Vælg en mulighed:\n: " +
                "1.Tilføj ny sang\n2. Fjern en sang\3. Vis alle sang\nSøg efter en sang\n" +
                "4. Søg efter en sang\n5. Rediger en sang\n6. Sorter sanglisten\n7. Afslut programmet");

        return scanner.nextInt();
    }

    /*
     Handles user selection logic
    */
    private static void handleChoice(int choice,
                                     ArrayList<String> songs,
                                     SongHandler handler) {

        if (choice > 0 && choice <= recipes.size()) {

            String selectedRecipe = recipes.get(choice - 1);

            ArrayList<Ingredient> ingredients =
                    handler.loadRecipe(selectedRecipe);

            handler.writeShoppingList(ingredients);

            System.out.println("Shopping list created successfully.");

        } else {
            System.out.println("Invalid choice.");
        }
    }




}
