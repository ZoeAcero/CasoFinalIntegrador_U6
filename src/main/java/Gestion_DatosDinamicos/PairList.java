package Gestion_DatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class PairList {
    private List<Pair> pairs;

    public PairList() {
        pairs = new ArrayList<>();
    }

    public void addPair(Pair pair) {
        pairs.add(pair);
    }

    public void removePair(int index) {
        pairs.remove(index);
    }

    public Pair getPair(int index) {
        return pairs.get(index);
    }

    public void setPair(int index, Pair pair) {
        pairs.set(index, pair);
    }
}
