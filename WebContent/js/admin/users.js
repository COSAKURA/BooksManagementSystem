$(function(){
    //���ò�ѯ������Ϣ
    selectUserAll();
});

//��ѯ�����û���Ϣ
function selectUserAll() {
    $.getJSON("../UserServlet?type=selectUsersAll", {}, function (data) {
        for (var i = 0; i < data.length; i++) {
            $("#tb").append("<tr><td>" + data[i].id + "</td><td>" + data[i].user +
                "</td><td><button class='btn btn-info' type='button' value='ɾ��' onclick='delUser("
                + data[i].id + ")'>ɾ��</button></td></tr>");
        }
    });
}

//ɾ���û�
function delUser(id) {
    if (confirm("ȷ��Ҫɾ�����û���?")) {
        $.ajax({
            type: "get",
            url: "../UserServlet?type=delete",
            data: {"id": id},
            success: function (data) {
                var d = jQuery.parseJSON(data);
                if (d == "ok") {
                    alert("ɾ���ɹ�!");
                     location.reload();
                    selectUserAll();
                } else {
                    alert("ɾ��ʧ��!");
                }

            }
        });
    }
}
