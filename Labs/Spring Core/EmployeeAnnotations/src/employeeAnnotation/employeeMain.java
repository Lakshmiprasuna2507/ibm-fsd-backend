package employeeAnnotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.examples.java.springs.Employee;

public class employeeMain {
	
	public static void main(String[] args) {
		public static void main(String[] args) {

			AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
	       Employee obj = (Employee) context.getBean("Employee");
	      /* Address obj1 = (Address) context.getBean("Address");*/
	       
	   	// Display message
			System.out.println(obj.getId());
			System.out.println(obj.getName());
			System.out.println(obj.getDesignation());
			System.out.println(obj.getSalary());
		/*	System.out.println(obj1.getCity());
			System.out.println(obj1.getCountry());
			System.out.println(obj1.getPin());*/
			System.out.println(obj.getAddress().getCity()+" "+obj.getAddress().getCountry()+" "+ obj.getAddress().getPin());
			System.out.println(obj.getDob());
			System.out.println(obj.getSkills());
		}

	}

	
