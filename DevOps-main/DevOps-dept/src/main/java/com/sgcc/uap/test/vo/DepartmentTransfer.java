package com.sgcc.uap.test.vo;

import com.sgcc.uap.test.domain.Department;


public class DepartmentTransfer {

	public static Department toPO(DepartmentVO vo) {
		Department department = new Department();
		if(vo != null){
			department.setId(vo.getId());
			department.setDepname(vo.getDepname());
			department.setDepparentid(vo.getDepparentid());
			department.setDepdesc(vo.getDepdesc());
        }
		return department;
	}

	public static DepartmentVO toVO(Department po) {
		DepartmentVO vo = new DepartmentVO();
		vo.setId(po.getId());
		vo.setDepname(po.getDepname());
		vo.setDepparentid(po.getDepparentid());
		vo.setDepdesc(po.getDepdesc());
		return vo;
	}
}
