$(function(){
	$('#username').blur(checkLoginForm);
	$('#password').blur(checkLoginForm);
});

function CheckPassWord(password) {//必须为字母加数字且长度不小于8位
	   var str = password;
	    if (str == null || str.length <5) {
	        return false;
	    }
	    var reg1 = new RegExp(/^[0-9A-Za-z]+$/);
	    if (!reg1.test(str)) {
	        return false;
	    }
	    var reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
	    if (reg.test(str)) {
	        return true;
	    } else {
	        return false;
	    }
	}

function checkLoginForm() {
	var name = $('#username').val();
	if(name == null || name == ""){
		//提示错误
		$('#errMsg').html("用户名不能为空");
		return false;
	}
	
	var reg = /^\w{4,20}$/;
	if(!reg.test(name)){
		$('#errMsg').html("用户名必须是4-20个字母或数字或下划线");
		return false;
	}
	
	var password = $('#password').val();
	if(password == null || password == ""){
		//提示错误
		$('#errMsg').html("密码不能为空");
		return false;
	}
	
	if(!CheckPassWord(password)){
		$('#errMsg').html("密码必须为字母加数字且长度不小于5位");
		return false;
	}
	$('#errMsg').empty();
	return true;
}


