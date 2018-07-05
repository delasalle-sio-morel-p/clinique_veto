package fr.eni.clinique.DAL;

import java.util.List;

public interface DAO<T> {

    T selectById(int id) throws DALException;

    List<T> selectAll() throws DALException;

    void insert(T data) throws DALException;

    void update(T data) throws DALException;

    void delete(T obj) throws DALException;


}
