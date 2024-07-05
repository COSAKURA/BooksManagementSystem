$(function(){
    selectType(1);
    $("#btn_add").click(function(){
        $("#tid").val("");
        $("#type").val("");
        $("#type_max_num").val("");
        $("#myModalLabel").text("新增");
        $('#myModal').modal("");
    });

    $("#btn_submit").click(function(){
        var tid=$("#tid").val();
        var type=$("#type").val();
        var type_max_num=$("#type_max_num").val();
        if(tid==""){
            $.ajax({
                type:"get",
                url:"../BookTypeServlet?type=insert",
                data:{"types":type,"type_max_num":type_max_num},
                dataType:"json",
                //cache: false,  //是否异步

                success:function(data){
                    if(data==1){
                        layui.use('layer',function(){
                            layer.open({
                                    title:'新增提示'
                                ,content:'新增成功'
                        });
                        });
                        selectType(1);
                    }else{
                        layui.use('layer',function(){
                            layer.open({
                                    title:'新增提示'
                                ,content:'新增失败'
                        });
                        });

                    }
                }
            });
        }else{
            $.ajax({
                type:"get",
                url:"../BookTypeServlet?type=update",
                data:{"id":tid,"types":types,"type_max_num":type_max_num},
                dataType:"json",
                //cache: false,  //是否异步
                success:function(data){
                    if(data==1){
                        layui.use('layer',function(){
                            layer.open({
                                    title:'修改提示'
                                ,content:'修改成功'
                        });
                        });
                        selectType(1);
                    }else{
                        layui.use('layer',function(){
                            layer.open({
                                    title:'修改提示'
                                ,content:'修改失败'
                        });
                        });

                    }
                }
            });
        }
        $("#tid").val("");
        $("#type").val("");
        $("#type_max_num").val("");
    });

});
function modifyBookType(id){
    $("#tid").val("");
    $("#type").val("");
    $("#type_max_num").val("");
    $("#myModalLabel").text("修改");
    $('#myModal').modal("");
    $.ajax({
        type:"get",
        url:"../BookTypeServlet?type=selectOne",
        data:{"id":id},
        dataType:"json",
        //cache: false,  //是否异步
        success:function(data){
            $("#tid").val(data.id);
            $("#type").val(data.type);
            $("#type_max_num").val(data.type_max_num);
        }
    });
}

function selectType(page){
    $.ajax({
        type:"get",
        url:"../BookTypeServlet?type=selectBookPage",
        dataType:"json",
        data:{"page":page},
        //cache: false,  //是否异步
        success:function(data){
            $("#tb").empty();
            var count=data[0];
            var list=data[1];
            for(var i=0;i<list.length;i++){
                $("#tb").append("<tr><td>"+list[i].id+"</td><td>"+list[i].type
                    +"</td><td>"+list[i].type_max_num+"</td><td><button class='btn btn-primary>' onclick='modifyBookType("
                    +list[i].id+")'>修改</button></td></tr>");
            }
            var result="";
            for(var i=page;i<=(page+4);i++){
                if(i==page){
                    result+"&nbsp;<a>"+i+"</a>&nbsp;";
                }else if(i>count){
                    break;
                }else{
                    result+="&nbsp;<a href='javascript:selectPage("+i+")'>"+i+"</a>&nbsp;";
                }
            }
            $("#tb").append("<tr align='right'><td colspan='4'>"+
                "<a href='javascript:selectPage(1)'>首页</a>&nbsp;"+
                "<a href='javascript:selectPageUp("+page+
                ")'>上一页</a>&nbsp;"+result+"&nbsp;<a href='javascript:selectPageDown("
                +page+","+count+")'>下一页</a>&nbsp;<a>&nbsp;<a href='javascript:selectPage("
                +count+")'>末页</a><input type='text'id='page'size='3' />"+
                "<input type='button' value='GO' onclick=''selectJumpPage("
                +count+")' /></td></tr>");
        }
    });
}

//layer.confirm("确定要删除该物资吗？")
//{icon: 3,title:'提示'},function(index){
//
//}};
function selectPage(p){
    selectType(p);
}

function selectPageUp(p){
    if((p-1)>0){
        selectType(p-1);
    }else{
        layui.use('layer',function(){
            layer.open({
                title:'提示'
                ,content:'没有上一页了!'
            });
        });

    }
}
function selectPageDown(p){
    if((p+1)>0){
        selectType(p+1);
    }else{
        layui.use('layer',function(){
            layer.open({
                title:'提示'
                ,content:'没有下一页了!'
            });
        });

    }
}
function selctJumpPage(count){
    var p=$("#page").val();
    if(/^\d+$/.test(p)){
        if(p>0 && p<=count){
            selectType(p);
        }else{
            layui.use('layer',function(){
                layer.open({
                    title:'提示'
                    ,content:'输入的页码大于0或者小于等于'+count
                });
            });

        }
    }else{
        layui.use('layer',function(){
            layer.open({
                title:'提示'
                ,content:'不能为空或者必须是数值页码！'
            });
        });

    }
}