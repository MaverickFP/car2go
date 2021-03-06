<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Dettaglio Macchina</title>
<link rel="stylesheet" type="css" href="<s:url value="/resources/autumn05.css"/>" />
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
function initialize() {
  var myLatlng = new google.maps.LatLng(${macchina.latitudine},${macchina.longitudine});
  var mapOptions = {
    zoom: 14,
    center: myLatlng
  }
  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

  var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title: '${macchina.tipo}'
  });
}

google.maps.event.addDomListener(window, 'load', initialize);

</script>
</head>
<body>
<div id="container">
  <div id="navarea">
    <ul id="nav">
      <li><c:url value="/home" var="home" /><a href="${home}">Home</a></li>
      <li><c:url value="/utente?login" var="login" /><a href="${login}">Login</a></li>
      <li><c:url value="/utente?new" var="newUtente" /><a href="${newUtente}">Registrati</a></li>      
    </ul>
  </div>
  <div id="hdr"> <span id="sitetitle">Car 2 Go</span> <br />
    <span id="subtitle">Prenota la tua auto</span></div>
  <div id="lftcol">
    <div class="leftcolbox">
      <div class="leftcolboxtop"></div>
      <h2>Car2Go</h2>
      <p>Progetto per la Tesi di Laurea Magistrale in Ingegneria Informatica. Francesco Paris. Matricola: 453908</p>
    </div>
    <div class="leftcolbox">
      <div class="leftcolboxtop"></div>
      <h2>Menu':</h2>
      <p> <c:url value="/home" var="home" /><a href="${home}">Home</a><br />
        <c:url value="/utente?login" var="login" /><a href="${login}">Login</a><br />
        <c:url value="/utente?new" var="newUtente" /><a href="${newUtente}">Registrati</a><br />
      </p>
      <br />
    </div>
  </div>
  <div id="maincol">
  
    
    
    
    
    <div class="rule">
      <h1>Dettaglio Macchina ${macchina.tipo}</h1>
    </div>
    <p>Le informazioni sulla macchina <strong>${macchina.tipo}</strong>.</p>
    <p>
   
    </p>
    <p> 
    
    <ul>
    		<li><strong>Modello:</strong> ${macchina.tipo}</li>
    		<li><strong>Codice:</strong> ${macchina.codice}</li>
    		<li><strong>Indirizzo:</strong> ${macchina.indirizzo}</li>
    		<li><strong>Benzina:</strong> <img src="<s:url value="/resources/images/${livelloBenzina}.png"/>" width="20" align="middle"/></li>
    		<li><strong>Stato Interno:</strong> <img src="<s:url value="/resources/images/${macchina.interno}.png"/>" width="20" align="middle"/></li>
    		<li><strong>Stato Esterno:</strong> <img src="<s:url value="/resources/images/${macchina.esterno}.png"/>" width="20" align="middle"/></li>
    		<li><strong>Note:</strong> ${macchina.note}</li>
    	
    </ul>
    
    <div id="map-canvas" style="width: 500px; height: 400px;"></div>
    	
    
    </p>
    
    
    
    
    
  
  
  
  
  <div id="bttmbar"> <span id="copyright"> Copyright &copy; 2014. Francesco Paris - Matricola 453908.</span>
    <ul id="bttmnav">
      <li><c:url value="/home" var="home" /><a href="${home}">Home</a></li>
      <li><c:url value="/utente?login" var="login" /><a href="${login}">Login</a></li>
      <li><c:url value="/utente?new" var="newUtente" /><a href="${newUtente}">Registrati</a></li> 
      <li><a href="" title="contact">contact</a></li>
      <li><a href="" title="links">links</a></li>
    </ul>
  </div>
</div>
</body>
</html>
