package ml;

import java.util.ArrayList;

public class NewClass{

     public static void main(String[] args) {

          ArrayList<Employee> list = new ArrayList<Employee>();
          Employee emp1 = new Hourly("Hourly Emp", "123 E Center", "555-555-5555", 00001, "123-45-6789", 12.75);
          Employee emp2 = new Salary("Salary Emp", "123 E Center", "555-555-5555", 00001, "123-45-6789");

          list.add(emp1);
          list.add(emp2);

          for(Employee e : list){
              if(e instanceof Hourly)
              {
                  System.out.println("Wage: " + ((Hourly)e).calcPay(20.2));
              }
              if(e instanceof Salary)
              {
                  System.out.println("Wage: " + ((Salary)e).gethours(12));
              }              
           }
    }
}
    abstract class Employee {

        private String name, address, phone, ssn;
        private int empNo;

        Employee(String name, String address, String phone, int empNo, String ssn)
        {
            this.name = name;
            this.address = address;
            this.phone = phone;
            this.empNo = empNo;
            this.ssn = ssn;
        }
    }


    class Hourly extends Employee{

        private double wage;

        Hourly(String name, String address, String phone, int empNo, String ssn, double wage) 
        {
            super(name, address, phone, empNo, ssn);        
                    this.wage = wage;
        }

        public double calcPay(double hours)
        {
                return wage * hours;
        }
   }

    class Salary extends Employee{


        Salary(String name, String address, String phone, int empNo, String ssn) 
        {
            super(name, address, phone, empNo, ssn);        
        }
        
        public double gethours(double hours)
        {
                return hours;
        }

   }