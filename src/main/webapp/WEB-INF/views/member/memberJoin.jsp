<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootStrap.jsp"></c:import>	
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
	<h3>Member Join Page</h3>
	<form action="./memberJoin" method="post" id="frm">
	    <div class="form-group" >
	      <label for="id" id="id2">ID:</label>
	      <input type="text" class="form-control" id="id" placeholder="Enter ID" name="id">
<<<<<<< Updated upstream
=======
	      <div id="idResult"></div>
>>>>>>> Stashed changes
	    </div>
	    
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
	    </div>
	    
	     <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw2" placeholder="Enter password" name="pw2">
	    </div>
	    
	   	 <div class="form-group">
	      <label for="name">Name:</label>
	      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
	    </div> 
	    
	   	<div class="form-group">
	      <label for="email">Email:</label>
	      <input type="text" class="form-control" id="email" placeholder="Enter Email" name="email">
	    </div>
	    
	    
	    <button type="submit" class="btn btn-default" id="btn">Submit</button>
	</form>
</div>
<<<<<<< Updated upstream
		<script type="text/javascript" src="../resources/js/boardWrite.js"></script>
=======
<script type="text/javascript">
	$("#id2").on("blur", "#id", function() {
		var id = $("#id").val();
		
		$.post("./memberCheck", {id:id}, function(result) {
			alert(result);
			if(result == 1){
				$("#idResult").text("중복된 ID")
			}else if(result == 0){
				$("#idResult").text("사용 가능한 ID")
			}
		});
		
	});
		


	
</script>


>>>>>>> Stashed changes
</body>
</html>