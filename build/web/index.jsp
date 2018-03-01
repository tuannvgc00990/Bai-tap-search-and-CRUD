<%-- 
    Document   : index
    Created on : Mar 1, 2018, 9:40:35 AM
    Author     : tuan5
--%>

<%@page import="model.ProductFinderBean"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Index!</h1>
        <jsp:useBean class="ProductFinderBean" id="finder" scope="request"/>
        <table>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Description</td>
            </tr>
            <c:forEach items="${listproduct.getAllProduct()}" var="product">
                <tr>
                    <td><c:out value="${product.id}"/></td>
                    <td><c:out value="${product.name}"/></td>
                    <td><c:out value="${product.desp}"/></td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
