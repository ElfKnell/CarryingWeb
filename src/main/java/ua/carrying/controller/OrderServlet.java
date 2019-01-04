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

        OrderView orderView = new OrderView();

        if (user == null) {
            response.sendRedirect("/car");
            return;
        }

        if (user.getRole() == 4) {
            out.println(orderView.getIndex(orderRepository.getOredrsByFerrymanId()));
        }

        if ( (request.getParameter("start_place") != null) && !(request.getPathInfo().equals("/edit") )) {
            String str, str2;
            String[] word;
            String[] rDate;
            Order order = new Order();

            order.setId_customer(user.getId());
            order.setStart_place(request.getParameter("start_place"));

            order.setFinal_place(request.getParameter("final_place"));

            order.setPrice(Double.valueOf(request.getParameter("price")));
            order.setWeight(Double.valueOf(request.getParameter("weight")));
            order.setVolume(request.getParameter("volume"));

            str = request.getParameter("send_date");
            word = str.split("/");
            str = word[2] + "-" + word[0] + "-" + word[1];
            order.setSend_date(str);
            str2 = request.getParameter("receive_date");
            rDate = str2.split("/");
            str2 = rDate[2] + "-" + rDate[0] + "-" + rDate[1];
            order.setReceive_date(str2);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            order.setOrder_date(timestamp.toString());

            orderRepository.saveOrder(order);

            System.out.println(request.getPathInfo());

            out.println(orderView.getIndex(orderRepository.getOrderByCustomerId(user.getId())));

        } if ( (request.getParameter("start_place") != null) && (request.getPathInfo().equals("/edit") ) ) {

            Order order = new Order();
            long idd;
            String str, str2;
            String[] word;
            String[] rDate;

            idd = Long.valueOf(request.getParameter("orderid"));

            order.setStart_place(request.getParameter("start_place"));

            order.setFinal_place(request.getParameter("final_place"));

            order.setPrice(Double.valueOf(request.getParameter("price")));
            order.setWeight(Double.valueOf(request.getParameter("weight")));
            order.setVolume(request.getParameter("volume"));

            str = request.getParameter("send_date");
            word = str.split("/");
            str = word[2] + "-" + word[0] + "-" + word[1];
            order.setSend_date(str);
            str2 = request.getParameter("receive_date");
            rDate = str2.split("/");
            str2 = rDate[2] + "-" + rDate[0] + "-" + rDate[1];
            order.setReceive_date(str2);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            order.setOrder_date(timestamp.toString());
            orderRepository.updateOrder(order, idd);
            out.println(orderView.getIndex(orderRepository.getOrderByCustomerId(user.getId())));
        }


        switch (request.getPathInfo()) {
            case "/index":
                if (user.getRole() == 3)
                    out.println(orderView.getIndex(orderRepository.getOrderByCustomerId(user.getId())));
                    break;
            case "/edit":
            case "/edit/":
                Order order = orderRepository.getOrderById(Long.parseLong(request.getParameter("id")));


                out.println(orderView.getExistingOrder(order));
                break;
            default:
                if (user.getRole() == 3)
                    out.println(orderView.getHtml());
        }

    }
}
