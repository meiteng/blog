package com.qx.ar.admin.dao;

import com.qx.ar.base.IBaseDao;
import com.qx.ar.modle.ResourcesInner;

public interface IAdminResourcesInnerDao extends IBaseDao {
	public Integer findCount(ResourcesInner find);
	
}
