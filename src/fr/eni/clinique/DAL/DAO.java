package fr.eni.clinique.DAL;

import java.util.List;

public interface DAO<T> {

    public T selectById(int id) throws DALException;

    public List<T> selectAll() throws DALException;

    public void insert(T data) throws DALException;

    public void update(T data) throws DALException;

    public void delete(T obj) throws DALException;


}
