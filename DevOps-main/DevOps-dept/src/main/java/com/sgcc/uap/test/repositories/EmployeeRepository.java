package com.sgcc.uap.test.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.sgcc.uap.test.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author MrZhang
 * @date 2018-04-04 09:12:11
 * @since 1.0
 */
public interface EmployeeRepository extends JpaRepository<Employee,String>,JpaSpecificationExecutor<Employee> {

	
}
