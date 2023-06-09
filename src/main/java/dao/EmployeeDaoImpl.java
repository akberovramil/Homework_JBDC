package dao;
import connection.Connection;
import connection.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Employee;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;



public class EmployeeDaoImpl implements EmployeeDao {


    Connection connection = new Connection();
    CityDaoImpl cityDao = new CityDaoImpl();


    @Override
    public void create(Employee employee) {
        Long id;

        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            id = (Long) session.save(employee);
            transaction.commit();

        }



    }

    @Override
    public Employee foundById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.get(Employee.class, id);
        }



    }

    @Override
    public List<Employee> showAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Employee").list();
        }


    }

    @Override
    public void updateEmployeeById(Employee employee) throws SQLException {

        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployeeById(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }
}
