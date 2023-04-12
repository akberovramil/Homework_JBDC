import dao.CityDao;
import dao.CityDaoImpl;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exceptions.EmptyListException;
import exceptions.NotFoundObjectException;
import pojo.City;
import pojo.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

public class Application {

    private static CityDao cityDao = new CityDaoImpl();
    private static  EmployeeDao employeeDao = new EmployeeDaoImpl();

    static void createCity(City city) throws SQLException {
        cityDao.addCity(city);
    }

    static Object findCityById(Long id) throws SQLException {
        try {
            return cityDao.foundCityById(id);
        } catch (NotFoundObjectException e) {
            return e.getMessage();
        }
    }

    static void updateCity(City city) throws SQLException {
        cityDao.updateCity(city);
    }

    static void deleteCity(City city) throws SQLException {
        cityDao.deleteCity(city);
    }

    static void createNewEmployee(Employee employee) {
        employeeDao.create(employee);
    }

    static Object findById(Long id) {
        try {
            return employeeDao.foundById(id);
        } catch (NotFoundObjectException e) {
            return e.getMessage();
        }


    }

    static void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    static void showEmployees() {
        try {
            for (Employee employee : employeeDao.showAll()) {
                System.out.println(employee);
            }
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws SQLException {

        City city = new City("Orenburg");
        cityDao.addCity(city);

        Employee petr = new Employee("Petr", "Pechkin", "men", 28, city);
        employeeDao.create(petr);

        Employee oleg= new Employee("Oleg", "Palkin", "men", 25, city);
        employeeDao.create(oleg);
    }
}

