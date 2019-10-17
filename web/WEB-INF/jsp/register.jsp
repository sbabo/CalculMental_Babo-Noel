<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Register - Inscrivez-vous</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Calcul Mental - Register</h1>
    </div>
</div>
<div class="row small-5 small-centered">

    <c:if test="${ !empty registerBean.registerResult}">
        <div class="callout alert">
            <p>${registerBean.registerResult}</p>
        </div>
    </c:if>
    <!--
    <form method="POST" action="login">
        <div class="form-icons">
            <h4>Boîte de login</h4>
            <div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-user"></i>
						</span>
                <input class="input-group-field" type="text" placeholder="Login" name="form-login"
                       value="${loginBean.login}"/>
            </div>
            <div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-key"></i>
						</span>
                <input class="input-group-field" type="password" placeholder="Mot de passe" name="form-pwd"
                       value=""/>
            </div>
        </div>
        <button class="button expanded">Valider</button>
    </form>
-->
    <form class="register-form" method="POST" action="register">
        <h4 class="text-center">Registration</h4>
        <label>Username
            <input type="text" placeholder="Username" name="form-name" required pattern="[A-Za-z]{2,50}" title="[A-Za-z]"/></label>
        <label>Login
            <input type="text" placeholder="Login" name="form-login" required pattern="[A-Za-z]{2,50}" title="[A-Za-z]"/>
        </label>
        <label>Password
            <input type="password" placeholder="Password" name="form-pwd" required minlength="6" maxlength="12">
        </label>
        <input id="show-password" type="checkbox"><label for="show-password">Show password</label>
        <p><input type="submit" class="button expanded" value="Register"></p>
    </form>


</div>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
<script>
    $(document).foundation();
    document.documentElement.setAttribute('data-useragent', navigator.userAgent);
</script>
</body>
</html>