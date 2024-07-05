$(function () {
    selectBooksPage(1);
    selectType();
    submits();

    $("#btn_add").click(function () {
        $("#myModalLabel").text("新增书籍");
        $('#myModal').modal();
    });
});

function emptys() {
    $("#bid").val("");
    $("#isbn").val("");
    $("#book_name").val("");
    $("#book_price").val("");
    $("#book_author").val("");
    $("#published_house").val("");
    $("#bookCategory").val(-1);
}

function submits() {
    $("#btn_submit").click(function () {
        var bid = $("#bid").val();
        var isbn = $("#isbn").val();
        var book_name = $("#book_name").val();
        var book_price = $("#book_price").val();
        var book_author = $("#book_author").val();
        var published_house = $("#published_house").val();
        var bookCategory = $("#bookCategory").val();

        if (bid != "") {
            $.ajax({
                type: "get", url: "../BooksServlet?type=update", dataType: "json", data: {
                    "bid": bid,
                    "isbn": isbn,
                    "book_name": book_name,
                    "book_price": book_price,
                    "book_author": book_author,
                    "published_house": published_house,
                    "book_category": bookCategory
                }, success: function (data) {
                    if (data == 1) {
                        layui.use('layer', function () {
                            layer.open({
                                title: '修改提示', content: '修改成功！！'
                            });
                        });
                        emptys();
                        selectBooksPage(1);
                    } else {
                        layui.use('layer', function () {
                            layer.open({
                                title: '修改提示', content: '修改失败！！'
                            });
                        });
                    }
                }
            });
        } else {
            $.ajax({
                type: "get", url: "../BooksServlet?type=insert", dataType: "json", data: {
                    "isbn": isbn,
                    "book_name": book_name,
                    "book_price": book_price,
                    "book_author": book_author,
                    "published_house": published_house,
                    "book_category": bookCategory
                }, success: function (data) {
                    if (data == 1) {
                        layui.use('layer', function () {
                            layer.open({
                                title: '新增提示', content: '新增成功！！'
                            });
                        });
                        emptys();
                        selectBooksPage(1);
                    } else {
                        layui.use('layer', function () {
                            layer.open({
                                title: '新增提示', content: '新增失败！！'
                            });
                        });
                    }
                }
            });
        }
    });
}

function selectType() {
    $.ajax({
        type: "get", url: "../BookTypeServlet?type=selectBookTypeAll", dataType: "json", success: function (data) {
            $("#bookCategory").empty();
            $("#bookCategory").append("<option value='-1'>=请选择类型=</option>");
            for (var i = 0; i < data.length; i++) {
                $("#bookCategory").append("<option value=" + data[i].id + ">" + data[i].type + "</option>");
            }
        }
    });
}

function selectBooksPage(page) {
    $.ajax({
        type: "get", url: "../BooksServlet?type=selectBooksPage",
        data: {
            "page": page
        }, dataType: "json", // cache: false,
        success: function (data) {
            var count = data[0];
            var list = data[1];
            $("#tb").empty();
            for (var i = 0; i < list.length; i++) {
                $("#tb").append("<tr>" +
                    "<td>" + list[i].id + "</td><td>" + list[i].ISBN + "</td>" +
                    "<td>" + list[i].book_name + "</td><td>" + list[i].book_price + "</td>" +
                    "<td>" + list[i].book_author + "</td><td>" + list[i].published_house + "</td>"+
                    "<td>" + list[i].bookCategory.type + "</td>" +
                    "<td><a href='javascript:del(" + list[i].id + ")'>删除</a>&nbsp;" +
                    "<a href='javascript:selectOne(" + list[i].id + ")'>修改</a></td>" +
                    "</tr>");
            }

            var result = "";
            for (var i = page; i <= (page + 4); i++) {
                if (i == page) {
                    result += "&nbsp;<a>" + i + "</a>&nbsp;";
                } else if (i > count) {
                    break;
                } else {
                    result += "&nbsp;<a href='javascript:selectPage(" + i + ")'>" + i + "</a>&nbsp;";
                }
            }

            $("#tb").append("<tr align='right'><td colspan='8'>" + "<a href='javascript:selectPage(1)'>首页</a>&nbsp;"
                + "<a href='javascript:selectPageUp(" + page + ")'>上一页</a>&nbsp;"
                + result + "&nbsp;<a href='javascript:selectPageDown(" + page + "," + count + ")'>下一页</a>&nbsp;" +
                "<a href='javascript:selectPage(" + count + ")'>末页</a>&nbsp;"
                + "<input type='text' id='page' size='3'/>"
                + "<input type='button' value='GO' onclick='selectJumpPage(" + count + ")'/></td></tr>");
        }
    });
}
function selectOne(id) {
    $.ajax({
        type: "get", url: "../BooksServlet?type=selectOne", data: {
            "id": id
        }, dataType: "json", success: function (data) {
            $("#bid").val(data.id);
            $("#isbn").val(data.ISBN);
            $("#book_name").val(data.book_name);
            $("#book_price").val(data.book_price);
            $("#book_author").val(data.book_author);
            $("#published_house").val(data.published_house);
            $("#bookCategory").val(data.bookCategory.id);
            $("#myModalLabel").text("修改书籍信息");
            $('#myModal').modal();
        }
    });
}

function del(id) {
    layui.use('layer', function () {
        layer.confirm('确定要删除该书籍吗？', {
            icon: 3, title: '提示'
        }, function (index) {
            $.ajax({
                type: "get", url: "../BooksServlet?type=removeBooks", data: {
                    "id": id
                }, dataType: "json", success: function (data) {
                    if (data == 1) {
                        layui.use('layer', function () {
                            layer.open({
                                title: '删除提示', content: '删除成功！！'
                            });
                        });
                        selectBooksPage(1);
                    } else if (data == -1) {
                        layui.use('layer', function () {
                            layer.open({
                                title: '删除提示', content: '当前书籍正被借阅中，无法删除！！'
                            });
                        });
                    } else {
                        layui.use('layer', function () {
                            layer.open({
                                title: '删除提示', content: '系统错误，请稍后再试！！'
                            });
                        });
                    }
                }
            });
        });
    });
}

function selectPage(page) {
    selectBooksPage(page);
}

function selectPageUp(page) {
    if ((page - 1) > 0) {
        selectBooksPage(page - 1);
    } else {
        layui.use('layer', function () {
            layer.open({
                title: '提示', content: '没有上一页了！'
            });
        });
    }
}

function selectPageDown(page, count) {
    if ((page + 1) <= count) {
        selectBooksPage(page + 1);
    } else {
        layui.use('layer', function () {
            layer.open({
                title: '提示', content: '没有下一页了！'
            });
        });
    }
}

function selectJumpPage(count) {
    var p = $("#page").val();
    if (/^\d+$/.test(p)) {
        if (p > 0 && p <= count) {
            selectBooksPage(p);
        } else {
            layui.use('layer', function () {
                layer.open({
                    title: '提示', content: '输入的页码必须大于0或者小于等于' + count
                });
            });
        }
    } else {
        layui.use('layer', function () {
            layer.open({
                title: '提示', content: '不能为空或者必须是数值页码！'
            });
        });
    }
}
