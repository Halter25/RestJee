
/**
 * Created by Ben on 21/01/2017.
 */
package m1.efrei.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Sets the path to base URL + /hello
@Path("/movies")
public class Movies {

    // This method is called the XML request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String moviesList() {

        Connection connec;
        Statement stmt = null;
        ResultSet result = null;

        try {
            // CONNECT to the database
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connec = DriverManager.getConnection("jdbc:hsqldb:file:L:/Java/RestJee/HSQLDB/", "root", "root");
            stmt = connec.createStatement();

            // READ into the database
            result = stmt.executeQuery("SELECT * FROM MOVIES");
            connec.close();

            // CONVERT to xml format
            while (result.next()) {
                // TODO Parse to XML
                System.out.println(result.getInt("ID") + " | " +
                        result.getString("TITLE") + " | " +
                        result.getInt("YEAR")
                );
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        // SEND the XML
        return "<?xml version=\"1.0\"?>" + "<hello> QUOI?" + "</hello>";
    }

}