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

    public PairListGUI() {
        pairList = new ArrayList<>();

        firstField = new JTextField();
        secondField = new JTextField();
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

        setLayout(new BorderLayout());
        add(firstField, BorderLayout.NORTH);
        add(secondField, BorderLayout.NORTH);
        add(addButton, BorderLayout.NORTH);
        add(modifyButton, BorderLayout.NORTH);
        add(removeButton, BorderLayout.NORTH);
        add(new JScrollPane(pairTable), BorderLayout.CENTER);

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        PairListGUI pairListGUI = new PairListGUI();
        pairListGUI.setVisible(true);
    }
}
