package com.reserve.struts2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.reserve.bean.User;
import com.reserve.dao.entity.Users;
import com.reserve.service.UserService;

@Controller
// 注解此类为控制层的Bean类
@Scope("prototype")
// 上面用到了Spring提供的@Controller注解，以表明UserAction是属于控制器一类的Bean，
// 且通过@Scope("prototype")注解设置每次请求都重新生成一个UserAction的实例对象以避免线程安全问题，
// 还在UserAction类的“userService”成员变量之前加了一个“@Resource(name="userService")”注解，
// 其作用是要求Spring提供一个名为“userService”的Bean对象，注入到成员变量“userService”（相当于赋值）
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private UserService userService;
	@Resource(name = "userService")
	private UserService userService;

	private String jsonRoot;

	// 处理页面提交的登录请求
	public String login() throws Exception {

		// 获取登录用户名和密码对应的帐号对象
		// Users acc = userService.getLoginAccount(username, password);
		Users acc = userService.getLoginAccount(username, password);
		Map<String, String> map = new HashMap<String, String>();
		// 检查是否登录成功
		if (acc != null) {
			// 存储全称到session，在界面显示登录人全称
			Map session = ActionContext.getContext().getSession();
			session.put("FULLNAME", "");
		} else {
			// 返回失败的结果
			return "login_failure";
		}
		// 将要返回的map对象进行json处理
		JSONObject jo = JSONObject.fromObject(map);

		// 调用json对象的toString方法转换为字符串然后赋值给jsonRoot
		this.setJsonRoot(jo.toString());

		// 转到显示用户清单的页面
		return "login_success";
	}

	// 登录表单提交的数据
	private int id;
	private String username;
	private String password;
	// 注册表单提交的数据，用户名使用上面的username成员变量
	private String password1;
	private String password2;
	private String fullname;
	private int age;
	private String address;
	// 传递一个对象的数据
	private User user;
	// 显示用户清单的数据集合
	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJsonRoot() {
		return jsonRoot;
	}

	public void setJsonRoot(String jsonRoot) {
		this.jsonRoot = jsonRoot;
	}

}
