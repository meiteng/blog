package com.qx.ar.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.qx.ar.api.service.ICommentService;
import com.qx.ar.dao.ICommentDao;
import com.qx.ar.modle.Comment;
import com.qx.ar.modle.UserComment;
import com.qx.ar.utils.DateUtils;
import com.qx.ar.utils.Response;
import com.qx.ar.utils.Result;

@Service
public class CommentServiceImpl implements ICommentService {

	@Resource
	private ICommentDao commentDao;

	private Comment comment = null;
	
	private UserComment userComment = null;

	@Override
	public Result add(int userid, int objId, String content) {
		comment  = new Comment();
		comment.setUserid(userid);
		comment.setContent(content);
		comment.setAddtime(DateUtils.getCurrentTimestamp());
		comment.setObjId(objId);
		int result = commentDao.add(comment);
		if (result > 0) {
			return Response.success("评论成功", comment);
		}
		return Response.failed("评论失败");
	}

	@Override
	public Result list(int objId,int addtime ,int size) {
		userComment  = new UserComment();
		userComment.setAddtime(addtime);
		userComment.setObjId(objId);
		userComment.setSize(size);
		List<T> list=commentDao.findAll(userComment);
		Map<String, Object> map = new HashMap<String, Object>();
		UserComment lastFind = new UserComment();
		if (list.size() > 0) {
			Object lastObject = list.get(list.size() - 1);
			lastFind = (UserComment) lastObject;
		}
		map.put("time", lastFind.getAddtime());
		map.put("size", size);
		map.put("list", list);
		return Response.success("查询成功", map);
	}

}
