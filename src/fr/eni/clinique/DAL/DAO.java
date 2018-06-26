package fr.eni.clinique.DAL;

public interface DAO<T> {

    // Insérer
    public void create(T data) throws DALException;

    // Sélectionner
    public T read(int id) throws DALException;

    // Modifier
    public void update(T data) throws DALException;

    // Supprimer
    public void delete(T obj) throws DALException;

}
