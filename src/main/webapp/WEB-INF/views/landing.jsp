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
	<div align="center">
        홈페이지
        </div>
        <hr>
        <div align="right">
        <c:if test="${UserSession == null}">
        	<form action="./login.todo" method="post">
        	아이디 : <input type="text" name="id" placeholder="아이디입력"><br>
        	비밀번호 : <input type="password" name="pwd" placeholder="패스워드입력"><br>
        	<input type="submit" value="로그인">
        	</form>
        	</c:if>
        <c:if test="${UserSession != null}">
            ${UserSession.name}님 환영합니다.
            <a href="./logout.todo">로그아웃</a>
            </c:if>
        	</div>
        	<hr>
        <ul>
        	<li><a href="./todo/registerForm">등록하기</a></li>
        	<li><a href="./todo/select">목록보기</a></li>
        </ul>
</body>
</html>