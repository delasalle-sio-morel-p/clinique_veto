package fr.eni.clinique.DAL;

import fr.eni.clinique.BO.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ClientDAO extends DAO<Client>{
    List<Client> selectByMotCle(String nomClient) throws DALException;

    Client clientBuilder(ResultSet rs, Boolean avecAnimaux) throws SQLException;
}


