/**
 * 
 */
package com.springhibernate.Spring4Hibernate4.service;

import java.util.List;

import com.springhibernate.Spring4Hibernate4.model.Employee;

/**
 * @author saroj-gautam
 *
 */
public interface EmployeeService {

	void saveEmployee(Employee employee);
	 
    List<Employee> findAllEmployees();
 
    void deleteEmployeeBySsn(String ssn);
 
    Employee findBySsn(String ssn);
 
    void updateEmployee(Employee employee);
}