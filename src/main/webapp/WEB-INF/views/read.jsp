<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>${UserSession.name}님</h2>
    <c:if test="${read != null}">
	<form action="/todo/update" method="post">
		<input type="text" name="seq" value="${read.seq}" readonly><br>
        <input type="text" name="title" value="${read.title}"><br>
        <input type="text" name="content" value="${read.content}"><br>
        <input type="text" name="startdate" value="${read.startDate}" readonly><br>
        <select name="status" required>
    		<option value="Y" ${read.status == 'Y' ? 'selected' : ''}>완료</option>
    		<option value="N" ${read.status == 'N' ? 'selected' : ''}>진행 중</option>
		</select><br>
        <input type="text" name="enddate" value="${read.endDate}" readonly><br>
        <input type="number" name="priority" value="${read.priority}"><br>
        <input type="submit" value="수정">
        <a href="/todo/delete?seq=${read.seq }">삭제</a>
        </form>
        </c:if>
        <c:if test="${read == null}">
            조회할 데이터가 없습니다.
            </c:if>
</body>
</html>