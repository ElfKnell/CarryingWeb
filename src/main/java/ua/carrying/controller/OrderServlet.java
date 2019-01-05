package ua.carrying.controller;

import ua.carrying.dao.entities.Order;
import ua.carrying.dao.entities.User;
import ua.carrying.dao.repository.OrderRepository;
import ua.carrying.view.OrderView;

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

        User user = (User) session.getAttribute("user");

        OrderRepository orderRepository = new OrderRepository();

        if (user == null) {
            response.sendRedirect("/car/");
            return;
        }

        if ( request.getParameter("startPlace") != null ) {
            String str, str2;
            String[] word;
            String[] rDate;
            Order order = new Order();
            order.setId_customer(user.getId());
            order.setStartPlace(request.getParameter("startPlace"));

            order.setFinalPlace(request.getParameter("finalPlace"));

            order.setPrice(Double.valueOf(request.getParameter("price")));
            order.setWeight(Double.valueOf(request.getParameter("weight")));
            order.setVolume(request.getParameter("volume"));

            str = request.getParameter("sendDate");
            word = str.split("/");
            str = word[2] + "-" + word[0] + "-" + word[1];
            order.setSendDate(str);
            str2 = request.getParameter("receiveDate");
            rDate = str2.split("/");
            str2 = rDate[2] + "-" + rDate[0] + "-" + rDate[1];
            order.setReceiveDate(str2);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            order.setOrderDate(timestamp.toString());
            System.out.println(str + "///" + str2);
            orderRepository.saveOrder(order);
        }

        OrderView orderView = new OrderView();
        switch (request.getPathInfo()) {
            case "/index":
                //out.println(orderView.getHtml(orderRepository.getNotesByCustomerId(user.getId())));
                break;
            default:
                out.println(orderView.getHtml());
        }

    }
}
