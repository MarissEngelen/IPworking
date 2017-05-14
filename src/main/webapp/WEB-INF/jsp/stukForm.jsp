<%--
  Created by IntelliJ IDEA.
  User: Sylvaren
  Date: 14/04/2017
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp"/>
<main>



<%--    <form method="post" action="/stuk.htm" novalidate="novalidate">
        <!-- novalidate in order to be able to run tests correctly -->
        <p><label>stukId </label><input type="text" Id="stukId" name="stukId" value="${stuk.stukId}"> </p>
        <p><label>naam </label><input type="text" Id="naam" name="naam" value="${stuk.naam}"> </p>
        <p><label>artiest </label><input type="text" Id="artiest" name="artiest" value="${stuk.artiest}"> </p>
        <p><label>duur </label><input type="number" Id="duur" name="duur" value="${stuk.duur}"> </p>

        <p><input type="submit" Id="save" value="save"></p>

    </form>--%>

    <form:form commandName="stuk" action="/stuk/save.htm" method="post">
        <table>
            <tr>
                <td>Id: </td>
                <td><form:input path="stukId" /></td>
                <td><form:errors path="stukId" cssStyle="color: #990407" /></td>
            </tr>
            <tr>
                <td>Naam:</td>
                <td><form:input path="naam" /></td>
                <td><form:errors path="naam" cssStyle="color: #990407"/></td>
            </tr>
            <tr>
                <td>artiest</td>
                <td><form:input path="artiest" /></td>
                <td><form:errors path="artiest" cssStyle="color: #990407"/></td>
            </tr>
            <tr>
                <td>duur</td>
                <td><form:input path="duur" /></td>
                <td><form:errors path="duur" cssStyle="color: #990407"/></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="save" />
                </td>
            </tr>
        </table>
    </form:form>


</main>
<jsp:include page="footer.jsp"></jsp:include>
