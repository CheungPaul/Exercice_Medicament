package Tools;



import Entities.Consultation;
import Entities.Medicament;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel {
    private String[] colonnes;
    private Object[][] lignes;

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return lignes.length;
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lignes[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        lignes[row][column] = value;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3 ;
    }


    public void loadDatasMedicaments(ArrayList<Medicament> lesMedicaments)
    {
        // A vous de jouer
        colonnes = new String[]{"Numéro", "Nom", "Prix", "Quantité"};
        lignes = new Object[lesMedicaments.size()][4];
        int i = 0;
        for (Medicament medoc : lesMedicaments){
            lignes[i][0] = medoc.getNumero();
            lignes[i][1] = medoc.getNom();
            lignes[i][2] = medoc.getPrix();
            lignes[i][3] = medoc.getQuantite();
            i++;
        }
        fireTableChanged(null);
    }
}
