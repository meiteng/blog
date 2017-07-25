package com.qx.ar.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.admin.dao.IAdminUserDao;
import com.qx.ar.admin.service.IAdminUserService;
import com.qx.ar.modle.User;
import com.qx.ar.utils.BackPageUtil;

@Service
public class AdminUserServiceImpl implements IAdminUserService {
	
	@Resource
	private IAdminUserDao adminUserDao;
	@Override
	public List<T> findAll(User user) {
		return adminUserDao.findAll(user);
	}
	
	@Override
	public Integer findCount(User user) {
		return adminUserDao.findCount(user);
	}

	@Override
	public Integer delete(Integer id) {
		return adminUserDao.delete(id);
	}

	@Override
	public Integer add(User user) {
		
		return adminUserDao.add(user);
	}

	@Override
	public User findOne(User user) {
		return (User) adminUserDao.findOne(user);
	}
	@Override
	public Map<String, Object> pageList(User user,int page){
      int totalNum=adminUserDao.findCount(user);
		
		BackPageUtil pageUtil=new BackPageUtil(2,page,totalNum);
		user.setSize(pageUtil.getSize());
		user.setStart(pageUtil.getCurrentPage()*pageUtil.getSize());
		List<T> findList =new ArrayList<T>();
		
		findList =adminUserDao.findAll(user);
		Map<String,Object> listMap=new HashMap<String,Object>();
		listMap.put("list", findList);
		listMap.put("page", pageUtil);
		return listMap;
	}
	@Override
	public Integer update(User user) {
		return adminUserDao.update(user);
	}

}
