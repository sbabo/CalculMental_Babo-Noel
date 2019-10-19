<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Game</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/gameStyle.scss"/>
</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Question n°${sessionScope.noquestion} :</h1>
    </div>
</div>
<div class="wrapper">
    <form id="question-form" action="game?action=NEXT&reponse=" method="POST" class="box a">

        <input id="form-method" type="hidden" name="form-method" value="NEXT"/>
        <input id="form-id" type="hidden" name="form-id" value=""/>
        <div class="question">
            <p>${sessionScope.questions}</p>
            <p>${sessionScope.rep}</p>
            <div class="rep">
                <input type="text" placeholder="Reponse" name="form-reponse"/>
            </div>
            <input type="submit" class="button" value="${sessionScope.valeurButton}"/>
        </div>
    </form>
</div>
</body>
</html>
