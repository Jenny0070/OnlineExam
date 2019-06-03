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
		}#div1{
			 margin:60px 0 0 0;
			 padding:0px;
			 width:100%;
			 height:99%;
			 font-size:14px;
			 position:absolute;
			 text-align: center;
		 }
		#div2{
			margin:0 0 0 30px;
			padding:0px;
			width:900px;
			border: 1px solid #F0F0F0;
		}

		.divtitle{
			height: 40px;
			line-height: 40px;
			color: #3180D8;
			font-family: "Microsoft YaHei";
			border-bottom: 1px dotted #ededed;
			float: left;
		}
		.divtitle2{
			margin: 10px 0 0 50px;
			float:left;
		}
		table{
			border:0px;
			margin:0px;
			padding:0px;
			width:100%;
			text-align: left;
			font-size: 12px;
			color:#6D6D6D;
		}
		tr{
			margin:0px;
			padding:0px;
		}
		td{
			margin:0px;
			padding:0px;
			border-bottom: 1px solid #F0F0F0;
		}
	</style>
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
				<strong>查看相似试题：</strong>
			</div>
			<div class="divtitle2">
				<form action="${pageContext.request.contextPath }/question_addAdminQuestionTKSX.action?qtid=3" target="mainFrame" method="post">
					<table style="display: none">
						<tr>
							<td style="text-align: right; width: 80px;">题目</td>
							<td style="text-align: left;">
								<textarea id="qcontent" name="qcontent" style="resize:none; overflow-y:scroll" cols="40" rows="4"><s:property value="question.qcontent"/></textarea>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">选项A</td>
							<td style="text-align: left;">
								<input id="aoption" name="aoption" size="80px" type="text" value="<s:property value="question.aoption"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">选项B</td>
							<td style="text-align: left;">
								<input id="boption" name="boption" size="80px" type="text" value="<s:property value="question.boption"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">选项C</td>
							<td style="text-align: left;">
								<input id="coption" name="coption" size="80px" type="text" value="<s:property value="question.coption"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">选项D</td>
							<td style="text-align: left;">
								<input id="doption" name="doption" size="80px" type="text" value="<s:property value="question.doption"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">正确答案</td>
							<td style="text-align: left;">
								<input id="qanswer" name="qanswer" size="80px" type="text" value="<s:property value="question.qanswer"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">试题范围</td>
							<td style="text-align: left;">
								<input id="qscope" name="qscope" type="text" value="<s:property value="question.qscope"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">试题难度</td>
							<td style="text-align: left;">
								<input id="qdifficulty" name="qdifficulty" type="text" value="<s:property value="question.qdifficulty"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">关键字</td>
							<td style="text-align: left;">
								<input id="oword" name="oword" type="text" value="<s:property value="question.oword"/>"/>
							</td>
						</tr>
						<tr>
							<td style="text-align: right; width: 80px;">试题解析</td>
							<td style="text-align: left;">
   						<textarea id="qanalysis" name="qanalysis" style="resize:none; overflow-y:scroll" cols="40" rows="4">
   							<s:property value="question.qanalysis"/>
   						</textarea>
							</td>
						</tr>
					</table>
					<input type="submit" value="确定添加试题"/>&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/question_addAdminQuestionTK.action">重新添加试题</a>
				</form>

			</div>
			<div id="div1">
				<div id="div2">
					<table border="0px" cellspacing="0px">
						<tr style="background-color: #DEEFFF">
							<td style="width: 70px">试题编号</td>
							<td style="width:620px">试题内容</td>
							<td>试题答案</td>
						</tr>
						<s:iterator value="listxs" var="q">
							<tr>
								<td><s:property value="#q.qid"/></td>
								<td><s:property value="#q.qcontent"/></td>
								<td><s:property value="#q.qanswer"/></td>
							</tr>
						</s:iterator>
					</table>

				</div>
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