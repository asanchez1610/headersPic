<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pic headers Test</title>
</head>
<body>
<h2>Prueba de concepto Headers PIC</h2>
<div style="line-height: 26px">
<b>Nombre:</b> ${userHeaders.nombre}<br>
<b>Registro:</b> ${userHeaders.registro}<br>
<b>IvUser:</b> ${userHeaders.ivUser}<br>
<b>IvTicket:</b> ${userHeaders.ivTicket}<br>
<b>Granting Ticket:</b> ${grantingTicket}<br>
</div>
</body>
<script>
var grantingTicket = '${grantingTicket}';
alert(grantingTicket);
localStorage.setItem('grantingTicket', grantingTicket);
</script>
</html>