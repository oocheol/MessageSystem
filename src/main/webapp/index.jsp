<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%--jsp:�±� => jsp action tag 
		jsp��� �Ϻθ� �±�ȭ
		
		<jsp:forward page="main.jsp"></jsp:forward>
		<%
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		%>
	--%>
	<jsp:forward page="main.jsp"></jsp:forward>
</body>
</html>