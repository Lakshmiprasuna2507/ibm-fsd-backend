package SpringEmployee;


	import org.springframework.context.annotation.AnnotationConfigApplicationContext;
    import org.springframework.context.support.AbstractApplicationContext;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class EmployeeMain {

		public static void main(String[] args) {

			AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
	       Employee obj = (Employee) context.getBean("employee");
	      /* Address obj1 = (Address) context.getBean("Address");*/
	       
	   	// Display message
			//System.out.println(obj.getId());
			//System.out.println(obj.getName());
			//System.out.println(obj.getDesignation());
			//System.out.println(obj.getSalary());
		/*	System.out.println(obj1.getCity());
			System.out.println(obj1.getCountry());
			System.out.println(obj1.getPin());*/
			System.out.println(obj.getAddress().getCity()+" "+obj.getAddress().getCountry()+" "+ obj.getAddress().getPin());
			//System.out.println(obj.getDob());
			//System.out.println(obj.getSkills());
			context.registerShutdownHook();
		}

	}


