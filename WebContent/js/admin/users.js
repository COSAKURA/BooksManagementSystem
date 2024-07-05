$(function(){
    //调用查询所有信息
    selectUserAll();
});

//查询所有用户信息
function selectUserAll() {
    $.getJSON("../UserServlet?type=selectUsersAll", {}, function (data) {
        for (var i = 0; i < data.length; i++) {
            $("#tb").append("<tr><td>" + data[i].id + "</td><td>" + data[i].user +
                "</td><td><button class='btn btn-info' type='button' value='删除' onclick='delUser("
                + data[i].id + ")'>删除</button></td></tr>");
        }
    });
}

//删除用户
function delUser(id) {
    if (confirm("确定要删除此用户吗?")) {
        $.ajax({
            type: "get",
            url: "../UserServlet?type=delete",
            data: {"id": id},
            success: function (data) {
                var d = jQuery.parseJSON(data);
                if (d == "ok") {
                    alert("删除成功!");
                     location.reload();
                    selectUserAll();
                } else {
                    alert("删除失败!");
                }

            }
        });
    }
}
