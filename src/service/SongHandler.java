package service;

import model.*;

import java.io.*;
import java.util.ArrayList;

public class SongHandler {

    private static final String FILE_PATH = "src\\spotify.txt";


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


    public void writeSongList(ArrayList<Song> songs) {

        FileWriter writer = null;

        try {

            writer = new FileWriter("src\\Lesson15\\Recipes\\shopping_list.txt");

            for (Song song : songs) {

                // Polymorphism in action
                writer.write(song.ads());

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
    }
}
