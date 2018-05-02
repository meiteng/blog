package com.qx.ar.api.service;

import com.qx.ar.utils.Result;

/**
 * 评论模块
 * 
 * @author Administrator
 *
 */
public interface ICommentService {

	/**
	 * 评论
	 * 
	 * @param userid
	 *            用户id
	 * @param objId
	 *            评论对象id
	 * @param content
	 *            评论内容
	 * @return
	 */
	public Result add(int userid, int objId, String content);
	
	/**
	 * 评论列表
	 * 通过时间分页
	 * @param addtime
	 * @return
	 * 
	 */
	public Result list(int objId,int addtime,int size);

}
