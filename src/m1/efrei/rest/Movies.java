
/**
 * Created by Ben on 21/01/2017.
 */
package m1.efrei.rest;

import m1.efrei.data.DataMovie;
import m1.efrei.model.Movie;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Sets the path to base URL + /movies
@Path("/movies")
public class Movies {

    @GET // Return the full list
    @Produces(MediaType.TEXT_XML)
    public List<Movie> MoviesList() {
        return DataMovie.getInstance();
    }

    @GET
    @Path("{year}") // Return a list of movie by the year
    public List<Movie> getYearMovies(@PathParam("year") int year) {
        ArrayList<Movie> yearMovies = new ArrayList<>();
        for (Movie m : DataMovie.getInstance()) {
            if (m.getYear() == year) {
                yearMovies.add(m);
            }
        }
        return (yearMovies.size() > 0) ? yearMovies : null;
    }

    @GET
    @Path("{year}/laureate") // Return the laureate of the asked year
    public Movie getYearLaureate(@PathParam("year") int year) {
        for (Movie m : DataMovie.getInstance()) {
            if (m.getYear() == year && m.isLaureate()) {
                return m;
            }
        }
        return null;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newMovie(@FormParam("title") String title, @FormParam("directorId") int directorId,
                         @FormParam("year") int year, @FormParam("laureate") boolean laureate,
                         @Context HttpServletResponse servletResponse) throws IOException {

        int i = 0;
        for (Movie mov : DataMovie.getInstance()) {
            if (mov.getId() == i) i++;
        }

        Movie m = new Movie();
        m.setId(i);
        m.setTitle(title);
        m.setDirectorId(directorId);
        m.setYear(year);
        m.setLaureate(laureate);

        DataMovie.add(m);
        servletResponse.sendRedirect("http://localhost:8080/RestJee_war_exploded/"); // TODO change url
    }
}