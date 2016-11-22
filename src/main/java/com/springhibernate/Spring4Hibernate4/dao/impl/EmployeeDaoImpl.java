/**
 * 
 */
package com.springhibernate.Spring4Hibernate4.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springhibernate.Spring4Hibernate4.dao.AbstractDao;
import com.springhibernate.Spring4Hibernate4.model.Employee;
import com.springhibernate.Spring4Hibernate4.dao.EmployeeDao;

/**
 * @author saroj-gautam
 *
 */

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.dao.EmployeeDao#saveEmployee(com.springhibernate.Spring4Hibernate4.dao.Employee)
	 */
	@Override
	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.dao.EmployeeDao#findAllEmployees()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.dao.EmployeeDao#deleteEmployeeBySsn(java.lang.String)
	 */
	@Override
	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from EMPLOYEE where ssn = :ssn");
        query.setString("ssn", ssn);
        query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.dao.EmployeeDao#findBySsn(java.lang.String)
	 */
	@Override
	public Employee findBySsn(String ssn) {
		Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Employee) criteria.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.springhibernate.Spring4Hibernate4.dao.EmployeeDao#updateEmployee(com.springhibernate.Spring4Hibernate4.dao.Employee)
	 */
	@Override
	public void updateEmployee(Employee employee) {
		getSession().update(employee);
	}
}