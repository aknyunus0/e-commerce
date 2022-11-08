<%@ page trimDirectiveWhitespaces="true" contentType="text/html" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
 <div class="container2">

  </div>
	<link href="/css/card1.css" rel="stylesheet"/>
<c:forEach items="${product}" var="pro">

 <div class="centered">
  <section class="cards">
        <div class="card">
          <div class="container">
            <h4><b>${pro.productName}</b></h4>
            <p>${pro.productDetails}</p>
            <p>$${pro.balance}</p>
              <form action="/addBasket" method="post">
                  <input type="hidden" id="productId" name="productId" value=${pro.id}>
                  <input type="hidden" id="numberOfProduct" name="numberOfProduct" value=1>
                  <input type="hidden" id="totalBalance" name="totalBalance" value=${pro.balance}>
                  <input  type="submit" value="Add Basket"> </input>
              </form>

          </div>
        </div>
</section>
</div>
</c:forEach>
</body>
</html>