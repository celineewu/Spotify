package service;

import model.*;
import java.io.*;
import java.util.ArrayList;


//SongHandler holder sig til kommunikationen mellem ArrayList og txt og
//lader SoundVault stå for kommunikationen med brugeren/Scanner
public class SongHandler {

    private static final String FILE_PATH = "src\\spotify.txt";
    private static ArrayList<Song> songs = new ArrayList<>();


    //Læser sangene fra txt og sætter dem ind i en ArrayList
    public ArrayList<Song> readSongFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                String title = parts[0];
                Genre genre = Genre.valueOf(parts[1].trim());

                Song song = new Song(title, genre);

                songs.add(song);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }


    //Denne metode skriver ArrayList<Song> til txt
    public static void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Song song : songs) {
                bufferedWriter.write(song.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Laver sangene i ArrayListen om til en String
    public String getStringOfSongs() {
        String allSongs = "";

        for (Song song : songs) {
            allSongs = allSongs.concat(song.toString() + "\n"); //concatenate: to link together in a series or chain
        }
        return allSongs;
    }


    //Tilføjer en sang til ArrayListen og txt
    public void addSong(Song song) {
        songs.add(song);
        writeToFile();
    }

    //Getter
    public ArrayList<Song> getSongs() {
        return songs;
    }

    //Søger efter en bestemt title i ArrayListen
    public Song searchTitle(String title) {
        for (Song song : songs) {
            if (title.equalsIgnoreCase(song.getTitle())) {
                return song;
            }

        }
        return null;
    }

    public static void removeSongFromArray(String title) {

    }








    public ArrayList<String> getSongNames() {

        ArrayList<String> songs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.contains(",")) {
                    songs.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return songs;
    }

    public ArrayList<Song> loadSong(String songName) {

        ArrayList<Song> songs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            boolean foundSong = false;

            while ((line = reader.readLine()) != null) {

                if (line.equals(songName)) {
                    foundSong = true;
                    continue;
                }

                if (foundSong) {

                    if (line.isEmpty()) break;

                    String[] parts = line.split(",");

                    String title = parts[0];
                    Genre genre = Genre.valueOf(parts[1]);

                    Song song = new Song(title, genre);

                    songs.add(song);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return songs;
    }

    // ------------------------------------------------------------
    // VERSION USING FILEWRITER (Not BufferedWriter)
    // ------------------------------------------------------------
    /*public void writeShoppingList(ArrayList<Ingredient> ingredients) {

        FileWriter writer = null;

        try {

            writer = new FileWriter("src\\Lesson15\\Recipes\\shopping_list.txt");

            for (Ingredient ingredient : ingredients) {

                // Polymorphism in action
                writer.write(ingredient.formatForShoppingList());

                // FileWriter has no newLine() method
                writer.write("\n");
            }

            writer.flush(); // ensure data is written

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

}
