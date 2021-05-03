/**
 * 
 */
function getValue(strUrl, strKey){
	//http://localhost:9090/JQueryPro/html/jquery09/jquery09_submit_result.html?userName=&userAge=&userId=&userPassword=&userHp=&userAddr=
	var userInfos = strUrl.substr(url.indexOf("?") + 1);
	var userInfo = userInfos.split("&");

	for(var i = 0; i < userInfo.length; i++){
		var val = userInfo[i].split("=");
		val[1] = val[1].replaceAll("+", " ");
		if(val[0] == strKey){
			return val[1];
		}
	}
}

function isEmpty(val){
	// val이 빈값이거나 null이거나 undefined이거나 " " 일때
	if(val == null || val == undefined || val == "undefined" || val == " " || val.length == 0){
		return false;
	} else {
		return true;
	}
}

function formatHp(val){

	val = val.replaceAll("-", "").replaceAll(" ", "");
	
	val = val.replace(/(\d{3})(\d{3,4})(\d{4})/, "$1-$2-$3");
	
	return val;
}

// 정규식 검사
function chkRegExp(val, type){
	var min, max;
	var regExp;
	if(type == "id"){
		min = 4; max = 12;
		regExp = /^[a-z][a-z0-9_]{4,12}$/;
	} else if(type == "password"){
		min = 8; max = 12;
		regExp = /[a-z]+/ && /[A-Z]+/ && /[0-9]+/ && /[~`!@\#$%^&*\(\)_\-\=+\\|\[\{\]\};:\'\",<.>\/?]+/;
	} else if(type == "name"){
		min = 2; max = 5;
		regExp = /^[가-힣]{2,5}$/;
	} else if(type == "NickName"){
		min = 2; max = 12;
		regExp = /^[가-힣ㄱ-ㅎa-zA-Z0-9._-]{2,}\$/;
	} else if(type == "hp"){
		min = "null"; max = "null";
		regExp =/^(\d{3}-\d{3,4}-\d{4})|(\d{3}\d{3,4}\d{4})$/;
	} else if(type == "email"){
		min = "null"; max = "null";
		regExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	}
	
	return val.match(regExp);
}
// 정규식 - 형식체크 함수
function checkRegExp(str, regExp) {
	return str.test(regExp);
}