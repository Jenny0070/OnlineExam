<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>在线考试系统</title>
	<!--引入css，否则没有样式-->
	<script src="${ctx}/static/plugins/layui/layui.js"></script>
	<link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
	<style type="text/css">
		body{
			margin: 0;
			padding: 0;
		}
		#div1{
			margin:0px;
			padding:0px;
			width:100%;
			height:99%;
			font-size:14px;
			position:absolute;
		}
		.divtitle{
			height: 40px;
			line-height: 40px;
			color: #3180D8;
			font-family: "Microsoft YaHei";
			border-bottom: 1px dotted #ededed;
		}
	</style>
	<script type="text/javascript">

		function checkTid(){
			var flag;
			//获取文件框值
			var tid = document.getElementById("tid").value;
			var reg = /^[0-9]{6,15}$/i;
			if(tid == ""){
				document.getElementById("tidspan").innerHTML = "* 教师编号不能为空".fontcolor("red").fontsize("2px");
				return false;
			}else if(!reg.test(tid)){
				document.getElementById("tidspan").innerHTML = "* 教师编号只能是6到15位的数字".fontcolor("red").fontsize("2px");
				return false;
			}else{
				//1.创建异步交互对象
				var xhr = createXmlHttp();
				//2.设置监听
				xhr.onreadystatechange = function(){
					if(xhr.readyState == 4){	//数据返回完毕
						if(xhr.status == 200){		//http操作正常
							var text = xhr.responseText;
							if("t" == text){
								document.getElementById("tidspan").innerHTML = "* 该教师编号已被使用".fontcolor("red").fontsize("2px");
							}else{
								document.getElementById("tidspan").innerHTML = "* 该教师编号可以使用".fontcolor("green").fontsize("2px");
								document.getElementById("password").value=tid;
								document.getElementById("passwordspan").innerHTML = "* 默认密码为教师编号".fontcolor("green").fontsize("2px");
							}
						}
					}
				}
				//3.打开连接
				xhr.open("GET","${pageContext.request.contextPath}/teacher_findByTid.action?time="+new Date().getTime()+"&tid="+tid,true);
				//4.发送
				xhr.send(null);
			}
		}
		function createXmlHttp(){
			var xmlHttp;
			try{ // Firefox, Opera 8.0+, Safari
				xmlHttp=new XMLHttpRequest();
			}
			catch (e){
				try{// Internet Explorer
					xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
					xmlHttp.setrequestheader("content-type","application/x-www-form-urlencoded; charset=utf-8");
				}
				catch (e){
					try{
						xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
					catch (e){}
				}
			}
			return xmlHttp;
		}

		//校验教师姓名
		function checkTname(){
			var tname = document.getElementById("tname").value;
			var tnamespan = document.getElementById("tnamespan");
			var flag;
			if(tname == ""){
				tnamespan.innerHTML = "* 姓名不能为空".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				tnamespan.innerHTML = "* 该姓名可以使用".fontcolor("green").fontsize("2px");
				flag = true;
			}
			return flag;
		}
		//校验教师密码
		function checkPassword(){
			var password = document.getElementById("password").value;
			var passwordspan = document.getElementById("passwordspan");
			var reg = /^[0-9]{6,15}$/i;
			var flag;
			if(password == ""){
				passwordspan.innerHTML = "* 密码不能为空".fontcolor("red").fontsize("2px");
				flag = false;
			}else if(!reg.test(password)){
				passwordspan.innerHTML = "* 密码只能是6到15位的数字".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				passwordspan.innerHTML = " 该密码可以使用".fontcolor("green").fontsize("2px");
				flag = true;
			}
			return flag;
		}
		//验证手机号码
		function checkPhone(){
			var phone = document.getElementById("phone").value;
			var phonespan = document.getElementById("phonespan");
			var reg = /^[0-9]{11}$/i;
			var flag;
			if(phone == ""){
				phonespan.innerHTML = "* 手机号不能为空".fontcolor("red").fontsize("2px");
				flag = false;
			}else if(!reg.test(phone)){
				phonespan.innerHTML = "* 手机号只能是11位的数字".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				phonespan.innerHTML = "* 该手机号可以使用".fontcolor("green").fontsize("2px");
				flag = true;
			}
			return flag;
		}

		function checkForm(){
			var tidspan = document.getElementById("tidspan");
			if(tidspan.innerText == ""){
				tidspan.innerHTML = "* 教师编号不能为空".fontcolor("red").fontsize("2px");
			}
			if(checkTname() && checkPassword() && checkPhone() && tidspan.innerText == "* 该教师编号可以使用"){
				return true;
			}else{
				return false;
			}
		}
	</script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo">在线考试系统</div>
		<ul class="layui-nav layui-layout-right">
			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
					${sessionScope.existAdmin.username}
				</a>
			</li>
			<li class="layui-nav-item"><a href="/admin/sessionDestoryadmin">退出登录</a></li>
		</ul>
	</div>

	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
				<li class="layui-nav-item layui-nav-itemed">
					<a class="" href="javascript:;">题库管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/pages/admin/ckqp.jsp">查找试题</a></dd>
						<dd><a href="/pages/admin/ckxsxzquestion.jsp">添加选择题</a></dd>
						<dd><a href="/pages/admin/ckxspdquestion.jsp">添加判断题</a></dd>
						<dd><a href="/pages/admin/ckxstkquestion.jsp">添加读程序题</a></dd>
						<%--                        <dd><a href="">超链接</a></dd>--%>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">试卷管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/pages/admin/ckqp.jsp">查看试卷</a></dd>
						<dd><a href="/pages/admin/tjquestionpaper.jsp">添加试卷</a></dd>
						<%--                        <dd><a href="">超链接</a></dd>--%>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">班级管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/pages/admin/ckbj.jsp">查看班级</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">考试管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/pages/admin/szquestionpaper.jsp">设置考试</a></dd>
						<dd><a href="/testControl/openTest">开启考场</a></dd>
						<dd><a href="/testControl/closeTest">关闭考场</a></dd>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">教师管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/pages/admin/ckallteacher.jsp">查看教师</a></dd>
						<dd><a href="/teacher/addTeacherAdmin">添加教师</a></dd>
						<%--                        <dd><a href="">超链接</a></dd>--%>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">学生管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/pages/admin/ckallstudent.jsp">查看学生</a></dd>
						<dd><a href="/student/addStudentAdmin">添加学生</a></dd>
						<%--                        <dd><a href="">超链接</a></dd>--%>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">我的信息</a>
					<dl class="layui-nav-child">
						<dd><a href="/admin/selectAdmin;">查看信息</a></dd>
						<dd><a href="/pages/admin_/upw.jsp">修改密码</a></dd>
					</dl>
				</li>
			</ul>
		</div>
	</div>

	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">
			<div class="divtitle">
				<strong>添加教师</strong>
			</div>
			<div id="div1">
				<form id="form1" action="/teacher/addTeacherAdmin" target="mainFrame" onsubmit="return checkForm()">
					<table>
						<tr>
							<td style="text-align:right;">教师编号:</td>
							<td><input id="tid" type="text" name="tid" onblur="checkTid()"/></td>
							<td style="text-align:left;"><span id="tidspan"></span></td>
						</tr>
						<tr>
							<td style="text-align:right;">姓名:</td>
							<td><input id="tname" type="text" name="tname" onblur="checkTname()"/></td>
							<td style="text-align:left;"><span id="tnamespan"></span></td>
						</tr>
						<tr>
							<td style="text-align:right;">密码:</td>
							<td><input id="password" type="text" name="password" onblur="checkPassword()"/></td>
							<td style="text-align:left;"><span id="passwordspan"></span></td>
						</tr>
						<tr>
							<td style="text-align:right;">电话:</td>
							<td><input id="phone" type="text" name="phone" onblur="checkPhone()"/></td>
							<td style="text-align:left;"><span id="phonespan"></span></td>
						</tr>
						<tr>
							<td colspan="3">
								<input style="width:100px; height:30px" type="submit" value="提交"/>
								<input style="width:100px; height:30px" type="reset" value="重置"/>
							</td>
						</tr>
					</table>
				</form>

			</div>
		</div>
	</div>

	<div class="layui-footer">
		<!-- 底部固定区域 -->
		CopyRight© 2019 东北师大在线模拟考试系统
	</div>
</div>

<script>
	//JavaScript代码区域
	layui.use('element', function(){
		var element = layui.element;

	});
</script>
</body>
</html>