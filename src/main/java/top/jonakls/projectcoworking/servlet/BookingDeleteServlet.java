package top.jonakls.projectcoworking.servlet;

import top.jonakls.projectcoworking.repository.BookingRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookingDeleteServlet", urlPatterns = "/booking/delete")
public class BookingDeleteServlet extends HttpServlet {

    // Singleton con la instancia del repositorio
    private static final BookingRepository bookingRepository = BookingRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id"); // Id del booking a eliminar que llega desde la lista de bookings
        bookingRepository.deleteById(id); // Eliminamos el booking por su id gracias al método del repositorio
        resp.sendRedirect("../index.jsp"); // Redirigimos a la página principal
    }
}
