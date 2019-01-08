package ua.carrying.view;

import ua.carrying.dao.entities.ConnectionUserOrder;
import ua.carrying.dao.entities.Order;

import java.util.List;
import java.util.stream.Collectors;

public class ConnectionUserOrderView {

    public String getIndexFerryman( List<Order> orders ) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String page = indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                .replace("<!--###all-orders###-->", indexSingleton.getMenuAccepted())
                .replace("<!--###body###-->", indexSingleton.getOrderIndex());

        String allOrders = orders.stream().map(n -> {
            return "<a href=\"/order/accept?id=" + n.getId() + "\">"+
                    "<div class=\"col-6 col-sm-4 col-md-3\" Style=\"padding-top: 5%;\">\n" +
                    "<h3>" + n.getStart_place() + "</h3>\n" +
                    "<h3>" + n.getFinal_place() + "</h3>\n" +
                    "<p>" + n.getPrice() + "</p>" +
                    "<p>" + n.getWeight() + "</p>" +
                    "<p>" + n.getVolume() + "</p>" +
                    "<p>" + n.getSend_date() + "</p>" +
                    "<p>" + n.getReceive_date() + "</p>" +
                    "</div>\n" +
                    "</a>" +
                    "<!--###-add-order-###-->";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-order-###-->", allOrders);
    }

    public String getExistingOrderAccept(Order order) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        System.out.println(order.toString());
        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                .replace("<!--###body###-->", indexSingleton.getOrderAccept())

                .replace("<!--###-add-adress-start-###-->", order.getStart_place())
                .replace("<!--###-add-adress-final-###-->", order.getFinal_place())
                .replace("<!--###-add-price-###-->", order.getPrice() + "$")
                .replace("<!--###-add-weight-###-->", order.getWeight() +
                        "kg")
                .replace("<!--###-add-volume-###-->", order.getVolume())
                .replace("<!--###-add-date-send-###-->", order.getSend_date())
                .replace("<!--###-add-date-receive-###-->", order.getReceive_date())
                .replace("<!--###existing-order-id###-->",
                        "<input name=\"orderid\" type=\"hidden\" value=\"" + order.getId() + "\">");

    }

    public String getExistingOrderAccept(Order order, List<ConnectionUserOrder> connectionUserOrders) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        //System.out.println(order.toString());

        String allOrders = connectionUserOrders.stream().map(n -> {
            return "<form>" +
                    "<div class=\"col-6 col-sm-4 col-md-3\" Style=\"padding-top: 5%;\">\n" +
                    "<h3>" + n.getId_ferryman() + "</h3>\n" +

                    "<p>" + n.getPrice() + "</p>" +

                    "<p>" + n.getSend_date() + "</p>" +
                    "<p>" + n.getReceive_date() + "</p>" +
                    "<input name=\"ferrymanid\" type=\"hidden\" value=\"" + n.getId_ferryman() + "\">" +
                    "<input name=\"orderid\" type=\"hidden\" value=\"" + order.getId() + "\">" +
                    "</div>\n" +
                    "<input type=\"checkbox\" name=\"vehicle1\" value=\"Bike\"> I have a accept<br>" +
                    "<button type=\"submit\" class=\"btn btn-primary\">Accept</button>\n" +
                    "    </form>" +
                            "<!--###-add-order-###-->";
        }).collect(Collectors.joining(" "));

        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                //.replace("<!--###all-orders###-->", indexSingleton.getMenuOrders())
                .replace("<!--###body###-->", indexSingleton.getOrderAccepts())

                .replace("<!--###-add-adress-start-###-->", order.getStart_place())
                .replace("<!--###-add-adress-final-###-->", order.getFinal_place())
                .replace("<!--###-add-price-###-->", order.getPrice() + "$")
                .replace("<!--###-add-weight-###-->", order.getWeight() +
                        "kg")
                .replace("<!--###-add-volume-###-->", order.getVolume())
                .replace("<!--###-add-date-send-###-->", order.getSend_date())
                .replace("<!--###-add-date-receive-###-->", order.getReceive_date())
                .replace("<!--###existing-order-id###-->",
                        "<input name=\"orderid\" type=\"hidden\" value=\"" + order.getId() + "\">")
                .replace("<!--###-add-order-###-->", allOrders);


    }

    public String getIndexFerrymanAccepted( List<Order> orders ) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String page = indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                .replace("<!--###all-orders###-->", indexSingleton.getMenuAccepted())
                .replace("<!--###body###-->", indexSingleton.getOrderIndex());

        String allOrders = orders.stream().map(n -> {
            return  "<div class=\"col-6 col-sm-4 col-md-3\" Style=\"padding-top: 5%;\">\n" +
                    "<h3>" + n.getStart_place() + "</h3>\n" +
                    "<h3>" + n.getFinal_place() + "</h3>\n" +
                    "<p>" + n.getPrice() + "</p>" +
                    "<p>" + n.getWeight() + "</p>" +
                    "<p>" + n.getVolume() + "</p>" +
                    "<p>" + n.getSend_date() + "</p>" +
                    "<p>" + n.getReceive_date() + "</p>" +
                    "</div>\n" +
                    "<!--###-add-order-###-->";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-order-###-->", allOrders);
    }
}
