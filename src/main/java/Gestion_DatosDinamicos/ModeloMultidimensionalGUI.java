package Gestion_DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeloMultidimensionalGUI extends JFrame {
    private final JTextField[][] camposTexto;
    private final JPanel panelDatos;
    private final PairList pairList;
    private final RealList realList;
    private final JTextField pairInput1, pairInput2, realInput;
    private final JButton addPairButton, addRealButton;

    public ModeloMultidimensionalGUI(int filas, int columnas) {
        setTitle("Modelo Multidimensional");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelDatos = new JPanel(new GridLayout(filas, columnas, 5, 5));
        camposTexto = new JTextField[filas][columnas];
        pairList = new PairList();
        realList = new RealList();

        pairInput1 = new JTextField();
        pairInput2 = new JTextField();
        realInput = new JTextField();

        addPairButton = new JButton("Add Pair");
        addPairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int first = Integer.parseInt(pairInput1.getText());
                    int second = Integer.parseInt(pairInput2.getText());
                    pairList.addPair(new Pair(first, second));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter two integers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addRealButton = new JButton("Add Real");
        addRealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double real = Double.parseDouble(realInput.getText());
                    realList.addReal(real);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a real number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                camposTexto[i][j] = new JTextField();
                panelDatos.add(camposTexto[i][j]);
            }
        }

        add(panelDatos, BorderLayout.CENTER);
        add(pairInput1, BorderLayout.NORTH);
        add(pairInput2, BorderLayout.NORTH);
        add(realInput, BorderLayout.NORTH);
        add(addPairButton, BorderLayout.NORTH);
        add(addRealButton, BorderLayout.NORTH);
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
        return 0; 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ModeloMultidimensionalGUI ventana = new ModeloMultidimensionalGUI(3, 3);
            ventana.setVisible(true);
        });
    }
}


