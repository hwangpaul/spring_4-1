/**
 * 
 */
 
	$("#btn").click(function() {
		var id = $("#id").val()
		var pw = $("#pw").val()
		var name = $("#name").val()
		
		var ch1 = false;
		var ch2 = false;
		var ch3 = false;
		
		if(id != ''){
			ch1 = true;
		} 	
		
		if(pw != ''){
			ch2 = true;
		}
		
		if(name != ''){
			ch3 = true;
		}
		
		if(ch1 && ch2 && ch3){
			$("#frm").submit();
		}else{
			alert("필수 항목을 입력");
		}

		
		
	});
	
