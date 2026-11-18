<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.routecrafter.model.Route" %>
<!DOCTYPE html>
<html>
<head>
    <title>Route Crafter - Módulo Web</title>
</head>
<body>
    <h1>Route Crafter: Gestión Web de Rutas</h1>

    <!-- Formulario GET para consultar -->
    <fieldset>
        <legend>Consultar Rutas por Ciudad (Método GET)</legend>
        <form action="routes" method="GET">
            <label>ID de Ciudad:</label>
            <input type="number" name="cityId" required>
            <button type="submit">Consultar</button>
        </form>
    </fieldset>

    <br>

    <!-- Formulario POST para registrar -->
    <fieldset>
        <legend>Registrar Nueva Ruta (Método POST)</legend>
        <form action="routes" method="POST">
            <label>Nombre:</label><br>
            <input type="text" name="name" required><br><br>
            
            <label>Descripción:</label><br>
            <input type="text" name="description"><br><br>
            
            <label>ID de Ciudad:</label><br>
            <input type="number" name="cityId" required><br><br>
            
            <button type="submit">Guardar Ruta</button>
        </form>
    </fieldset>

    <br>
    <h2>Resultados:</h2>
    <ul>
        <%
            List<Route> routes = (List<Route>) request.getAttribute("routes");
            if (routes != null && !routes.isEmpty()) {
                for (Route r : routes) {
        %>
                    <li><strong><%= r.getName() %></strong> - <%= r.getDescription() %> (Ciudad ID: <%= r.getCityId() %>)</li>
        <%
                }
            } else {
        %>
                <li>No hay rutas cargadas o no se ha consultado ninguna ciudad.</li>
        <%
            }
        %>
    </ul>
</body>
</html>