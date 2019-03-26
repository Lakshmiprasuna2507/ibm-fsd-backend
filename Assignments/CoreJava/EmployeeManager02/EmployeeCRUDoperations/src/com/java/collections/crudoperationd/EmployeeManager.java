package com.java.collections.validations;

import java.util.InputMismatchException;
import java.util.Scanner;


//import com.examples.java.io.EmployeeDetails;

public class EmployeeManager {

	public static void main(String[] args) {
		
		int empId = 0;
		String empname = null;
		String gender = null;
		int age = 0;
		String designation = null;
		String department = null;
		double salary =0.0;
		String country = null;
		
		EmployeeDetails employee=new EmployeeDetails(empId,empname,gender,age,designation,department,salary,country);
         int choice = 0;
         boolean menu = false;
         Scanner input = new Scanner(System.in);
         
         while(!menu) {
        	 System.out.println("-------Menu------");
        	 System.out.println("1.Add Employee details");
        	 System.out.println("2.View Employee details");
        	 System.out.println("3. Update Employee details");
        	 System.out.println("4.Delete Employee details");
        	 System.out.println("5.Display Employee details based on id");
        	 System.out.println("6.print statistics");
             System.out.println("7.Import"); 
        	 System.out.println("8.Export");
        	 System.out.println("9.Exit");
        	 System.out.println("Enter the choice");
        	 boolean flag = false;
        	 try {
        		 choice = input.nextInt();
        	 }catch(InputMismatchException e) {
        		 System.out.println("please enter only numbers");
        		 input.nextLine();
        		 continue;
        	 }
        	 switch(choice) {
        	 case 1:
        		 try {
        			 employee.addEmployee();
        			 
        		 }catch(Exception e) {
        			 System.out.println(e.getMessage());
        		 }
        		 break;
        	 case 2:
        		 try {
        			  employee.viewEmployee();
        		 }catch(Exception e) {
        			 System.out.println(e.getMessage());
        		 }
        		 break;
        	 case 3:
        		 try {
        			 employee.updateEmployee();
        		 }catch(Exception e) {
        			 System.out.println(e.getMessage());
        		 }
        		 break;
        	 case 4:
        		 employee.deleteEmployee();
        		 break;
        	 case 5:
        		 employee.displayEmployeeBasedOnId();
        		 break;
        	 case 6:
        		 employee.printStatistics();
        		 break;
        	
        	 case 7:
        		 System.exit(0);
        	 default:
        		 System.out.println("Enter valid option");
        			 }
        	 }
        	 }
         

	}






