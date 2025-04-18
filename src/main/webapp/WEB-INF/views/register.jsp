<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../valid/insert" method="post">
	    
       <input type="text" name="title" placeholder="제목을 입력하세요.">
       ${validError.title}
       <textarea id="content" name="content" rows="5" required></textarea>
        ${validError.content}
       <label for="priority">우선순위 (숫자)</label>
       <input type="number" name="priority">
         ${validError.priority}
       <label for ="phone">전화번호</label>
       <input type="text" name="phone" placeholder="전화번호를 입력하세요.">
         ${validError.phone}
       <label for="status">상태</label>
        <select id="status" name="status">
            <option value="N">진행 중</option>
            <option value="Y">완료</option>
        </select>
       <button type="submit">등록</button>
       </form>
</body>
</html>