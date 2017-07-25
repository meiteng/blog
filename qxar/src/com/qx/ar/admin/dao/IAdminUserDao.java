package com.qx.ar.admin.dao;


import com.qx.ar.base.IBaseDao;
import com.qx.ar.modle.User;

public interface IAdminUserDao extends IBaseDao {

	public Integer findCount(User user);
	
	
}
