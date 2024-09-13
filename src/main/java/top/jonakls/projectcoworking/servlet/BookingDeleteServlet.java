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

    private static final BookingRepository bookingRepository = BookingRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        bookingRepository.deleteById(id);
        resp.sendRedirect("../index.jsp");
    }
}
