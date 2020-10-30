<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>	
<title>Insert title here</title>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
  
<div class="container">
  <h3>${board} Select Page</h3>
  	<h3 id="num">Num : ${dto.num}</h3>
  	<h3>Title : ${dto.title}</h3>
  	<h3>Writer : ${dto.writer}</h3>
  	<h3>Contents : ${dto.contents}</h3>
  	
  	<div>
  	<c:forEach items="${dto.boardFileDTOs}" var="file">
  		<a href="../resources/upload/${board}/${file.fileName}">${file.oriName}</a>
  		<hr> 
  	</c:forEach>
  	</div>
  	
  	<input type="button" title="${dto.num}" value="Delete" class="btn btn-warning" id="del">
  	<input type="button" value="Update" class="btn btn-primary" id="update">
  	<c:if test="${board ne 'notice'}">
  	<a href="./${board}Reply?num=${dto.num}" class="btn btn-info">Reply</a>
  	</c:if>
</div>

<script type="text/javascript">
	//$("css선택자").action();
	$("#update").click(function() {
		location.href = "./${board}Update?num=${dto.num}";
	});
		
	
	$("#del").click(function(){
		//var num = $("#num").html();
		var num = $(this).attr("title");
		
		location.href="./${board}Delete?num="+num;	
	});
	

	

</script>	