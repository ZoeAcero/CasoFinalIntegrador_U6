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
    public void ordenarPorElemento1() {
        Collections.sort(listaDatos.obtenerLista(), Comparator.comparing(Pair::getFirst));
    }

    // Método para ordenar los registros por el segundo elemento de la pareja
    public void ordenarPorElemento2() {
        Collections.sort(listaDatos.obtenerLista(), Comparator.comparing(Pair::getSecond));
    }

    // Método para buscar una pareja por el primer elemento
    public Pair buscarPorElemento1(int elemento1) {
        for (Pair pareja : listaDatos.obtenerLista()) {
            if (pareja.getFirst() == elemento1) {
                return pareja;
            }
        }
        return null;
    }
    // Método para buscar una pareja por el segundo elemento
    public Pair buscarPorElemento2(int elemento2) {
        for (Pair pareja : listaDatos.obtenerLista()) {
            if (pareja.getSecond() == elemento2) {
                return pareja;
            }
        }
        return null;
    }
}
