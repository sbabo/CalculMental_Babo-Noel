<html>
<head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>HighScore</title>
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
        <link rel="stylesheet" type="text/css"
              href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
    </head>

</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Calcul Mental - HighScore</h1>
    </div>
</div>
<div class="row small-5 small-centered">
<table class="responsive-card-table unstriped">
    <thead>
    <tr>
        <th>Pseudo</th>
        <th>Score</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="score" items="${sessionScope.scores}" varStatus="status">
        <tr>
            <td data-label="Pseudo">${score.pseudo}</td>
            <td data-label="Score">${score.score}</td>
            <td data-label="Date">${score.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <p>Votre plus haut score est de : 9 et date du</p>
</div>

</body>
</html>
