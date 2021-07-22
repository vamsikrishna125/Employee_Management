package controller;
import repositories.*;
import bean.Employee;
import services.*;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataStore ds;
	private EmployeeDAO edao;
	private EmployeeService es;

public ControllerServlet() {
super();

    }
public void init()  {
	try {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

ds = new DataStore(jdbcURL, jdbcUsername, jdbcPassword);

edao=new EmployeeDAOImpl(ds);
es=new EmployeeService(edao);
	}catch(Exception e) {}

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
switch (action) {
case "/new":showNewForm(request, response);
            break;
case "/insert":insertEmployee(request, response);
            break;
case "/delete":deleteEmployee(request, response);
            break;
case "/edit":showEditForm(request, response);
            break;
case "/update":updateEmployee(request, response);
            break;
case "/list":listEmployee(request,response);
            break;
default:
     listEmployee(request, response);
     break;
         }
        } catch(Exception ex) {
           throw new ServletException(ex);
        }

	}
	
	
	
private void listEmployee(HttpServletRequest request, HttpServletResponse response)throws Exception {
       List<Employee>listEmployee = es.listAllEmployees();
       request.setAttribute("listEmp", listEmployee);
       RequestDispatcher dispatcher = request.getRequestDispatcher("Emplist.jsp");
       dispatcher.forward(request, response);
    }
private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
       RequestDispatcher dispatcher = request.getRequestDispatcher("Empform.jsp");
       dispatcher.forward(request, response);
    }
private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee newEmpl= new Employee(id,name,password,address,salary);
        es.insertEmployee(newEmpl);
        response.sendRedirect("list");
    }

private void showEditForm(HttpServletRequest request, HttpServletResponse response)throws Exception {
	    int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = edao.getEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Empform.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
	
	
    }

private void updateEmployee(HttpServletRequest request, HttpServletResponse response)throws Exception {
	     int id = Integer.parseInt(request.getParameter("id"));
	     String name = request.getParameter("name");
         String password = request.getParameter("password");
         String address = request.getParameter("address");
         double salary = Double.parseDouble(request.getParameter("salary"));

         Employee employee = new Employee(id, name, password,address, salary);
         es.updateEmployee(employee);

         response.sendRedirect("list");
	
	
    }

private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	int id = Integer.parseInt(request.getParameter("id"));
    es.deleteEmployee(id);
    response.sendRedirect("list");	
   
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
