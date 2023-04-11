package dao;

import connection.Connection;
import connection.HibernateSessionFactoryUtil;
import exceptions.NotFoundObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CityDaoImpl implements CityDao {
    Connection connection = new Connection();

    @Override
    public City foundCityById(Long id) throws SQLException {
        City city =  HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, id);
        if (city == null) {
            throw new NotFoundObjectException("Данного города нет в базе данных");
        } else {
            return city;
        }

    }

    @Override
    public void addCity(City city) throws SQLException {
       Long id;

       try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
           Transaction transaction = session.beginTransaction();
           session.save(city);
           transaction.commit();
       }
    }

    @Override
    public void updateCity(City city) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) throws SQLException {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
        }

    }
}
