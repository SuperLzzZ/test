package com.sgcc.uap.test.vo;

import com.sgcc.uap.test.domain.Employee;


public class EmployeeTransfer {

	public static Employee toPO(EmployeeVO vo) {
		Employee employee = new Employee();
		if(vo != null){
			employee.setId(vo.getId());
			employee.setDepid(vo.getDepid());
			employee.setName(vo.getName());
			employee.setNum(vo.getNum());
			employee.setAge(vo.getAge());
			employee.setSex(vo.getSex());
			employee.setAddress(vo.getAddress());
			employee.setTel(vo.getTel());
			employee.setInductiontime(vo.getInductiontime());
        }
		return employee;
	}

	public static EmployeeVO toVO(Employee po) {
		EmployeeVO vo = new EmployeeVO();
		vo.setId(po.getId());
		vo.setDepid(po.getDepid());
		vo.setName(po.getName());
		vo.setNum(po.getNum());
		vo.setAge(po.getAge());
		vo.setSex(po.getSex());
		vo.setAddress(po.getAddress());
		vo.setTel(po.getTel());
		vo.setInductiontime(po.getInductiontime());
		return vo;
	}
}
