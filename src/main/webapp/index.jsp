<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%--jsp:태그 => jsp action tag 
		jsp기능 일부를 태그화
		
		<jsp:forward page="main.jsp"></jsp:forward>
		<%
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		%>
	--%>
	<jsp:forward page="main.jsp"></jsp:forward>
</body>
</html>