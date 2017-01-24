
/**
 * Created by Ben on 21/01/2017.
 */
package m1.efrei.rest;

import m1.efrei.data.DataMovie;
import m1.efrei.model.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /laureates
@Path("/laureates")
public class Laureates {

    @GET // Return the full list
    @Produces(MediaType.TEXT_PLAIN)
    public String LaureateList() {
        String laureatesList = "";
        for (Movie m : DataMovie.getInstance()) {
            if (m.isLaureate()) {
                laureatesList += (m.getYear() + " - " + m.getTitle() + "\n");
            }
        }
        return (laureatesList.length() > 0) ? laureatesList : "No Laureate registred";
    }
}