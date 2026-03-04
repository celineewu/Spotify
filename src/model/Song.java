package model;

public class Song implements Comparable<Song>{
    private String title;

    public Song(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Song other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return title;
    }
}
