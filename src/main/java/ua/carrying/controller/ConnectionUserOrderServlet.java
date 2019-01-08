package ua.carrying.controller;

import ua.carrying.dao.entities.ConnectionUserOrder;
import ua.carrying.dao.entities.Order;
import ua.carrying.dao.entities.User;
import ua.carrying.dao.repository.ConnectionUserOrderRepository;
import ua.carrying.dao.repository.OrderRepository;
import ua.carrying.view.ConnectionUserOrderView;
import ua.carrying.view.OrderView;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "ConnectionUserOrderServlet", urlPatterns = {"/order/accept/*"})
public class ConnectionUserOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        ConnectionUserOrderRepository connectionUserOrderRepository = new ConnectionUserOrderRepository();

        ConnectionUserOrderView connectionUserOrderView = new ConnectionUserOrderView();
        OrderRepository orderRepository = new OrderRepository();
        OrderView orderView = new OrderView();





        if (user == null) {
            response.sendRedirect("/car");
            return;
        } if ((user.getRole() == 3) && (request.getParameter( "vehicle1" ) != null)) {

            long orderId = Long.valueOf(request.getParameter("orderid"));
            long ferrymanId = Long.valueOf(request.getParameter("ferrymanid"));

            orderRepository.takeOrder(ferrymanId, orderId);
            out.println(orderView.getIndex(orderRepository.getOrderByCustomerId(user.getId())));

        } if ((user.getRole() == 3) && (request.getParameter( "vehicle1" ) == null)) {

            Order order2 = orderRepository.getOrderById(Long.parseLong(request.getParameter("id")));
            List<ConnectionUserOrder> connectionUserOrders = connectionUserOrderRepository.getOredrsById(order2.getId());

            out.println(connectionUserOrderView.getExistingOrderAccept(order2, connectionUserOrders));

        } if (user.getRole() == 4){

            String str, str2;
            String[] word;
            String[] rDate;
            ConnectionUserOrder connectionUserOrder = new ConnectionUserOrder();

            if (request.getParameter("price") != null) {

                connectionUserOrder.setId_order(Long.valueOf(request.getParameter("orderid")));
                connectionUserOrder.setId_ferryman(user.getId());

                connectionUserOrder.setPrice(Double.valueOf(request.getParameter("price")));

                str = request.getParameter("send_date");
                word = str.split("/");
                str = word[2] + "-" + word[0] + "-" + word[1];
                connectionUserOrder.setSend_date(str);
                str2 = request.getParameter("receive_date");
                rDate = str2.split("/");
                str2 = rDate[2] + "-" + rDate[0] + "-" + rDate[1];
                connectionUserOrder.setReceive_date(str2);


                connectionUserOrderRepository.saveUserAccept(connectionUserOrder);

                //System.out.println("DDDЄЄ" + connectionUserOrder);

                out.println(connectionUserOrderView.getIndexFerryman(orderRepository.getOredrsByFerrymanId()));
            }

            Order order2 = orderRepository.getOrderById(Long.parseLong(request.getParameter("id")));
            out.println(connectionUserOrderView.getExistingOrderAccept(order2));
        }

    }
}
