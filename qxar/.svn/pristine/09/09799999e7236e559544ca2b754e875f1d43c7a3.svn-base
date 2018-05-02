package com.qx.ar.admin.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.qx.ar.admin.dao.IAdminFindTypeDao;
import com.qx.ar.admin.service.IAdminFindTypeService;
import com.qx.ar.modle.FindType;

@Service
public class AdminFindTypeServiceImpl implements IAdminFindTypeService {

	@Resource
	private IAdminFindTypeDao adminFindTypeDao;
	
	@Override
	public List<Object> findList(Object FindType) {
		return adminFindTypeDao.findList(FindType);
	}

	@Override
	public Integer add(FindType findType) {
		
		return adminFindTypeDao.add(findType);
	}

	@Override
	public Integer update(FindType findType) {
		return adminFindTypeDao.update(findType);
	}

	@Override
	public FindType findOne(FindType findType) {
		return (FindType) adminFindTypeDao.findOne(findType);
	}

	@Override
	public Integer delete(Integer id) {
		return adminFindTypeDao.delete(id);
	}
}
