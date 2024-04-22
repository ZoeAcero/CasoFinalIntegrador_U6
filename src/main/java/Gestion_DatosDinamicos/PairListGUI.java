package Gestion_DatosDinamicos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PairListGUI extends JFrame{
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
        pairTable = new JTable(); // This will need a custom table model

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int first = Integer.parseInt(firstField.getText());
                    int second = Integer.parseInt(secondField.getText());
                    pairList.addPair(new Pair(first, second));
                    updateTable();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter two integers.", "Error", JOptionPane.ERROR_MESSAGE);
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

    private void updateTable() {

    }
    //main
    public static void main(String[] args) {
        PairListGUI pairListGUI = new PairListGUI();
        pairListGUI.setVisible(true);
    }
}
