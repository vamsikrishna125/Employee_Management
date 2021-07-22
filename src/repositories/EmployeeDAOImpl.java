package repositories;

import java.util.*;
import java.sql.*;
import bean.Employee;

import bean.*;
public class EmployeeDAOImpl implements EmployeeDAO {
private DataStore ds;
private Connection jdbcConnection;
public EmployeeDAOImpl (DataStore d) throws Exception {
      ds=d;
      jdbcConnection=ds.connect();
}
public  void closeConnection() throws Exception {
     ds. disconnect();
}
public boolean insertEmployee(Employee employee) throws Exception {
      String sql = "INSERT INTO Employee VALUES (?,?,?,?,?)";

      PreparedStatement statement = jdbcConnection.prepareStatement(sql);
      statement.setInt(1, employee.getID());
      statement.setString(2, employee.getName());
      statement.setString(3, employee.getPassword());
      statement.setString(4, employee.getAddress());
      statement.setDouble(5, employee.getSalary());

      boolean rowInserted = statement.executeUpdate() > 0;
      statement.close();        
      return rowInserted;
}

public List<Employee>listAllEmployees() throws Exception {
        List<Employee> listEmployee = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        Statement statement = jdbcConnection.createStatement();
        ResultSet  resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("eid");
            String name = resultSet.getString("ename");
            String password=resultSet.getString("password");
            String address = resultSet.getString("address");
            double salary = resultSet.getDouble("salary");

            Employee employee = new Employee();
            employee.setID(id);
            employee.setName(name);
            employee.setAddress(address);
            employee.setSalary(salary);
            listEmployee.add(employee);
        }

        resultSet.close();
        statement.close();
        return listEmployee;

}

public boolean deleteEmployee(int id) throws Exception{
        String sql = "delete from Employee  where eid=?";
        boolean rowdeleted=false;
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
   try {
        statement.setInt(1, id);
        rowdeleted = statement.executeUpdate() > 0;
    }catch(Exception e) {
	    System.out.println("error ;"+e);
	}
     statement.close();
     return rowdeleted;
}

public boolean updateEmployee(Employee employee)throws Exception {
	  String sql = "update Employee set ename=?, password=?, address=?, salary=? where eid=?";
      PreparedStatement statement = jdbcConnection.prepareStatement(sql);
      statement.setInt(5, employee.getID());
      statement.setString(1, employee.getName());
      statement.setString(2, employee.getPassword());
      statement.setString(3, employee.getAddress());
      statement.setDouble(4, employee.getSalary());    
      boolean rowupdated = statement.executeUpdate() > 0;    
      statement.close();
      return rowupdated;	
	
}

public Employee getEmployee(int id)throws Exception {
	String sql = "SELECT * FROM Employee where eid=?";
    PreparedStatement ps = jdbcConnection.prepareStatement(sql);
    ps.setInt(1, id);   
    Employee employee=new Employee();
    ResultSet resultSet = ps.executeQuery();  
    while(resultSet.next()) {	
         int eid=resultSet.getInt(1);
         String name=resultSet.getString(2);
	     String password=resultSet.getString(3);
	     String address=resultSet.getString(4);
	     double salary=resultSet.getDouble(5);
         employee=new Employee(eid,name,password,address,salary);
    }
   return employee;
  }
}
