package ua.carrying.view;

import ua.carrying.dao.entities.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderView {
    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                .replace("<!--###all-orders###-->", indexSingleton.getMenuOrders())
                .replace("<!--###my-orders###-->", indexSingleton.getMenuAccepted())
                .replace("<!--###body###-->", indexSingleton.getOrderForm());
    }

    public String getIndex( List<Order> orders ) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String page = indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                .replace("<!--###my-orders###-->", indexSingleton.getMenuAccepted())
                .replace("<!--###body###-->", indexSingleton.getOrderIndex());

        String allOrders = orders.stream().map(n -> {
            return
                    "<div class=\"col-6 col-sm-4 col-md-3\" Style=\"padding-top: 5%;\">\n" +
                    "<h3>" + n.getStart_place() + "</h3>\n" +
                    "<h3>" + n.getFinal_place() + "</h3>\n" +
                    "<p>" + n.getPrice() + "</p>" +
                    "<p>" + n.getWeight() + "</p>" +
                    "<p>" + n.getVolume() + "</p>" +
                    "<p>" + n.getSend_date() + "</p>" +
                    "<p>" + n.getReceive_date() + "</p>" +
                            "<a class=\"btn btn-outline-primary\" href=\"/order/accept?id=" + n.getId() + "\">"+
                            "Who has accepted the order" +"</a>" +
                            "<a class=\"btn btn-outline-primary\" href=\"/order/edit?id=" + n.getId() + "\">"+
                            "Edit" +"</a>" +
                    "</div>\n" +

                    "<!--###-add-order-###-->";
        }).collect(Collectors.joining(" "));

        return page.replace("<!--###-add-order-###-->", allOrders);
    }

    public String getExistingOrder(Order order) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        //System.out.println(order.toString());
        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                .replace("<!--###body###-->", indexSingleton.getOrderEdit())
                .replace("id order\"></textarea>", "id order1\">" + order.getId() + "</textarea>")
                .replace("St\"></textarea>", "St\">" +
                        order.getStart_place() +
                        "</textarea>")
                .replace("or\"></textarea>", "or\">" +
                        order.getFinal_place() +
                        "</textarea>")
                .replace("Price\"></textarea>", "Price\">" +
                        order.getPrice() +
                        "</textarea>")
                .replace("Weight\"></textarea>", "Weight\">" +
                        order.getWeight() +
                        "</textarea>")
                .replace("Volume\"></textarea>", "Volume\">" +
                        order.getVolume() +
                        "</textarea>")
                .replace("<!--###-add-date-send-###-->", order.getSend_date())
                .replace("<!--###-add-date-receive-###-->", order.getReceive_date())
                .replace("<!--###existing-order-id###-->",
                        "<input name=\"orderid\" type=\"hidden\" value=\"" + order.getId() + "\">");

    }


}
