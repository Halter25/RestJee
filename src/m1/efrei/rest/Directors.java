
/**
 * Created by Ben on 21/01/2017.
 */
package m1.efrei.rest;

import m1.efrei.data.DataDirector;
import m1.efrei.model.Director;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

//Sets the path to base URL + /directors
@Path("/directors")
public class Directors {

    @GET // Return the full list
    @Produces(MediaType.TEXT_XML)
    public List<Director> DirectorsList() {
        return DataDirector.getInstance();
    }

    /* TODO Individuellement
    @Path("{directors}") // Return a director by his ID
    public Director getDirector(@PathParam("directors") int id) {
        for (Director d : DataDirector.getInstance()) {
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