package top.jonakls.projectcoworking.servlet;

import top.jonakls.projectcoworking.entity.BookingEntity;
import top.jonakls.projectcoworking.repository.BookingRepository;
import top.jonakls.projectcoworking.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "BookingProcessServlet", urlPatterns = "/booking/process")
public class BookingProcessServlet extends HttpServlet {

    // Singleton del repository de bookings
    private static final BookingRepository BOOKING_REPOSITORY = BookingRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Campos del formulario
        String name = req.getParameter("name");
        String secondName = req.getParameter("secondName");
        String dateBooking = req.getParameter("dateBooking");
        String workspace = req.getParameter("workspace");
        String timeBooking = req.getParameter("hours");

        // Validaciones de los campos (Posiblemente ya no sean necesarias)
        // Los mismsos redireccionan a la página de inicio con una confirmación de error
        if (name == null || name.isEmpty()) {
            resp.sendRedirect("../index.jsp?error=1");
            return;
        }

        if (secondName == null || secondName.isEmpty()) {
            resp.sendRedirect("../index.jsp?error=2");
            return;
        }

        if (dateBooking == null || dateBooking.isEmpty()) {
            resp.sendRedirect("../index.jsp?error=3");
            return;
        }

        if (workspace == null || workspace.isEmpty() || workspace.equals("0")) {
            resp.sendRedirect("../index.jsp?error=4");
            return;
        }

        if (timeBooking == null || timeBooking.isEmpty()) {
            resp.sendRedirect("../index.jsp?error=5");
            return;
        }

        if (timeBooking.equals("0")) {
            resp.sendRedirect("../index.jsp?error=5");
            return;
        }

        int hours = Integer.parseInt(timeBooking);

        if (hours < 1 || hours > 5) {
            resp.sendRedirect("../index.jsp?error=7");
            return;
        }

        final UUID uuid = UUID.randomUUID(); // Genera un UUID aleatorio para la reserva
        final BookingEntity bookingEntity = new BookingEntity(uuid.toString(), name + " " + secondName); // Crea la entidad de la reserva
        bookingEntity.setWorkspace(Integer.parseInt(workspace)); // Setea el workspace seleccionado
        bookingEntity.setDate(DateUtil.parseDate(dateBooking)); // Setea la fecha de la reserva en formato Date (yyyy-MM-dd)
        bookingEntity.setHours(Integer.parseInt(timeBooking)); // Setea las horas de la reserva

        BOOKING_REPOSITORY.save(bookingEntity); // Guarda la reserva en el repositorio

        final HttpSession session = req.getSession(); // Obtiene la sesión actual
        session.setAttribute("bookings", BOOKING_REPOSITORY); // Setea el repositorio de reservas en la sesión
        resp.sendRedirect("../bookingList.jsp?success=true"); // Redirecciona a la lista de reservas con un mensaje de éxito
    }
}
