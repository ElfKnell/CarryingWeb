package ua.carrying.view;

public class OrderView {
    public String getHtml() {
        IndexSingleton indexSingleton = IndexSingleton.getInstance();
        return indexSingleton.getPage()
                .replace("<!--###menu###-->", indexSingleton.getMenu())
                .replace("<!--###body###-->", indexSingleton.getOrderForm());
    }
}
