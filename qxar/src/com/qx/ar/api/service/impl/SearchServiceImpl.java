package com.qx.ar.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.api.service.ISearchService;
import com.qx.ar.dao.IFindDao;
import com.qx.ar.modle.Find;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

@Service
public class SearchServiceImpl implements ISearchService {

	@Resource
	private IFindDao searchDao;

	private Find find = null;

	@Override
	public Result find(String title, String desc, int time, int size) {
		find = new Find();
		find.setTitle(title);
		find.setDesc(desc);
		find.setAddtime(time);
		find.setSize(size);
		List<T> list = searchDao.findAll(find);
		Map<String, Object> map = new HashMap<String, Object>();
		Find lastFind = new Find();
		if (list.size() > 0) {
			Object lastObject = list.get(list.size() - 1);
			lastFind = (Find) lastObject;
		}
		System.out.println(lastFind);
		map.put("time", lastFind.getAddtime());
		map.put("size", size);
		map.put("list", list);
		return Response.success("查询成功", map);
	}

}
