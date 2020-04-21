<%--
  Created by IntelliJ IDEA.
  User: ssylla
  Date: 07/01/2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<title>Gestion des Contacts - Liste des contacts</title>
		<link rel="stylesheet" type="text/css"
		      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
		<link rel="stylesheet" type="text/css"
		      href="<c:url value="/vendor/foundation-6.5.1/css/foundation.min.css" />" />
		<link rel="stylesheet" href="<c:url value="/css/style.css"/>" />
	</head>
	<body>
		<div class="callout large primary">
			<div class="row column text-center">
				<h1>Gestion des contacts - Login</h1>
			</div>
		</div>
		<div class="row small-5 small-centered">
			<c:if test="${!empty loginBean.message}">
				<div class="callout alert">
					<p>${loginBean.message}</p>
				</div>
			</c:if>
			<form method="POST" action="login">
				<div class="form-icons">
					<h4>Boîte de login</h4>
					<div class="input-group">
							<span class="input-group-label">
								<i class="fa fa-user"></i>
							</span>
						<input class="input-group-field" type="text" placeholder="Login" name="form-username"
						       value=""/>
					</div>
					<div class="input-group">
							<span class="input-group-label">
								<i class="fa fa-key"></i>
							</span>
						<input class="input-group-field" type="password" placeholder="Mot de passe"
						       name="form-password"
						       value=""/>
					</div>
				</div>
				<button class="button expanded">Valider</button>
			</form>
		</div>
		<script src="${pageContext.request.contextPath}/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
		<script src="${pageContext.request.contextPath}/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
		<script>
			$(document).foundation();
			document.documentElement.setAttribute('data-useragent', navigator.userAgent);
		</script>
	</body>
</html>
