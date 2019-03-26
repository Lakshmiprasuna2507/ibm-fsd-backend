package com.examples.java.generics;

    import java.util.InputMismatchException;
	import java.util.Scanner;

	public class EmployeeManagement {

		public static <T> void main(String[] args) {
			// TODO Auto-generated method stub
			int id = 0;
			String employeeName = null;
			String employeeAge = null;
			String gender = null;
			String designation = null;
			String department = null;
			T salary = null;

			EmployeeImpl<T> employee = new EmployeeImpl<T>(id, employeeName, employeeAge, gender, designation, department,
					salary);
			int choice = 0;
			boolean menu = false;
			Scanner input = new Scanner(System.in);

			while (!menu) {
				System.out.println("*******Menu*******");
				System.out.println("1. Add Employee Data");
				System.out.println("2. List Employee Data");
				System.out.println("3. Update Employee Data");
				System.out.println("4. Delete Employee Data");
				System.out.println("5. Display Employee Based On Id");
				System.out.println("6. Print Statistics");
				System.out.println("7. Exit");
				System.out.println("Enter the choice");

				try {

					choice = input.nextInt();

				} catch (InputMismatchException e) {
					System.out.println("Please enter only numbers");

					input.nextLine();

					continue;

				}

				switch (choice) {
				case 1:
					try {

						employee.addEmployeeData();
					} catch (Exception e) {

					}

					break;
				case 2:
					try {
						employee.listEmployeeData();
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						employee.updateEmployeeData();
					} catch (Exception e) {
						System.out.println("please enter the integer value for key");
					}

					break;
				case 4:
					try {
						employee.deleteEmployeeData();
					} catch (Exception e) {
						System.out.println("please enter the integer value for key");
					}
					break;
				case 5:
					try {
						employee.displayEmployeeBasedOnId();
					} catch (Exception e) {
						System.out.println("please enter the integer value for key");
					}

					break;
				case 6:
					employee.printStatistics();
					break;
				case 7:
					menu = true;
					System.out.println("Stopped Execution");
					break;
				default:
					System.out.println("Enter options given in  the menu");

				}
			}
			input.close();
		}

	}


