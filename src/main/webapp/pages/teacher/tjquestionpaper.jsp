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
            text-align: center;
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
        #div2 a:link,#div2 a:visited{
            color:#1183C2;
            text-decoration:none;
        }
        #div2 a:hover{
            color:#df4011;
        }
        .pagediv{
            height: 20px;
            float: right;
            margin-bottom: 10px;
            font-size: 12px;
        }
    </style>
    <script type="text/javascript">

        function checkForm(){
            var qt = document.getElementById("qt").value;
            var qscope = document.getElementById("qscope").value;
            var qdifficulty = document.getElementById("qdifficulty").value;
            if(qt == "---请选择题型---"){
                alert("请选择试题类型");
                return false;
            }else if(qscope == "---请选试题范围---"){
                alert("请选择试题范围");
                return false;
            }else if(qdifficulty == "---请选试题难度---"){
                alert("请选择试题难度");
                return false;
            }else{
                return true;
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
                        <dd><a href="/admin/update">修改密码</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <div class="divtitle">
                <strong>查找试题：</strong>
            </div>
            <div class="divtitle2">
                <form action="/questionPaper/tjAdminQuestion?qpid=${questionPaper.qpid}"/>&page=1" target="mainFrame" method="post" onsubmit="return checkForm()">
                    <select id="qt" name="qtid">
                        <option value="---请选择题型---">---请选择题型---</option>
                        <s:iterator var="qt" value="listqt">
                            <option value="<s:property value="#qt.qtid"/>"><s:property value="#qt.qtname"/></option>
                        </s:iterator>
                    </select>
                    <select id="qscope" name="question.qscope">
                        <option value="---请选试题范围---">---请选试题范围---</option>
                        <option value="第一单元">第一单元</option>
                        <option value="第二单元">第二单元</option>
                        <option value="第三单元">第三单元</option>
                        <option value="第四单元">第四单元</option>
                        <option value="第五单元">第五单元</option>
                        <option value="第六单元">第六单元</option>
                        <option value="第七单元">第七单元</option>
                        <option value="第八单元">第八单元</option>
                        <option value="第九单元">第九单元</option>
                        <option value="第十单元">第十单元</option>
                    </select>
                    <select id="qdifficulty" name="question.qdifficulty">
                        <option value="---请选试题难度---">---请选试题难度---</option>
                        <option>简单</option>
                        <option>中等</option>
                        <option>困难</option>
                    </select>
                    <input type="submit" value="搜索"/>
                </form>
            </div>
            <div id="div1">
                <div class="divtitle">
                    <strong>查找要添加的试题：</strong>
                </div>
                <div id="div2">
                    <table border="0px" cellspacing="0px">
                        <tr style="background-color: #DEEFFF">
                            <td style="width:30px;">编号</td>
                            <td style="width:630px;">试题内容</td>
                            <td style="width:70px">试题范围</td>
                            <td style="width:70">试题难度</td>
                            <td>题号</td>
                            <td style="width: 70px">添加试题</td>
                        </tr>
                    </table>
                    <s:iterator value="pageBean.list" var="q">
                        <form action="${pageContext.request.contextPath }/questionPaper_tjAdminQuestionSX.action?qpid=<s:property value="questionPaper.qpid"/>&qid=<s:property value="#q.qid"/>" target="mainFrame" method="post">
                            <table border="0px" cellspacing="0px">
                                <tr>
                                    <td style="width:30px"><s:property value="#q.qid"/></td>
                                    <td style="text-align: left;width:630px;"><s:property value="#q.qcontent"/></td>
                                    <td style="width:70px"><s:property value="#q.qscope"/></td>
                                    <td style="width:70"><s:property value="#q.qdifficulty"/></td>
                                    <td><input name="num" size="3px" type="text"/></td>
                                    <td style="width: 70px"><input type="submit" value="添加试题"/></td>
                                </tr>
                            </table>
                        </form>
                    </s:iterator>
                    <div class="pagediv">
                        <s:if test="pageBean.list != null">
                            <span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页&nbsp;</span>
                            <s:if test="pageBean.page != 1">
                                <a href="${pageContext.request.contextPath }/questionPaper_tjAdminQuestion.action?qpid=<s:property value="questionPaper.qpid"/>&page=<s:property value="pageBean.page-1"/>&qid=<s:property value="pageBean.list[0].qid"/>&qtid=<s:property value="pageqtid"/>">&nbsp;上一页&nbsp;</a>
                            </s:if>
                            <s:iterator var="i" begin="1" end="pageBean.totalPage">
                                <a href="${pageContext.request.contextPath }/questionPaper_tjAdminQuestion.action?qpid=<s:property value="questionPaper.qpid"/>&page=<s:property value="#i"/>&qid=<s:property value="pageBean.list[0].qid"/>&qtid=<s:property value="pageqtid"/>">&nbsp;<s:property value="#i"/>&nbsp;</a>
                            </s:iterator>
                            <s:if test="pageBean.page != pageBean.totalPage">
                                <a href="${pageContext.request.contextPath }/questionPaper_tjAdminQuestion.action?qpid=<s:property value="questionPaper.qpid"/>&page=<s:property value="pageBean.page+1"/>&qid=<s:property value="pageBean.list[0].qid"/>&qtid=<s:property value="pageqtid"/>">&nbsp;下一页</a>
                            </s:if>
                        </s:if>
                    </div>
                </div>
                <div class="divtitle">
                    <strong>该试卷已有试题：</strong>
                </div>
                <div id="div2">
                    <table border="0px" cellspacing="0px">
                        <tr style="background-color: #DEEFFF">
                            <td style="width: 70px">试题编号</td>
                            <td style="width:620px;">试题内容</td>
                            <td style="width:70px">试题范围</td>
                            <td style="width:70">试题难度</td>
                            <td>题号</td>
                        </tr>
                        <s:iterator value="listqpq" var="qpq">
                            <tr>
                                <td><s:property value="#qpq.question.qid"/></td>
                                <td style="text-align: left;"><s:property value="#qpq.question.	qcontent"/></td>
                                <td><s:property value="#qpq.question.qscope"/></td>
                                <td><s:property value="#qpq.question.qdifficulty"/></td>
                                <td><s:property value="#qpq.num"/></td>
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