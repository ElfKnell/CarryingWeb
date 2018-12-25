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
                .replace("<!--###body###-->", indexSingleton.getOrderForm());
    }

    public String getIndex( List<Order> orders ) {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        String page = indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###log###-->", indexSingleton.getMenuLogout())
                .replace("<!--###body###-->", indexSingleton.getOrderIndex());

        String allOrders = orders.stream().map(n -> {
            return "<div class=\"col-6 col-sm-4 col-md-3\" Style=\"padding-top: 5%;\">\n" +
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
