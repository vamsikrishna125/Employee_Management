package bean;

public class Employee {
   private int id;
   private String name;
   private String password;
   private String address;
   private double salary;
public Employee ()
{ }

public Employee (int id, String name, String password,String  address, double salary) {

this.id = id;
this.name=name;
this.password=password;
this.address=address;
this.salary=salary;
    }


public int getID() {
return id;
    }

public void setID(int id) {
this.id = id;
    }

public String getName() {
return name;
    }

public void setName(String name) {
this.name = name;
    }


public void setPassword(String password) {
this.password = password;
    }
public String getPassword() {
return password;
    }


public String getAddress() {
return address;
    }

public void setAddress(String address) {
this.address=address;
    }

public double getSalary() {
return salary;
    }

public void setSalary(double salary) {
this.salary=salary;
    }
}
