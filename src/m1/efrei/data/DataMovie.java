package m1.efrei.data;

import m1.efrei.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 23/01/2017.
 */

public final class DataMovie {

    private DataMovie() {
    }

    /**
     * Instance unique non préinitialisée
     */
    private static List<Movie> movieList = null;

    /**
     * Point d'accès pour l'instance unique du singleton
     */
    public static List<Movie> getInstance() {
        if (movieList == null) {
            movieList = setMovies();
        }
        return movieList;
    }

    private static List<Movie> setMovies() {
        Movie a = new Movie();
        a.setId(0);
        a.setTitle("The Secret Life of Walter Mitty");
        a.setDirectorId(0);
        a.setYear(2014);
        a.setLaureate(false);

        Movie b = new Movie();
        b.setId(1);
        b.setTitle("The King's Speech");
        b.setDirectorId(1);
        b.setYear(2011);
        b.setLaureate(true);

        ArrayList<Movie> listMovies = new ArrayList<>();

        listMovies.add(a);
        listMovies.add(b);

        return listMovies;
    }

    public static void add(Movie d) {
        getInstance().add(d);
    }
}
