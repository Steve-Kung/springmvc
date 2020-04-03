import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取前端参数 http://localhost:8080/hello?method=delete
        String method = req.getParameter("method");
        if(method.equals("add")){
            req.getSession().setAttribute("msg", "执行add方法");
        }
        if(method.equals("delete")){
            req.getSession().setAttribute("msg", "执行delete方法");
        }
        // 2. 调用业务层（service）
        // 3. 视图转发或者重定向
        // 法一 视图转发（大多数）
        req.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(req, resp);
        // 法二 重定向
//        resp.sendRedirect();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
