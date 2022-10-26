package ohremchuk.hometask.task9.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servletCounter", urlPatterns = "/count")
public class ServletCounter extends HttpServlet {
    ClassLoader classLoader = getClass().getClassLoader();
    File file;
    String path;


    @Override
    public void init() throws ServletException {
        super.init();
        file = new File(classLoader.getResource("file.txt").getFile());
        path = file.getAbsolutePath();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            session.setAttribute("counter", 1);
            counter = 1;
        } else {
            session.setAttribute("counter", ++counter);
        }
        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.write("<h1> Counter is: " + counter + "</h1>");
        pw.write("<h1> PATH TO FILE: " + path + "</h1>");
        pw.write("</html>");

        FileWriter writer = new FileWriter(file, false);
        writer.write("Total count is: " + counter);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}