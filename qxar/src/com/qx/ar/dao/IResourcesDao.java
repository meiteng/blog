package com.qx.ar.dao;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.qx.ar.base.IBaseDao;

public interface IResourcesDao extends IBaseDao{

	/**
	 * 查询一个list<T>集合
	 * 
	 * @param object
	 *            传入对象
	 * @return
	 */
	public List<T> getResourceImg(Object object);
}
