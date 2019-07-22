<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="/myWeb/static/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(function(){
			
		});
	</script>
</head>
<body>
		<table>
			<caption>俱乐部会员信息</caption>
			<thead>
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>家庭地址</td>
					<td>Email</td>
				</tr>		
			</thead>
			<tbody>
				<c:forEach items="${LIST.list }" var="l">
					<tr>
						<td><a href="member?m=toup&id=${l.id }" >${l.id }</a></td>
						<td>${l.mname }</td>
						<td>${l.mgender }</td>
						<td>${l.mage }</td>
						<td>${l.maddress }</td>
						<td>${l.memail }</td>
					</tr>		
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a href="member?currn=${LIST.prev<=1?1:LIST.prev-1 }">上一页</a>
			<a href="member?currn=${LIST.next>=LIST.totalpage?LIST.totalpage:LIST.next+1 }">下一页</a>
		</div>
</body>
</html>