package org.example;

import org.example.Service_Impl.AddressService;
import org.example.Service_Impl.EmployeeService;
import org.example.Service_Impl.ProjectService;
import org.example.SessionUtil.HibernateMyUtil;
import org.example.entity.Address;
import org.example.entity.Employee;
import org.example.entity.Project;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class HibernateMain {
    public static void main(String[] args) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("EG");
        address.setCity("London");
        address.setStreet("Baker Street");
        address.setPostCode("221B");

        Project project = new Project();
        project.setTitle("Yerevan City Good Programmer");

        Employee employee = new Employee();
        employee.setFirstName("Sherlock");
        employee.setLastName("Holmes");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1983, Calendar.APRIL, 19);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projects = new HashSet<>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        HibernateMyUtil.shutdown();
    }
}
