package Gestion_DatosDinamicos;

import java.awt.*;
import javax.swing.*;

public class ModeloMultidimensionalGUI extends JFrame {
    private final JTextField[][] camposTexto;
    private final JPanel panelDatos;

    public ModeloMultidimensionalGUI(int filas, int columnas) {
        setTitle("Modelo Multidimensional");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelDatos = new JPanel(new GridLayout(filas, columnas, 5, 5));
        camposTexto = new JTextField[filas][columnas];

        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                camposTexto[i][j] = new JTextField();
                panelDatos.add(camposTexto[i][j]);
            }
        }

    }
