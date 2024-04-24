package Indexacion_VisualizacionArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacionListado extends JFrame {
    private List<File> archivosIndexados;
    private JFrame frame;
    private JTextArea textArea;


    // Constructor
    public OrdenacionListado() {
        setTitle("Indexacion y Visualizacion de Archivos");
        setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        this.archivosIndexados = archivosIndexados;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Ordenacion de Listado");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());


        JButton sortNameButton = new JButton("Ordenar por Nombre");
        JButton sortSizeButton = new JButton("Ordenar por Tamaño");
        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        sortNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarPorNombre();
                textArea.append("Archivos ordenados por nombre.\n");
            }
        });

        sortSizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarPorTamano();
                textArea.append("Archivos ordenados por tamaño.\n");
            }
        });

        frame.add(sortNameButton);
        frame.add(sortSizeButton);
        frame.add(new JScrollPane(textArea));

        frame.pack();
        frame.setVisible(true);
    }

    // Método para ordenar los archivos por nombre
    public void ordenarPorNombre() {
        Collections.sort(archivosIndexados, Comparator.comparing(File::getName));
    }

    // Método para ordenar los archivos por tamaño
    public void ordenarPorTamano() {
        Collections.sort(archivosIndexados, Comparator.comparing(File::length));
    }

    // Método para obtener la lista de archivos indexados
    public List<File> obtenerArchivosIndexados() {
        return this.archivosIndexados;
    }

    // main

    public static void main(String[] args) {
        IndexacionRecursiva indexacionRecursiva = new IndexacionRecursiva();
        OrdenacionListado ordenacionListado = new OrdenacionListado();
        ordenacionListado.frame.setVisible(true);
    }
}
