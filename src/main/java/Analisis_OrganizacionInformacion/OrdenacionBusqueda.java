package Analisis_OrganizacionInformacion;

import Gestion_de_Datos_Dinamicos.Pareja;
import Gestion_de_Datos_Dinamicos.ListaDatos;

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
        Collections.sort(listaDatos.obtenerLista(), Comparator.comparing(Pareja::getElemento1));
    }

    // Método para ordenar los registros por el segundo elemento de la pareja
    public void ordenarPorElemento2() {
        Collections.sort(listaDatos.obtenerLista(), Comparator.comparing(Pareja::getElemento2));
    }

    // Método para buscar una pareja por el primer elemento
    public Pareja buscarPorElemento1(int elemento1) {
        for (Pareja pareja : listaDatos.obtenerLista()) {
            if (pareja.getElemento1() == elemento1) {
                return pareja;
            }
        }
        return null;
    }
