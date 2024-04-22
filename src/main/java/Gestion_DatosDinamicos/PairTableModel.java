package Gestion_DatosDinamicos;

import javax.swing.table.AbstractTableModel;

public class PairTableModel extends AbstractTableModel {
    private final PairList pairList;
    private final String[] columnNames = {"First", "Second"};

    public PairTableModel(PairList pairList) {
        this.pairList = pairList;
    }

    @Override
    public int getRowCount() {
        return pairList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pair pair = pairList.getPair(rowIndex);
        return (columnIndex == 0) ? pair.getFirst() : pair.getSecond();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
