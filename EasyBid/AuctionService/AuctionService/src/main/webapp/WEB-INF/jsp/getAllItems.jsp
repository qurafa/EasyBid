<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>View Item</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>Name</th>
        <th>Author</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${auctionItems}" var="auctionItem">
        <tr>
            <td>${auctionItem.name}</td>
            <td>${auctionItem.description}</td>
            <td>${auctionItem.price}</td>
            <td>${auctionItem.auctionType}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>