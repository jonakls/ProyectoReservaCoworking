<%@ page import="top.jonakls.projectcoworking.entity.BookingEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="top.jonakls.projectcoworking.repository.BookingRepository" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
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
        
        final BookingRepository repository = (BookingRepository) session.getAttribute("bookings");
        final Collection<BookingEntity> bookings = repository.findAll();
        
        if (bookings == null || bookings.isEmpty()) {
            out.println("<h1 class=\"text-center\">No hay reservas</h1>");
            return;
        }
    %>
    </div>
    <div class="container">
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
                int count = 0;
                String[] nameComponents;
                for (BookingEntity entity : bookings) {
                    count++;
                    
                    nameComponents = entity.getName().split(" ");
                    
            %>
            <tr>
                <th scope="row"><%= count %>
                </th>
                <td><%= nameComponents[0] %>
                </td>
                <td><%= nameComponents[1] %>
                </td>
                <td><%= entity.getDate().toString() %>
                </td>
                <td><%= entity.getWorkspace() %>
                </td>
                <td><%= entity.getHours() %>
                </td>
                <td>
                    <form action="booking/delete" method="POST">
                        <input type="hidden" name="id" value="<%= entity.getId() %>">
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
