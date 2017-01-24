package m1.efrei.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ben on 20/01/2017.
 */
@XmlRootElement
public class Commentary {
    private int id;
    private int movieId;
    private String author;
    private String content;

    public Commentary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movie_id) {
        this.movieId = movie_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
