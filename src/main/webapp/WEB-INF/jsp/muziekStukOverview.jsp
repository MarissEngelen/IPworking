<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
    <main>
<table>
<tr>
<th>stukId</th>
<th>naam</th>
<th>artiest</th>
<th>duur</th>
</tr>
<c:forEach var="stuk" items="${stukken}">
<tr>
<td>${stuk.key}</td>
<td>${stuk.value.naam}</td>
<td>${stuk.value.artiest}</td>
<td>${stuk.value.duur}</td>
<td> <a href="<c:url value="stuk/${stuk.value.stukId}.htm"/>"> Edit </a> </td>
    <td> <a href="<c:url value="stuk/delete/${stuk.value.stukId}.htm"/>"> Delete </a> </td>
</tr>

</c:forEach>

    <p>De Gemiddelde duur van een stuk is: ${gem}</p>

<caption>Muziekstukken</caption>
</table>

<a href="<c:url value="/stuk/new.htm"/>">New</a>

</main>
<jsp:include page="footer.jsp"></jsp:include>