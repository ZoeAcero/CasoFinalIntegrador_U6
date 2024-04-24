package Mapas_AsociacionDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import Gestion_DatosDinamicos.*;

public class RecuperacionEficiente extends JFrame{
    private Map<Pair, Pair> relaciones;
    private JFrame frame;
    private JTextField input1;
    private JTextField input2;
    private JTextArea textArea;

    // Constructor
    public RecuperacionEficiente(Map<Pair, Pair> relaciones) {
        setTitle("Mapas y Asociación de Datos");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.relaciones = relaciones;
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Recuperacion Eficiente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        input1 = new JTextField(10);
        input2 = new JTextField(10);
        JButton retrieveButton = new JButton("Obtener Relacion");
        JButton deleteButton = new JButton("Eliminar Relacion");
        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        retrieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pair pareja = new Pair(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                Pair relacion = obtenerRelacion(pareja);
                textArea.append(pareja + " -> " + relacion + "\n");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pair pareja = new Pair(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                eliminarRelacion(pareja);
                textArea.append("Relacion " + pareja + " eliminada.\n");
            }
        });

        frame.add(input1);
        frame.add(input2);
        frame.add(retrieveButton);
        frame.add(deleteButton);
        frame.add(new JScrollPane(textArea));

        frame.pack();
        frame.setVisible(true);
    }

    public Pair obtenerRelacion(Pair pareja) {
        return this.relaciones.get(pareja);
    }

    public void eliminarRelacion(Pair pareja) {
        this.relaciones.remove(pareja);
    }
}
