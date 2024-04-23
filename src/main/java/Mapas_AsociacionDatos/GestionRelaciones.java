package Mapas_AsociacionDatos;

import java.util.HashMap;
import java.util.Map;
import Gestion_DatosDinamicos.*;

public class GestionRelaciones {
    private Map<Pair, Pair> relaciones;

    // Constructor
    public GestionRelaciones() {
        this.relaciones = new HashMap<>();
    }

    public void agregarRelacion(Pair pareja1, Pair pareja2) {
        this.relaciones.put(pareja1, pareja2);
    }

    public Pair obtenerRelacion(Pair pareja) {
        return this.relaciones.get(pareja);
    }

    public void eliminarRelacion(Pair pareja) {
        this.relaciones.remove(pareja);
    }

}
