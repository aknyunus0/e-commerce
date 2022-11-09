<%@ page trimDirectiveWhitespaces="true" contentType="text/html" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
 <div class="container3">
     <div class="conta">

         <section class="container4">
             <h4><b>USER INFO</b></h4>
         </section>

     </div>

<div class="conta">
    <section class="container2">


<form action="/order">

    <input  type="submit" value="Basket"> </input>
</form>

        <input  type="submit" value="Logout"> </input>

    </section>

</div>


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
              <form action="/addBasket/${pro.id}" method="post">
                  <label >Quantity:</label>
                  <input type="text" id="quantity" name="quantity">
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