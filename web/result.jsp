<%-- 
    Document   : result
    Created on : Feb 27, 2018, 3:06:29 PM
    Author     : tuan5
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.ProductFinderBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Product</title>
    </head>
    <body>
        <h1>List Product!</h1>
        <a href="seach.jsp">Search</a>
        <jsp:useBean class="ProductFinderBean" id="finder" scope="request"/>
        <table>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Description</td>
            </tr>
            <c:forEach items="${finder.getProduct()}" var="product">
                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.desp}"/></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
