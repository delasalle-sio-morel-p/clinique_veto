package fr.eni.clinique.IHM.GestionClient;

import fr.eni.clinique.BO.Animal;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableAnimalModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    String[] entetes = {"NomAnimal", "Sexe", "Couleur", "Race", "Espece", "CodeClient", "Tatouage", "Antecedents"};
    private List<Animal> listeAnimaux;

    public TableAnimalModel(List<Animal> listeAnimaux) {
        this.listeAnimaux = listeAnimaux;
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
        return listeAnimaux.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                // Nom
                return listeAnimaux.get(rowIndex).getNomAnimal();

            case 1:
                // Prenom
                return listeAnimaux.get(rowIndex).getSexe();

            case 2:
                // Couleur
                return listeAnimaux.get(rowIndex).getCouleur();

            case 3:
                // Race
                return listeAnimaux.get(rowIndex).getRace();

            case 4:
                // Espece
                return listeAnimaux.get(rowIndex).getEspece();

            case 5:
                // CodeClient
                return listeAnimaux.get(rowIndex).getCodeClient();

            case 6:
                // Tatouage
                return listeAnimaux.get(rowIndex).getTatouage();

            case 7:
                // Antecedents
                return listeAnimaux.get(rowIndex).getAntecedents();

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
                return Integer.class;

            case 6:
                return String.class;

            case 7:
                return String.class;

            default:
                return Object.class;
        }
    }

}
