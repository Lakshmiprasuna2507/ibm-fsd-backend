package com.java.employeemanagement;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class EmployeeManagement {

	public static void main(String[] args) {

		int empId = 0;
		String empname = null;
		String gender = null;
		int age = 0;
		String designation = null;
		String department = null;
		String country = null;

		int choice = 0;
		boolean menu = false;
		
	
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);

		   EmployeeService employee1 = (EmployeeService) context.getBean("employee");

		   Scanner input = new Scanner(System.in);

		

		while (!menu) {
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
			} catch (InputMismatchException e) {
				System.out.println("please enter only numbers");
				input.nextLine();
				continue;
			}
			switch (choice) {
			case 1:
				try {
					employee1.addEmployee();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					employee1.viewEmployee();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					employee1.updateEmployee();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				employee1.deleteEmployee();
				break;
			case 5:
				employee1.displayEmployeeBasedOnId();
				break;
			case 6:
				employee1.printStatistics();
				break;
			case 7:
				Callable<Boolean> importDetailsThreads = new Callable<Boolean>() {
					public Boolean call() throws Exception {
						System.out.println(Thread.currentThread() + "Waiting for 1s");
						Thread.sleep(1000);
						employee1.importDetails();
						return null;
					}
				};

				ExecutorService executors = Executors.newFixedThreadPool(3);
				@SuppressWarnings("unused")
				Future<Boolean> importfutures = executors.submit(importDetailsThreads);
				System.out.println(Thread.currentThread().getName() + "Import process trigged");
				break;
			case 8:
				Callable<Boolean> exportDetailsThread = new Callable<Boolean>() {
					public Boolean call() throws Exception {
						System.out.println(Thread.currentThread() + "Waiting for 1s");
						Thread.sleep(1000);
						employee1.exportDetails();
						return null;
					}
				};
				ExecutorService executors1 = Executors.newFixedThreadPool(3);
				@SuppressWarnings("unused")
				Future<Boolean> exportfutures = executors1.submit(exportDetailsThread);
				System.out.println(Thread.currentThread().getName() + "Export process trigged");
				break;
			case 9:
				System.exit(0);
			default:
				System.out.println("Enter valid option");
			}
		}
	}

}
