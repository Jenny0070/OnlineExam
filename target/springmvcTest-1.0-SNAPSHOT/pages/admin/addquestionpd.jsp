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

        .divtitle{
            height: 40px;
            line-height: 40px;
            color: #3180D8;
            font-family: "Microsoft YaHei";
            border-bottom: 1px dotted #ededed;
        }
        #div1{
            margin:0px;
            padding:0px;
            width:100%;
            height:99%;
            font-size:14px;
            position:absolute;
            text-align: center;
        }
        #div2{
            margin:0 0 0 120px;
            padding:0px;
            width:700px;

            text-align: center;
            background-color: #A7D4F5;
            border: 2px solid #22546B;
        }
        table{
            border:0px;
            margin:0px;
            padding:0px;
            width:100%;
            text-align: center;
            font-size: 14px;
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
    <script type="text/javascript">
        function checkQcontent(){
            var qcontent = document.getElementById("qcontent").value;
            var qcontentspan = document.getElementById("qcontentspan");
            var flag;
            if(qcontent == ""){
                qcontentspan.innerHTML = "* 不能为空".fontcolor("red").fontsize("1px");
                flag = false;
            }else{
                qcontentspan.innerHTML = "";
                flag = true;
            }
            return flag;
        }

        function checkQscope(){
            var qscope = document.getElementById("qscope").value;
            var qsd = document.getElementById("qsd");

            var flag;
            if(qscope == "---请选择试题范围---"){
                qsd.innerHTML = "* 请选择试题范围".fontcolor("red").fontsize("1px");
                flag = false;
            }else{
                qsd.innerHTML = "";
                flag = true;
            }
            return flag;
        }
        function checkQanswer(){
            var qanswer = document.getElementById("qanswer").value;
            var qanswerspan = document.getElementById("qanswerspan");
            var flag;
            if(qanswer == "---请选择答案---"){
                qanswerspan.innerHTML = "* 请输入正确答案".fontcolor("red").fontsize("1px");
                flag = false;
            }else{
                qanswerspan.innerHTML = "";
                flag = true;
            }
            return flag;
        }
        function checkQdifficulty(){
            var qdifficulty = document.getElementById("qdifficulty").value;
            var qsd = document.getElementById("qsd");
            var flag;
            if(qdifficulty == "---请选择试题难度---"){
                qsd.innerHTML = "* 请选择试题难度".fontcolor("red").fontsize("1px");
                flag = false;
            }else{
                qsd.innerHTML = "";
                flag = true;
            }
            return flag;
        }
        function checkOword(){
            var oword = document.getElementById("oword").value; //关键字
            var owordspan = document.getElementById("owordspan");
            var flag;
            if(oword == ""){
                owordspan.innerHTML = "* 请输入关键字".fontcolor("red").fontsize("1px");
                flag = false;
            }else{
                owordspan.innerHTML = "";
                flag = true;
            }
            return flag;
        }

        function checkQanalysis(){
            var qanalysis = document.getElementById("qanalysis").value;
            var qanalysisspan = document.getElementById("qanalysisspan");
            var flag ;
            if(qanalysis == ""){
                qanalysisspan.innerHTML = "* 请输入解析".fontcolor("red").fontsize("1px");
                flag = false;
            }else{
                qanalysisspan.innerHTML = "";
                flag = true;
            }
            return flag;
        }

        function checkForm(){
            if(checkQcontent() && checkQanswer() && checkQscope() && checkQdifficulty() && checkOword() && checkQanalysis()){
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
                <strong>添加判断题：</strong>
            </div>
            <div id="div1">
                <div id="div2">
                    <form id="form1" action="/question/addQuestionPD?qtid=2"  target="mainFrame" onsubmit="return checkForm()">
                        <table>
                            <tr>
                                <td style="text-align: right; width: 80px;">题目</td>
                                <td style="text-align: left;">
                                    <textarea id="qcontent" name="qcontent" style="resize:none; overflow-y:scroll" cols="40" rows="4" onblur="checkQcontent()"></textarea>
                                    <span id="qcontentspan"></span>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right; width: 80px;">正确答案</td>
                                <td style="text-align: left;">
                                    <select id="qanswer" name="qanswer" onblur="checkQanswer()">
                                        <option value="---请选择答案---">---请选择答案---</option>
                                        <option value="对">对</option>
                                        <option value="错">错</option>
                                    </select>

                                    <span id="qanswerspan"></span>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right; width: 80px;">试题范围</td>
                                <td style="text-align: left;">
                                    <select id="qscope" name="qscope" onblur="checkQscope()">
                                        <option value="---请选择试题范围---">---请选择试题范围---</option>
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
                                    试题难度<select id="qdifficulty" name="qdifficulty" onblur="checkQdifficulty()">
                                    <option value="---请选择试题难度---">---请选择试题难度---</option>
                                    <option value="简单">简单</option>
                                    <option value="中等">中等</option>
                                    <option value="困难">困难</option>
                                </select>
                                    <span id="qsd"></span>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right; width: 80px;">关键字</td>
                                <td style="text-align: left;">
                                    <input id="oword" name="oword" type="text" onblur="checkOword()"/>
                                    <span id="owordspan">* 关键字表示该试题所考察的知识点</span>

                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: right; width: 80px;">试题解析</td>
                                <td style="text-align: left;">
                                    <textarea id="qanalysis" name="qanalysis" style="resize:none; overflow-y:scroll" cols="40" rows="4" onblur="checkQanalysis()"></textarea>
                                    <span id="qanalysisspan"></span>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2"><input style="width: 100px;" type="submit" value="添加试题"/><input style="width: 100px;" type="reset"  value="重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置"></td>
                            </tr>
                        </table>
                    </form>
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