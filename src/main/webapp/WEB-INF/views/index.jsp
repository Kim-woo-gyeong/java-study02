  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<body>
<h2>hello!???</h2>
<h2>${total }</h2>
<c:forEach var='month' items = "${month }" varStatus = 'status'>
	<h2>${month.amount }</h2>
</c:forEach>
</body>
</html>
