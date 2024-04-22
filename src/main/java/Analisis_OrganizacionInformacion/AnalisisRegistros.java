package Analisis_OrganizacionInformacion;

import Gestion_DatosDinamicos.*;

public class AnalisisRegistros {
    private PairListGUI listaDatos;

    // Constructor
    public AnalisisRegistros(PairListGUI listaDatos) {
        this.listaDatos = listaDatos;
    }

    public void ordenarRegistros() {
        System.out.println("Este método ordenará los registros");
    }

    public void filtrarRegistros() {
        System.out.println("Este método filtrará los registros");
    }
}
