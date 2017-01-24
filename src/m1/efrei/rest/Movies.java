
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
import java.util.List;

//Sets the path to base URL + /movies
@Path("/movies")
public class Movies {

    @GET // Return the full list
    @Produces(MediaType.TEXT_XML)
    public List<Movie> MoviesList() {
        return DataMovie.getInstance();
    }

    /* TODO Individuellement
    @Path("{movies}") // Return a director by his ID
    public Movie getMovie(@PathParam("movies") int id) {
        for (Movie d : DataMovie.getInstance()) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }
    */

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
        m.setLaureate(laureate); // TODO Fix le probleme. La valeur n'est pas sauvegardé

        DataMovie.add(m);
        servletResponse.sendRedirect("http://localhost:8080/RestJee_war_exploded/"); // TODO change url
    }
}