package com.qx.ar.admin.service.impl;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;


import com.qx.ar.admin.dao.IAdminFindDao;
import com.qx.ar.admin.service.IAdminFindService;
import com.qx.ar.modle.Find;
import com.qx.ar.utils.BackPageUtil;

@Service
public class AdminFindServiceImpl implements IAdminFindService {

	@Resource
	private IAdminFindDao adminFindDao;
	
	@Override
	public  List<T> findAll(Find find) {
		return adminFindDao.findAll(find);
	}

	@Override
	public Integer findCount(Find find) {
		return adminFindDao.findCount(find);
	}

	@Override
	public Integer add(Find find) {
		return adminFindDao.add(find);
	}

	@Override
	public Integer delete(Integer id) {
		return adminFindDao.delete(id);
	}

	/**
	 * 发现列表
	 * @param find
	 * @param page
	 * @return
	 */
	@Override
	public Map<String, Object> pageList(Find find,int page){

		int totalNum=adminFindDao.findCount(find);
		
		BackPageUtil pageUtil=new BackPageUtil(10,page,totalNum);
		find.setSize(pageUtil.getSize());
		find.setStart(pageUtil.getCurrentPage()*pageUtil.getSize());
		List<T> findList =new ArrayList<T>();
			
		findList =adminFindDao.findAll(find);
	
		Map<String,Object> listMap=new HashMap<String,Object>();
		listMap.put("list", findList);
		listMap.put("page", pageUtil);
		return listMap;
	}

	@Override
	public Find findOne(Find find) {
		return (Find)adminFindDao.findOne(find);
	}

	@Override
	public Integer update(Find find) {
		return adminFindDao.update(find);
	}

	
}
