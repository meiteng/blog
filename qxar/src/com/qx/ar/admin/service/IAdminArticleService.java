package com.qx.ar.admin.service;


import java.util.List;
import java.util.Map;
import org.apache.poi.ss.formula.functions.T;
import com.qx.ar.modle.Article;

public interface IAdminArticleService {
	public List<T> findAll(Article article);
	
//	public Integer findCount(Article article);
	
	public Integer delete(Integer id);
	
	public Integer add(Article article);
	
//	public Article findOne(Integer id);
	
	public Map<String,Object> pageList(Article article,int page);

	Article findOne(Article article);

	public void update(Article article);

	//public Integer update(User user);
	
	/*public List<Object> findList(Object object);*/
}
