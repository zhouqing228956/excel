<%--
  User: ZHOU
  Date: 2018/10/14
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>电力监测</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <%--映入echart--%>
    <script src="js/echarts.common.min.js"></script>
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>


    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">电力监测表</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/detail" id="form1" method="post">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入日期" name="riqi">
                                <span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
                            </div>
                        </form>
                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>点位</th>
                        <th>日期</th>
                        <th>高程</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  items="${list}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.point}</td>
                            <td>${item.riqi}</td>
                            <td>${item.attu}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info" onClick="location.href='#'">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='#'">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <jsp:include page="foot.jsp"></jsp:include>
        <div class="col-md-12"></div>
    </div>
</div>
</body>
<script type="text/javascript">
    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    }
    $("#sub").click(function () {
        $("#form1").submit();
    });
</script>
</html>