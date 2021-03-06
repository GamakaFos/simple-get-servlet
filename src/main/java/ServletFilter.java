
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletFilter implements Filter {
    ServletContext cntxt;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Check pass filter init");
        cntxt = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter writer = servletResponse.getWriter();

        int filPassword = Integer.parseInt(servletRequest.getParameter("password"));
        String filName = servletRequest.getParameter("name");
        if(filPassword != Integer.parseInt(cntxt.getInitParameter("contextPassword")))
        {
            writer.println(filPassword + " is wrong password");
            System.out.println(filName + " tried to enter with wrong password(" + filPassword + ")");
        }
        else
        {
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {
        System.out.println("Check pass filter destr");
    }
}
