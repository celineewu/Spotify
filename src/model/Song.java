package model;

public class Song implements Comparable<Song>{
    private String title;
    private Genre genre;
    private double time;

    public Song(String title, Genre genre, double time) {
        this.title = title;
        this.genre = genre;
        this.time = time;
    }

    //Getters
    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getTime() {
        return time;
    }

    //Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setTime(double time) {
        this.time = time;
    }


    @Override
    public int compareTo(Song other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nGenre: " + genre + "\nTime: " + time;
    }
}
