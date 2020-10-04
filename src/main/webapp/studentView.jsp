<%-- 
    Document   : studentView
    Created on : Sep 28, 2020, 8:37:23 AM
    Author     : oujia
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="at.kaindorf.beans.Student;"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Schülerliste</title>
    </head>
    <body>
        <form action="schuelerliste" method="POST">
            <label for="filter">
                Filter:
            </label>
            <input type="text" name="filter" value="zhang" />
            <input type="submit" value="Filter setzen" name="bt_set_filter" />
            <input type="submit" value="Filter entfernen" name="bt_rem_filter" />
            <br>
            <label for="choose_student">
                Schüler auswählen:
            </label>

            <select name="choose_student">
                <option value="nachname"></option>
            </select>
            <br><br>
            <a href="https://ibb.co/vPGy1Kk"><img src="https://i.ibb.co/tstjBWD/unkown-person.jpg" alt="unkown-person" border="0" width="100" height="120"></a>

            <table border="0">
                <tbody>
                    <tr>
                        <td name="lb_name">Name: </td>
                        <td name="Name">Moder Thomas Wolfgang</td>
                    </tr>
                    <tr>
                        <td name="lb_katalognummer">Katalognummer: </td>
                        <td name="katalognummer">17</td>
                    </tr>
                    <tr>
                        <td name="lb_klasse">Klasse: </td>
                        <td name="Klasse">4AHIF</td>
                    </tr>
                    <tr>
                        <td name="lb_Geschlecht">Geschlecht: </td>
                        <td name="Geschlecht">M</td>
                    </tr>
                    <tr>
                        <td name="lb_Geburtsdatum">Geburtsdatum: </td>
                        <td name="Geburtsdatum">24.07.1996</td>
                    </tr>
                </tbody>
            </table>

            <%
                List<Student> liStudents = (LinkedList) request.getAttribute("student-entries");
                
            %>
        </form>
    </body>
</html>

