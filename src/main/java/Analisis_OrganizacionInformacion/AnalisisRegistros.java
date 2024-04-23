package Analisis_OrganizacionInformacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gestion_DatosDinamicos.*;

public class AnalisisRegistros {
    private PairListGUI listaDatos;
    private JFrame frame;
    private JTextArea textArea;

    // Constructor
    public AnalisisRegistros(PairListGUI listaDatos) {
        this.listaDatos = listaDatos;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Analisis de Registros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton sortButton = new JButton("Ordenar Registros");
        JButton filterButton = new JButton("Filtrar Registros");
        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarRegistros();
                textArea.append("Registros ordenados.\n");
            }
        });

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarRegistros();
                textArea.append("Registros filtrados.\n");
            }
        });

        frame.add(sortButton);
        frame.add(filterButton);
        frame.add(new JScrollPane(textArea));

        frame.pack();
        frame.setVisible(true);
    }

    public void ordenarRegistros() {
        System.out.println("Este método ordenará los registros");
    }

    public void filtrarRegistros() {
        System.out.println("Este método filtrará los registros");
    }
}