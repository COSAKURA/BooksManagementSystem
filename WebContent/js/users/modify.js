$(function(){
	$("#submit").click(function(){
		var oldpwd=$("#oldpwd").val();
		var newpwd=$("#newpwd").val();
		var repwd=$("#repwd").val();
		if(/^\w+$/.test(oldpwd)){
			if(/^\w+$/.test(newpwd) && /^\w+$/.test(repwd)){
				if(newpwd==repwd){
					$.ajax({
						type: "get",
						url: "../UserServlet?type=findUserPwd",
						dataType: "json",
						success: function(data){
							if(data.passwd==oldpwd){
								modifyPwd(data.id,newpwd);
							}else{
								layui.use('layer', function(){
									layer.open({
									  title: '信息提示'
									  ,content: '原密码错误！！'
									});
								});
							}
						}
					});
				}else{
					layui.use('layer', function(){
						layer.open({
						  title: '信息提示'
						  ,content: '两次新密码必须一致！！'
						});
					});
				}
			}else{
				layui.use('layer', function(){
					layer.open({
					  title: '信息提示'
					  ,content: '两次新密码不能为空！！'
					});
				});
			}
		}else{
			layui.use('layer', function(){
				layer.open({
				  title: '信息提示'
				  ,content: '原密码不能为空！！'
				});
			});
		}
	});
});


function modifyPwd(id,p){
	$.ajax({
		type: "get",
		url: "../UserServlet?type=modiftRootPwd",
		dataType: "json",
		data:{"id":id,"pwd":p},
		success: function(data){
			if(data==1){
				layui.use('layer', function(){
					layer.open({
						title: '信息提示'
						,content: '修改密码成功,请重新登录！！'
						,end:function(){
						location.href="../Login.jsp";
					}
					});
				});


			}else{
				layui.use('layer', function(){
					layer.open({
					  title: '信息提示'
					  ,content: '修改密码失败！！'
						,end:function(){
							location.href="./modify.js";
						}
					});
				});
			}
		}
	});
}

