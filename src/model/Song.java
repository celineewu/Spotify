package model;

public class Song implements Comparable<Song>{
    private String title;
    private Genre genre;
    private double time;

    public Song(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    @Override
    public int compareTo(Song other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return title + ", " + genre;
    }
}
