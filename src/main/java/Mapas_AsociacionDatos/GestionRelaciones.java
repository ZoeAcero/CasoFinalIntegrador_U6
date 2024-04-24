package Mapas_AsociacionDatos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import Gestion_DatosDinamicos.*;

public class GestionRelaciones extends JFrame{
    private Map<Pair, Pair> relaciones;
    private JFrame frame;
    private JTextField input1;
    private JTextField input2;
    private JTextArea textArea;

    // Constructor
    public GestionRelaciones() {
        setTitle("Mapas y Asociación de Datos");
        setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        this.relaciones = new HashMap<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Gestion de Relaciones");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        input1 = new JTextField(10);
        input2 = new JTextField(10);
        JButton button = new JButton("Agregar Relacion");
        textArea = new JTextArea(20, 30);
        textArea.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pair pareja1 = new Pair(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                Pair pareja2 = new Pair(Integer.parseInt(input2.getText()), Integer.parseInt(input1.getText()));
                agregarRelacion(pareja1, pareja2);
                textArea.append(pareja1 + " -> " + pareja2 + "\n");
            }
        });

        frame.add(input1);
        frame.add(input2);
        frame.add(button);
        frame.add(new JScrollPane(textArea));

        frame.pack();
        frame.setVisible(true);
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

    // Main

    public static void main(String[] args) {
        GestionRelaciones gestionRelaciones = new GestionRelaciones();
    }
}
