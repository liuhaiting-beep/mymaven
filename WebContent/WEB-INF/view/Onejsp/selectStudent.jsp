<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>Insert title here</title>

<script type="text/javascript" src="static/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		$(".one").click(function(){
			window.location.href="c/student?m=findStudent&status=1";
		});
		$(".two").click(function(){
			window.location.href="c/student?m=findStudent&status=2";
		});
	});
</script>

</head>
<body>
	<table>
		<thead>
			<tr>
				<th class="one">序号</th>
				<th>姓名</th>
				<th class="two">年龄</th>
				<th>入学时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${LIST }" var="s">
				<tr>
					<td>${s.id }</td>
					<td>${s.name }</td>
					<td>${s.age }</td>
					<td> <fmt:formatDate value="${s.startDate }" pattern="yyyy年MM月dd日" /> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>