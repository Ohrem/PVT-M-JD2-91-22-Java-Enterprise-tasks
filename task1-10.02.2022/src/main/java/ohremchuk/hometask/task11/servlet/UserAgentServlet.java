package ohremchuk.hometask.task11.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserAgentServlet", urlPatterns = "/browser")
public class UserAgentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String browserDetails = req.getHeader("User-Agent");
        String userAgent = browserDetails;
        String user = userAgent.toLowerCase();

        if (user.contains("opr")) {
            req.setAttribute("browser", "Opera");
        } else if (user.contains("edg")) {
            req.setAttribute("browser", "Microsoft Edge");
        } else if (user.contains("firefox")) {
            req.setAttribute("browser","Firefox");
        } else if (user.contains("safari") && user.contains("chrome")) {
            req.setAttribute("browser", "Google Chrome");
        } else if (user.contains("safari")) {
            req.setAttribute("browser", "Safari");
        } else if (user.contains("brave")) {
            req.setAttribute("browser", "Brave");
        } else if (user.contains("vivaldi")) {
            req.setAttribute("browser", "Vivaldi");
        }
        RequestDispatcher requestDispatcher = req.getServletContext().getRequestDispatcher("/pages/showInfoAboutBrowser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
