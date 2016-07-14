package com.reserve.service;

import com.reserve.dao.entity.Users;

public interface UserService {

	/**
	 * 根据提供的用户名和密码验证是否在帐号中存在
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return Account对象。若为null则表示帐号表中不存在对应的用户名和密码
	 */
	public Users getLoginAccount(String username, String password);

}
