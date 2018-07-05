package fr.eni.clinique.IHM.GestionClient;

import fr.eni.clinique.BO.Client;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableClientModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    String[] entetes = {"Nom", "Prenom", "Adresse1", "Adresse2", "CodePostal", "Ville", "N°Téléphone", "Assurance","Email"};
    private List<Client> listeClients;

    public TableClientModel(List<Client> listeClients) {
        this.listeClients = listeClients;
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
        return listeClients.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                // Nom
                return listeClients.get(rowIndex).getNomClient();

            case 1:
                // Prenom
                return listeClients.get(rowIndex).getPrenomClient();

            case 2:
                // Role
                return listeClients.get(rowIndex).getAdresse1();

            case 3:
                // Mot de passe
                return listeClients.get(rowIndex).getAdresse2();

            case 4:
                // Mot de passe
                return listeClients.get(rowIndex).getCodePostal();

            case 5:
                // Mot de passe
                return listeClients.get(rowIndex).getVille();

            case 6:
                // Mot de passe
                return listeClients.get(rowIndex).getNumTel();

            case 7:
                // Mot de passe
                return listeClients.get(rowIndex).getAssurance();

            case 8:
                // Mot de passe
                return listeClients.get(rowIndex).getEmail();

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

            case 4:
                return String.class;

            case 5:
                return String.class;

            case 6:
                return String.class;

            case 7:
                return String.class;

            case 8:
                return String.class;

            default:
                return Object.class;
        }
    }

}

