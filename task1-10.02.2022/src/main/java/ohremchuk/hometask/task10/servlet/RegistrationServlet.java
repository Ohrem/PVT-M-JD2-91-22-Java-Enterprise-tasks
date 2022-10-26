package ohremchuk.hometask.task10.servlet;
import ohremchuk.hometask.task10.validation.ServletValidator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "RegistrationServlet", urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    RequestDispatcher requestDispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/pages/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");


        if (!ServletValidator.validateAllConditions(name, phone, email)) {
            req.setAttribute("nameResult", name);
            req.setAttribute("phoneResult", phone);
            req.setAttribute("emailResult", email);
            requestDispatcher = req.getServletContext().getRequestDispatcher("/pages/result.jsp");
        } else {
            req.setAttribute("exceptionMessage", "Incorrect input!");
            req.setAttribute("error", "request exception");
            requestDispatcher = req.getServletContext().getRequestDispatcher("/pages/error.jsp");
        }
        requestDispatcher.forward(req, resp);
    }
}
