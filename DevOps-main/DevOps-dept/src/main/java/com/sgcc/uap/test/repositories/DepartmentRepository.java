package com.sgcc.uap.test.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sgcc.uap.test.domain.Department;


/**
 * <b>概述</b>：<br>
 *	TODO
 * <p>
 * <b>功能</b>：<br>
 *	TODO
 *	
 * @author MrZhang
 * @date 2018-04-04 11:12:38
 * @since 1.0
 */
public interface DepartmentRepository extends JpaRepository<Department,String>,JpaSpecificationExecutor<Department> {

	//查询树根节点
	public List<Department> findBydepparentidIsNull();
	//查询树子节点
	public List<Department> findBydepparentid(String nodeid);

}
