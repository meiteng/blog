package com.qx.ar.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.admin.dao.IAdminResourcesDao;
import com.qx.ar.admin.service.IAdminResourcesService;
import com.qx.ar.modle.Resources;
import com.qx.ar.utils.BackPageUtil;

@Service
public class AdminResourcesServiceImpl implements IAdminResourcesService {

	@Resource 
	private IAdminResourcesDao resourcesDao;
	
	@Override
	public List<T> findAll(Resources resources) {
		return resourcesDao.findAll(resources);
	}
	
	@Override
	public Integer findCount(Resources resources) {
		return resourcesDao.findCount(resources);
	}

	@Override
	public Integer delete(Integer id) {
	  return resourcesDao.delete(id);
	}
  
	@Override
	public Integer add(Resources resources) {
		return resourcesDao.add(resources);
	}

	@Override
	public Map<String, Object> pageList(Resources resources,int page){
      int totalNum=resourcesDao.findCount(resources);
		
		BackPageUtil pageUtil=new BackPageUtil(12,page,totalNum);
		resources.setSize(pageUtil.getSize());
		resources.setStart(pageUtil.getCurrentPage()*pageUtil.getSize());
		List<T> findList =new ArrayList<T>();
		
		findList =resourcesDao.findAll(resources);
		Map<String,Object> listMap=new HashMap<String,Object>();
		listMap.put("list", findList);
		listMap.put("page", pageUtil);
		return listMap;
	}

	@Override
	public Resources findOne(Resources resources) {
		return (Resources) resourcesDao.findOne(resources);
	}

	@Override
	public Integer update(Resources resources) {
		return resourcesDao.update(resources);
	}
	
}
