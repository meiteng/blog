package com.qx.ar.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;


import com.qx.ar.admin.service.IAdminCompanyService;
import com.qx.ar.admin.dao.ICompanyDao;
import com.qx.ar.modle.Company;
import com.qx.ar.utils.BackPageUtil;

@Service
public class AdminCompanyServiceImpl implements IAdminCompanyService {

	@Resource
	private ICompanyDao companyDao;
	
	@Override
	public Company findOne(Company company) {
		return (Company) companyDao.findOne(company);
	}

	@Override
	public List<T> findAll(Company find) {
		return companyDao.findAll(find);
	}

	@Override
	public Integer add(Company find) {
		return companyDao.add(find);
	}

	@Override
	public Integer update(Company find) {
		return companyDao.update(find);
	}

	@Override
	public Integer delete(Integer id) {
		return companyDao.delete(id);
	}

	@Override
	public Map<String, Object> pageList(Company find, int page) {
       int totalNum=companyDao.findCount(find);
		
		BackPageUtil pageUtil=new BackPageUtil(2,page,totalNum);
		find.setSize(pageUtil.getSize());;
		find.setStart(pageUtil.getCurrentPage()*pageUtil.getSize());
		List<T> findList =new ArrayList<T>();
		
		findList =companyDao.findAll(find);
		Map<String,Object> listMap=new HashMap<String,Object>();
		listMap.put("list", findList);
		listMap.put("page", pageUtil);
		return listMap;
	}

	@Override
	public Integer findCount(Company find) {
		return companyDao.findCount(find);
	}

	
}
