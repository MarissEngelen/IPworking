<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8">
    <title>${title}</title>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>" />
    <link rel="stylesheet" href="<c:url value="/css/yellow.css"/>" />


</head>
<body>
<div id="container">
    <header>
        <h1><span>Partituren Library</span></h1>
        <nav>
            <ul>
                <li><a href="<c:url value="/index.htm"/>">Home</a></li>
                <li><a href="<c:url value="/stuk.htm"/>">Stukken</a></li>


            </ul>
        </nav>
        <h2>
            ${title}
        </h2>

    </header>
