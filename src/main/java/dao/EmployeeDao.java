package dao;

import pojo.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    void create(String firstName, String lastName, String gender,
                Integer age, Long city_id);

    Employee foundById(int id);

    List<Employee> showAll();

    void updateEmployeeById(Long id,String firstName, String lastName,String gender,
                            Integer age, Long city_id) throws SQLException;

    void deleteEmployeeById(Long id);


}
