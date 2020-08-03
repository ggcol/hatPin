<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.LinkedList"
    import = "it.abupro.LatLng.function.PinHelper"
    %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>dashBoard HatPin</title>
  <!-- Stylesheet di bootstrap-->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <!-- style sheet leaflet-->
  <link rel="stylesheet"
  	href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
  	integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
  	crossorigin="" />
  <!-- leaflet js config -->
  <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
  	integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
  	crossorigin=""></script>
    <!--nostro css-->
    <link rel="stylesheet" type="text/css" href="css/hatPin.css">
    <!--script ingranaggio-->
    <script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
<style>
html, body {
  margin: 0;
  height: 100vm;
  overflow: hidden
}
  .leaflet-control-zoom  {
    display: none;
  }
  .leaflet-bar{
    display: none;
  }
  .leaflet-control{
    display: none;
  }
</style>
</head>
<body>
  <div class="d-flex" id="wrapper">
    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="card bg-custom" id="formDash">
  <img src="./immagini/logoHatPin2.png" class="card-img-top" id="imagePinHub">
  <div  class="text">
  <div id="formSide">
    <form action="insertPin" method="post" enctype="multipart/form-data">
    <div class="sideNavForm" class="form-group">
      <label for="title"><b>Titolo</b></label>
      <input type="text" class="form-control" id="title" name="title">
    </div>
    <div class="sideNavForm" class="form-group">
    <label for="body"><b>Cosa vuoi raccontare?</b></label>
  <textarea class="form-control" id="body" name="body" rows="2"></textarea>
  </div>
  <div class="sideNavForm" class="form-group">
      <label for="username"><b>Utente</b></label>
      <input type="text" class="form-control" id="username" name="username">
  </div>
    <div class="form-group">
      <label for="file"><b>Photo</b></label>
      <input class="sideNavForm" type="file" class="form-control" id="file" name="file" accept="image/*">
      <input type="hidden" value=""  id="latlng" name="latlng">
    </div>
  <button id="pinButton" type="submit" class="btn btn-danger btn-outline-light">Pin it!</button>
  </form></div>
  </div>
  </div>
    </div>
    <!-- /#sidebar-wrapper -->
    <!-- Page Content -->
    <div id="page-content-wrapper">
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
      			<form class="form-inline my-2 my-lg-0">
            <button class="btn btn-info my-2 my-sm-0 navItem" id="navPin" type="button">Add Pin</button>
          </form>
      <!--     <form class="form-inline my-2 my-lg-0">
      	      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      	    </form>  -->
      	  </div>
      	</nav>
      <div class="container-fluid" id="map">
            </div>
    </div>
    <!-- /#page-content-wrapper -->
  </div>
  <!-- /#wrapper -->
  <!-- Bootstrap core JavaScript -->

  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Menu Toggle Script -->
  <script>
  $("#wrapper").toggleClass("toggled");
    $("#navPin").click(function(e) {
      e.preventDefault();
    $("#wrapper").toggleClass("toggled");
    });
  </script>
  <script>
    var myMap = L.map('map').locate({setView: true, maxZoom: 20});
</script>
	<!-- + tile layer strade ESSENZIALE! -->
	<!-- access token otenuto da mapbox.com, basta fare registrazione -->
	<script>
    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery � <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 24,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'pk.eyJ1IjoicmVkcm92ZXIiLCJhIjoiY2tjb3VkMnI5MG9uaTJ4bGZkcHpuZTVoaSJ9.D9NLoVyZKNt4Cai3QVQlGg'
    }).addTo(myMap);
</script>
	<!-- aggiungo pin -->
	<% PinHelper pH = new PinHelper();
	LinkedList<String> read = pH.importPinFields();%>

	<%!int flag = 0; %>
	<%for (int i = 0; i < read.size(); i = i+3) {
	String latlng = read.get(i);
	String title = read.get(i+1);
	String body = read.get(i+2);
	flag++;%>

	<script>var newMarker<%=flag%> = L.marker([<%=latlng%>]).addTo(myMap);
    newMarker<%=flag%>.bindPopup("<b><%=title%></b><br><p><%=body%></p>");
</script>

<% } %>


<!-- script interazione utente-pin -->
<script>
  var newMarker = L.marker();
function onMapClick(e) {
  newMarker
      .setLatLng(e.latlng)
      .bindPopup("Aggiungi un nuovo pin con l'apposito form")
      .addTo(myMap)
      document.getElementById("latlng").value = (e.latlng.lat.toString() + ", " + e.latlng.lng.toString());
}myMap.on('click', onMapClick);
</script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
