<%-- 
    Document   : StatVisiteurJ
    Created on : 16 mai 2021, 22:07:27
    Author     : andrew
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js"></script>
        <script src = "main.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Statistiques</h1>
        <form action="${pageContext.request.contextPath}/StatVisiteur" method="post">
            <select name="annee">
                <c:forEach var="i" begin="2000" end="2021" step="1">
                    <option valeur="${i}">${i}</option>
                </c:forEach>
            </select>
            <button type="submit" value="parAnnee" name ="buttonGraph">GraphParAnnée</button>
            <button type="submit" value="troisDer" name ="buttonGraph">GraphTroisDerniereAnnee</button>
        </form>
        <div>
            <canvas id="graph" height="600" width="1200">
                <p>Votre navigateur ne prend pas en charge canvas. Boo hoo!</p>
            </canvas>
        </div>
        <script>genGraph(${type},${annee},${list},${list1},${list2},${list3});</script>
    </body>
</html>
