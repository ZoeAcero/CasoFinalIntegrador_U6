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
