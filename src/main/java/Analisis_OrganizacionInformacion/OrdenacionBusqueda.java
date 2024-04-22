package Analisis_OrganizacionInformacion;

import Gestion_DatosDinamicos.*;

import java.util.Collections;
import java.util.Comparator;

public class OrdenacionBusqueda {
    private ListaDatos listaDatos;

    // Constructor
    public OrdenacionBusqueda(ListaDatos listaDatos) {
        this.listaDatos = listaDatos;
    }

    // Método para ordenar los registros por el primer elemento de la pareja
    public void ordenarPorElemento1() {
        Collections.sort(listaDatos.obtenerLista(), Comparator.comparing(Pair::getElemento1));
    }

    // Método para ordenar los registros por el segundo elemento de la pareja
    public void ordenarPorElemento2() {
        Collections.sort(listaDatos.obtenerPairListGUI(), Comparator.comparing(Pair::getElemento2));
    }

    // Método para buscar una pareja por el primer elemento
    public Pair buscarPorElemento1(int elemento1) {
        for (Pair pareja : listaDatos.obtenerLista()) {
            if (pareja.getElemento1() == elemento1) {
                return pareja;
            }
        }
        return null;
    }
    // Método para buscar una pareja por el segundo elemento
    public Pair buscarPorElemento2(int elemento2) {
        for (Pair pareja : listaDatos.obtenerLista()) {
            if (pareja.getElemento2() == elemento2) {
                return pareja;
            }
        }
        return null;
    }
}
