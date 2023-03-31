package dao;

import connection.Connection;
import pojo.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDaoImpl implements CityDao {
    Connection connection = new Connection();

    @Override
    public Long foundCityById(Long id) throws SQLException {

        try (PreparedStatement preparedStatement =
                     connection.getConnection().prepareStatement
                             ("SELECT * FROM city WHERE id = (?)")) {

            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return new City(resultSet.getString("name"));
        }
    }

    @Override
    public void addCity(String name) throws SQLException {
        try (PreparedStatement preparedStatement =
                     connection.getConnection().prepareStatement
                             ("INSERT INTO  city (name) values (?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void updateCityById(Long id, String name) throws SQLException {
        try (PreparedStatement preparedStatement =
                     connection.getConnection().prepareStatement
                             ("UPDATE city SET name=? WHERE id=(?)")) {
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
        }



    }

    @Override
    public void deleteCityById(Long id) throws SQLException {
        try (PreparedStatement preparedStatement =
             connection.getConnection().prepareStatement
                             ("DELETE FROM city WHERE id =(?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }

    }
}
