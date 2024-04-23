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

        indexButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    indexarArchivos(selectedDirectory);
                    textArea.append("Archivos indexados:\n");
                    for (File file : obtenerArchivosIndexados()) {
                        textArea.append(file.getPath() + "\n");
                    }
                }
            }
        });

        frame.add(indexButton);
        frame.add(new JScrollPane(textArea));

        frame.pack();
        frame.setVisible(true);
    }

    // Método para indexar archivos de manera recursiva
    public void indexarArchivos(File directorio) {
        // Si el archivo es un directorio, indexamos recursivamente
        if (directorio.isDirectory()) {
            for (File archivo : directorio.listFiles()) {
                indexarArchivos(archivo);
            }
        } else {
            // Si el archivo no es un directorio, lo añadimos a la lista de archivos indexados
            archivosIndexados.add(directorio);
        }
    }

    // Método para obtener la lista de archivos indexados
    public List<File> obtenerArchivosIndexados() {
        return this.archivosIndexados;
    }
}

