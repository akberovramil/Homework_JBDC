package dao;

import pojo.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    void create(Employee employee);

    Employee foundById(Long id);

    List<Employee> showAll();

    void updateEmployee(Employee employee) throws SQLException;

    void deleteEmployee(Employee employee);


}
