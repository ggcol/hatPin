<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>-- PROVA MAPPA JSP --</title>
</head>

<!doctype html>
<head>
<!-- style sheet leaflet-->
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
	integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
	crossorigin="" />

<!-- leaflet js config -->
<script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js"
	integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew=="
	crossorigin=""></script>
<!-- rende non scalabile la mappa -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<title>-- PROVA MAPPA --</title>

<!-- stile contenitore mappa-->
<style>
body {
	padding: 0;
	margin: 120;
}

html, body, #map {
	height: 600px;
	width: 1024px;
}
</style>

</head>

<body>
	<!-- contenitore mappa -->
	<div id="map"></div>
	
	<form action="insertPin" method="get">
		<label for="titolo">Titolo: </label> <br><br> 
		<input type="text" id="titolo" name="titolo" /><br><br> 
		<label for="corpo">Cosa vuoi raccontare?</label> 
		<input type="text" id="corpo" name="corpo" /><br><br>
		<input type="hidden" id="latlng" name="latlng" value="" />
		
		
		<fieldset>
			<legend>Scope entry</legend>
			Solo io <input type="radio" name="scope" value="userOnly" /> Amici <input
				type="radio" name="sesso" value="friendsOnly" /> Tutti <input
				type="radio" name="sesso" value="all" />
		</fieldset>

		<input type="submit" value="Submit Pin">

	</form>
	
	<button onclick="leggiPin()">Prova</button>



	<!-- .setView([45.483388, 9.200729], 13) -->
	<script>
    var myMap = L.map('map').locate({setView: true, maxZoom: 16});
   
</script>

	<!-- + tile layer strade ESSENZIALE! -->
	<!-- access token otenuto da mapbox.com, basta fare registrazione -->
	<script>
    L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'pk.eyJ1IjoicmVkcm92ZXIiLCJhIjoiY2tjb3VkMnI5MG9uaTJ4bGZkcHpuZTVoaSJ9.D9NLoVyZKNt4Cai3QVQlGg'
    }).addTo(myMap);

    
</script>

	<!-- aggiungo pin Locale-->
	<script>var pinLocale = L.marker([45.4446143, 9.2084152]).addTo(myMap);
    pinLocale.bindPopup("<b>The White Flag</b><br><a href='http://www.thewhiteflag.it/'>Go to Site</a>");
</script>

<!--  aggiungo pin prova Cascina Martesana-->
<script>
var provaCiccia = L.marker([45.5031887, 9.2292022]).addTo(myMap);
provaCiccia.bindPopup("<b>Cascina Martesana</b><br>Bruciasse male.");
</script>


	<!-- aggiungo pin Duomo-->
	<script>var Duomo = L.marker([45.464159, 9.1911128]).addTo(myMap);
    Duomo.bindPopup("<b>Duomo di Milano</b><br>Vediamo.");
	</script>
	
		<!-- aggiungo pin Ippodromo-->
	<script>var Ippodromo = L.marker([45.482589075374136, 9.132369160652162]).addTo(myMap);
    Ippodromo.bindPopup("<b>Vecchio Ippodromo</b><br><a href='https://www.ippodromisnai.it/sansirogaloppo/'>Go to Site</a>");
</script>

<!-- factory pin? -->
<% int value = 2;
double uno = 45.5087757;
double due = 9.1896702;
// HNiguarda
double tre = 45.4626045;
double quattro = 9.1933334;
//S.Bernardino alle ossa
%>
	<script>var Ippodromo = L.marker([uno, due]).addTo(myMap);
    Ippodromo.bindPopup("<b>Vecchio Ippodromo</b><br><a href='https://www.ippodromisnai.it/sansirogaloppo/'>Go to Site</a>");
</script>


	<!-- prova interazione per add pin -->
	<script>
    var newMarker = L.marker();

function onMapClick(e) {
    newMarker
        .setLatLng(e.latlng)
        .bindPopup("Aggiungi un nuovo pin con l'apposito form")
        .addTo(myMap);
    	document.getElementById("latlng").value = e.latlng.lat+", "+e.latlng.lng;
}



myMap.on('click', onMapClick);

</script>


</body>
</html>
