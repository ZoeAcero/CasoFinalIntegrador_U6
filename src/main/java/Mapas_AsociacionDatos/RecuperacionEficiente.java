package Mapas_AsociacionDatos;

import Gestion_DatosDinamicos.Pair;
import java.util.Map;

public class RecuperacionEficiente {
    private Map<Pair, Pair> relaciones;

    // Constructor
    public RecuperacionEficiente(Map<Pair, Pair> relaciones) {
        this.relaciones = relaciones;
    }

    public Pair obtenerRelacion(Pair pareja) {
        return this.relaciones.get(pareja);
    }

    public void eliminarRelacion(Pair pareja) {
        this.relaciones.remove(pareja);
    }
}
