package com.qx.ar.admin.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.admin.dao.IAdminSuggestionDao;
import com.qx.ar.admin.service.IAdminSuggestionService;
import com.qx.ar.modle.Suggestion;
import com.qx.ar.utils.BackPageUtil;
@Service
public class AdminSuggestionServiceImpl implements IAdminSuggestionService {
	@Resource
	private IAdminSuggestionDao adminSuggestionDao;
	@Override
	public List<Object> findList(Object suggestion) {
		
		return adminSuggestionDao.findList(suggestion);
	}
	@Override
	public Integer findCount(Suggestion find) {
		
		return adminSuggestionDao.findCount(find);
	}
	@Override
	public List<T> findAll(Suggestion find) {
		
		return adminSuggestionDao.findAll(find);
	}
	
	
	@Override
	public Integer delete(Integer id) {
		
		return adminSuggestionDao.delete(id);
	}
	@Override
	public Integer add(Suggestion suggestion) {
		
		return adminSuggestionDao.add(suggestion);
	}
	@Override
	public Map<String, Object> pageList(Suggestion suggestion,int page){
      int totalNum=adminSuggestionDao.findCount(suggestion);
		
		BackPageUtil pageUtil=new BackPageUtil(2,page,totalNum);
		suggestion.setSize(pageUtil.getSize());
		suggestion.setStart(pageUtil.getCurrentPage()*pageUtil.getSize());
		List<T> findList =new ArrayList<T>();
		
		findList =adminSuggestionDao.findAll(suggestion);
		Map<String,Object> listMap=new HashMap<String,Object>();
		listMap.put("list", findList);
		listMap.put("page", pageUtil);
		return listMap;
	}
	@Override
	public Suggestion findOne(Suggestion suggestion) {
		return (Suggestion) adminSuggestionDao.findOne(suggestion);
	}
	@Override
	public Integer update(Suggestion suggestion) {
		return adminSuggestionDao.update(suggestion);
	}
}
