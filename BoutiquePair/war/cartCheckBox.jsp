<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="tsuda.choco.Price"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <div align="center">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
     <form action="import.do" method="post">
    <body>
        <h1>ご注文は以下の通りです。</h1>
    <tr>　注文商品　　　　　　　　　　　　　　　　　　　　個数　　　　価格</tr><br>
     <tr>-----------------------------------------------------------------------------------------</tr><br>
    <tr>ハワイ　　　　　マカダミアナッツ　　　　　　　　<%=request.getParameter("choco1") %>個
    <% int a = Integer.parseInt(request.getParameter("choco1")); %>
    <% int a1 = a * 1000; %>　　　　
    <%=a1%>円</tr><br>
    <tr>アメリカ　　　　キスチョコ　　　　　　　　　　　<%=request.getParameter("choco2") %>個
    <% int b = Integer.parseInt(request.getParameter("choco2")); %>
    <% int b1 = b * 700; %>　　　　
    <%=b1%>円</tr><br>
    <tr>イタリア　　　　カントチーニチョコ　　　　　　　<%=request.getParameter("choco3") %>個
    <% int c = Integer.parseInt(request.getParameter("choco3")); %>
    <% int c1 = c * 400; %>　　　　
    <%=c1%>円</tr><br>
    <tr>オーストラリア　ティムタムチョコ　　　　　　　　<%=request.getParameter("choco4") %>個
    <% int d = Integer.parseInt(request.getParameter("choco4")); %>
    <% int d1 = d * 400; %>　　　　
    <%=d1%>円</tr><br>
    <tr>スイス　　　　　ホワイトアンドゴールドチョコ　　<%=request.getParameter("choco5") %>個
    <% int e = Integer.parseInt(request.getParameter("choco5")); %>
    <% int e1 = e * 3000; %>　　　　
    <%=e1%>円</tr><br>
	<tr>-----------------------------------------------------------------------------------------</tr><br>
	<tr>合計金額　<% int total = a1 + b1 + c1 + d1 + e1; %><%=total%>円</tr><br>
           　<input type="submit" name="thanks.jsp" value="購入する" />
    </body>
    </form>
    </div>
</html>