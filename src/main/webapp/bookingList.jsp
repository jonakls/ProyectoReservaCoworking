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
    <div class="container md-5">
        <h1 class="text-center">¡Lista de reservas!</h1>
        <p class="text-center">Aquí puedes encontrar todas las listas de reservas.</p>
    </div>
    <div class="container md-5">
    <%
        
        final List<BookingEntity> bookings = (List<BookingEntity>) session.getAttribute("bookings");
        
        if (bookings == null || bookings.isEmpty()) {
            out.println("<h1 class=\"text-center\">No hay reservas</h1>");
            return;
        }
    %>
    </div>
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
                <th scope="col">Eliminar</th>
            </tr>
            </thead>
            <tbody>
            <%
                int count = 1;
                for (final BookingEntity entity : bookings) {
                    count++;
            %>
            <tr>
                <th scope="row"><%= count %>
                </th>
                <td><%= entity.getName() %>
                </td>
                <td><%= entity.getName() %>
                </td>
                <td><%= entity.getDate().toString() %>
                </td>
                <td><%= entity.getWorkspace() %>
                </td>
                <td><%= entity.getHours() %>
                </td>
                <td>
                    <form action="booking/delete" method="POST">
                        <input type="hidden" name="id" value="<%= entity.getName() %>">
                        <button type="submit" class="btn btn-danger">Eliminar</button>
                    </form>
                </td>
            </tbody>
            <% } %>
        </table>
    </div>

</main>

</body>
</html>
