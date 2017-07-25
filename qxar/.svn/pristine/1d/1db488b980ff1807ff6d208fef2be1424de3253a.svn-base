package com.qx.ar.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.admin.dao.IAdminResourcesInnerDao;
import com.qx.ar.admin.service.IAdminResourcesInnerService;
import com.qx.ar.modle.Resources;
import com.qx.ar.modle.ResourcesInner;
import com.qx.ar.utils.BackPageUtil;

@Service
public class AdminResourcesInnerServiceImpl implements IAdminResourcesInnerService {

	@Resource 
	private IAdminResourcesInnerDao adminResourcesInnerDao;
	
	@Override
	public List<T> findAll(ResourcesInner resources) {
		return adminResourcesInnerDao.findAll(resources);
	}
	
	@Override
	public Integer findCount(ResourcesInner resources) {
		return adminResourcesInnerDao.findCount(resources);
	}

	@Override
	public Integer delete(Integer id) {
	  return adminResourcesInnerDao.delete(id);
	}
  
	@Override
	public Integer add(ResourcesInner resources) {
		return adminResourcesInnerDao.add(resources);
	}

	@Override
	public Map<String, Object> pageList(ResourcesInner resources,int page){
      int totalNum=adminResourcesInnerDao.findCount(resources);
		
		BackPageUtil pageUtil=new BackPageUtil(13,page,totalNum);
		resources.setSize(pageUtil.getSize());
		resources.setStart(pageUtil.getCurrentPage()*pageUtil.getSize());
		List<T> findList =new ArrayList<T>();
		
		findList =adminResourcesInnerDao.findAll(resources);
		Map<String,Object> listMap=new HashMap<String,Object>();
		listMap.put("list", findList);
		listMap.put("page", pageUtil);
		return listMap;
	}

	@Override
	public ResourcesInner findOne(ResourcesInner resources) {
		return (ResourcesInner) adminResourcesInnerDao.findOne(resources);
	}

	@Override
	public Integer update(ResourcesInner resources) {
		return adminResourcesInnerDao.update(resources);
	}
	
}
