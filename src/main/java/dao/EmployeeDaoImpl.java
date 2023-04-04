package dao;
import connection.Connection;
import pojo.Employee;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;



public class EmployeeDaoImpl implements EmployeeDao {


    Connection connection = new Connection();
    CityDaoImpl cityDao = new CityDaoImpl();


    @Override
    public void create(String firstName, String lastName, String gender,
                       Integer age, Long city_id) {

        try (PreparedStatement statement = connection.getConnection().prepareStatement(
                "INSERT INTO employee(first_name,last_name,gender,age,city_id) VALUES ((?), (?), (?), (?), (?))")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, gender);
            statement.setInt(4, age);
            statement.setLong(5, city_id);

            statement.executeQuery();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Employee foundById(int id) {
           try (PreparedStatement statement = connection.getConnection().prepareStatement(

                "SELECT * FROM employee WHERE id=(?)")) {
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();
            resultSet.next();
            return new Employee(resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("gender"),
                    resultSet.getInt("age"),
                    cityDao.foundCityById(resultSet.getLong("city_id")));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Employee> showAll() {
        try (PreparedStatement statement = connection.getConnection().prepareStatement(
                "SELECT * FROM employee")) {
            List<Employee> employees = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employees.add(new Employee(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("gender"),
                        resultSet.getInt("age"),
                        cityDao.foundCityById(resultSet.getLong("city_id"))));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployeeById(Long id, String firstName, String lastName, String gender,
                                   Integer age, Long city_id) throws SQLException {
        try (PreparedStatement statement =
                     connection.getConnection().prepareStatement("update employee set first_name = ?, last_name = ?,gender = ?, age = ?, city_id =? where id =(?)")) {
            statement.setLong(1, id);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, gender);
            statement.setInt(5, age);
            statement.setLong(6, city_id);
            statement.executeUpdate();
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {
        try (PreparedStatement preparedStatement = connection.getConnection().prepareStatement
                ("delete from employee where id=(?)")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
