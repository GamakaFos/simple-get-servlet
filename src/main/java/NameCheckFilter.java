import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class NameCheckFilter implements Filter {
    ServletContext cntxt;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Check name filter init");
        cntxt = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();

        if(servletRequest.getParameter("name").equals(cntxt.getInitParameter("contextName")))
        {
            System.out.println(servletRequest.getParameter("name") + " trying to enter account");
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else
        {
            out.println("You typed wrong name");
            System.out.println("Denied access to " + servletRequest.getParameter("name"));
        }


    }

    @Override
    public void destroy() {
        System.out.println("Check name filter destr");
    }
}
