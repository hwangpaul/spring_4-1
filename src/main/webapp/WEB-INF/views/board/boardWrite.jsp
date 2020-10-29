<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	#f {
		display: none;
	}

    .del {
        color: red;
        font-weight: bold;
        cursor: pointer;
    }
</style>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
  <h2>${board} Write Form</h2>
  <form id="frm" action="./${board}Write" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control"  id="title" placeholder="Enter Title" name="title">
    </div>
    
	<div class="form-group">
      <label for="writer">Writer:</label>
      <input type="text" class="form-control" readonly="readonly" value="${member.id}" id="writer" placeholder="Enter Writer" name="writer">
    </div>
    
     <div class="form-group">
      <label for="contents">Contents:</label>
      <textarea class="form-control" rows="10" id="contents" name="contents"></textarea>
    </div>  
    
	<input type="button" value="File Add" class="btn btn-info" id="fileadd">
	
	
	<div id="files">
	
	</div>
		
    
    
    <input type="button" class="btn btn-primary" value="Write" id="btn">
    <button type="submit" class="btn btn-default">Write</button>
    <button>TestButton</button>
     
  </form>
  <div id="f">
       <div class="input-group">
        <input id="file" type="file" class="form-control" name="files">
        <span class="input-group-addon del">DEL</span>
      </div>
	</div>
    
</div>
<script type="text/javascript">
	var count = 0;
	
	$("#files").on("click", ".del", function() {
		$(this).parent().remove();
		count --;
	});	

	$("#fileadd").click(function () {
		
		if(count<5){
		var f = $("#f").html().trim();
		
		$("#files").append(f);
		count++;
		}else{
			alert("첨부파일은 최대 5개")
		}
	});
	


</script>

</body>
</html>