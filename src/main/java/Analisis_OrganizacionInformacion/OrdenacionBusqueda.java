package Analisis_OrganizacionInformacion;

import Gestion_DatosDinamicos.*;

import java.util.Collections;
import java.util.Comparator;

public class OrdenacionBusqueda {
    private PairListGUI listaDatos;

    // Constructor
    public OrdenacionBusqueda(PairListGUI listaDatos) {
        this.listaDatos = listaDatos;
    }

    // Método para ordenar los registros por el primer elemento de la pareja
    public void ordenarPorFirst() {
        Collections.sort(listaDatos.getPairList(), Comparator.comparing(Pair::getFirst));
    }

    // Método para ordenar los registros por el segundo elemento de la pareja
    public void ordenarPorSecond() {
        Collections.sort(listaDatos.getPairList(), Comparator.comparing(Pair::getSecond));
    }

    // Método para buscar una pareja por el primer elemento
    public Pair buscarPorFirst(int First) {
        for (Pair pareja : listaDatos.getPairList()) {
            if (pareja.getFirst() == First) {
                return pareja;
            }
        }
        return null;
    }
    // Método para buscar una pareja por el segundo elemento
    public Pair buscarPorSecond(int Second) {
        for (Pair pareja : listaDatos.getPairList()) {
            if (pareja.getSecond() == Second) {
                return pareja;
            }
        }
        return null;
    }
}
