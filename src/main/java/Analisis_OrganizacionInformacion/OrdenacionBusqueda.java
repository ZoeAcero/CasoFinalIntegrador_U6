package Analisis_OrganizacionInformacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Gestion_DatosDinamicos.*;

import java.util.Collections;
import java.util.Comparator;

public class OrdenacionBusqueda extends JFrame{
    private PairListGUI listaDatos;
    private JFrame frame;
    private JTextField input;
    private JTextArea textArea;

    // Constructor
    public OrdenacionBusqueda() {
        setTitle("Análisis y Organización de Información");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.listaDatos = listaDatos;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Ordenacion y Busqueda");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        input = new JTextField(10);
        JButton sortFirstButton = new JButton("Ordenar por First");
        JButton sortSecondButton = new JButton("Ordenar por Second");
        JButton searchFirstButton = new JButton("Buscar por First");
        JButton searchSecondButton = new JButton("Buscar por Second");
        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        sortFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarPorFirst();
                textArea.append("Registros ordenados por First.\n");
            }
        });

        sortSecondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarPorSecond();
                textArea.append("Registros ordenados por Second.\n");
            }
        });

        searchFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pair result = buscarPorFirst(Integer.parseInt(input.getText()));
                textArea.append("Resultado de la búsqueda por First: " + result + "\n");
            }
        });

        searchSecondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pair result = buscarPorSecond(Integer.parseInt(input.getText()));
                textArea.append("Resultado de la búsqueda por Second: " + result + "\n");
            }
        });

        frame.add(input);
        frame.add(sortFirstButton);
        frame.add(sortSecondButton);
        frame.add(searchFirstButton);
        frame.add(searchSecondButton);
        frame.add(new JScrollPane(textArea));

        frame.pack();
        frame.setVisible(true);
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
