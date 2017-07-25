package com.qx.ar.admin.service;


import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.qx.ar.modle.Resources;
import com.qx.ar.modle.User;

public interface IAdminUserService {
	public List<T> findAll(User user);
	
	public Integer findCount(User user);
	
	public Integer delete(Integer id);
	
	public Integer add(User user);
	
	public User findOne(User user);
	
	public Map<String,Object> pageList(User user ,int page);
		 
	public Integer update(User user);
}
