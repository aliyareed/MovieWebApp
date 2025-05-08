package goldenoaks.business;

import java.io.Serializable;


public class Movie implements Serializable {

    private long checkoutNumber;
    private String title;
    private String actors;
    private String directors;
    private String genre;

    public Movie() {
        title = "";
        actors = "";
        directors = "";
        genre = "";

    }

    public long getCheckoutNumber() {
        return checkoutNumber;
    }

    public void setCheckoutNumber(long checkoutNumber) {
        this.checkoutNumber = checkoutNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getDirectors() {
        return directors;
    }

    public void setDirectors(String directors) {
        this.directors = directors;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
