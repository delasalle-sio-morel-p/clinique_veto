package fr.eni.clinique.IHM.GestionPersonnel;

import fr.eni.clinique.BO.Personnel;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TablePersonnelModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    String[] entetes = {"Nom", "Prenom", "Role", "Password"};
    private List<Personnel> listePersonnels;

    public TablePersonnelModel(List<Personnel> listePersonnels) {
        this.listePersonnels = listePersonnels;
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }

    @Override
    public int getRowCount() {
        return listePersonnels.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                // Nom
                return listePersonnels.get(rowIndex).getNom();

            case 1:
                // Prenom
                return listePersonnels.get(rowIndex).getPrenom();

            case 2:
                // Role
                return listePersonnels.get(rowIndex).getRole();

            case 3:
                // Mot de passe
                return listePersonnels.get(rowIndex).getMotPasse();

            default:
                throw new IllegalArgumentException();
        }
    }
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;

            case 1:
                return String.class;

            case 2:
                return String.class;

            case 3:
                return String.class;

            default:
                return Object.class;
        }
    }

}
