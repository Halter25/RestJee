
/**
 * Created by Ben on 21/01/2017.
 */
package m1.efrei.rest;

import m1.efrei.data.DataDirector;
import m1.efrei.data.DataMovie;
import m1.efrei.model.Director;
import m1.efrei.model.Movie;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Sets the path to base URL + /directors
@Path("/directors")
public class Directors {

    @GET // Return the full list
    @Produces(MediaType.TEXT_XML)
    public List<Director> DirectorsList() {
        return DataDirector.getInstance();
    }

    @GET
    @Path("{id}") // Return details of a director by his ID
    public List<Director> getDirectorDetail(@PathParam("id") int id) {
        ArrayList<Director> directorDetail = new ArrayList<>();
        for (Director d : DataDirector.getInstance()) {
            if (d.getId() == id) {
                directorDetail.add(d);
            }
        }
        return (directorDetail.size() > 0) ? directorDetail : null;
    }

    @GET
    @Path("{id}/movies") // Return details of a director by his ID
    public List<Movie> getDirectorMovies(@PathParam("id") int id) {
        ArrayList<Movie> directorMovies = new ArrayList<>();
        for (Movie m : DataMovie.getInstance()) {
            if (m.getDirectorId() == id) {
                directorMovies.add(m);
            }
        }
        return (directorMovies.size() > 0) ? directorMovies : null;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newDirector(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
                        @Context HttpServletResponse servletResponse) throws IOException {

        Director d = new Director();
        d.setFirstname(firstName);
        d.setLastname(lastName);

        int i = 0;
        for (Director dir : DataDirector.getInstance()) {
            if (dir.getId() == i) i++;
        }
        d.setId(i);

        DataDirector.add(d);
        servletResponse.sendRedirect("http://localhost:8080/RestJee_war_exploded/"); // TODO change url
    }
}