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
		$("[type=button]").click(function(){
		var f = confirm("确定删除吗？");
		if(!f){
			return;
		}
			var id = $(this).attr("id");
			alert(id)
			$.ajax({
				url:"tender?m=delete",
				data:"id="+id,		
				type:"post",
				success:function(result){
					if(result>0){
						window.location.reload();
					}else{
						alert("删除失败！")
					}
						
				}
			});
		});
	});
</script>

</head>
<body>
		<table border="1">
			<thead>
				<tr>
					<th>编号</th>
					<th>工程名</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tenderLIST }" var="t">
					<tr>
						<td>${t.tender_id }</td>
						<td>${t.project_name }</td>
						<td>
							<button><a href="tender?m=queryById&id=${t.tender_id}">详情</a></button>
							<input type="button" id=${t.tender_id } value="删除">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>