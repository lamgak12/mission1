<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8");%>
<%--<%@ page import="wifi.ApiDBService"%>--%>
<%--<%@ page import="wifi.WifiDTO"%>--%>
<!DOCTYPE html>
<html>
<script>
    function here(){
        navigator.geolocation.getCurrentPosition(function(pos) {
            console.log(pos);
            var latitude = pos.coords.latitude;
            var longitude = pos.coords.longitude;
            latitude= latitude
            document.getElementById("lat").value=latitude;
            document.getElementById("lnt").value=longitude;

        });
    }

</script>
<head>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            text-align: center;
            padding: 8px;
        }
        tr:nth-child(even){background-color: #f2f2f2}
        th{
            background-color: #04AA6D;
            border: 0.5px solid;
            border-color: #f2f2f2;
            color: white;
        }

    </style>
    <title>와이파이 정보 구하기</title>
</head>
<body>
<h1>
    와이파이 정보 구하기
</h1>

<a href="index.jsp">홈</a> &nbsp;|&nbsp; <a href="#">위치 히스토리 목록</a> &nbsp;|&nbsp; <a href="load-wifi.jsp">Open API 와이파이 정보 가져오기</a>
</br>
    <%
        String lat = request.getParameter("lat");
        System.out.println(lat);
        String lnt = request.getParameter("lnt");
        System.out.println(lnt);
    %>
    <form accept-charset="UTF-8" action="index.jsp" method="get">
        LAT : <input type="text" id="lat" name="lat" value="<%=lat != null ? lat : "0.0"%>">
        LNT : <input type="text" id="lnt" name="lnt" value="<%=lnt != null ? lnt : "0.0"%>">
        <input type="button" value="내 위치 가져오기" onclick="here()"/>
        <input type="button" value="근처WIPI정보 보기" />
    </form>

<table>
    <tr>
        <th>거리(Km)</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    <tr>
        <td colspan="17">위치 정보를 입력한 후에 조회해 주세요.</td>
    </tr>
</table>
</body>
</html>