package m1.efrei.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ben on 20/01/2017.
 */
@XmlRootElement
public class Movie {
    private int id;
    private String title;
    private int directorId;
    private int year;
    private boolean laureate;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isLaureate() {
        return laureate;
    }

    public void setLaureate(boolean laureate) {
        this.laureate = laureate;
    }
}
