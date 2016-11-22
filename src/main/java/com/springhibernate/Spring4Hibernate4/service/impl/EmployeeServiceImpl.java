/**
 * 
 */
package com.springhibernate.Spring4Hibernate4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernate.Spring4Hibernate4.dao.EmployeeDao;
import com.springhibernate.Spring4Hibernate4.model.Employee;
import com.springhibernate.Spring4Hibernate4.service.EmployeeService;

/**
 * @author saroj-gautam
 *
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeDao dao;

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.service.EmployeeService#saveEmployee(com.springhibernate.Spring4Hibernate4.service.Employee)
	 */
	@Override
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.service.EmployeeService#findAllEmployees()
	 */
	@Override
	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.service.EmployeeService#deleteEmployeeBySsn(java.lang.String)
	 */
	@Override
	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.service.EmployeeService#findBySsn(java.lang.String)
	 */
	@Override
	public Employee findBySsn(String ssn) {
		return dao.findBySsn(ssn);
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.service.EmployeeService#updateEmployee(com.springhibernate.Spring4Hibernate4.service.Employee)
	 */
	@Override
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}
}