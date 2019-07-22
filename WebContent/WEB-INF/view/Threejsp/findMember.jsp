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
			$(".a").click(function(){
				var f = true;
				$("[name=id],[name=mname],[name=mgender]").each(function(){
					var i = $(this).val();
					if(i==""){
						alert($(this).parent().prev().html()+"不能为空");
						f=false;
						return false;
					}
				});
				if(f){
					$("form").submit();
				}
			});
			$("[type=button]:eq(1)").click(function(){
				$("[type=text]").each(function(){
					$(this).val("");
				});
			});
		});
	</script>
</head>
<body>
				<c:forEach items="${LIST }" var="LIST">
	<form action="member?m=up" method="post">
		<table border="1">
			<caption>会员信息</caption>
				<input type="hidden" name="id" value="${LIST.id }">
				<tr>
					<td>姓名</td>
					<td><input type="text" name="mname" value="${LIST.mname }"></td>
				</tr>	
				<tr>
					<td>性别</td>
					<td>
					<c:choose>
						<c:when test="${LIST.mgender =='男' }">
							<input type="radio" name="mgender" value="男" checked>男
							<input type="radio" value="女" name="mgender" >女
						</c:when>
						<c:when test="${LIST.mgender =='女' }">
							<input type="radio" name="mgender" value="男" >男
							<input type="radio" value="女" name="mgender" checked>女
						</c:when>
					</c:choose>
					</td>
				</tr>	
				<tr>
					<td>年龄</td>
					<td><input type="text" name="mage" value="${LIST.mage }"></td>
				</tr>	
				<tr>
					<td>家庭地址</td>
					<td><input type="text" name="maddress" value="${LIST.maddress }"></td>
				</tr>	
				<tr>
					<td>Email</td>
					<td><input type="text" name="memail" value="${LIST.memail }"></td>
				</tr>	
				<tr>
					<td colspan="2"><input class="a" type="button" value="修改"> <input type="button" value="重置" ></td>
				</tr>
		</table>
	</form>
				</c:forEach>
</body>
</html>