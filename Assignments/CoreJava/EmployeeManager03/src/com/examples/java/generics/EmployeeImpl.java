package com.examples.java.generics;


	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.List;
	import java.util.Scanner;
	import java.util.TreeMap;
	import java.util.concurrent.atomic.AtomicInteger;

	public class EmployeeImpl<T> implements Employee {

		Scanner input = new Scanner(System.in);
		private static AtomicInteger idGenerator = new AtomicInteger(100);
		private final int employeeId;
		private String employeeName;
		private String employeeAge;
		private String gender;
		private String designation;
		private String department;
		private T salary;

		public EmployeeImpl(int employeeId, String employeeName, String employeeAge, String gender, String designation,
				String department, T salary) {

			this.employeeId = idGenerator.getAndIncrement();
			this.employeeName = employeeName;
			this.employeeAge = employeeAge;
			this.gender = gender;
			this.designation = designation;
			this.department = department;
			this.salary = salary;

		}

		public int getEmployeeId() {
			return employeeId;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getEmployeeAge() {
			return employeeAge;
		}

		public void setEmployeeAge(String employeeAge) {
			this.employeeAge = employeeAge;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public T getSalary() {
			return salary;
		}

		public void setSalary(T salary) {
			this.salary = salary;
		}

		Comparator<EmployeeImpl<T>> EMPLOYEE_SORT_BY_NAME = new Comparator<EmployeeImpl<T>>() {

			@Override
			public int compare(EmployeeImpl<T> o1, EmployeeImpl<T> o2) {
				// TODO Auto-generated method stub
				if (o1 instanceof EmployeeImpl && o2 instanceof EmployeeImpl) {
					return ((EmployeeImpl<T>) o1).getEmployeeName().compareTo(((EmployeeImpl<T>) o2).getEmployeeName());
				}
				return 0;
			}
		};
		Comparator<EmployeeImpl<T>> EMPLOYEE_SORT_BY_AGE = new Comparator<EmployeeImpl<T>>() {

			@Override
			public int compare(EmployeeImpl<T> o1, EmployeeImpl<T> o2) {
				// TODO Auto-generated method stub
				if (o1 instanceof EmployeeImpl && o2 instanceof EmployeeImpl) {
					return ((EmployeeImpl<T>) o1).getEmployeeAge().compareTo(((EmployeeImpl<T>) o2).getEmployeeAge());
				}
				return 0;
			}
		};
		TreeMap<Integer, EmployeeImpl<T>> employeeData = new TreeMap<Integer, EmployeeImpl<T>>();

		EmployeeImpl<T> employee;

		@SuppressWarnings("unchecked")
		@Override
		public void addEmployeeData() {

			System.out.print("Enter Employee Name:");
			employeeName = input.next();

			boolean flag = false;
			String name = "[a-zA-Z ]+";
			while (!flag) {
				if ((employeeName.matches(name))) {

					flag = true;

				} else {
					System.out.println("enter only alphabets");
					employeeName = input.next();
				}
			}

			System.out.print("Enter Employee Age:");
			employeeAge = input.next();
			boolean isAge = false;
			String ageValidation = "[0-9]+";

			while (!isAge) {
				if (employeeAge.matches(ageValidation)) {
					int agevalue = Integer.parseInt(employeeAge);
					if (agevalue < 20 || agevalue > 80) {
						System.out.println("Enter valid age between 20 and 80");
						employeeAge = input.next();
					} else {
						isAge = true;
					}

				} else {
					System.out.println("enter only numbers");
					employeeAge = input.next();

				}
			}

			System.out.print("Enter Gender:");
			gender = input.next();
			String match = "[a-zA-Z]+";
			boolean isGender = false;
			while (!isGender) {

				if (gender.matches(match)) {
					isGender = true;

				} else {

					System.out.println("Enter either male or female");
					gender = input.next();

				}
			}
			System.out.print("Enter Employee Designation:");
			designation = input.next();
			System.out.print("Enter Employee Department:");
			department = input.next();
			System.out.print("Enter salary:");
			salary = (T) input.next();
			String sal = "[0-9.]+";
			boolean isSal = false;
			while (!isSal) {
				if (salary.toString().matches(sal)) {
					isSal = true;
				} else {
					System.out.println("Enter only numbers");
					salary = (T) input.next();

				}
			}
			employee = new EmployeeImpl<T>(employeeId, employeeName, employeeAge, gender, designation, department, salary);

			employeeData.put(employee.getEmployeeId(), employee);
			System.out.println("Data inserted succesfully");

		}

		@Override
		public void listEmployeeData() {
			List<EmployeeImpl<T>> employeeSorted = new ArrayList<EmployeeImpl<T>>(employeeData.values());
			Collections.sort(employeeSorted, EMPLOYEE_SORT_BY_AGE);

			if (!employeeSorted.isEmpty()) {
				System.out.format("EmployeeId    EmployeeName    Age    gender    Designation    Department    Salary \n");
				System.out.println(
						"----------------------------------------------------------------------------------------------------");
				for (EmployeeImpl<T> emps : employeeSorted) {

					System.out.format("%6d\t%15s\t%6s%15s\t%15s\t%15s\t%15s \n", emps.employeeId, emps.employeeName,
							emps.employeeAge, emps.gender, emps.designation, emps.department, emps.salary);

				}

			} else {
				System.out.println("No data to display");
			}

		}

		@Override
		public void displayEmployeeBasedOnId() {
			int id;
			System.out.print("Enter the id to display data:");
			id = input.nextInt();
			boolean flag = false;
			if (!employeeData.isEmpty()) {

				for (EmployeeImpl<T> emps : employeeData.values()) {
					while (!flag) {
						if (emps.employeeId == id) {
							System.out.format(
									"EmployeeId    EmployeeName    Age    gender    Designation    Department    Salary \n");
							System.out.println(
									"----------------------------------------------------------------------------------------------------");

							System.out.format("%6d\t%15s\t%6s%15s\t%15s\t%15s\t%15s \n", id, emps.employeeName,
									emps.employeeAge, emps.gender, emps.designation, emps.department, emps.salary);

							flag = true;
						} else {
							System.out.println("Entered key doesnt exist please enter valid value");
							id = input.nextInt();
						}

					}
				}
			} else {
				System.out.println("No data to display");
			}

		}

		@Override
		public void updateEmployeeData() {
			int value;
			boolean flag = false;
			System.out.print("Enter the key to update data:");
			value = input.nextInt();
			while (!flag) {
				if (employeeData.containsKey(value)) {
					System.out.print("Enter Employee Name:");
					employeeName = input.next();
					boolean flag1 = false;
					String name = "[a-zA-Z ]+";
					while (!flag1) {
						if ((employeeName.matches(name))) {

							flag1 = true;

						} else {
							System.out.println("enter only alphabets");
							employeeName = input.next();
						}
					}
					System.out.print("Enter Employee Age:");
					employeeAge = input.next();
					boolean isAge = false;
					String ageValidation = "[0-9]+";

					while (!isAge) {
						if (employeeAge.matches(ageValidation)) {
							int agevalue = Integer.parseInt(employeeAge);
							if (agevalue < 20 || agevalue > 80) {
								System.out.println("Enter valid age between 20 and 80");
								employeeAge = input.next();
							} else {
								isAge = true;
							}

						} else {
							System.out.println("enter only numbers");
							employeeAge = input.next();

						}
					}
					System.out.print("Enter Employee Designation:");
					designation = input.next();
					System.out.print("Enter Employee Department:");
					department = input.next();
					System.out.print("Enter salary:");
					salary = (T) input.next();
					String sal = "[0-9.]+";
					boolean isSal = false;
					while (!isSal) {
						if (salary.toString().matches(sal)) {
							isSal = true;
						} else {
							System.out.println("Enter only numbers");
							salary = (T) input.next();

						}
					}
					employeeData.get(value).setEmployeeName(employeeName);
					employeeData.get(value).setEmployeeAge(employeeAge);
					employeeData.get(value).setDesignation(designation);
					employeeData.get(value).setDepartment(department);
					employeeData.get(value).setSalary(salary);

					System.out.println("Data Updated succesfully");
					flag = true;

				}

				else {
					System.out.println("No available key to update enter valid key");
					value = input.nextInt();

				}
			}

		}

		@Override
		public void deleteEmployeeData() {
			int value;
			boolean flag = false;
			System.out.print("Enter the key to delete:");
			value = input.nextInt();
			while (!flag) {
				if (employeeData.containsKey(value)) {
					employeeData.remove(value);
					flag = true;
					System.out.println("Deleted Succesfully");
				} else {
					System.out.println("Entered value doesnt exist to delete enter valid value");
					value = input.nextInt();

				}
			}
		}

		@Override
		public void printStatistics() {
			int count1 = 0;
			int count2 = 0;
			int countValue = employeeData.size();
			int salaries;
			int salaryValue = 0;
			for (EmployeeImpl<T> emps : employeeData.values()) {
				String age = emps.employeeAge.toString();
				int aged = Integer.parseInt(age);
				if (aged >= 30) {
					count1++;
					} else if (aged >= 20) {
					count2++;
				}
			}
			System.out.println("Total " + count2 + " employees are of age greaterthan 20");
			System.out.println("Total " + count1 + " employees are of age greaterthan 30");
			for (EmployeeImpl<T> emps : employeeData.values()) {

				String sal = emps.salary.toString();
				salaries = Integer.parseInt(sal);

				salaryValue += salaries;
			}
			int averageSalary = (salaryValue) / (countValue);
			System.out.println("Average Salary of " + countValue + " employees " + averageSalary);

		}

	}


