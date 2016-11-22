package com.springhibernate.Spring4Hibernate4;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.springhibernate.Spring4Hibernate4.configuration.AppConfig;
import com.springhibernate.Spring4Hibernate4.model.Employee;
import com.springhibernate.Spring4Hibernate4.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeService service = (EmployeeService) context.getBean("employeeService");

		/*
		 * Create Employee1
		 */
		Employee employee1 = new Employee();
		employee1.setName("Saroj Yenn");
		employee1.setSalary(new BigDecimal(10000));
		employee1.setSsn("ssn00000003");

		/*
		 * Create Employee2
		 */
		Employee employee2 = new Employee();
		employee2.setName("Micheal Thomas");
		employee2.setSalary(new BigDecimal(20000));
		employee2.setSsn("ssn00000004");

		/*
		 * Persist both Employees
		 */
		service.saveEmployee(employee1);
		service.saveEmployee(employee2);

		/*
		 * Get all employees list from database
		 */
		List<Employee> employees = service.findAllEmployees();
		for (Employee emp : employees) {
			System.out.println(emp);
		}

		/*
		 * delete an employee
		 */
		service.deleteEmployeeBySsn("ssn00000002");
		
		
		/*
		 * update an employee
		 */
		Employee employee = service.findBySsn("ssn00000001");
		employee.setSalary(new BigDecimal(50000));
		service.updateEmployee(employee);

		/*
		 * Get all employees list from database
		 */
		List<Employee> employeeList = service.findAllEmployees();
		for (Employee emp : employeeList) {
			System.out.println(emp);
		}
		context.close();
	}
}