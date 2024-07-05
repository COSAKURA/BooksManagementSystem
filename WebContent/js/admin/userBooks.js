$(function(){
    initUserBooksPage(1, -1, -1, -1, "", "");
});

function search(){
    var uid = $("#uid").val();
    var bid = $("#bid").val();
    var stat = $("#stat").val();
    var btime = $("#dateBegin").val();
    var etime = $("#dateEnd").val();
    initUserBooksPage(1, uid, bid, stat, btime, etime);
}

function initUserBooksPage(page, uid, bid, stat, btime, etime){
    $.ajax({
        type: "get",
        data: { "page": page, "uid": uid, "bid": bid, "stat": stat, "btime": btime, "etime": etime },
        dataType: "json",
        url: "../UserBooksServlet?type=searchInfo",
        success: function(data){
            var count = data[0];
            var ulist = data[1];
            var blist = data[2];
            var list = data[3];
            $("#uid").empty();
            $("#uid").append("<option value='-1'>��ѡ���û�</option>");
            for (var i = 0; i < ulist.length; i++){
                $("#uid").append("<option value='" + ulist[i].id + "'>" + ulist[i].user + "</option>");
            }
            $("#bid").empty();
            $("#bid").append("<option value='-1'>��ѡ���鼮</option>");
            for (var i = 0; i < blist.length; i++){
                $("#bid").append("<option value='" + blist[i].id + "'>" + blist[i].book_name + "</option>");
            }
            $("#tbs").empty();
            for (var i = 0; i < list.length; i++){
                var str = "";
                if (list[i].stat == 0){
                    str = "<font color='aqua'>�ѹ黹</font>";
                } else if (list[i].stat == 1){
                    var d = new Date(list[i].end_time);
                    var date = new Date();
                    if ((d - date) > 0){
                        str = "<font color='green'>�ѳ�ʱ</font>";
                    } else {
                        str = "<font color='red'>δ�黹</font>";
                    }
                }
                var re = "";
                if (str == "<font color='aqua'>�ѹ黹</font>"){
                    re = "�ѹ黹";
                } else {
                    re = "<a href='javascript:tuiding(" + list[i].id + ")'>�˶�</a>";
                }

                $("#tbs").append("<tr><td>" + list[i].id + "</td><td>" + list[i].userId.user + "</td><td>"
                    + list[i].bookId.book_name + "</td><td>" + list[i].begin_time + "</td><td>" + list[i].end_time + "</td><td>"
                    + str + "</td><td>" + re + "</td></tr>");
            }
            var result = "";
            for (var i = page; i <= (page + 4); i++){
                if (i == page){
                    result += "&nbsp;<a>" + i + "</a>&nbsp;";
                } else if (i > count){
                    break;
                } else {
                    result += "&nbsp;<a href='javascript:selectPage(" + i + ")'>" + i + "</a>&nbsp;";
                }
            }

            $("#tbs").append("<tr align='right'><td colspan='7'>"
                + "<a href='javascript:selectPage(1)'>��ҳ</a>&nbsp;"
                + "<a href='javascript:selectPageUp(" + page + ")'>��һҳ</a>&nbsp;" + result + "&nbsp;<a href='javascript:selectPageDown(" + page + "," + count + ")'>��һҳ</a>&nbsp;<a href='javascript:selectPage(" + count + ")'>ĩҳ</a><input type='text' id='page' size='3' />"
                + "<input type='button' value='GO' onclick='selectJumpPage(" + count + ")' /></td></tr>");
        }
    });
}

function selectPage(p){
    initUserBooksPage(p, -1, -1, -1, "", "");
}

function selectPageUp(p){
    if ((p - 1) > 0){
        initUserBooksPage(p - 1, -1, -1, -1, "", "");
    } else {
        layui.use('layer', function(){
            layer.open({
                title: '��ʾ',
                content: 'û����һҳ�ˣ�'
            });
        });
    }
}

function selectPageDown(p, count){
    if ((p + 1) <= count){
        initUserBooksPage(p + 1, -1, -1, -1, "", "");
    } else {
        layui.use('layer', function(){
            layer.open({
                title: '��ʾ',
                content: 'û����һҳ�ˣ�'
            });
        });
    }
}

function selectJumpPage(count){
    var p = $("#page").val();
    if (/^\d+$/.test(p)){
        if (p > 0 && p <= count){
            initUserBooksPage(p, -1, -1, -1, "", "");
        } else {
            layui.use('layer', function(){
                layer.open({
                    title: '��ʾ',
                    content: '�����ҳ�������������С�ڵ���' + count
                });
            });
        }
    } else {
        layui.use('layer', function(){
            layer.open({
                title: '��ʾ',
                content: '����Ϊ�ջ��߱�������ֵҳ�棡'
            });
        });
    }
}

function tuiding(id){
    layui.use('layer', function(){
        layer.confirm('ȷ��Ҫ�黹���鼮��?', { icon: 1, title: '��ʾ' }, function(index){
            $.ajax({
                type: "get",
                url: "../UserBooksServlet?type=updateStat",
                data: { "id": id },
                dataType: "json",
                success: function(data){
                    if (data == 1){
                        layui.use('layer', function(){
                            layer.open({
                                title: '��ʾ',
                                content: '�黹�ɹ�����'
                            });
                        });
                        initUserBooksPage(1, -1, -1, -1, "", "");
                    } else {
                        layui.use('layer', function(){
                            layer.open({
                                title: '��ʾ',
                                content: '����ʧ��!'
                            });
                        });
                    }
                }
            });
        });
    });
}
