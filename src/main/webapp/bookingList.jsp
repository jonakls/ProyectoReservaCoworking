<%@ page import="top.jonakls.testpage.entity.BookingEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de reservas</title>
</head>
<body>
<jsp:include page="./layout/header.jsp"/>
<main>
    <%
        List<BookingEntity> bookings = (List<BookingEntity>) session.getAttribute("bookings");
    %>
    <div class="container">
        <h1 class="text-center">Lista de reservas</h1>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Fecha de reserva</th>
                <th scope="col">Espacio de trabajo</th>
                <th scope="col">Horas</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="booking" items="${bookings}">
                <tr>
                    <th scope="row">${booking.id}</th>
                    <td>${booking.name}</td>
                    <td>${booking.secondName}</td>
                    <td>${booking.dateBooking}</td>
                    <td>${booking.workspace}</td>
                    <td>${booking.hours}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</main>

</body>
</html>
