<%--
  User: ZHOU
  Date: 2018/10/14
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a data-toggle="modal" data-target="#myModal">excel导入<span class="badge pull-right">1</span></a></li>
        <li><a href="/export">excel导出<span class="badge pull-right">2</span></a></li>
        <li><a href="/admin/showTeacher">文件上传<span class="badge pull-right">3</span></a></li>
        <li><a href="/admin/userPasswordRest">文件下载<sapn class="badge pull-right" />4</a></li>
        <li><a href="/admin/passwordRest">个人信息<sapn class="badge pull-right" />5</a></li>
        <li><a href="/logout">退出系统<sapn class="badge pull-right" />6</a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    导入
                </h4>
            </div>
            <form action="/upload" method="post" enctype="multipart/form-data">
            <div class="modal-body">
                <input type="file" name="upFile">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消
                </button>
                <input type="submit" class="btn btn-primary" value="确定"/>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>