package ua.carrying.controller;


import ua.carrying.model.*;
import ua.carrying.repository.OrderRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

@WebServlet(name = "OrderServlet", urlPatterns = {"/order/*"})
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        User user;
        user = (User)session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("/main");
            return;
        }

        // save order
        if ( request.getParameter("startPlace") != null ) {
            Order order = new Order();
            order.setStartPlace(request.getParameter("startPlace"));
            order.setFinalPlace(request.getParameter("finalPlace"));
            order.setId_customer(user.getId());//
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            order.setOrderDate(timestamp.toString());
            OrderRepository noteRepository = new OrderRepository();
            noteRepository.saveOrder(order);
        }

       // View orderView = new OrderView();
        //out.println(orderView.getHtml());
    }
}
