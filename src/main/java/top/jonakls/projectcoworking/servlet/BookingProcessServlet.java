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

    private static final BookingRepository BOOKING_REPOSITORY = BookingRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String secondName = req.getParameter("secondName");
        String dateBooking = req.getParameter("dateBooking");
        String workspace = req.getParameter("workspace");
        String timeBooking = req.getParameter("hours");
        System.out.println("date: " + dateBooking);

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

        final UUID uuid = UUID.randomUUID();
        final BookingEntity bookingEntity = new BookingEntity(uuid.toString(), name + " " + secondName);
        bookingEntity.setWorkspace(Integer.parseInt(workspace));
        bookingEntity.setDate(DateUtil.parseDate(dateBooking));
        bookingEntity.setHours(Integer.parseInt(timeBooking));

        BOOKING_REPOSITORY.save(bookingEntity);

        final HttpSession session = req.getSession();
        session.setAttribute("bookings", BOOKING_REPOSITORY);
        resp.sendRedirect("../bookingList.jsp?success=true");
    }
}
