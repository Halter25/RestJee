package m1.efrei.data;

import m1.efrei.model.Commentary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben on 23/01/2017.
 */

public final class DataCommentary {

    private DataCommentary() {
    }

    private static List<Commentary> commentaryList = null;


    public static List<Commentary> getInstance() {
        if (commentaryList == null) {
            commentaryList = setommentaries();
        }
        return commentaryList;
    }

    private static List<Commentary> setommentaries() {
        
        Commentary a = new Commentary();
        a.setId(0);
        a.setMovieId(0);
        a.setAuthor("Ben76");
        a.setContent("Best movie ever !");

        Commentary b = new Commentary();
        b.setId(1);
        b.setMovieId(1);
        b.setAuthor("Xyfreed");
        b.setContent("Lol, before the Kingsman, the King's Speech ! ");

        ArrayList<Commentary> listCommentaries = new ArrayList<>();

        listCommentaries.add(a);
        listCommentaries.add(b);

        return listCommentaries;
    }

    public static void add(Commentary c) {
        getInstance().add(c);
    }
}
