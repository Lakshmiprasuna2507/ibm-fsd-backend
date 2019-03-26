package com.java.collections.crudoperationd;



	import java.util.Comparator;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.TreeSet;
	//import java.util.TreeSet;

	public class EmployeeSet {

		private int empId;
		private String employeeName;
		private String gender;
		private int age;
		private String designation;
		private String department;
		private double salary;

		public EmployeeSet(int empId, String employeeName, String gender, int age, String designation, String department,
				double salary) {
			super();
			this.empId = empId;
			this.employeeName = employeeName;
			this.gender = gender;
			this.age = age;
			this.designation = designation;
			this.department = department;
			this.salary = salary;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
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

		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Comparator EMPLOYEE_SORT_BY_AGE = new Comparator() {
				
				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					if (o1 instanceof EmployeeSet && o2 instanceof EmployeeSet) {
						return ((EmployeeSet) o2).getAge() - ((EmployeeSet) o1).getAge();
					}
					return 0;
				}
			};
			EmployeeSet employee = new EmployeeSet(10, "lakshmi", "female", 23, "java developer", "Technical", 450000);
			EmployeeSet employee1 = new EmployeeSet(20, "mohan", "male", 25, "java developer", "IT", 550000);
			EmployeeSet employee2 = new EmployeeSet(30, "prasuna", "female", 21, "oracle developer", "Technical", 350000);

			TreeSet employeeData = new TreeSet(EMPLOYEE_SORT_BY_AGE);
			employeeData.add(employee);
			employeeData.add(employee1);
			employeeData.add(employee2);
			Iterator itr = employeeData.iterator();
			while (itr.hasNext()) {
				Object emps = itr.next();
				System.out.println(emps);
			}
			
			System.out.println("**********Employee After updation*************");
			employee.setEmployeeName("lakshmi prasuna");
			employee1.setEmployeeName("mohan krishna");
			Iterator itr2 = employeeData.iterator();
			while (itr2.hasNext()) {
				Object emps = itr2.next();
				System.out.println(emps);
			}

			
			System.out.println("**********Employee After Deletion*************");
			employeeData.remove(employee2);
			Iterator itr1 = employeeData.iterator();
			while (itr1.hasNext()) {
				Object emps = itr1.next();
				System.out.println(emps);
			}

		}

		
}
