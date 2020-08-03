<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.LinkedList"
    import = "it.abupro.LatLng.function.WallHelper"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bacheca</title>
<!-- Stylesheet di bootstrap-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<!--nostro css-->
<link rel="stylesheet" type="text/css" href="css/hatPin.css">
<!--script ingranaggio-->
<script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
<style>
  html, body {
  overflow-x: hidden
}
</style>
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
<!-- contenitore di pin-->
  <div class="card text-center bg-custom post" id="containterPin">
     <% WallHelper wh = new WallHelper();
      LinkedList<String> read = wh.importPin4Wall(); %>
      <%! int flag = 0; %>
      <%  for (int i = 0; i < read.size(); i = i+5) {
      	String latlng = read.get(i);
      	String title = read.get(i+1);
      	String body = read.get(i+2);
      	String ref_img = read.get(i+3);
      	String username = read.get(i+4);
      	flag++;
      	%>
       <div id="postForm" class="card">
          <h2 class="text titoloPost">
            <%=title %>
            <br>
          </h2>
          <p class="smallText text">coords:<br><%=latlng%><br></p>
          <img src="<%=ref_img%>" class="card-img-top">
          <div class="card-body">
            <p class="card-text text"><%=body %><br>Username: <%=username %></p>

          </div>
        </div>
        <% } %>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
