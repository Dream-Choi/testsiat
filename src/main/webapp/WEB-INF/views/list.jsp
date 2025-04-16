<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
  <h2>${UserSession.name}님</h2>
  <p>The .table class adds basic styling (light padding and horizontal dividers) to a table:</p>            
  <table class="table">
    <thead>
      <tr>
        <th>제목</th>
        <th>상태</th>
        <th>우선순위</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="dto" items="${list}">
      <tr>
        <%--<td><a href="./read?seq=${dto.seq}">${dto.title}</a></td>--%>
        <td><a href="./view/${dto.seq}">${dto.title}</a></td>
        <td>${dto.status}</td>
        <td>${dto.priority}</td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>