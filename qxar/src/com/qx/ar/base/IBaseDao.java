package com.qx.ar.base;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.qx.ar.modle.Admin;

/**
 * 基础DAO
 * 
 * @author Administrator
 *
 */
public interface IBaseDao {

	/**
	 * 增
	 * 
	 * @param object
	 *            传入对象
	 * @return
	 */
	public int add(Object object);

	/**
	 * 删
	 * 
	 * @param object
	 *            传入对象
	 * @return
	 */
	public int delete(Integer id);

	/**
	 * 
	 * @param object
	 *            传入对象
	 * @return
	 */
	public int update(Object object);

	/**
	 * 查询一个对象
	 * 
	 * @param object
	 *            传入对象
	 * @return
	 */
	public Object findOne(Object object);

	/**
	 * 查询一个list<T>集合
	 * 
	 * @param object
	 *            传入对象
	 * @return
	 */
	public List<T> findAll(Object object);
	
	/**
	 * 查询一个list<object>集合
	 * 
	 * @param object
	 *            传入对象
	 * @return
	 */
	public List<Object> findList(Object object);

}
