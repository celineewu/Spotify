package service;

import model.*;
import java.io.*;
import java.util.ArrayList;


//SongHandler holder sig til kommunikationen mellem ArrayList og txt og
//lader SoundVault stå for kommunikationen med brugeren/Scanner
public class SongHandler {

    private static final String FILE_PATH = "src/spotify.txt";
    private static ArrayList<Song> songs = new ArrayList<>();


    //Getter
    public ArrayList<Song> getSongs() {
        return songs;
    }

    //Læser sangene fra txt og sætter dem ind i en ArrayList
    public void readSongFromFile() {

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
    }

    //Tilføjer en sang til ArrayListen og txt
    public void addSong(Song song) {
        songs.add(song);
        writeToFile();
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

    //Søger efter en bestemt title i ArrayListen
    public Song searchTitle(String title) {
        for (Song song : songs) {
            if (title.equalsIgnoreCase(song.getTitle())) {
                return song;
            }
        }
        return null;
    }

    //For en bestemt titel og fjerner sangen fra ArrayList og txt
    public ArrayList<Song> removeSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (title.equalsIgnoreCase(songs.get(i).getTitle())) {
                songs.remove(i); //fjerner sang fra ArrayList
                writeToFile(); //opdatere txt
                return songs;
            }
        }
        return null;
    }

    //Metoden tager en sang og giver den en ny titel
    public void editSong(Song song, String newTitle) {
        song.setTitle(newTitle);
        writeToFile();
    }

}