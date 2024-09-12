package top.jonakls.testpage.servlet;

import top.jonakls.testpage.entity.BookingEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BookingProcessServlet", urlPatterns = "/booking/process")
public class BookingProcessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String secondName = req.getParameter("secondName");
        String dateBooking = req.getParameter("dateBooking");
        String workspace = req.getParameter("workspace");
        String timeBooking = req.getParameter("hours");

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

        if (workspace == null || workspace.isEmpty()) {
            resp.sendRedirect("../index.jsp?error=4");
            return;
        }

        if (timeBooking == null || timeBooking.isEmpty()) {
            resp.sendRedirect("../index.jsp?error=5");
            return;
        }

        if (timeBooking.equals("0")) {
            resp.sendRedirect("../index.jsp?error=6");
            return;
        }

        final BookingEntity bookingEntity = new BookingEntity(name + secondName);
        bookingEntity.setWorkspace(workspace);
        bookingEntity.setDate(new Date());
        bookingEntity.setHours(Integer.parseInt(timeBooking));

        final List<BookingEntity> bookingList = new ArrayList<>();
        bookingList.add(bookingEntity);

        final HttpSession session = req.getSession();
        session.setAttribute("bookings", bookingList);
        resp.sendRedirect("../bookingList.jsp");
    }
}
