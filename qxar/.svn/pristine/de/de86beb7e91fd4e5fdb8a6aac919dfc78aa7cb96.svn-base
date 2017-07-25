package com.qx.ar.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.api.service.IFindService;
import com.qx.ar.dao.IFindDao;
import com.qx.ar.dao.IFindTypeDao;
import com.qx.ar.modle.Find;
import com.qx.ar.modle.FindType;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

@Service
public class FindServiceImpl implements IFindService {

	@Resource
	private IFindDao findDao;
	
	@Resource
	private IFindTypeDao findTypeDao;
	
	private Find find = null;
	private FindType findType = null;
	
	/**
	 * 根据主键查询发现
	 */
	@Override
	public Result findOne(int id) {
		find=new Find();
		find.setId(id);
		Find result = (Find)findDao.findOne(find);
		if (null == result) {
			return Response.failed("非法传入");
		}
		return Response.success("查询成功", result);
	}
	
	/**
	 * 查询发现列表，并根据时间分类
	 */
	@Override
	public Result findAll(int addtime,int size){
		find=new Find();
		find.setAddtime(addtime);
		find.setSize(size);
		List<T> list =findDao.findAll(find);
		Map<String, Object> map = new HashMap<String, Object>();
		Find lastFind = new Find();
		if (list.size() > 0) {
			Object lastObject = list.get(list.size() - 1);
			lastFind = (Find) lastObject;
		}
		map.put("time", lastFind.getAddtime());
		map.put("size", size);
		map.put("list", list);
		return Response.success("查询成功", map);
	}

	@Override
	public Result allType() {
		findType=new FindType();
		findType.setTitle("aaa");
		List<T> list=findTypeDao.findAll(findType);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return Response.success("查询成功", map);
	}
	
}
