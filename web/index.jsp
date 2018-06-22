<%--
  Created by IntelliJ IDEA.
  User: wentaohuang
  Date: 3/6/18
  Time: 下午7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>MyWebapp</title>
  </head>
  <body>
    <div>
        <form action="/jsp/upload" enctype="multipart/form-data" method="post">
            <input type="file" name="upfile">
            <input type="submit">
        </form>
    </div>
  </body>
</html>
