
/**
 * Created by Ben on 21/01/2017.
 */
package m1.efrei.rest;

import m1.efrei.data.DataCommentary;
import m1.efrei.model.Commentary;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Sets the path to base URL + /commentaries
@Path("/commentaries")
public class Commentaries {

    @GET // Return the full list
    @Produces(MediaType.TEXT_XML)
    public List<Commentary> CommentarysList() {
        return DataCommentary.getInstance();
    }

    @GET
    @Path("{id}") // Return a list of movie's commentaries by his ID
    public List<Commentary> getMovieCommentaries(@PathParam("id") int id) {
        ArrayList<Commentary> movieCommentaries = new ArrayList<>();
        for (Commentary c : DataCommentary.getInstance()) {
            if (c.getMovieId() == id) {
                movieCommentaries.add(c);
            }
        }
        return movieCommentaries;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newCommentary(@FormParam("movieId") int movieId, @FormParam("author") String author,
                              @FormParam("content") String content, @Context HttpServletResponse servletResponse)
            throws IOException {

        int i = 0;
        for (Commentary com : DataCommentary.getInstance()) {
            if (com.getId() == i) i++;
        }

        Commentary c = new Commentary();
        c.setId(i);
        c.setMovieId(movieId);
        c.setAuthor(author);
        c.setContent(content);

        DataCommentary.add(c);
        servletResponse.sendRedirect("./..");
    }
}