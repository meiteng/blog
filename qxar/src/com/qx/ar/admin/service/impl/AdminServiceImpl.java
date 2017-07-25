package com.qx.ar.admin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.qx.ar.admin.service.IAdminService;
import com.qx.ar.admin.dao.IAdminDao;
import com.qx.ar.modle.Admin;


@Service
public class AdminServiceImpl implements IAdminService {

	@Resource
	private IAdminDao adminDao;

	private Admin admin = null;
	
	@Override
	public Admin login(String username) {
		admin=new Admin();
		admin.setUsername(username);
		return  (Admin) adminDao.findOne(admin);
	}

}
