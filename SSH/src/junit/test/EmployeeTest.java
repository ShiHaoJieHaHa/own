


import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.demo.bean.Employee;
import cn.demo.bean.Gender;
import cn.demo.service.EmployeeService;

public class EmployeeTest {
	private static EmployeeService employeeService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			employeeService = (EmployeeService)act.getBean("employeeServiceBean");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void save(){
		employeeService.save(new Employee("xxxx", "123456"));
	}
	@Test
	public void update(){
		Employee employee = employeeService.find("liming");
		employee.setGender(Gender.WOMEN);
		employeeService.update(employee);
	}
	
	@Test
	public void delete(){
		employeeService.delete("liming");
	}
	
	@Test
	public void list(){
		List<Employee> ems = employeeService.list();
		for(Employee em: ems)
			System.out.println(em.getPassword());
	}
	
	@Test
	public void find(){
		Employee em = employeeService.find("liming");
		System.out.println(em.getPassword());
	}
}
