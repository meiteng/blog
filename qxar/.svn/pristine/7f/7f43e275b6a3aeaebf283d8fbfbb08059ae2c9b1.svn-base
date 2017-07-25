package com.qx.ar.api.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.api.service.IResourcesService;
import com.qx.ar.dao.IResourcesDao;
import com.qx.ar.dao.IResourcesInnerDao;
import com.qx.ar.modle.Resources;
import com.qx.ar.modle.ResourcesInner;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

/**
 * 资源控制器
 * @author hanyu
 *
 */
@Service
public class ResourcesServiceImpl implements IResourcesService {
	
	@Resource
	private IResourcesDao resourcesDao;
	@Resource
	private IResourcesInnerDao resourcesInnerDao;
	private Resources resources=null;

	/**
	 * 查询资源列表
	 */
	@Override
	public Result list(String apptoken, String title, String desc ,int size,int addtime) {
		resources=new Resources();
		resources.setApptoken(apptoken);
		resources.setTitle(title);
		resources.setSize(size);
		resources.setAddtime(addtime);;
		
		List<T> list =resourcesDao.findAll(resources);
		
		Map<String, Object> map =new HashMap<String ,Object>();
		Resources lastFind=new Resources();
		
		
		if (list.size() > 0) {
			Object lastObject = list.get(list.size() - 1);
			lastFind = (Resources) lastObject;
		}
		map.put("time", lastFind.getAddtime());
		map.put("size", size);
		map.put("list", list);
		return Response.success("查询成功", map);
	}

	/**
	 * 获取resourceImg内容,为unity接口提供
	 * @param resources
	 * @return
	 */
	@Override
	public Result getResourceImg(Resources resources){
		List<T> list=resourcesDao.getResourceImg(resources);
		return Response.success("查询成功", list);
	}
	
	@Override
	public Result detail(Resources res) {
		
		resources=(Resources)resourcesDao.findOne(res);
		if(null == resources){
			return Response.failed("数据为空");
		}
		return Response.success("查询成功", resources);
	}

	@Override
	public Result getRsourceInner(ResourcesInner resourcesInner) {
		List<T> list=resourcesInnerDao.findAll(resourcesInner);
		return Response.success("查询成功", list);
	}
	
	
	
	
	
}
