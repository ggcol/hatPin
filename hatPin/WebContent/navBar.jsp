<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
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
        <button class="btn btn-outline-light my-2 my-sm-0 navItem" id="navPin" type="button"><img src="./immagini/AddPin.png" id="scrittaAddPin"></button>
      </form>
      <form class="form-inline NavBarsearch" action="profilo.jsp">
      <input class="form-control"  type="text" placeholder="Username" aria-label="Search" name="username" id="inputNavbar">
        <button class="btn btn-outline-light my-2 my-sm-0 navItem NavBarsearch" type="submit">Cerca</button>
        </form>
    <!--     <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>  -->
      </div>
    </nav>
