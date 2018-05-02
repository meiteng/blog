package com.qx.ar.admin.dao;


import com.qx.ar.base.IBaseDao;
import com.qx.ar.modle.Suggestion;

public interface IAdminSuggestionDao extends IBaseDao {
	public Integer findCount(Suggestion suggestion);
		
}
