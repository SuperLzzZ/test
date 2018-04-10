package com.sgcc.uap.test.controller;

import com.sgcc.uap.rest.support.ViewMetaData;
import org.slf4j.Logger;
import com.sgcc.uap.rest.support.QueryResultObject;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import com.sgcc.uap.test.services.IDepartmentService;
import com.sgcc.uap.rest.annotation.ColumnRequestParam;
import com.sgcc.uap.rest.utils.ViewAttributeUtils;
import com.sgcc.uap.rest.utils.WrappedTreeNodes;

import org.springframework.transaction.annotation.Transactional;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import com.sgcc.uap.rest.support.RequestCondition;
import com.sgcc.uap.rest.support.TreeNode;
import com.sgcc.uap.rest.annotation.QueryRequestParam;
import com.sgcc.uap.rest.support.IDRequestObject;
import com.sgcc.uap.exception.NullArgumentException;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sgcc.uap.rest.annotation.attribute.ViewAttributeData;
import com.sgcc.uap.rest.support.FormRequestObject;
import com.sgcc.uap.test.vo.DepartmentVO;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import com.sgcc.uap.rest.support.WrappedResult;


/**
 * <b>概述</b>：<br>
 * TODO
 * <p>
 * <b>功能</b>：<br>
 * TODO
 *
 * @author MrZhang
 * @date 2018-04-04 11:12:38
 * @since 1.0
 */
@RestController
@Transactional
@RequestMapping("/department")
public class DepartmentController {
	private final static Logger logger = (Logger) LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private IDepartmentService departmentService;
	/**
	 * 根据id查询
	 * @param id
	 * @return 查询结果
	 */
	@RequestMapping(value = "/{id}")
	public WrappedResult getById(@PathVariable String id) {
		try {
			QueryResultObject result = departmentService.getDepartmentById(id);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 删除节点（包括所有子节点）
	 * 
	 * @param params
	 *            删除节点ID
	 * @return 删除结果
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public WrappedResult deleteByIds(@RequestBody IDRequestObject idObject) {
		try {

			departmentService.remove(idObject);
			logger.info("删除节点["+idObject+"]成功");  
			return WrappedResult.successWrapedResult(true);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 保存
	 * @param params
	 * @return 保存结果
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public WrappedResult saveOrUpdate(@RequestBody FormRequestObject<Map> params) {
		try {
			if(params == null){
				throw new NullArgumentException("params");
			}
			QueryResultObject result = new QueryResultObject();
			List<Map> items = params.getItems();
			if(items != null && !items.isEmpty()){
				for(Map map : items){
					result.setFormItems(departmentService.saveDepartment(map));
				}
			}
			logger.info("保存数据成功"); 
			return WrappedResult.successWrapedResult(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 查询
	 * @param requestCondition
	 * @return 查询结果
	 */
	@RequestMapping("/")
	public WrappedResult query(@QueryRequestParam("params") RequestCondition requestCondition) {

		try {
			QueryResultObject queryResult = departmentService.query(requestCondition);
			logger.info("查询数据成功"); 
			return WrappedResult.successWrapedResult(queryResult);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	/**
	 * 从vo中获取页面展示元数据信息
	 * 
	 * @param columns
	 *            将请求参数{columns:["id","name"]}封装为字符串数组
	 * @return datas
	 */
	@RequestMapping("/meta")
	public 	WrappedResult getMetaData(
			@ColumnRequestParam("params") String[] columns) {
		try{
			if(columns == null){
				throw new NullArgumentException("columns");
			}
			List<ViewAttributeData> datas = null;
			datas = ViewAttributeUtils.getViewAttributes(columns, DepartmentVO.class);
			WrappedResult wrappedResult = WrappedResult
					.successWrapedResult(new ViewMetaData(datas));
			return wrappedResult;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	@RequestMapping(value = "/tree")
	public WrappedResult getRootTreeNode() {
		try {
			List<TreeNode> treenodelist = departmentService.listNodes(null);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult(new WrappedTreeNodes(treenodelist));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}
	@RequestMapping(value = "/tree/{id}")
	public WrappedResult getListTreeNode(@PathVariable String id) {
		try {
			List<TreeNode> treenodelist = departmentService.listNodes(id);
			logger.info("查询成功"); 
			return WrappedResult.successWrapedResult(new WrappedTreeNodes(treenodelist));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return WrappedResult.failedWrappedResult(e.getMessage());
		}
	}



}
