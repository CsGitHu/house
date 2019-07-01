<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD><TITLE>青鸟租房 -发布房屋信息</TITLE>
    <META content="text/html; charset=utf-8" http-equiv=Content-Type>
    <LINK rel=stylesheet type=text/css href="${pageContext.request.contextPath}/css/style.css">
    <META name=GENERATOR content="MSHTML 8.00.7601.17514">
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function () {
            //网页加载完成显示
            showStreet($("#district").val());
            //给区域添加改变事件，显示对应的街道
            $("#district").change(function () {
                //获取区域的id,去后台查询对应的街道
                var did = $(this).val();
                //发送异步请求获取街道
                showStreet(did);
            });

        });

        function showStreet(did) {
            $.post("getStreetByDid", {did: did}, function (data) {
                console.log(data)
                $("#streetDid > option").remove(); //清空选项
                for (var i = 0; i < data.length; i++) {
                    //创建一个dom节点
                    var option = $("<option value=" + data[i].id + ">" + data[i].name + "</option>");
                    $("#streetDid").append(option);  //追加节点
                }
                //设置选中项
                $("#streetDid").val("${house.streetId}");

            }, "json");
        }

    </script>
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="${pageContext.request.contextPath}/images/logo.gif"></DIV>
    <DIV class=search><h2 style="color: #CC2222">【欢迎:${user.name}】
    </h2><LABEL class="ui-green searchs"><a
            href="goFaBu" title="">发布房屋信息</a></LABEL>
        <LABEL class="ui-green searchs"><a href="${pageContext.request.contextPath}/page/getUserHouse" title="">管理房屋信息</a></LABEL>
        <LABEL class=ui-green><INPUT onclick='document.location="index.jsp"' value="退       出" type=button name=search></LABEL>
    </DIV>

</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DL class=clearfix>
            <DT>新房屋信息发布</DT>
            <DD class=past>填写房屋信息</DD>
        </DL>
        <DIV class=box>
            <FORM id=add_action method=post name=ss
                  action="/page/updateHouse" enctype="multipart/form-data">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <input type="hidden" name="id" value="${house.id}"/>
                            <TD class=field>标　　题：</TD>
                            <TD><INPUT id=add_action_title class=text type=text value="${house.title}" name=title></TD>
                        </TR>
                        <TR>
                            <TD class=field>户　　型：</TD>
                            <TD><SELECT class=text name=typeId>
                                <c:forEach items="${types}" var="t">
                                    <OPTION
                                            <c:if test="${t.id==house.typeId}">selected="selected"</c:if>
                                            value=${t.id}>${t.name}</OPTION>
                                </c:forEach>
                            </SELECT>
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>面　　积：</TD>
                            <TD><INPUT id=add_action_floorage class=text type=text value="${house.floorage}"
                                       name=floorage></TD>
                        </TR>
                        <TR>
                            <TD class=field>价　　格：</TD>
                            <TD><INPUT id=add_action_price class=text type=text value="${house.price}" name=price></TD>
                        </TR>
                        <TR>
                            <TD class=field>发布日期：</TD>
                            <TD><INPUT class=text type=date name=pubdate
                                       value="<f:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"></f:formatDate>">
                            </TD>
                        </TR>
                        <TR>
                            <TD class=field>位　　置：</TD>
                            <TD>区：
                                <SELECT class=text id="district" name=district_id>
                                    <c:forEach items="${districts}" var="d">
                                        <OPTION
                                                <c:if test="${house.distrctid==d.id}">selected="selected"</c:if>
                                                value=${d.id}>${d.name}</OPTION>
                                    </c:forEach>
                                </SELECT>

                                街：<SELECT id="streetDid" class=text
                                          name=streetId>
                                    <OPTION selected value=1001>请选择街道</OPTION>
                                </SELECT></TD>
                        </TR>
                        <TD class=field>联系方式：</TD>
                        <TD><INPUT id=add_action_contact class=text type=text value="${house.contact}" name=contact>
                        </TD>
                        </TR>
                        <TR>
                        <TR>
                            <TD class=field>图片：</TD>
                            <TD>
                                <img src="http://localhost:80/${house.path}?a=<%=Math.random()%>" width="50%"
                                     height="30%">
                                <input type="hidden" name="oldPic" value="${house.path}"/>
                                <INPUT id=sss name="pfile" class=text type=file></TD>
                        </TR>
                        <TR>
                            <TD class=field>详细信息：</TD>
                            <TD><TEXTAREA name=description>${house.description}</TEXTAREA></TD>
                        </TR>
                        </TBODY>
                    </TABLE>
                    <DIV class=buttons>
                        <INPUT value=立即更新 name="dd" type=submit>
                    </DIV>
                </DIV>
            </FORM>
        </DIV>
    </DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2018 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>
</BODY>
</HTML>
