<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css"/>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/users.js"></script>
</head>
<body>
<table id="dg"></table>


<!--定义工具栏-->
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a href="javascript:ModifyBySelect()" class="easyui-linkbutton"
           iconCls="icon-edit" plain="true">修改</a>
        <a href="javascript:DeleteByFruitName()" class="easyui-linkbutton"
           iconCls="icon-remove" plain="true">删除</a>
    </div>

    <!--搜索条件-->
    <div>
        姓名:<input type="text" name="name" id="name"/>
        电话:<input type="text" name="telephone" id="telephone"/>
        开始年龄:<input type="text" name="startAge" id="startAge"/>
        结束年龄:<input type="text" name="endAge" id="endAge"/>
        <a id="btn" href="javascript:searchUser();" class="easyui-linkbutton"
           data-options="iconCls:'icon-search'">搜索</a>

    </div>

</div>

<!--添加窗口-->
<div id="AddDialog" class="easyui-dialog" buttons="#AddDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="SaveDialogForm" method="post">
        <table>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td><input type="text" name="telephone"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age"/></td>
            </tr>

        </table>
    </form>
</div>

<!--给添加对话框添加按钮-->
<div id="AddDialogButtons">
    <a href="javascript:SaveDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a>
    <a href="javascript:CloseDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>


<!--修改对话框-->
<div id="upDialog" class="easyui-dialog" buttons="#upDialogButtons"
     style="width: 280px; height: 250px; padding: 10px 20px;" closed="true">
    <form id="upDialogForm" method="post">
        <table>
            <tr>
                <td><input type="hidden" name="id"/></td>
            </tr>
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td><input type="text" name="telephone"/></td>
            </tr>
            <tr>
                <td>年龄:</td>
                <td><input type="text" name="age"/></td>
            </tr>
        </table>
    </form>
</div>

<!--给修改对话框添加修改按钮-->
<div id="upDialogButtons">
    <a href="javascript:updateDialog()" class="easyui-linkbutton"
       iconCls="icon-ok">修改</a>
    <a href="javascript:CloseupDialog()"
       class="easyui-linkbutton" iconCls="icon-cancel">取消</a>
</div>
</body>
</html>
