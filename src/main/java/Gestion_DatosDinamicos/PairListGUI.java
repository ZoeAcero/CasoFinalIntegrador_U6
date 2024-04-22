package Gestion_DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.AbstractTableModel;

public class PairListGUI extends JFrame {
    private PairList pairList;
    private JTextField firstField, secondField;
    private JButton addButton, modifyButton, removeButton;
    private JTable pairTable;

    public PairListGUI() {
        pairList = new PairList();

        firstField = new JTextField();
        secondField = new JTextField();
        addButton = new JButton("Add");
        modifyButton = new JButton("Modify");
        removeButton = new JButton("Remove");
        pairTable = new JTable(new PairTableModel(pairList));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int first = Integer.parseInt(firstField.getText());
                    int second = Integer.parseInt(secondField.getText());
                    pairList.addPair(new Pair(first, second));
                    ((AbstractTableModel) pairTable.getModel()).fireTableDataChanged();
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
                        pairList.setPair(selectedRow, new Pair(first, second));
                        ((AbstractTableModel) pairTable.getModel()).fireTableDataChanged();
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
                    pairList.removePair(selectedRow);
                    ((AbstractTableModel) pairTable.getModel()).fireTableDataChanged();
                }
            }
        });

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