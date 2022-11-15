<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title><% out.println("Merhaba JSP");%></title>
    </head>
    <body>
${userId}
    <link href="/css/card1.css" rel="stylesheet"/>

 <div class="centered">

  <section class="cards">
        <div class="card">
          <div class="container">
            <h4><b>John Doe</b></h4>
            <p>Architect & Engineer</p>
            <input type="submit" value="Add Basket"> </input>
          </div>
        </div>
</section>

</div>
    </body>
</html>