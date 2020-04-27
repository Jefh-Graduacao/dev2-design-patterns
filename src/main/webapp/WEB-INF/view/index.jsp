<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<html lang="en">
<body>
<div>
    <div>
        <h1>Convid Por Localização</h1>
        <table border="1">
            <thead>
                <th>ID</th>
                <th>Pais</th>
                <th>Codigo</th>
                <th>População do pais</th>
                <th>Casos confirmados</th>
                <th>Casos recuperados</th>
                <th>Mortes</th>
            </thead>
            <tbody>
                <tr>
                    <td>${location.id}</td>
                    <td>${location.country}</td>
                    <td>${location.country_code}</td>
                    <td>${location.country_population}</td>
                    <td>${location.latest.confirmed}</td>
                    <td>${location.latest.recovered}</td>
                    <td>${location.latest.deaths}</td>
                </tr>
            </tbody>
        </table>


    </div>
</div>
</body>
</html>