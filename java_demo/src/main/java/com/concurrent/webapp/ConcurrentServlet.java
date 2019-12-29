package com.concurrent.webapp;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Brian in 23:41 2018/3/23
 */
public class ConcurrentServlet extends GenericServlet {

    private String username;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        username = req.getParameter("username");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        res.setContentType("text/html;charset=utf-8");
        PrintWriter writer = res.getWriter();
        writer.println("<html><head><title></title></head><body>");
        writer.println("test2<br>"+username+"</body></html>");

        writer.flush();
        writer.close();

    }


}
