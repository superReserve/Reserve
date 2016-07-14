package com.reserve.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.reserve.dao.UsersDAO;
import com.reserve.dao.entity.Users;

@Service("userService")
// 注解此类为业务逻辑层的Bean类
public class UserServiceImpl implements UserService {

	@Resource(name = "usersDAO")
	private UsersDAO usersDAO;

	/*
	 * 获取用户信息
	 * 
	 * @see users.center.service.UserService#getLoginAccount(java.lang.String,
	 * java.lang.String)
	 */
	public Users getLoginAccount(String username, String password) {

		Users a = new Users();
		a.setUsername(username);
		// 输入密码加密处理
		a.setPassword(password);
		List<Users> accs = usersDAO.findByExample(a);

		// 检查是否找到符合条件的对象
		if (accs.size() > 0) {
			Users acc = (Users) accs.get(0);
			return acc;
		}
		return null;
	}
}
