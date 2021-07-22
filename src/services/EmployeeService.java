package services;
import bean.Employee;
import repositories.*;
import java.util.*;
public class EmployeeService {
private EmployeeDAO Edao;
public EmployeeService(EmployeeDAO Edao) throws Exception {
this.Edao=Edao;
}

public boolean insertEmployee(Employee employee) throws Exception {
   if(Edao.insertEmployee(employee))
      return false;
   else
      return false;
}
public List<Employee> listAllEmployees() throws Exception {
      List<Employee> emplist=new ArrayList<Employee>();
      emplist=Edao.listAllEmployees();
      return emplist;
}
public List<String> lis(){
	return null;
	
}
public boolean deleteEmployee(int id) throws Exception {
	return Edao.deleteEmployee(id);
}
public boolean updateEmployee(Employee employee) throws Exception {
	return Edao.updateEmployee(employee);
}
}
