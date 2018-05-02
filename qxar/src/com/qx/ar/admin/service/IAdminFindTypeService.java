package com.qx.ar.admin.service;

import java.util.List;

import com.qx.ar.modle.FindType;



public interface IAdminFindTypeService {
	public List<Object> findList(Object object);
	
	public Integer add(FindType findType);
	
	public Integer update(FindType findType);
	
	public FindType findOne(FindType findType);
	
	public Integer delete(Integer id);
}
