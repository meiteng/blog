package com.qx.ar.admin.dao;


import com.qx.ar.base.IBaseDao;
import com.qx.ar.modle.Article;

public interface IAdminArticleDao extends IBaseDao {

	public Integer findCount(Article article);
	public Integer findOne(Integer id);
	
	/*public List<Object> findList(Object object);*/
}
