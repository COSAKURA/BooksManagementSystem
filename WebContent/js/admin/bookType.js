$(function(){
    selectType(1);
    $("#btn_add").click(function(){
        $("#tid").val("");
        $("#type").val("");
        $("#type_max_num").val("");
        $("#myModalLabel").text("����");
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
                //cache: false,  //�Ƿ��첽

                success:function(data){
                    if(data==1){
                        layui.use('layer',function(){
                            layer.open({
                                    title:'������ʾ'
                                ,content:'�����ɹ�'
                        });
                        });
                        selectType(1);
                    }else{
                        layui.use('layer',function(){
                            layer.open({
                                    title:'������ʾ'
                                ,content:'����ʧ��'
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
                //cache: false,  //�Ƿ��첽
                success:function(data){
                    if(data==1){
                        layui.use('layer',function(){
                            layer.open({
                                    title:'�޸���ʾ'
                                ,content:'�޸ĳɹ�'
                        });
                        });
                        selectType(1);
                    }else{
                        layui.use('layer',function(){
                            layer.open({
                                    title:'�޸���ʾ'
                                ,content:'�޸�ʧ��'
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
    $("#myModalLabel").text("�޸�");
    $('#myModal').modal("");
    $.ajax({
        type:"get",
        url:"../BookTypeServlet?type=selectOne",
        data:{"id":id},
        dataType:"json",
        //cache: false,  //�Ƿ��첽
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
        //cache: false,  //�Ƿ��첽
        success:function(data){
            $("#tb").empty();
            var count=data[0];
            var list=data[1];
            for(var i=0;i<list.length;i++){
                $("#tb").append("<tr><td>"+list[i].id+"</td><td>"+list[i].type
                    +"</td><td>"+list[i].type_max_num+"</td><td><button class='btn btn-primary>' onclick='modifyBookType("
                    +list[i].id+")'>�޸�</button></td></tr>");
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
                "<a href='javascript:selectPage(1)'>��ҳ</a>&nbsp;"+
                "<a href='javascript:selectPageUp("+page+
                ")'>��һҳ</a>&nbsp;"+result+"&nbsp;<a href='javascript:selectPageDown("
                +page+","+count+")'>��һҳ</a>&nbsp;<a>&nbsp;<a href='javascript:selectPage("
                +count+")'>ĩҳ</a><input type='text'id='page'size='3' />"+
                "<input type='button' value='GO' onclick=''selectJumpPage("
                +count+")' /></td></tr>");
        }
    });
}

//layer.confirm("ȷ��Ҫɾ����������")
//{icon: 3,title:'��ʾ'},function(index){
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
                title:'��ʾ'
                ,content:'û����һҳ��!'
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
                title:'��ʾ'
                ,content:'û����һҳ��!'
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
                    title:'��ʾ'
                    ,content:'�����ҳ�����0����С�ڵ���'+count
                });
            });

        }
    }else{
        layui.use('layer',function(){
            layer.open({
                title:'��ʾ'
                ,content:'����Ϊ�ջ��߱�������ֵҳ�룡'
            });
        });

    }
}