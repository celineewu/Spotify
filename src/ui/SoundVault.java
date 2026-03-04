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

       // printSongs(songs);


    }



    private static ArrayList<String> getSongs(SongHandler handler) {
        return handler.getSongNames();
    }
}
