"use strict"
$.prototype.nullchecker=x=>{
	let flag = false
	let i = 0 
	for(i in x){
		if(x[i] === ''){
			flag = true
		}
	}
	return flag 
}
var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
var maxSize = 5242880;

/*function CheckExtension (x){
	let flag = false
	alert(x.fsize+'    '+x.fname)
	if (x.fsize >= maxSize){
		alert("파일 사이즈 초과")
		flag = true
	}
	
	if(regex.test(x.fname)){
		alert("해당 종류의 파일은 업로드 할 수 없습니다.")
		flag = true
	}
	return flag
}*/


$.prototype.checkExtension = x=>{
	if (x.fsize >= maxSize){
		alert("파일 사이즈 초과")
		return false;
	}
	
	if(regex.test(x.fname)){
		alert("해당 종류의 파일은 업로드 할 수 없습니다.")
		return false
	}
	return true;
}