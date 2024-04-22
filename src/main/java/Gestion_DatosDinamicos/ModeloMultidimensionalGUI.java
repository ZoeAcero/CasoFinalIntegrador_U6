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

        add(panelDatos, BorderLayout.CENTER);
    }

    public void establecerDato(int fila, int columna, int valor) {
        if (fila >= 0 && fila < camposTexto.length && columna >= 0 && columna < camposTexto[0].length) {
            camposTexto[fila][columna].setText(String.valueOf(valor));
        } else {
            JOptionPane.showMessageDialog(this, "Error: Índices fuera de rango.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int obtenerDato(int fila, int columna) {
        if (fila >= 0 && fila < camposTexto.length && columna >= 0 && columna < camposTexto[0].length) {
            try {
                return Integer.parseInt(camposTexto[fila][columna].getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error: Valor no válido en la celda [" + fila + "][" + columna + "]", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return 0; // Default value if there's an error
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModeloMultidimensionalGUI ventana = new ModeloMultidimensionalGUI(3, 3);
            ventana.setVisible(true);
        });
    }
}

    
