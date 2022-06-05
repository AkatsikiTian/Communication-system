package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] urls = {"/loginin.jsp","/album/","/bootstrap-5.1.3-dist","/register.html","/login.css","/loginin","/register"};
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        Object user = session.getAttribute("username");
        String requestURL = req.getRequestURL().toString();
        for (String url: urls) {
            if(requestURL.contains(url)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        if (user!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            req.getRequestDispatcher("/loginin.jsp").forward(req,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
