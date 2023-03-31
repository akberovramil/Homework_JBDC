package dao;

import pojo.City;

import java.sql.SQLException;

public interface CityDao {

    City foundCityById(Long id) throws SQLException;

    void addCity(String name) throws SQLException;

    void updateCityById(Long id, String name) throws SQLException;

    void deleteCityById(Long id) throws SQLException;
}
