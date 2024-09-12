<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Start Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="./layout/header.jsp"/>

<main>
    <div class="container">
        <h1 class="text-center">¡Reserve ya!</h1>
        <p class="text-center">This is the start page of the application.</p>
    </div>
    <div class="container">
        <form class="row g-3 form-floating" action="booking/process" method="POST">
            <div class="col-md-6">
                <input type="text" class="form-control" placeholder="Nombre" aria-label="Nombre" name="name">
            </div>
            <div class="col-md-6">
                <input type="text" class="form-control" placeholder="Apellido" aria-label="Apellido" name="secondName">
            </div>
            <div class="col-md-4">
                <label for="dateBooking" class="form-label">Horas de reserva</label>
                <input type="date" class="form-control" aria-label="Fecha de reserva" id="dateBooking"
                       name="dateBooking">
            </div>
            <div class="col-md-4">
                <label for="workspace" class="form-label">Horas de reserva</label>
                <select class="form-select" aria-label="Espacio de trabajo" id="workspace" name="workspace">
                    <option selected>Selecciona un espacio de trabajo</option>
                    <option value="1">Escritorio</option>
                    <option value="2">Sala de reuniones</option>
                    <option value="3">Oficina privada</option>
                </select>
            </div>
            <div class="col-md-4">
                <label for="hours" class="form-label">Horas de reserva</label>
                <input type="number" class="form-control" aria-label="Horas" id="hours" name="hours">
            </div>
            <div class="col-md-12">
                <button type="submit" class="btn btn-primary">Reservar</button>
            </div>
        </form>
    </div>
</main>
</body>
</html>
