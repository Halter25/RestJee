package m1.efrei.data;

import m1.efrei.model.Director;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 23/01/2017.
 */

public final class DataDirector {

    private DataDirector() {
    }

    /**
     * Instance unique non préinitialisée
     */
    private static List<Director> directorList = null;

    /**
     * Point d'accès pour l'instance unique du singleton
     */
    public static List<Director> getInstance() {
        if (directorList == null) {
            directorList = setDirectors();
        }
        return directorList;
    }

    private static List<Director> setDirectors() {
        Director a = new Director();
        a.setId(0);
        a.setFirstname("Ben");
        a.setLastname("Stiller");

        Director b = new Director();
        b.setId(1);
        b.setFirstname("Tom");
        b.setLastname("Hooper");

        ArrayList<Director> listDirectors = new ArrayList<>();

        listDirectors.add(a);
        listDirectors.add(b);

        return listDirectors;
    }

    public static void add(Director d) {
        getInstance().add(d);
    }
}
