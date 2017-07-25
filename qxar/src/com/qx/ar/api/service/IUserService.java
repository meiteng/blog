package com.qx.ar.api.service;

import com.qx.ar.modle.User;
import com.qx.ar.utils.Result;

/**
 * 用户模块
 * 
 * @author Administrator
 *
 */
public interface IUserService {

	/**
	 * 登陆接口
	 * 
	 * @param apptoken
	 *            公司唯一标志
	 * @param phone
	 *            手机号
	 * @param pswd
	 *            密码
	 * @return
	 */
	public Result login(String apptoken, String phone, String pswd);

	/**
	 * 注册
	 * 
	 * @param apptoken
	 *            公司唯一标志
	 * @param phone
	 *            手机号
	 * @param pswd
	 *            密码
	 * @param vercode
	 *            验证码
	 * @return
	 */
	public Result register(User user);

	/**
	 * 修改手机号
	 * 
	 * @param userid
	 *            用户id
	 * @param newphone
	 *            新手机号
	 * @param vercode
	 *            验证码
	 * @return
	 */
	public Result rephone(int userid, String newphone);

	/**
	 * 用户反馈
	 * 
	 * @param apptoken
	 *            公司唯一标志
	 * @param content
	 *            反馈内容
	 * @param contactway
	 *            联系方式
	 * @return
	 */
	public Result feedback(String apptoken, String content, String contactway,int userid);

	/**
	 * 修改头像
	 * 
	 * @param userid
	 *            用户id
	 * @param headurl
	 *            新头像url
	 * @return
	 */
	public Result rehead(int userid, String headurl);

	/**
	 * 修改密码
	 * 
	 * @param userid
	 *            用户id
	 * @param pswd
	 *            密码
	 * @param vercode
	 *            验证码
	 * @return
	 */
	public Result repswd(int userid, String pswd);

	/**
	 * 用户中心--帮助
	 * 
	 * @param apptoken
	 *            公司唯一标志
	 * @return
	 */
	public Result help(String apptoken);

	/**
	 * 用户中心--关于每个公司信息
	 * 
	 * @param apptoken
	 *            公司唯一标志
	 * @return
	 */
	public Result about(String apptoken);

	/**
	 * 我的相册
	 * 
	 * @param userid
	 *            用户id
	 * @return
	 */
	public Result albumlist(int userid);

	/**
	 * 修改用户昵称
	 * 
	 * @param userid
	 *            用户id
	 * @param nickname
	 *            昵称
	 * @return
	 */
	public Result renickname(int userid, String nickname);
}
