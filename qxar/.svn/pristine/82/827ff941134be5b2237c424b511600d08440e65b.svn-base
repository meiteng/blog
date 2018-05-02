package com.qx.ar.api.service;

import com.qx.ar.modle.Resources;
import com.qx.ar.modle.ResourcesInner;
import com.qx.ar.utils.Result;

/**
 * 资源控制器接口
 * @author hanyu
 *
 */
public interface IResourcesService {
	
	/**
	 * 通过制定字段查询资源列表
	 * @param apptoken
	 * @param title ----like
	 * @param desc----like
	 * @return
	 */
	public Result list(String apptoken,String title,String desc,int size,int addtime);
	
	/**
	 * 通过id查询资源详情
	 * @param id
	 * @return
	 */
	public Result detail(Resources resources);
	
	/**
	 * 获取resourceImg内容
	 * @param resources
	 * @return
	 */
	public Result getResourceImg(Resources resources);
	
	/**
	 * 获取resources inner内容
	 * @param resourcesInner
	 * @return
	 */
	public Result getRsourceInner(ResourcesInner resourcesInner);
}
