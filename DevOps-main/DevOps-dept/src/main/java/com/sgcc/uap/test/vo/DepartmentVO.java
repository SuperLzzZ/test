package com.sgcc.uap.test.vo;

import java.io.Serializable;


import com.sgcc.uap.rest.annotation.attribute.AttributeType;
import com.sgcc.uap.rest.annotation.attribute.EditorType;
import com.sgcc.uap.rest.annotation.attribute.ViewAttribute;
import com.sgcc.uap.rest.support.ParentVO;
/**
 * Department的VO类
 *
 * @author MrZhang 
 * @date 2018-04-04 11:12:38
 */
public class DepartmentVO extends ParentVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
    /** 
     * 属性id
     */  
    @ViewAttribute(name ="id",caption="id", editor=EditorType.TextEditor,nullable =false,readOnly=false, type=AttributeType.STRING)
    private String id;    
    /** 
     * 属性部门名称
     */  
    @ViewAttribute(name ="depname",caption="部门名称", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String depname;    
    /** 
     * 属性父ID
     */  
    @ViewAttribute(name ="depparentid",caption="父ID", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String depparentid;    
    /** 
     * 属性描述
     */  
    @ViewAttribute(name ="depdesc",caption="描述", editor=EditorType.TextEditor,nullable =true,readOnly=false, type=AttributeType.STRING)
    private String depdesc;    
    /**
     * DepartmentVO构造函数
     */
    public DepartmentVO() {
        super();
    } 
   
	 /**
     * DepartmentVO完整的构造函数
     */  
    public DepartmentVO(String id){
        this.id = id;
    }
    /**
     * id的get方法
     * @return id
     */
    public String getId(){
        return id;
    }
    /**
     * id的set方法
     * @param id
     */
    public void setId(String id){
        if(id != null && id.trim().length() == 0){
        	this.id = null;
        }else{
        	this.id = id;
        }
	} 
    /**
     * 部门名称的get方法
     * @return depname
     */
    public String getDepname(){
        return depname;
    }
    /**
     * 部门名称的set方法
     * @param depname
     */
    public void setDepname(String depname){
		this.depname = depname;
	} 
    /**
     * 父ID的get方法
     * @return depparentid
     */
    public String getDepparentid(){
        return depparentid;
    }
    /**
     * 父ID的set方法
     * @param depparentid
     */
    public void setDepparentid(String depparentid){
		this.depparentid = depparentid;
	} 
    /**
     * 描述的get方法
     * @return depdesc
     */
    public String getDepdesc(){
        return depdesc;
    }
    /**
     * 描述的set方法
     * @param depdesc
     */
    public void setDepdesc(String depdesc){
		this.depdesc = depdesc;
	} 

    /**
     * toString方法
     * @return String
     */
	public String toString(){

		  return new StringBuffer()
	  			.append("ID"+":"+getId())
				.append("DEPNAME"+":"+getDepname())
				.append("DEPPARENTID"+":"+getDepparentid())
				.append("DEPDESC"+":"+getDepdesc())
		        .toString(); 
			
    } 
   


}
