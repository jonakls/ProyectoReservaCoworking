<%@ page import="top.jonakls.projectcoworking.entity.BookingEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="top.jonakls.projectcoworking.repository.BookingRepository" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Collection" %>
<%@ page import="top.jonakls.projectcoworking.util.DateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de reservas</title>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
<jsp:include page="./layout/header.jsp"/>

<%
    final String succes = request.getParameter("success");
    
    if (succes != null && !succes.isEmpty()) {
%>
<script>
    Swal.fire({
        icon: 'success',
        title: 'Reserva realizada',
        text: 'Su reserva fue agendada correctamente.',
        showConfirmButton: false,
        timer: 1500
    });
</script>
<%
    }
%>

<main>
    <div class="container md-5">
        <h1 class="text-center">¡Lista de reservas!</h1>
        <p class="text-center">Aquí puedes encontrar todas las listas de reservas.</p>
    </div>
    <div class="container md-5">
        <%
            
            final BookingRepository repository = (BookingRepository) session.getAttribute("bookings");
            
            if (repository == null) {
                out.println("<h1 class=\"text-center\">No hay reservas</h1>");
                return;
            }
            
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
                    
                    nameComponents = entity.getName().split(" ");
                    
                    if (nameComponents.length < 1) {
                        nameComponents = new String[]{"Nombre no valido", ""};
                    }
                    
                    if (nameComponents.length == 1) {
                        nameComponents = new String[]{nameComponents[0], ""};
                    }
                    
                    count++;
            
            %>
            <tr>
                <th scope="row"><%= count %>
                </th>
                <td><%= nameComponents[0] %>
                </td>
                <td><%= nameComponents[1] %>
                </td>
                <td><%= DateUtil.parseStringDate(entity.getDate()) %>
                </td>
                <td><%= entity.getWorkspace() %>
                </td>
                <td><%= entity.getHours() %>
                </td>
                <td>
                    <form id="deleteForm" action="booking/delete" method="POST">
                        <input type="hidden" name="id" value="<%= entity.getId() %>">
                        <button id="deleteButton" type="button" class="btn btn-danger">Eliminar
                        </button>
                    </form>
                </td>
            </tbody>
            <% } %>
        </table>
    </div>

</main>
</body>
<script>
    const deleteButtons = document.querySelectorAll('#deleteButton');
    deleteButtons.forEach(button => {
        button.addEventListener('click', () => {
            const form = button.parentElement;
            Swal.fire({
                title: '¿Estás seguro?',
                text: 'No podrás revertir esta acción',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#30d6d6',
                cancelButtonColor: '#dd4c33',
                confirmButtonText: 'Sí, eliminar 👍',
                cancelButtonText: 'Cancelar 🧐'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire({
                        icon: 'success',
                        title: 'Reserva eliminada',
                        showConfirmButton: false,
                        timer: 1500
                    }).then(() => {
                        form.submit();
                    });
                }
            });
        });
    });
</script>
</html>
