<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		function checkState(){
			var state = document.getElementById("state").value;
			var statespan = document.getElementById("statespan");
			var flag;
			if(state == "----考场状态----"){
				statespan.innerHTML = "* 请选择考场状态".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				statespan.innerHTML = "";
				flag = true;
			}
			return flag;
		}
		function checkMode(){
			var mode = document.getElementById("mode").value;
			var trqpid = document.getElementById("trqpid");
			var modespan = document.getElementById("modespan");
			var flag;
			if(mode == "----考试方式----"){
				modespan.innerHTML = "* 请选择考试方式".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				if(mode == 3){
					trqpid.style.display = "table-row";
				}else{
					trqpid.style.display = "none";
				}
				modespan.innerHTML = "";
				flag = true;
			}
			return flag;
		}
		function checkTname(){
			var tname = document.getElementById("tname").value;
			var tnamespan = document.getElementById("tnamespan");
			var flag;
			if(tname == ""){
				tnamespan.innerHTML = "* 请输入考试名称".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				tnamespan.innerHTML = "";
				flag = true;
			}
			return flag;
		}
		function checkQpid(){
			var qpid = document.getElementById("qpid").value;
			var qpidspan = document.getElementById("qpidspan");
			var flag;
			if(qpid == -1){
				qpidspan.innerHTML = "* 请指定试卷".fontcolor("red").fontsize("2px");
				flag = false;
			}else{
				qpidspan.innerHTML = "";
				flag = true;
			}
			return flag;
		}
		function checkForm(){
			var qpid = document.getElementById("qpid").value;
			var qpidspan = document.getElementById("qpidspan");
			var mode = document.getElementById("mode").value;
			if(mode == 3){
				if(qpid == -1){
					qpidspan.innerHTML = "* 请指定试卷".fontcolor("red").fontsize("2px");
					return false;
				}
			}
			if(checkState() && checkMode() && checkTname()){
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
						<dd><a href="/pages/admin/addquestionxz.jsp">添加选择题</a></dd>
						<dd><a href="/pages/admin/addquestionpd.jsp">添加判断题</a></dd>
						<dd><a href="/pages/admin/addquestiontk.jsp">添加读程序题</a></dd>
						<%--                        <dd><a href="">超链接</a></dd>--%>
					</dl>
				</li>
				<li class="layui-nav-item">
					<a href="javascript:;">试卷管理</a>
					<dl class="layui-nav-child">
						<dd><a href="/questionPaper/ckAdminQuestionPaper">查看试卷</a></dd>
						<dd><a href="/pages/admin/szquestionpaper.jsp">添加试卷</a></dd>
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
						<dd><a href="/testControl/szTest">设置考试</a></dd>
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
		<div class="divtitle">
			<strong>设置考试</strong>
		</div>
		<div id="div1">
			<form id="form1" action="/testControl/addTestControl"  target="mainFrame" onsubmit="return checkForm()">
				<table>
					<tr>
						<td style="text-align:right;">考场状态:</td>
						<td>
							<select name="state" id="state" onblur="checkState()">
								<option value="----考场状态----">----考场状态----</option>
								<option value=1>开启考场</option>
								<option value=0>关闭考场</option>
							</select>
						</td>
						<td style="text-align:left;"><span id="statespan"></span></td>
					</tr>
					<tr>
						<td style="text-align:right;">考试方式:</td>
						<td>
							<select name="mode" id="mode" onblur="checkMode()">
								<option value="----考试方式----">----考试方式----</option>
								<option value=2>随机抽卷</option>
								<option value=3>指定试卷</option>
							</select>
						</td>
						<td style="text-align:left;"><span id="modespan"></span></td>
					</tr>

					<tr>
						<td style="text-align:right;">考试名称:</td>
						<td><input id="tname" type="text" name="tname" onblur="checkTname()"/></td>
						<td style="text-align:left;"><span id="tnamespan"></span></td>
					</tr>
					<tr id="trqpid" style="display: none;">
						<td style="text-align:right;">指定试卷:</td>
						<td>
							<select name="qpid" id="qpid" onblur="checkQpid()">
								<option value="-1">----指定试卷----</option>
								<c:forEach items="list" var="qp">
									<option value="${qp.qpid}">第<s:property value="${qp.qpid}"/>套试卷</option>
								</c:forEach>
							</select>
						</td>
						<td style="text-align:left;"><span id="qpidspan"></span></td>
					</tr>
					<tr>
						<td colspan="3">
							<input style="width:100px; height:30px" type="submit" value="提交设置"/>
							<input style="width:100px; height:30px" type="reset" value="重置"/>
						</td>
					</tr>
				</table>
			</form>

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