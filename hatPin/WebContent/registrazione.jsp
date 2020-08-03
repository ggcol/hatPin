<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/hatPin.css">
	<style>
	body{
		overflow-x: hidden
	}
</style>
<title>Registrati ad hatPin</title>
</head>
<body>
<div class="generico">
	<img src="./immagini/logoHatPin.png" class="logoHatPin">
	<div class="card text-center bg-custom">
	  <div class="card-body" style="margin-top: -50px;">
			<div class="text" id="titolo">
				<h2>Registrati a hat<font color = #BDAC5C>P</font>in</h2>
			</div>
			<form action="signIn" method="post">
				<div class="form-group">
					<label class="text" for="username">Username</label> <input
					name="username" class="form-control" id="username">
				</div>
				<div class="form-group">
					<label class="text" for="name">Nome</label> <input
					name="name" class="form-control" id="name">
				</div>
				<div class="form-group">
					<label class="text" for="surname">Cognome</label> <input
					name="surname"  class="form-control" id="surname">
				</div>
				<div class="form-group"> <!-- Date input -->
					<label class="text" for="birthdate">Data di nascita</label>
					<input class="form-control" id="birthdate" name="birthdate" placeholder="MM/GG/AAAA" type="text"/>
				</div>
				<div class="form-group">
					<label class="text" for="email">E-mail:</label> 
					<input type="email" name="email" class="form-control" id="email" aria-describedby="emailHelp">
				</div>
				<div class="form-group">
					<label class="text" for="password1">Password</label> 
					<p class="text smallText">La password deve contenere almeno un carattere e un numero,<br>
					lunghezza minima consentita 8 caratteri</p>
					<input type="password" name="password1" class="form-control" id="password1">
				</div>
				<div class="form-group">
					<label class="text" for="password2">Confirm Password</label>
					<input type="password" name="password2" class="form-control" id="password2">
					</div>
					<div class="errori">
					<p class="smallText">${user_null}</p>
					<p class="smallText">${userAE}</p>
					<p class="smallText">${email_null}</p>
					<p class="smallText">${emailAE}</p>
					<p class="smallText">${password_null}</p> 
					<p class="smallText">${password_not_equals}</p>
					<p class="smallText">${birthdate_error}</p>
					</div>
					<button type="submit" class="btn btn-info btn-outline-light" id="submitButton">Submit</button>
				</form>
					  </div>
	</div>
	</div>
			<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
		<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
		<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	</body>
	</html>