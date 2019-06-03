<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>在线考试系统</title>
    <!--引入css，否则没有样式-->
    <script src="${ctx}/static/plugins/layui/layui.js"></script>
    <link rel="stylesheet" href="${ctx}/static/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">在线考试系统</div>
        <!--&lt;!&ndash; 头部区域（可配合layui已有的水平导航） &ndash;&gt;-->
        <!--<ul class="layui-nav layui-layout-left">-->
        <!--<li class="layui-nav-item"><a href="">控制台</a></li>-->
        <!--<li class="layui-nav-item"><a href="">商品管理</a></li>-->
        <!--<li class="layui-nav-item"><a href="">用户</a></li>-->
        <!--<li class="layui-nav-item">-->
        <!--<a href="javascript:;">其它系统</a>-->
        <!--<dl class="layui-nav-child">-->
        <!--<dd><a href="">邮件管理</a></dd>-->
        <!--<dd><a href="">消息管理</a></dd>-->
        <!--<dd><a href="">授权管理</a></dd>-->
        <!--</dl>-->
        <!--</li>-->
        <!--</ul>-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="">基本资料</a></dd>--%>
<%--                    <dd><a href="">安全设置</a></dd>--%>
<%--                </dl>--%>
            </li>
            <li class="layui-nav-item"><a href="">退出登录</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">题库管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查找试题</a></dd>
                        <dd><a href="javascript:;">添加选择题</a></dd>
                        <dd><a href="javascript:;">添加判断题</a></dd>
                        <dd><a href="javascript:;">添加读程序题</a></dd>
<%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">试卷管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看试卷</a></dd>
                        <dd><a href="javascript:;">添加试卷</a></dd>
<%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">班级管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看班级</a></dd>
<%--                        <dd><a href="javascript:;">添加试卷</a></dd>--%>
                        <%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">考试管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">设置考试</a></dd>
                        <dd><a href="javascript:;">开启考场</a></dd>
                        <dd><a href="javascript:;">关闭考场</a></dd>
                        <%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">教师管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看教师</a></dd>
                        <dd><a href="javascript:;">添加教师</a></dd>
                        <%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">学生管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看学生</a></dd>
                        <dd><a href="javascript:;">添加学生</a></dd>
                        <%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">我的信息</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看信息</a></dd>
                        <dd><a href="javascript:;">修改密码</a></dd>
                        <%--                        <dd><a href="">超链接</a></dd>--%>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

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