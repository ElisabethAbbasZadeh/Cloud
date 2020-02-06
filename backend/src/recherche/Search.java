package recherche;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import precalcul.index.Indexing;
import precalcul.titres.titre;

/**
 * Search
 */
public class Search {

    public static void main(String[] args) {
        String rechercheString = args[0];
        ArrayList<String> paths = new ArrayList<>();
        HashMap<String, String> titres = titre.loadTitres();
        try {

            Files.walk(Paths.get("./data/index/")).filter(Files::isRegularFile).map(p -> p.toString())
                    .filter(p -> p.endsWith("index")).collect(Collectors.toList()).forEach(x -> paths.add(x));

            for (String path : paths) {
                HashMap<String, Integer> indexMap = Indexing.loadIndexMap(path);
                if (indexMap.containsKey(rechercheString)) {

                    String textString = path.substring(0, path.indexOf("/index"));
                    textString += "/books/" + path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
                    System.out.println("\nFILENAME : " + textString);
                    System.out.println("NAME : " + titres.getOrDefault(textString, textString));

                }

            }

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static ArrayList<HashMap<String, String>> search(String val) {
        ArrayList<HashMap<String, String>> books = new ArrayList<>();

        String rechercheString = val;
        ArrayList<String> paths = new ArrayList<>();
        HashMap<String, String> titres = titre.loadTitres();
        try {

            Files.walk(Paths.get("./data/index/")).filter(Files::isRegularFile).map(p -> p.toString())
                    .filter(p -> p.endsWith("index")).collect(Collectors.toList()).forEach(x -> paths.add(x));

            for (String path : paths) {
                HashMap<String, Integer> indexMap = Indexing.loadIndexMap(path);
                if (indexMap.containsKey(rechercheString)) {

                    String textString = path.substring(0, path.indexOf("/index"));
                    textString += "/books/" + path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
                    HashMap<String, String> h = new HashMap();
                    books.add(h);
                    h.put("title", titres.getOrDefault(textString, textString));
                    h.put("path", textString);
                }
                if (books.size() > 20) {
                    break;
                }
            }

        } catch (IOException io) {
            io.printStackTrace();
        }

        return books;
    }

    public static ArrayList<HashMap<String, String>> sugest(String val) {

        ArrayList<HashMap<String, String>> books = new ArrayList<>();

        return books;
    }

}