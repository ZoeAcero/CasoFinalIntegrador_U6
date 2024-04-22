package Gestion_DatosDinamicos;

import java.util.ArrayList;
import java.util.List;

public class RealList {
    private List<Double> reals;

    public RealList() {
        reals = new ArrayList<>();
    }

    public void addReal(double real) {
        reals.add(real);
    }

    public double getReal(int index) {
        return reals.get(index);
    }
}
