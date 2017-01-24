package m1.efrei.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ben on 20/01/2017.
 */
@XmlRootElement
public class Director {
    private int id;
    private String lastname;
    private String firstname;

    public Director() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
