package dao;

import pojo.City;

import java.sql.SQLException;

public interface CityDao {

    City foundCityById(Long id) throws SQLException;

    void addCity(City city) throws SQLException;

    void updateCity(City city) throws SQLException;

    void deleteCity(City city) throws SQLException;
}
