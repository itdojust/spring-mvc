<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>

        <title>图书库</title>

        <script  src="static/jquery-1.11.1.min.js"></script>

        <script>
            $(function () {
                var getBookDesc = function (bookId) {
                    $.ajax({
                        type: "get",
                        url: "books/book/" + bookId,
                        success: function (data) {
                            if (data.result == "success") {
                                $("#bookName").html(data.bookName);
                                $("#bookDesc").html(data.content);
                            } else {
                                $("#bookName").html("");
                                $("#bookDesc").html("");

                                alert("该图书已经被管理员删除");
                            }
                        }
                    });
                }

                $("[id=displayDesc]").click(function () {
                    getBookDesc($(this).attr("bookId"));
                });
            })

        </script>
    </head>

    <body>
        <table border="1px">
            <tr>
                <td>编号</td>
                <td>书名</td>
                <td>价格</td>
                <td>操作</td>
            </tr>

            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td><a id="displayDesc" href="javascript:void(0);" bookId="${book.id}">详情</a></td>
                </tr>
            </c:forEach>
        </table>

        <h1 id="bookName"></h1>

        <p id="bookDesc"></p>
    </body>
</html>