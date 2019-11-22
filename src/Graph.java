package Online;

import java.util.ArrayList;

import Online.Document;

/**
 * Graph
 */
public class Graph {

    public ArrayList<Document> docs;
    public int nbS;
    public ArrayList<ArrayList<Integer>> adjacence;

    public Graph(ArrayList<Document> docs) {
        this.docs = docs;
        nbS = 0;
        adjacence = new ArrayList<>();

        for (Document document : docs) {
            addSommet();
        }

        for (int i = 0; i < docs.size(); i++) {

            for (int j = i + 1; j < docs.size(); j++) {
                double dist = distJacquard(docs.get(i), docs.get(j));
                if (dist > 0.7) {
                    addEdge(i, j);
                    System.out.println(
                            "distance entre " + docs.get(i).textPath + " et " + docs.get(j).textPath + " : " + dist);
                }
            }
        }
    }

    public void addSommet() {
        nbS++;
        adjacence.add(new ArrayList<>());

    }

    public void addEdge(int i, int j) {

        if (!adjacence.get(i).contains(j)) {
            adjacence.get(i).add(j);

            if (!adjacence.get(j).contains(i)) {
                adjacence.get(j).add(i);
            }
        }
    }

    public String noeudSeuls() {
        String sortie = "";
        for (int i = 0; i < this.nbS; i++) {
            if (this.adjacence.get(i).size() == 0) {
                sortie += i + "\n";
            }
        }
        return sortie;
    }

    public double distJacquard(Document d1, Document d2) {
        double somme = 0;
        double sommemax = 0;

        for (String motD1 : d1.indexArray) {
            if (d2.indexArray.contains(motD1)) {
                int max = Math.max(d1.indexMap.get(motD1), d2.indexMap.get(motD1));
                int min = Math.min(d1.indexMap.get(motD1), d2.indexMap.get(motD1));

                somme += (max - min);
                sommemax += max;
            } else {
                somme += d1.indexMap.get(motD1);

                sommemax += d1.indexMap.get(motD1);
            }

        }
        for (String motD2 : d2.indexArray) {
            if (!d1.indexArray.contains(motD2)) {
                somme += d2.indexMap.get(motD2);

                sommemax += d2.indexMap.get(motD2);
            }
        }

        return somme / sommemax;
    }
}