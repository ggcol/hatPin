<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Impostazioni</title>
<!-- Stylesheet di bootstrap-->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!--nostro css-->
 <link rel="stylesheet" type="text/css" href="css/hatPin.css">
<!--imp css-->
	<link rel="stylesheet" type="text/css" href="css/Imp.css">

<link href="https://fonts.googleapis.com/css2?family=Rowdies:wght@300&display=swap" rel="stylesheet">

<style>
html, body {
  margin: 0;
  height: 100vm;
}
</style>
<script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
</head>

<body>
  <!-- navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-custom3">
      <button class="btn btn-light my-2 my-sm-2 navItem" id="navHome" type="button" onclick="location.href='dashboardhatpin.jsp'">
      <img src="./immagini/HatPin.png" id="scrittaHatPin">
      </button>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse my-sm-0" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <button class="btn btn-outline-light my-2 my-sm-0 navItem" id="navBacheca" type="button" onclick="location.href='bacheca.jsp'"><span class="iconify" data-icon="si-glyph:pin-location-map" data-inline="false"></span></button>
          </li>
          <li class="nav-item active">
            <button class="btn btn-outline-light my-2 my-sm-0 navItem" id="navProfilo" type="button" onclick="location.href='profilo.jsp'"><span class="iconify" data-icon="si-glyph:person" data-inline="false"></span></button>
          </li>
          <li class="nav-item active">
              <button class="btn btn-outline-light my-2 my-sm-0 navItem" id="navImpostazioni" type="button" onclick="location.href='PaginaImpostazioni.html'"><span class="iconify" data-icon="si-glyph:gear" data-inline="false"></span></button>
          </li>
        </ul>

  <!--     <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>  -->
      </div>
    </nav>

      <div>
         <br>
         <br>
         <h5 id="testone" class="chebelcarattere">Per modificare il proprio profilo inserire
            le credenziali nel riquadro a sinistra <br> e poi compilare i campi desiderati sulla destra</h5>
           
      </div>
       <center><div><p class="text smallText">${update_profile_ok} ${update_profile_not_ok}</p></div></center>
      

<div class="container mt-5">
<div class="row">
        <!-- Profile Settings-->
<div class="col-md-5 pb-5">
          <form action = "modificaUtente" method="post">
            <div class="divprimacolonna pb-3">

               <div class="pallino">
                  <img src="immagini/logoHatPin2.png" >
                </div>

                <div class="credenziali">
                  <h4 id="testocredenziali" class="chebelcarattere">Inserisci le tue credenziali</h4><br>
                </div>

                <div class="form-group">
                  <label for="account-phone" class="chebelcarattere">Utente</label>
                  <input class="form-control" type="text" name="usrChck" id="account-phone" placeholder="Utente">
                </div>

                <div class="">
                  <label for="account-phone" class="chebelcarattere">Password</label>
                  <input class="form-control" type="password" name="pswChck" id="account-phone" placeholder="Password">
                </div>
               <br>
            </div>
        </div>
<div class="col-md-7 pb-5">
<!-- Label di acquisizione --->
         <div class="col-md-auto">
            <div class="form-group">
              <label for="account-fn" class="chebelcarattere" >Modifica Utente</label>
              <input class="form-control" type="text" id="account-fn" name="username" placeholder="Utente">
            </div>
          </div>

          <div class="col-md-auto">
            <div class="form-group">
              <label for="account-ln" class="chebelcarattere">Modifica E-Mail</label>
              <input class="form-control" type="text" id="account-ln" name="email" placeholder="E-Mail"">
            </div>
          </div>

          <div class="w-100"></div>

          <div class="col-md-auto">
            <div class="form-group">
              <label for="account-confirm-pass" class="chebelcarattere">Modifica Nome</label>
              <input class="form-control" type="text" name="name" id="account-confirm-pass" placeholder="Nome">
            </div>
          </div>

          <div class="col-md-auto">
            <div class="form-group">
              <label for="account-confirm-pass" class="chebelcarattere">Modifica Cognome</label>
              <input class="form-control" type="text" name="surname" id="account-confirm-pass" placeholder="Cognome" >
            </div>
          </div>

          <div class="w-100"></div>

          <div class="col-md-auto">
            <div class="form-group">
               <label for="account-email" class="chebelcarattere">Aggiorna Password</label>
               <input class="form-control" type="password" name="passowrd1" id="account-email" placeholder="Aggiorna Password">
            </div>
          </div>

          <div class="col-md-auto">
            <div class="form-group">
              <label for="account-phone" class="chebelcarattere">Ripeti Password</label>
              <input class="form-control" type="password" name="password2" id="account-phone" placeholder="Ripeti Password">
            </div>
          </div>

          <div class="w-100"></div>

          <div class="col-md-auto">
            <div class="form-group">
               <label for="account-pass" class="chebelcarattere">Aggiorna Biografia</label>
              <input class="form-control" type="textarea" name="bio" id="account-pass" placeholder="Aggiorna Biografia">
            </div>
          </div>

         <div class="col-12">
            <hr class="mt-2 mb-3">
              <div class="d-flex flex-wrap justify-content-between align-items-center">
                <button id="bottone1" type="submit" class="btn btn-danger btn-outline-light">Update Profile</button>
              </div>
          </div>
      </form>
  </div>
 </div>
</div>

</body>
</html>
