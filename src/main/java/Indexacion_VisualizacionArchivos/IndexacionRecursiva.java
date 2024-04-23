package Indexacion_VisualizacionArchivos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IndexacionRecursiva {
    private List<File> archivosIndexados;
    private JFrame frame;
    private JTextArea textArea;

    // Constructor
    public IndexacionRecursiva() {
        this.archivosIndexados = new ArrayList<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Indexacion Recursiva");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton indexButton = new JButton("Indexar Archivos");
        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);
}
