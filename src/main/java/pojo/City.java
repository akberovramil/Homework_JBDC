package pojo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name")
    private String city_name;

    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public City(String city_name) {
        this.city_name = city_name;
    }

    public City(Long id, String city_name) {
        this.id = id;
        this.city_name = city_name;
    }

    public City(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_name='" + city_name + '\'' +
                '}';
    }
}
