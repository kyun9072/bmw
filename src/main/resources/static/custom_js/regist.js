function checkId() {
			var chek= document.getElementById("chkMsg");
			var result;
			var username = $("#username").val();
			if (username == "") {

				$("#chkMsg").html(inputChk);
				chek.style.color = "red";
				return false;
			}

			var isusername = /^[a-z0-9][a-z0-9_\-]{4,19}$/;
			if (!isusername.test(username)) {
				$("#chkMsg").html(regexName);
				chek.style.color = "red";

				return false;
			} else {

				$.ajax({
					url : "/idcheck?username=" + encodeURI(username),
					type : "POST",
					data : username,
					async : false,
					success : function(data) {
						result = data;
						if (data == false) {
							
							$("#chkMsg").html(allow);
							chek.style.color = "green";
						} else {
							$("#chkMsg").html(not_allow);
							chek.style.color = "red";
						}
					}
				});
				return result;
			}
			;
		}

		function checkPw() {
			var pw = $("#password").val();
			if (pw == "") {
				$("#chkPw").show().html(inputChk);
				return false;
			}
			var isPw = /^[A-Za-z0-9]{8,12}$/;
			if (!isPw.test(pw)) {
				$("#chkPw").show().html(regexPw);
				return false;
			} else {
				$("#chkPw").hide();
			}
			return true;
		}
		function checkPw2(){
			var pw = $("#password").val();
			var pw2 = $("#password2").val();
			if(pw2==""){
				$("#chkPw2").show().html(inputChk);
				return false;
			}
			if(pw == pw2){
				$("#chkPw2").hide();
				return true;
			}else{
				$("#chkPw2").show().html(chkPwMsg);
				return false;
			}
		}
		function checkName() {
			var name = $("#name").val();
			if (name == "") {
				$("#chkName").show().html(inputChk);
				return false;
			} else {
				$("#chkName").hide();
				return true;
			}
		}
		function checkEmail() {
			var chek= document.getElementById("chkEmail");
			var email = $("#email").val();
			if (email == "") {
				$("#chkEmail").show().html(inputChk);
				chek.style.color = "red";
				return false;
			} 
				var isEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
				if(!isEmail.test(email)){
					$("#chkEmail").show().html(regexEmail)
					chek.style.color = "red";
					return false;
				}else{
					$.ajax({
						url : "/emailchk?email=" + encodeURI(email),
						type : "POST",
						data : email,
						async : false,
						success : function(data) {
							result = data;
							if (data == false) {
								$("#chkEmail").html(not_allow);
								chek.style.color = "red";

							}else {
							
								$("#chkEmail").html(allow);
								chek.style.color = "green";
							}
						}
					});
					return result;
				};
		}
		function checkPhone() {
			var phone = $("#phone").val();
			if (phone == "") {
				$("#chkPhone").show().html(inputChk);
				return false;
			}
			var isphone = /^\d{3}\d{3,4}\d{4}$/;
			if (!isphone.test(phone)) {
				$("#chkPhone").show().html(regexPhone);
				return false;
			} else {
				$("#chkPhone").hide();
				return true;
			}
		}
		function checkY() {
			var b_year = $("#b_year").val();
			var b_day = $("#b_day").val();
			var b_month = $("#b_month").val();
			if (b_year == "") {
				$("#chkY").show().html(inputChk);
				return false;
			}
				
			var isb_year = /^\d{4}$/;
			if (!isb_year.test(b_year)){
				$("#chkY").show().html(regexYear);
				return false;
			}if(b_month ==""){
				$("#chkY").show().html(regexMonth);
				return false;
				
	 }else if(b_day ==""){
				$("#chkY").show().html(regexDate);
				return false;
			
			}else{
				$("#chkY").hide();
				return true;
			}
			 
 		}
		function conn(){
			console.log("dlapdlf");
			var email = $("#email").val();
			if(checkEmail() == false){
				checkEmail();
				return false;
			}else{
			$.ajax({
				url : "/confirm",
				type : "POST",
				data : {email:email},
				success : function(data) {
					alert("인증번호 발송")
					}
			});
		}
	}
	function checknum(){
			var num = $("#num").val();
	

			$.ajax({
				url : "/num",
				type : "POST",
				data : {num:num},
				async : false,
				success : function(data) {
					test = data;
					console.log(data);
					if(data == true){
						alert("인증하였습니다.")
						
					}else{
						alert("인증값을 확인하세요.")
					}
					}
				
			});
			return test;
		}
	function all() {
		return !checkId() && checkPw() && checkPw2 && checkName() && checkEmail()
				&& checkPhone() && checkY();

	}
	function sign() {
		checkId();
		checkPw();
		checkPw2();
		checkName();
		checkEmail();
		checkPhone();
		checkY();
		var con = $("#cono").val();
		if(con==undefined){
			test=true;
		}
			
		if (all()==true&&test==true) {
			
				alert("가입을 환영합니다.");
				
			return true;
		} else if (test==false||test==undefined){
			alert("인증값을 확인하세요.");
			return false;
		} else{
			return false;
		}

	}