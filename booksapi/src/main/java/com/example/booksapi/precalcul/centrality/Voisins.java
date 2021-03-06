package com.example.booksapi.precalcul.centrality;

import java.io.*;
import java.util.ArrayList;

/**
 * Voisins
 */
public class Voisins {

    public static boolean voisins(Graph g) {

        for (int i = 0; i < g.paths.size(); i++) {
            String gpath = g.paths.get(i);

            gpath = gpath.substring(gpath.lastIndexOf("/") + 1);
            gpath = "./data/voisins/" + gpath;
            // System.out.println(gpath);

            ArrayList<String> voisins = new ArrayList<>();

            ArrayList<Integer> inv = g.adjacence.get(i);
            for (Integer integer : inv) {
                String path = g.paths.get(integer);
                voisins.add(path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".")));

            }

            File f = new File(gpath);
            Writer writer = null;

            try {
                writer = new FileWriter(f);

                PrintWriter pw = new PrintWriter(writer);

                for (String voisin : voisins) {

                    pw.println(voisin);
                }

                pw.flush();

                pw.close();
                writer.close();

            } catch (IOException e) {
                System.out.println("Problème écriture dans fichier voisins.");
            } finally {

            }

        }

        return true;

    }

}