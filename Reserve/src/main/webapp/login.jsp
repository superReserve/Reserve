<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<script type="text/javascript" src="js/jquery-1.4.4.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		// 使用Ajax的方式提交表单以注册用户
		$('#login').submit(function() {
			//alert($("#username").val());
			var url = 'users!login.action';
			// 获取所需的表单值，并以json的数据格式保存到params中
			var params = {
				username : $("#username").val(),
				password : $("#password").val()
			};

			// 使用$.post方式
			$.ajax({
				url : "users!login.action", // 提交目标
				type : "POST",
				dataType : 'json', // 接受数据格式
				data : $('#login').serialize(), // 序列化表单各字段的值
				success : function(data) { // 表单成功提交后的回调函数
					//alert("data:" + data);
					var member = eval("(" + data + ")"); // 包数据解析为json格式
					if (member.reg == "username_Locked") {
						$('#checkinfo').html("帐号被锁，请稍后再用!");
						$('#checkinfo').attr("style", "color: red");
						// 清空表单
						$('#regform')[0].reset();
						$('#checkinfo').html("");
					}
					//可以通过window.location.href重新定义跳转出口
					window.location.href = "user!list.action";
				},
				error : function(data) {
					$('#checkinfo').html("输入的用户或者密码不正确!");
					$('#checkinfo').attr("style", "color: red");
				}
			});
			return false;
		});
	});
</script>
<body>
	<a href="register.jsp">新用户注册</a>
	<p />
	<span style="color:#FF0000">${error_info}</span>
	<br />
	<form action="user!login.action" method="post">
		<!-- <form id="login" method="post">-->
		用户名：<input type="text" name="username" id="username" value="caijp" /><br /> 密码：<input
			type="password" name="password" id="password" value="123"/><br /> <input
			type="submit" value="登录" /> <span id="checkinfo" style="color: red"></span><br />
	</form>
</body>
</html>
