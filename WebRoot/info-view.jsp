<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/base.css" />
<link rel="stylesheet" href="css/info-reg.css" />
<title>移动办公自动化系统</title>
</head>

<body>
<div class="title"><h2>题目录入</h2></div>
<div class="main">
	<!--  <p class="short-input ue-clear">
    	<label>来文时间：</label>
        <input type="text" placeholder="来文时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
        <span><em>*</em>请输入正确的时间格式</span>
    </p>
    <p class="short-input ue-clear">
    	<label>收文时间：</label>
        <input type="text" placeholder="收文时间" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" />
    </p> -->
    <form action="question?who=insert" method="post" id="form1">
    
    <p class="short-input ue-clear">
    	<label>试题编号：</label>
        <input type="text" value="${question.queId}" name="queId" id="queId" readonly="true"/> 
    </p>
    
    <p class="short-input ue-clear">
    	<label>试题类别：</label>
        <input type="text" value="${question.queCate}" name="queCate" id="queCate" readonly="true"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>所属科目：</label>
        <input type="text" value="${question.queSubject}" name="queSubject" id="queSubject" readonly="true"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>试题内容：</label>
        <input type="text" value="${question.queBody}" name="queBody" id="queBody" readonly="true"/>
    </p>
    
    <p class="short-input ue-clear">
    	<label>试题答案：</label>
        <input type="text" value="${question.queAns}" name="queAns" id="queAns" readonly="true"/>
    </p>
       
    <p class="short-input ue-clear">
    	<label>难度系数：</label>
        <input type="text" value="${question.queDiff}" name="queDiff" id="queDiff" readonly="true"/>
    </p>
       
    <p class="short-input ue-clear">
    	<label>试题状态：</label>
        <input type="text" value="${question.queCon}" name="queCon" id="queCon" readonly="true"/>
    </p>
    
    </form>
</div>



</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
$(".select-title").on("click",function(){
	$(".select-list").toggle();
	return false;
});
$(".select-list").on("click","li",function(){
	var txt = $(this).text();
	$(".select-title").find("span").text(txt);
});

function submit_a(){
	//var frm = document.getElementById("form1");
	form1.submit();
}

function reset_a(){
	form1.reset();
}

showRemind('input[type=text], textarea','placeholder');



</script>
</html>
