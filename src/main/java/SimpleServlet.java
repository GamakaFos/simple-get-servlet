import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        writer.println("Hey, " + name);
        writer.println("your password -> " + password);
    }
}
