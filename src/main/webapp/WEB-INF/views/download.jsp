<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Spring Boot Sample</title>
<%--    <script src="${ctx}/webjars/jquery/3.3.1-2/jquery.min.js"></script>--%>
    <script type="text/javascript">
        function download() {
            window.open("/download")
        }
    </script>
</head>

<body>
<button onclick="download()">下载</button>
</body>
</html>
