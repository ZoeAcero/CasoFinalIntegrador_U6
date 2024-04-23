package Indexacion_VisualizacionArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacionListado {
    private List<File> archivosIndexados;
    private JFrame frame;
    private JTextArea textArea;


    // Constructor
    public OrdenacionListado(List<File> archivosIndexados) {
        this.archivosIndexados = archivosIndexados;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Ordenacion de Listado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}
