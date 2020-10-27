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
		<h1>Memo Page</h1>
		
		
	<div>
			<div class="form-group">
    	 	 <label for="writer">Writer:</label>
      		<input type="text" class="form-control" id="writer" placeholder="Enter Writer" name="writer">
    	</div>
    
   		 <div class="form-group">
      		<label for="contents">Contents:</label>
      		<textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    	</div>  
    	
    		<div class="form-group">
			 <button type="submit" class="btn btn-default" id="write">Write</button>
			 </div>
	</div>
		
		
		<div>
			<table id="result" class="table table-border">
			
			</table>
		</div>
		<button class="btn btn-danger" id="more">더보기</button>
		
	</div>

<script type="text/javascript">
	

	getList();
	
	//************ more ****************
	$("#more").click(function() {
		getList();
		
	})
	
	
	
	
	//************** DEL **************
	$("#result").on("click", ".del", function() {
		var num = $(this).attr("title")
		
		$.ajax({
			url : "./memoDelete",
			type : "POST",
			data : {num:num},
			success : function(data) {
				data=data.trim();
				
				if(data>0) {
					alert("Delete Success")
					getList();
				}else {
					alert("Delete Fail")
					
				}
				
			}
				
		});
						
	});
	
	
	//**********************************
	$("#write").click(function() {
		var writer = $("#writer").val();
		var contents = $("#contents").val();
		
		$.ajax({
			url : "./memoWrite",
			type : "POST",
			data : {writer:writer, contents:contents},
			success : function(result) {
				alert(result);
				$("#writer").val('');
			    $("#contents").val('');
				getList();
			}
			
		});
		
		
	});
	
	//**********************************
	
	
	function getList() {
		
		$.ajax({
			url : "./memoList",
			type : "GET",
			success : function (data) {
				$("#result").append(data);
			}
		});
		
	
		}

			
</script>
</body>
</html>