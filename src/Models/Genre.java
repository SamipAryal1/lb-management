package Models;

public class Genre {
    String genre_name;
    String genre_description;

    public Genre(String genre_name, String genre_description) {
        this.genre_name = genre_name;
        this.genre_description = genre_description;
    }

    public String getGenre_name() {
        return this.genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public String getGenre_description() {
        return this.genre_description;
    }

    public void setGenre_description(String genre_description) {
        this.genre_description = genre_description;
    }
}
