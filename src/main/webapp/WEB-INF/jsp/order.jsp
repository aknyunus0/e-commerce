<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ORDER</title>
</head>
<body>
<link href="/css/card.css" rel="stylesheet"/>
<c:forEach items="${OrderList}" var="order">
<div class="container">
    <h2>${order.key}</h2>
    <ul class="responsive-table">

        <li class="table-header">
            <div class="col col-3">Product Name</div>
            <div class="col col-2">Details</div>
            <div class="col col-1">Quantity</div>
            <div class="col col-1">Balance</div>
        </li>
        <c:forEach items="${order.value}" var="basketItem">
            <li class="table-row">

                <div class="col col-3" data-label="Product Name">${basketItem.product.productName}</div>
                <div class="col col-2" data-label="Details">${basketItem.product.productDetails}</div>
                <div class="col col-1" data-label="Quantity"  >${basketItem.quantity}</div>
                <div class="col col-1" data-label="Balance">$${basketItem.totalBalance}</div>

            </li>
        </c:forEach>
    </ul>
</div>
</c:forEach>
</body>
</html>