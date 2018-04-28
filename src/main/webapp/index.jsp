<html>
<body>
<h2>Hello World!</h2>
</body>
 <script type='text/javascript' src='//g.alicdn.com/sj/lib/zepto/zepto.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm.min.js' charset='utf-8'></script>
    <script type='text/javascript' src='//g.alicdn.com/msui/sm/0.6.2/js/sm-extend.min.js' charset='utf-8'></script>
<link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm.min.css">
    <link rel="stylesheet" href="//g.alicdn.com/msui/sm/0.6.2/css/sm-extend.min.css">
<script type="text/javascript">
$(function(){
	alert('123');
	$.toast("开始");
	$.ajax({
	url:"/o2o/superadmin/listarea",
	type:'POST',
	contentType:false,
	processData:false,
	cache:false,
	sucess:function(data){
		$.toast(0);
		if(data.success)
			{$.toast('提交成功');}
		else
			{
			 $.toast('提交失败');
			}
		 $.toast(1);
		$('captcha_img').click();
	},
	erro:$.toast("erro")

});
})

</script>
</html>
