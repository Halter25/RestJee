
/**
 * Created by Ben on 21/01/2017.
 */
package m1.efrei.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Sets the path to base URL + /hello
@Path("/movies")
public class Movies {

    // This method is called the XML request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String moviesList() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
    }

}