package repositories;

import java.util.*;

import bean.Employee;

public interface EmployeeDAO {
public boolean insertEmployee(Employee employee) throws Exception;
public List<Employee> listAllEmployees() throws Exception;
public boolean deleteEmployee(int id)throws Exception;
public boolean updateEmployee(Employee employee)throws Exception;
public Employee getEmployee(int id)throws Exception;
}

