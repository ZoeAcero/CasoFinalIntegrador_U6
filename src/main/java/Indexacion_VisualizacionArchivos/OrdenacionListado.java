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
}
