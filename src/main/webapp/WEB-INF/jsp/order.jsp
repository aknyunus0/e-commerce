<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ORDER</title>
</head>
<body>
${Basket}
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