<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>BASKET</title>
</head>
<body>




<link href="/css/card.css" rel="stylesheet"/>
<c:forEach items="${BasketItem}" var="basketItem">
    <c:set var = "sumTotal" scope = "session" value = "${basketItem.basket.sumBalance}"/>
</c:forEach>
    <div class="container">
        <h2> TOTAL BASKET : $<c:out value = "${sumTotal}"/></h2>
        <ul class="responsive-table">
            <li class="table-header">
                <div class="col col-3">Product Name</div>
                <div class="col col-2">Details</div>
                <div class="col col-1">Quantity</div>
                <div class="col col-1">Balance</div>
                <div class="col col-5">Update / Delete</div>
            </li>
            <c:forEach items="${BasketItem}" var="basketItem">
            <li class="table-row">

                <div class="col col-3" data-label="Product Name">${basketItem.product.productName}</div>
                <div class="col col-2" data-label="Details">${basketItem.product.productDetails}</div>
                <div class="col col-1" data-label="Quantity" contenteditable="true" >${basketItem.quantity}
                </div>
                <div class="col col-1" data-label="Balance">$${basketItem.totalBalance}</div>
                <div class="col col-5" data-label="Update / Delete" >
                    <form  action="/basket/up/${basketItem.id}" method="post">
                    <input type="text" id="quantity" name="quantity" value=${basketItem.quantity}>
                    <input type="hidden" id="totalBalance" name="totalBalance" value=${basketItem.product.balance}>
                    <input  type="submit" value="Update"> </input>
                    </form>
                    <form action="/basket/del/${basketItem.id}" method="post">

                        <input  type="submit" value="DELETE"> </input>
                    </form>
                </div>

            </li>
                <c:set var = "basketId" scope = "session" value = "${basketItem.basket.id}"/>
                <c:set var = "userId" scope = "session" value = "${basketItem.basket.user.id}"/>
            </c:forEach>
        </ul>
        <form action="/basket/createOrder/${userId}/${basketId}" method="post">
            <input  type="submit" value="CREATE ORDER"> </input>
        </form>
    </div>
</body>
</html>