package com.examples.java.hibernet.core;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.examples.java.hibernet.model.Employee;

public class EmployeeManager {
	private static SessionFactory sessionFactory;
	public static void main(String[] args)  {
		
		//step:1 Create Configuration
		Configuration config= new Configuration();
		config.configure();
		//step:2 Create SessionFactory
		sessionFactory=config.buildSessionFactory();
		System.out.println( "Connected to databased-" +sessionFactory);
		//step:3 Create Session
		//Session session = sessionFactory.openSession();
		//Transaction t= session.beginTransaction();
		
		//Insert data into table by suppling the persistent data
		Employee emp= new Employee();
		emp.setName("Lakshmi");
		emp.setAge(22);
		emp.setGender("female");
		emp. setDesignation("TS");
		emp.setDepartment("IT");
		emp.setCountry("India");
		
	//	session.save(emp);
		//step:4 Transaction Management
		//t.commit();
		//System.out.println("Inserted Successfully");
		//STEP:5 perform database operations using query/criteria API

		listEmployees();
		
		Integer empId1 = createEmployee(emp);
		
		listEmployees();
		
		updateEmployee(empId1, "Admin", "Software Engineer");
		
		listEmployees();
		
		deleteEmployee(empId1);
		
		listEmployees();
		
		}
	// CREATE EMPLOYEE
		private static Integer createEmployee(Employee employee) {

			Transaction t = null;
			Integer id = -1;

			try (Session session = sessionFactory.openSession()) {
				t = session.beginTransaction();

				// Insert data into table by supplying the persistent object
				id = (Integer) session.save(employee);
				
				System.out.println("\nEmployee inserted successfully with ID - " + id);
				
				t.commit();
			} catch (HibernateException he) {
				t.rollback();
				he.printStackTrace();
			}

			return id;
		}

		// LIST EMPLOYEE DETAILS
		private static void listEmployees() {
			Transaction t = null;

			try (Session session = sessionFactory.openSession()) {
				t = session.beginTransaction();

				// List Employee Details
				List<Employee> employees = session.createQuery("FROM E mployee").list();

				System.out.println("ID \tName \tAge \tGender \tDepartment \tDesignation");
				for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext();) {
					Employee employee = (Employee) iterator.next();

					System.out.println(employee.getId() + "\t" + employee.getName() + "\t" + employee.getAge() + "\t"
							+ employee.getGender() + "\t" + employee.getDepartment() + "\t" + employee.getDesignation());
				}

				t.commit();

			} catch (HibernateException he) {
				t.rollback();
				he.printStackTrace();
			}
		}

		// UPDATE EMPLOYEE DETAILS
		private static void updateEmployee(Integer empId, String dept, String designation) {
			Transaction t = null;

			try (Session session = sessionFactory.openSession()) {
				t = session.beginTransaction();

				// Update Employee Details
				Employee empForUpdate = session.get(Employee.class, empId);
				empForUpdate.setDepartment(dept);
				empForUpdate.setDesignation(designation);
				session.update(empForUpdate);

				System.out.format("\nEmployee %s updated successfuly.\n", empId);

				t.commit();

			} catch (HibernateException he) {
				t.rollback();
				he.printStackTrace();
			}
		}

		// DELETE EMPLOYEE DETAILS
		private static void deleteEmployee(Integer empId) {
			Transaction t = null;

			try (Session session = sessionFactory.openSession()) {
				t = session.beginTransaction();

				// Update Employee Details
				Employee empForDelete = session.get(Employee.class, empId);
				session.delete(empForDelete);

				System.out.format("\nEmployee %s deleted successfuly.\n", empId);

				t.commit();

			} catch (HibernateException he) {
				t.rollback();
				he.printStackTrace();
			}
		}

	

	
		
	}

