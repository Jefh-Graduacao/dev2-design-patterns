<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<html lang="en">
<body>
<div>
    <div>
        <h1>Convid Global</h1>
        <table border="1">
            <thead>
                <th>Casos confirmados</th>
                <th>Casos recuperados</th>
                <th>Mortes</th>
            </thead>
            <tbody>
                <tr>
                    <td>${infected.confirmed}</td>
                    <td>${infected.recovered}</td>
                    <td>${infected.deaths}</td>
                </tr>
            </tbody>
        </table>


    </div>
</div>
</body>
</html>