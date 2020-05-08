<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<hr width="500" color="green">
		<H3>:::파일업로드 폼!!!!!!!</H3>
		<hr width="500" color="green">
		
		<form method="post" 
			enctype="multipart/form-data"
			action="<%=request.getContextPath()%>/upload_ok.do">
		 <!-- 파일업로드는 get방식은안됨! 무조건 post방식으로만!! 왜? -->
		 
		 	<table border="1" cellspacing="0" width="600">
		 		<tr>
		 			<th>첨부파일1</th>
		 			<td><input type="file" name="file1"></td>
		 		</tr>
		 		<tr>
		 			<th>첨부파일2</th>
		 			<td><input type="file" name="file2"></td>
		 		</tr>
		 		<tr>
		 			<th>첨부파일3</th>
		 			<td><input type="file" name="file3"></td>
		 		</tr>
		 		<tr>
		 			<td colspan="2" align="center">
		 				<input type="submit" value="파일전송">
		 				<input type="reset" value="다시작성">
		 			
		 			</td>
		 		</tr>
		 	</table>
		 
		</form>
	
	</div>
</body>
</html>