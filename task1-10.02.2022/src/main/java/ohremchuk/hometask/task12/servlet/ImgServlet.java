package ohremchuk.hometask.task12.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet(name = "imgServlet", urlPatterns = "/imgsCount")
public class ImgServlet extends HttpServlet {
    private BufferedImage img;
    private Graphics2D g2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        HttpSession session = req.getSession();
        img = new BufferedImage(350, 100, BufferedImage.TYPE_INT_RGB);
        g2 = img.createGraphics();
        g2.setFont(new Font("TimesRoman", Font.ROMAN_BASELINE, 24));
        g2.setColor(Color.WHITE);
        g2.drawString("Number of visits: " + String.valueOf(getVisitorCount(session)), 50, 50);
        ServletOutputStream out = resp.getOutputStream();
        ImageIO.write(img, "jpeg", out);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private int getVisitorCount(HttpSession session){
        Integer counter = (Integer) session.getAttribute("counter");
        if (counter == null) {
            session.setAttribute("counter", 1);
            counter = 1;
        } else {
            session.setAttribute("counter", ++counter);
        }
        return counter;
    }
}
