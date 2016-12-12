<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
  <title>Clients Page</title>

  <style type="text/css">
    .tg {
      border-collapse: collapse;
      border-spacing: 0;
      border-color: #ccc;
    }
    .tg td {
      font-family: Arial, sans-serif;
      font-size: 14px;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #fff;
    }
    .tg th {
      font-family: Arial, sans-serif;
      font-size: 14px;
      font-weight: normal;
      padding: 10px 5px;
      border-style: solid;
      border-width: 1px;
      overflow: hidden;
      word-break: normal;
      border-color: #ccc;
      color: #333;
      background-color: #f0f0f0;
    }
    .tg .tg-4eph {
      background-color: #f9f9f9
    }
  </style>
</head>

<body>

<a href="../../index.jsp" target="_self">Back to main menu</a>

<br/>
<br/>

<h1>Client List</h1>

<input type="search" name="search" placeholder="Search"/>
<input type="submit" value="Search">
<br/>
<br/>

<c:if test="${!empty listClients}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Address</th>
            <th width="120">Phone</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listClients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td><a href="<c:url value='/client' />" target="_self">client.nameClient</a></td>
                <td>${client.address}</td>
                <td>${client.numberPhone}</td>
                <td><a href="<c:url value='/edit/${client.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${client.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>