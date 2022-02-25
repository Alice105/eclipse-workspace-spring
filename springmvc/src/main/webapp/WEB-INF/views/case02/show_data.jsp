<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show data</title>
</head>
<body>
	name=${name}<p />
	<c:forEach varStatus="status" var="name" items="${name }">
		${status.index }${name }<br />
	</c:forEach>
	<hr />
	fruits=${fruits }<p/>
	<c:forEach varStatus="status" var="fruit" items="${ fruits }">
		${ status.index } ${ fruit } ${ fruit.key } ${ fruit.value }<br />
	</c:forEach>
</body>
</html>