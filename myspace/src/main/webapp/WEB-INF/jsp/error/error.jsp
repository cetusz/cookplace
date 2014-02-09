<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>错误页面</title>
<style>
body{
	text-align:center;
}
</style>
</head>
<body>
<%
    Integer statCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
	Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");
	request.setAttribute("exception", exception);
%>

<%  
Exception e = (Exception)request.getAttribute("exception");  
out.print(e.getMessage());  
%>  
<br>
<a href="../entry/tologin">返回登录页面</a>
  <c:if test="${statCode eq 404}">
  <div>找不到该页面!</div>
  </c:if>
  <c:if test="${statCode eq 500}">
  <div>
    <h3>服务器内部错误!</h3>
     <h5>
     <c:if test="${not empty exception}">
     	<c:out value="${exception}"></c:out>   
     </c:if>
     </h5>
  </div>
  </c:if>
</body>
</html>