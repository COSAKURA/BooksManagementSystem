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
									  title: '��Ϣ��ʾ'
									  ,content: 'ԭ������󣡣�'
									});
								});
							}
						}
					});
				}else{
					layui.use('layer', function(){
						layer.open({
						  title: '��Ϣ��ʾ'
						  ,content: '�������������һ�£���'
						});
					});
				}
			}else{
				layui.use('layer', function(){
					layer.open({
					  title: '��Ϣ��ʾ'
					  ,content: '���������벻��Ϊ�գ���'
					});
				});
			}
		}else{
			layui.use('layer', function(){
				layer.open({
				  title: '��Ϣ��ʾ'
				  ,content: 'ԭ���벻��Ϊ�գ���'
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
						title: '��Ϣ��ʾ'
						,content: '�޸�����ɹ�,�����µ�¼����'
						,end:function(){
						location.href="../Login.jsp";
					}
					});
				});


			}else{
				layui.use('layer', function(){
					layer.open({
					  title: '��Ϣ��ʾ'
					  ,content: '�޸�����ʧ�ܣ���'
						,end:function(){
							location.href="./modify.js";
						}
					});
				});
			}
		}
	});
}

