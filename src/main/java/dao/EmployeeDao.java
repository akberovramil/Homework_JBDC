package dao;

import pojo.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    void create(Employee employee);

    Employee foundById(int id);

    List<Employee> showAll();

    void updateEmployeeById(Employee employee) throws SQLException;

    void deleteEmployeeById(Employee employee);


}
