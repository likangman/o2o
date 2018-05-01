
//changeVerifyCode

function changeVerifyCode(img)
{
	img.src="../Kaptcha?"+Math.floor(Math.random()*100);
}


//返回链接中？后面的get参数
function getQueryString(name)
{
	var reg = new RegExp("(^|&)"+name+"([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r!=null)
	{
		return decodeURIComponent(r[2]);
	}
	return '';
		
}