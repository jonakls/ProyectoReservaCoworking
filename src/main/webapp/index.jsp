<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Coworking Booking</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
<jsp:include page="./layout/header.jsp"/>
<%
    final String error = request.getParameter("error");
    if (error != null && !error.isEmpty()) {
%>
<script>
    const type = parseInt("<%= error %>");
    switch (type) {
        case 1:
        case 2:
            Swal.fire({
                icon: 'error',
                title: 'Datos faltantes',
                text: 'Se requieren de los nombres completos',
                showConfirmButton: false,
                timer: 1500
            });
            break;
        case 3:
            Swal.fire({
                icon: 'error',
                title: 'Datos faltantes',
                text: 'Se requiere de la fecha de reserva',
                showConfirmButton: false,
                timer: 1500
            });
            break;
        case 4:
            Swal.fire({
                icon: 'error',
                title: 'Datos faltantes',
                text: 'Se requiere de la selección de un espacio de trabajo',
                showConfirmButton: false,
                timer: 1500
            });
            break;
        case 5:
            Swal.fire({
                icon: 'error',
                title: 'Datos faltantes',
                text: 'Se requiere de la cantidad de horas',
                showConfirmButton: false,
                timer: 1500
            });
            break;
        case 6:
            Swal.fire({
                icon: 'error',
                title: 'Datos incorrectos',
                text: 'La fecha de reserva no puede ser anterior a la actual',
                showConfirmButton: false,
                timer: 1500
            });
            break;
        case 7:
            Swal.fire({
                icon: 'error',
                title: 'Datos incorrectos',
                text: 'La cantidad de horas debe ser mayor a 0 y menor a 5 horas',
                showConfirmButton: false,
                timer: 1500
            });
            break;
    }
</script>
<%
    }
%>

<main>
    <div class="container">
        <h1 class="text-center">¡Reserve ya!</h1>
        <p class="text-center">Aquí puede reservar su espacio para trabajar o estudiar cómodamente, asegurese de llenar
            todos los campos.</p>
    </div>
    <div class="container">
        <form class="row g-3 form-floating" action="booking/process" method="POST">
            <div class="col-md-6">
                <input type="text" class="form-control" placeholder="Nombre" aria-label="Nombre" name="name" required>
                
            </div>
            <div class="col-md-6">
                <input type="text" class="form-control" placeholder="Apellido" aria-label="Apellido" name="secondName" required>
            </div>
            <div class="col-md-4">
                <label for="dateBooking" class="form-label">Fecha de reserva</label>
                <input type="date" class="form-control" aria-label="Fecha de reserva" id="dateBooking"
                       name="dateBooking" required>
            </div>
            <div class="col-md-4">
                <label for="workspace" class="form-label">Espacio de trabajo</label>
                <select class="form-select" aria-label="Espacio de trabajo" id="workspace" name="workspace" required>
                    <option selected value="0">Selecciona un espacio de trabajo</option>
                    <option value="1">Escritorio</option>
                    <option value="2">Sala de reuniones</option>
                    <option value="3">Oficina privada</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="hours" class="form-label">Horas de reserva</label>
                <input type="number" class="form-control" aria-label="Horas" id="hours" name="hours" required>
            </div>
            <button type="submit" class="btn btn-primary" id="bookingButton">Reservar</button>
        </form>
    </div>
</main>
</body>
<script>
    const bookingButton = document.querySelector('#bookingButton');
    
    bookingButton.addEventListener('click', () => {
        const name = document.querySelector('input[name="name"]').value;
        const secondName = document.querySelector('input[name="secondName"]').value;
        const dateBooking = document.querySelector('input[name="dateBooking"]').value;
        const workspace = document.querySelector('select[name="workspace"]').value;
        const hours = document.querySelector('input[name="hours"]').value;
        
        if (name === '' || secondName === '') {
            window.location.href = 'index.jsp?error=1';
        } else if (dateBooking === '') {
            window.location.href = 'index.jsp?error=3';
        } else if (workspace === '0') {
            window.location.href = 'index.jsp?error=4';
        } else if (hours === '') {
            window.location.href = 'index.jsp?error=5';
        } else {
            const currentDate = new Date();
            const bookingDate = new Date(dateBooking);
            
            if (bookingDate < currentDate) {
                window.location.href = 'index.jsp?error=6';
            } else if (hours <= 0 || hours > 5) {
                window.location.href = 'index.jsp?error=7';
            }
        }
    });
</script>
</html>
