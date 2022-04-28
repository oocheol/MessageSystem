<%@page import="kr.smhrd.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forty by HTML5 UP</title>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="assetsBoard/css/main.css" />
<link rel="stylesheet" href="assetsBoard/css/board.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->

</head>
<body>
	<%
		// request 영역에 저장해둔 list 꺼내기
		List<BoardVO> list = (List<BoardVO>) request.getAttribute("list");
		
	%>

	<div id="board">
		<table id="list">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>시간</td>
			</tr>
		</thead>
		<tbody>
			<%for (BoardVO bvo : list) {%>
			<tr>
				<td><%=bvo.getNum() %></td>
				<%-- 쿼리스트링 : ?name=value&name2=value2... --%>
				<td> <a href="ViewService?num=<%=bvo.getNum() %>"><%=bvo.getTitle() %> </a></td>
				<td><%=bvo.getWriter() %></td>
				<td><%=bvo.getDay() %></td>
			</tr>
			<%} %>
		</tbody>

		</table>

		<a href="main.jsp"><button id="writer">홈으로가기</button></a> <a
			href="writerBoard.jsp"><button id="writer">작성하러가기</button></a>
	</div>


	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/jquery.scrolly.min.js"></script>
	<script src="assets/js/jquery.scrollex.min.js"></script>
	<script src="assets/js/skel.min.js"></script>
	<script src="assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>
</body>
</html>