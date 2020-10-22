<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
  <h3>${board} list</h3>
  <form action="./${board}List">
  	<div class="input-group">
   		<span class="input-group-addon">Text</span>
   		
   	<div class="form-group">
  	<label for="sel1">Select list:</label>
  	<select class="form-control" id="sel1" name="kind">
    	<option value="tt">Title</option>
   	 	<option value="wr">Writer</option>
    	<option value="con">Contents</option>
  	</select>
	</div>
    	<input id="msg" type="text" class="form-control" name="search" placeholder="Additional Info">
    	
    	<div class="input-group-btn">
      		<button class="btn btn-default" type="submit">
        	<i class="glyphicon glyphicon-search"></i>
      		</button>
    	</div>
  	</div>
  
  </form>
  <table class="table table-hober">
  	<tr>
  		<td>Num</td>
  		<td>Title</td>
  		<td>Writer</td>
  		<td>Date</td>
  		<td>Hit</td>
  	</tr>
  	<c:forEach items="${list}" var ="dto" varStatus="vs">
  	<tr>
  		<td>${dto.num}  :  ${vs.count} </td>
  		<td>
  			<a href="./${board}Select?num=${dto.num}">
  			<c:catch>
  			<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
  			</c:catch>
  			${dto.title}
  			</a>
  		</td>
  		<td>${dto.writer}</td>
  		<td>${dto.regDate}</td>
  		<td>${dto.hit}</td>
  	</tr>
  	</c:forEach>
  	
  	
  </table>

  <div>
  	<c:if test="${pager.beforeCheck}">
  	<a href="./${board}List?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${search}">[이전]</a>
  	</c:if>
  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
  		<a href="./${board}List?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
  	</c:forEach>
  	
  	<c:if test="${pager.nextCheck}">
  	<a href="./${board}List?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">[다음]</a>
  	 </c:if>  
  </div>
	
	
  <a href="./${board}Write" class="btn btn-danger">Write</a>
  

</div>
</body>
</html>