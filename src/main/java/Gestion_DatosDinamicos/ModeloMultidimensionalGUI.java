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

    }
