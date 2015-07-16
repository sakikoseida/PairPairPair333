<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <div align="center">
        <h1>服屋さんへようこそ！！</h1>
    <form action="import.do" method="post" class="login">
        <table>
        <h2>新規登録します</h2>
            <tr>
                <td>氏名</td>
                <td><input type="text" name="name" size="16" value="" /></td>
            </tr>
            <tr>
                <td>パスワード</td>
                <td><input type="password" name="password" size="16" value="" /></td>
            </tr>
        </table>
        
        <input type="submit" value="登録" /><br>
        
        <a href="Welcome.jsp">トップページに戻る</a>
        
     </form>
        </div>
</html>