<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8");%>
<%@page import="api.apitest"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        h1{
            text-align: center;
        }
        h3{
            text-align: center;
        }
    </style>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<% apitest.loadWifi(); %>
<h1>
    <%=
    apitest.getTotalCountOfList()
    %>개의 WIFI 정보를 정상적으로 저장하였습니다.
</h1>
<h3>
    <a href="index.jsp">홈 으로 가기</a>
</h3>
</br>
</body>
</html>