package Gestion_DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PairListGUI extends JFrame {
    private List<Pair> pairList;
    private JTextField firstField, secondField;
    private JButton addButton, modifyButton, removeButton;
    private JTable pairTable;

    public List<Pair> getPairList() {
        return pairList;
    }

    public PairListGUI() {
        pairList = new ArrayList<>();

        firstField = new JTextField();
        firstField.setText("Texto para firstField");
        firstField.setFont(new Font("Arial", Font.PLAIN, 18)); // Cambia el tamaño de la fuente de firstField
        secondField = new JTextField();
        secondField.setText("Texto para secondField");
        secondField.setFont(new Font("Arial", Font.PLAIN, 18));
        addButton = new JButton("Add");
        modifyButton = new JButton("Modify");
        removeButton = new JButton("Remove");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int first = Integer.parseInt(firstField.getText());
                    int second = Integer.parseInt(secondField.getText());
                    pairList.add(new Pair(first, second));
                    pairTable.updateUI();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter two integers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = pairTable.getSelectedRow();
                if (selectedRow >= 0) {
                    try {
                        int first = Integer.parseInt(firstField.getText());
                        int second = Integer.parseInt(secondField.getText());
                        pairList.set(selectedRow, new Pair(first, second));
                        pairTable.updateUI();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter two integers.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = pairTable.getSelectedRow();
                if (selectedRow >= 0) {
                    pairList.remove(selectedRow);
                    pairTable.updateUI();
                }
            }
        });

        pairTable = new JTable(); // Aquí necesitarás un modelo de tabla personalizado para mostrar los objetos Pair

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(firstField);
        buttonPanel.add(secondField);
        buttonPanel.add(addButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(removeButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(pairTable), BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        PairListGUI pairListGUI = new PairListGUI();
        pairListGUI.setVisible(true);
    }
}
