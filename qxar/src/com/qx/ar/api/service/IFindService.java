package com.qx.ar.api.service;

import com.qx.ar.utils.Result;

/**
 * 发现模块
 * 
 * @author hanyu
 *
 */
public interface IFindService {

	/**
	 * 通过主键查询发现详细
	 * @param id
	 * @return
	 */
	public Result findOne(int id);
	/**
	 * 查找所有发现--list
	 * @return
	 */
	public Result findAll(int addtime,int size);
	
	/**
	 * 查找所有发现的类型
	 * @return
	 */
	public Result allType();
}
