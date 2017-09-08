package com.toi.servlet;


import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Toi on 2017/9/1 10:50.
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(new Date());
        System.out.println(time);
        req.setAttribute("time",time);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        new HelloServlet().doGet((HttpServletRequest)new Object(),(HttpServletResponse)new Object());
    }
}
